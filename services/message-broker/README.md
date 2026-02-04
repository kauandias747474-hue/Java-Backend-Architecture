# 🐇 Message Broker (RabbitMQ)
**Pilar:** Message-Driven Architecture

Central de mensageria que garante a resiliência e o desacoplamento entre os serviços de auditoria, finanças e logs.

### 📑 Arquitetura de Filas
- **Dead Letter Exchanges (DLX):** Tratamento de mensagens que falharam após o `RetryManager` esgotar as tentativas.
- **Idempotency:** Garantia de que a mesma mensagem não será processada duas vezes (conectado ao `IdempotencyEngine`).
- **Reliability:** Confirmação de entrega (Publisher Confirms) para evitar perda de dados financeiros.
