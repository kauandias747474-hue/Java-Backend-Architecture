# 🗄️ Domain Records & Persistence

## 🇧🇷 Português

O módulo **records** é responsável pela representação imutável dos dados e pela garantia da integridade do estado em todo o ecossistema do sistema.

###  Componentes e Sincronização
A arquitetura baseia-se na integração de três pilares fundamentais:

1.  **`pom.xml` (O Alicerce)**: Define o ambiente de execução (Java 25 + Spring Boot 3.4). Ele garante que o compilador e as dependências estejam alinhados para suportar recursos avançados de performance e segurança.
2.  **`Main.java` (O Orquestrador)**: É o ponto de entrada que consome as definições do POM para inicializar o sistema. Ele gere o fluxo de execução e instancia os objetos de domínio.
3.  **`TransactionRecord.java` (A Verdade Imutável)**: Representa uma "foto" inalterável de uma transação. Uma vez instanciado pelo orquestrador, o dado não pode ser corrompido ou modificado por outras threads.

###  Por que esta estrutura?
* **Segurança de Thread**: A imutabilidade dos Records permite processamento paralelo massivo sem riscos de race conditions.
* **Ciclo de Vida Previsível**: O `pom.xml` padroniza o build, garantindo que o comportamento do código no `Main.java` seja idêntico em qualquer ambiente.
* **Integridade Financeira**: Garante que o valor calculado pelo motor de processamento seja exatamente o mesmo que será persistido, sem efeitos colaterais.

###  Aplicação Técnica
essa estrutura permite criar ferramentas de automação onde o estado de uma vulnerabilidade ou transação financeira é preservado como uma prova técnica inalterável.

---

## 🇺🇸 English

The **records** module is responsible for the immutable representation of data and ensuring state integrity across the entire system ecosystem.

###  Components & Synchronization
The architecture is based on the integration of three fundamental pillars:

1.  **`pom.xml` (The Foundation)**: Defines the runtime environment (Java 25 + Spring Boot 3.4). It ensures that the compiler and dependencies are aligned to support advanced performance and security features.
2.  **`Main.java` (The Orchestrator)**: The entry point that consumes POM definitions to initialize the system. It manages the execution flow and instantiates domain objects.
3.  **`TransactionRecord.java` (The Immutable Truth)**: Represents an unalterable "snapshot" of a transaction. Once instantiated by the orchestrator, the data cannot be corrupted or modified by other threads.

###  Why this structure?
* **Thread Safety**: The immutability of Records allows for massive parallel processing without the risk of race conditions.
* **Predictable Lifecycle**: The `pom.xml` standardizes the build, ensuring that code behavior in `Main.java` is identical across any environment.
* **Financial Integrity**: Ensures that the value calculated by the processing engine is exactly the same as what will be persisted, without side effects.

###  Technical Application
 this structure allows for the creation of automation tools where the state of a vulnerability or financial transaction is preserved as unalterable technical proof.
