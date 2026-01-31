package poc;

import java.util.UUID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;

interface IAuditoriaService {
    void registrar(String mensagem);
    void exportar(String id);
}

interface IBankOperations {
    void realizarDeposito(double valor, String token) throws BusinessException;
    double consultarSaldo();
}

class BusinessException extends Exception {
    public BusinessException(String message) { super(message); }
}

class SecurityException extends RuntimeException {
    public SecurityException(String message) { super(message); }
}

enum TipoTransacao {
    DEPOSITO, SAQUE, TRANSFERENCIA, FALHA_SEGURANCA
}

class LocalAuditService implements IAuditoriaService {
    private final List<String> logs = new ArrayList<>();
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Override
    public void registrar(String mensagem) {
        logs.add(LocalDateTime.now().format(fmt) + " | " + mensagem);
    }

    @Override
    public void exportar(String id) {
        String nomeArquivo = "auditoria_service_" + id.substring(0,8) + ".txt";
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            for (String log : logs)  {
                writer.write(log + System.lineSeparator());
            }
            System.out.println("[SERVICE] Relatório de auditoria gerado: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("[ERROR] Falha crítica de escrita.");
        }
    }
}

class ContaBancaria {
    private double saldo;
    private String email;
    private final String userId;
    private String hashPin;
    public Optional<String> tokenAcesso = Optional.empty();
    private LocalDateTime expiracaoToken;
    private boolean contaBloqueada;
    private final AtomicInteger tentativesErradas = new AtomicInteger(0);
    private final List<String> historico;
    private final IAuditoriaService auditoria;
    private final ReentrantLock lock = new ReentrantLock();
    private final double LIMITE_ANALISE_RISCO = 50000.0;
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public ContaBancaria(String email, String pinPuro, IAuditoriaService auditoria) {
        this.email= email;
        this.userId = UUID.randomUUID().toString();
        this.hashPin = gerarHash(pinPuro);
        this.saldo = 0.0;
        this.historico = new ArrayList<>();
        this.auditoria = auditoria;
        this.contaBloqueada = false;
        registrarEvento("SISTEMA: Conta instanciada com UUID: " + userId);
    }

    public String getUserId() { return this.userId; }

    private String gerarHash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) { return "ERRO_SEGURANCA"; }
    }

    public void gerarTokenSeguro() {
        String novoToken = UUID.randomUUID().toString().substring(0,6).toUpperCase();
        this.tokenAcesso = Optional.of(novoToken);
        this.expiracaoToken = LocalDateTime.now().plusSeconds(60);
        registrarEvento("AUTH:Novo token gerado. Expira em: " + expiracaoToken.format(fmt));
    }

    public void depositar(double valor, String tokenInformado) {
        lock.lock();
        try {
            if (validarAcesso(tokenInformado)) {
                if (valor > LIMITE_ANALISE_RISCO) {
                    registrarEvento("RISCO: OPERAÇÃO RETIDA. (Valor excede limite de análise: R$" + valor);
                    System.out.println("ALERTA: VAL0R SUSPEITO!" );
                    return;
                }
                this.saldo += valor;
                registrarEvento("FINANCEIRO: Depósito de R$" + valor + " confirmado. Novo Saldo: R$" + saldo);
                System.out.println("Sucesso! Deposito realizado.");
            }
        } finally { lock.unlock(); }
    }

    private boolean validarAcesso(String tokenInformado) {
        if (contaBloqueada) {
            System.out.println("ACESSO BLOQUEADO: Conta em estado de Lock-down.");
            return false;
        }
        if (expiracaoToken == null || LocalDateTime.now().isAfter(expiracaoToken)) {
            registrarEvento("SEGURANÇA: Tentativa com token expirado.");
            System.out.println("Erro: Token expirou. Gere um novo.");
            return false;
        }
        if (this.tokenAcesso.isPresent() && this.tokenAcesso.get().equals(tokenInformado)) {
            tentativesErradas.set(0);
            return true;
        } else {
            int erros = tentativesErradas.incrementAndGet();
            registrarEvento("ALERTA: Falha de autenticação. Tentativa N: " + erros);
            if (erros >= 3) {
                this.contaBloqueada = true;
                registrarEvento("CRÍTICO:Conta bloqueada por suspeita de Brute-Force.");
                System.out.println("CONTA BLOQUEADA POR SEGURANÇA!");
            }
            return false;
        }
    }

    private void registrarEvento(String acao)  {
        String logEntry = LocalDateTime.now().format(fmt) + " | " + acao;
        this.historico.add(logEntry);
        if (this.auditoria != null) {
            this.auditoria.registrar(acao);
        }
    }

    public void exportarLogsParaArquivo() {
        String nomeArquivo = "auditoria_" + userId.substring(0, 8) + ".txt";
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            for (String linha : historico) {
                writer.write(linha + System.lineSeparator());
            }
            System.out.println("Relatório de auditoria salvo em: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro crítico de I/O ao salvar logs.");
        }
    }
}

public class SystemResiliencePoC {
    public static void main(String[] args) {
        IAuditoriaService logger = new LocalAuditService();
        ContaBancaria conta = new ContaBancaria("freela_expert@dev.com", "senha123", logger);
        conta.gerarTokenSeguro();
        String tkValido = conta.tokenAcesso.orElse("");
        conta.depositar(1500.0, tkValido);
        conta.depositar(70000.0, tkValido);
        System.out.println("\n--- SIMULANDO ATAQUE ---");
        conta.depositar(10.0, "HACKER_1");
        conta.depositar(10.0,"HACKER_2");
        conta.depositar(10.0, "HACKER_3");
        logger.exportar(conta.getUserId());
    }
}
