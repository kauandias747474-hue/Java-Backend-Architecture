# 🐇 Message Broker (RabbitMQ)

## 🇧🇷 Português | 🇺🇸 English

---

### ⛓️ Pilar: Message-Driven Architecture
**Pillar: Message-Driven Architecture**

O **RabbitMQ** é a espinha dorsal da comunicação assíncrona do sistema. Ele permite que os serviços de auditoria, finanças e logs operem de forma desacoplada, garantindo que, mesmo que um serviço esteja temporariamente fora do ar, as mensagens sejam retidas e processadas com segurança assim que a disponibilidade for restaurada.
*The **RabbitMQ** is the backbone of the system's asynchronous communication. It allows audit, finance, and log services to operate decoupled, ensuring that messages are retained and safely processed even if a service is temporarily down.*

---

### 📑 Arquitetura de Filas | Queue Architecture

* **Dead Letter Exchanges (DLX):** Mecanismo de "Cestinha de Erros". Mensagens que falham repetidamente após o esgotamento das tentativas de reprocessamento são movidas para uma exchange especial para análise manual ou recuperação. / *Automatic handling of failed messages for manual analysis or recovery.*
* **Idempotency (IdempotencyEngine):** Garantia de que a mesma mensagem (identificada pelo `Correlation-ID`) nunca será processada duas vezes, prevenindo duplicidade em registros financeiros. / *Ensures messages are not processed twice, preventing duplicate financial records.*
* **Reliability (Publisher Confirms):** Protocolo de confirmação onde o broker avisa o emissor que a mensagem foi escrita em disco, eliminando a perda de dados em caso de queda de energia. / *Guarantees messages are persisted to disk through acknowledgement protocols.*

---

### ☕ Conceitos Java & Programação Aplicados

* **Spring AMQP (RabbitTemplate):** Abstração de alto nível que simplifica o envio e recebimento de mensagens, gerenciando automaticamente a serialização de objetos Java para o formato JSON.
* **Exponential Backoff Strategy:** Implementação de retentativas com intervalos crescentes (ex: 2s, 4s, 8s). Isso evita o efeito "Thundering Herd" (manada barulhenta) sobre um serviço que está tentando se recuperar.
* **Prefetch Count:** Configuração que limita quantas mensagens um consumidor recebe por vez, garantindo que o processamento seja distribuído de forma justa entre múltiplas instâncias do serviço.



---

### ⚙️ Funcionamento do Código | How it Works

O fluxo de resiliência segue uma lógica de **Tentativa -> Erro -> Quarentena**:
1.  **Publish:** O serviço financeiro envia uma mensagem para a `AuditExchange`.
2.  **Retry:** Se o serviço de Auditoria falhar, o RabbitMQ reencaminha a mensagem com um delay.
3.  **DLX:** Após 3 tentativas frustradas, a mensagem é movida para a `audit.deadletter.queue`.
4.  **Ack/Nack:** O consumidor só envia o `Acknowledgment` (confirmação) após o registro ser persistido na *Immutable Chain*.

---
