
import java.time.LocalDateTime;

 public record AuditEntry(String mensagem, Status status, LocalDateTime data) {

     public AuditEntry {
         if (mensagem == null || mensagem.isBlank()) {
             throw new IllegalArgumentException("A mensagem não pode ser vazia!");
         }
     }
 }
