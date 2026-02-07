import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Collections;



enum Status  { SUCESSO, FALHA }


class Registro {
    double valor;
    Status status;
    long timestamp;


    public Registro(double valor, Status status) {
        this.valor = valor;
        this.status = status;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "[R$ " + valor + " | " + status + " | " + timestamp + "]";
    }
}


public class IdempotencyEngine<K, V> extends LinkedHashMap<K, V> {
    private final int limite;
    private final Map<K, V> cache;

    public IdempotencyEngine(int limite) {
        super(limite, 0.75f, true);
        this.limite = limite;
        this.cache = Collections.synchronizedMap(new LinkedHashMap<K, V>(limite, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > limite;
            }
        });
    }

    public V executarOuObter(K chave, V novoResultado) {
        if (cache.containsKey(chave)) {
            V salvo = cache.get(chave);


            if (salvo instanceof Registro && novoResultado instanceof Registro) {
                Registro rSalvo = (Registro) salvo;
                Registro rNovo = (Registro) novoResultado;

                long agora = System.currentTimeMillis();
                if ((agora - rSalvo.timestamp) < 30000 && rSalvo.valor == rNovo.valor) {
                    System.out.println("🚨 [SEGURANÇA] Bloqueio preventivo: tentativa idêntica em < 30s.");
                    return salvo;
                }

                if (rSalvo.status == Status.FALHA) {
                    System.out.println("🔄 [RE-TENTATIVA] Limpando falha anterior para permitir novo processamento.");
                    cache.put(chave, novoResultado);
                    return novoResultado;
                }
            }
            System.out.println("[IDEMPOTÊNCIA] Registro encontrado para: " + chave);
            return salvo;
        }
        cache.put(chave, novoResultado);
        return novoResultado;
    }

    public static void main (String[] args) throws InterruptedException {

        IdempotencyEngine<String, Registro> meuCache = new IdempotencyEngine<>(3);

        System.out.println("---🏦 [IDEMPOTENCY ENGINE] Iniciando Motor Financeiro...---");


        meuCache.executarOuObter("TX-100", new Registro(50.0, Status.SUCESSO));

        meuCache.executarOuObter("TX-101", new Registro(20.0, Status.FALHA));


        Thread.sleep(4000);


        System.out.println("\nTentando repetir TX-100...");
        meuCache.executarOuObter("TX-100", new Registro(50.0, Status.SUCESSO));

        System.out.println("\nTentando repetir TX-101 (que falhou antes)...");

        meuCache.executarOuObter("TX-101", new Registro(20.0, Status.SUCESSO));


        Thread.sleep(4000);
    }
}

