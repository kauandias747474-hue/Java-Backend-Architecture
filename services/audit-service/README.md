# ⛓️ Audit Service (Immutable Chain)
**Pilar:** Integridade Criptográfica

Serviço especializado em persistir a trilha de auditoria descrita no `07-cryptographic-audit`. 

### 🔒 Mecanismo de Integridade
- **SHA-256 Hashing:** Cada entrada de log contém o hash da entrada anterior, criando uma corrente de blocos lógica.
- **Anti-Tampering:** Caso um registro antigo seja alterado, o `IntegrityChecker` detectará a quebra da assinatura matemática.
- **Async Logging:** Utiliza RabbitMQ para garantir que o log de auditoria não atrase o processamento principal.
