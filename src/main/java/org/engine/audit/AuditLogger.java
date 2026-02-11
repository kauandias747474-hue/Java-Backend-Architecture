 import java.time.LocalDateTime;

 class ConsoleRepository implements AuditRepository {
     @Override
     public void salvar(AuditEntry entry) {
         System.out.println("--- NOVO LOG DE AUDITORIA ---");
         System.out.println("Data: " + entry.data());
         System.out.println("Nível: " + entry.status() + " (Grau: " + entry.status().getNivel() + ")");
         System.out.println("Mensagem: " + entry.mensagem());
         System.out.println("------------------------------");
     }
 }
     public class Main {


       static void main() {

         AuditRepository repo = new ConsoleRepository();


         AuditEntry log = new AuditEntry(
                 "Sistema iniciado com sucesso",
                 Status.INFO,
                 LocalDateTime.now()
         );

         repo.salvar(log);
     }
     }

