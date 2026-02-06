import java.util.concurrent.*;
import java.util.Set;
import java.time.LocalTime;

public class TaskScheduler {


    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);


    private final Set<String> tarefasEmExecucao = ConcurrentHashMap.newKeySet();

    public static void main(String[] args) {
        TaskScheduler core = new TaskScheduler();

        System.out.println("[" + LocalTime.now() + "] Sistema Iniciado.");


        core.programar("Sincronizar_Banco", 2);  // Executa em 2s
        core.programar("Enviar_Emails", 5);     // Executa em 5s
        core.programar("Sincronizar_Banco", 1);  // Será bloqueada (duplicata)
    }

    public void programar(String nome, long delaySegundos) {
        // LÓGICA DE GATILHO: Verificação de duplicidade.
        if (tarefasEmExecucao.contains(nome)) {
            System.err.println("-> Bloqueio: '" + nome + "' já está pendente.");
            return;
        }

        System.out.println("-> Agendado: '" + nome + "' em " + delaySegundos + "s.");


        executor.schedule(() -> executarFluxo(nome), delaySegundos, TimeUnit.SECONDS);
    }

    private void executarFluxo(String nome) {
        tarefasEmExecucao.add(nome);

        try {
            System.out.println("[" + LocalTime.now() + "] Executando: " + nome);


            Thread.sleep(3000);

            System.out.println("[" + LocalTime.now() + "] Sucesso: " + nome + " concluído.");
        } catch (Exception e) {
            System.err.println("Erro ao processar " + nome);
        } finally {

            tarefasEmExecucao.remove(nome);
        }
    }
}
