# 📡 Domain Events Engine (Reactive Core)

> **Stack:** Java 25 (OpenJDK), Spring Boot 3.2.4, Maven 3.9+
> **Architecture:** Vanilla-First / Event-Driven Design

---

##  Visão Geral | Overview

**PT:** O **Domain Events Engine** é o sistema circulatório da nossa arquitetura. Ele implementa o padrão de *Event-Driven Design*, permitindo que o sistema reaja a mudanças de estado sem criar dependências circulares. Aqui, o motor financeiro não "comanda" ações externas; ele apenas declara: "Um fato de negócio ocorreu", e o ecossistema reage de forma inteligente e assíncrona.

**EN:** The **Domain Events Engine** is the circulatory system of our architecture. It implements the *Event-Driven Design* pattern, enabling a reactive and decoupled architecture where the core engine declares business facts, and the ecosystem reacts intelligently and asynchronously.



---

##  Funcionalidades de Alta Engenharia | High-End Features

* **Integridade Transacional | Transactional Integrity:** * **PT:** Eventos vinculados ao ciclo de vida da transação. Mensagens só são disparadas após o `COMMIT` bem-sucedido no banco de dados.
    * **EN:** Events tied to the transaction lifecycle. Messages are only dispatched after a successful database `COMMIT`.
* **Isolamento de Efeitos Colaterais | Side-Effect Isolation:** * **PT:** Falhas em disparos de periféricos (e-mail, notificações) não interrompem o fluxo principal.
    * **EN:** Failures in peripheral dispatches (e-mail, notifications) do not interrupt the main processing flow.
* **Arquitetura Vanilla-First:** * **PT:** Foco em lógica pura. O Spring Boot atua como um mediador leve, mantendo o núcleo de domínio independente de frameworks.
    * **EN:** Focus on pure logic. Spring Boot acts as a lightweight mediator, keeping the domain core framework-independent.

---

##  Stack Moderna & Decisões Técnicas | Modern Stack

* **Java 25 (OpenJDK):** * **PT:** Operando na última versão do ecossistema para máxima performance.
    * **EN:** Operating on the latest ecosystem version for maximum performance.
* **Java Records:** * **PT:** Imutabilidade total (Thread-Safety) para definição de eventos.
    * **EN:** Total immutability (Thread-Safety) for event definitions.
* **Package Refactoring (`com.evento`):** * **PT:** Estrutura organizada para evitar conflitos de Scan e resolver erros de compilação (JVM Target).
    * **EN:** Organized structure to avoid Scan conflicts and resolve compilation errors (JVM Target).

---

##  Implementação Técnica | Technical Implementation

| Class / Classe | Responsibility / Responsabilidade | Pattern / Padrão |
| :--- | :--- | :--- |
| `DomainEvent.java` | Representar o fato ocorrido | Value Object (Record) |
| `FinanceEventPublisher.java` | Anunciar o evento internamente | Inversion of Control (IoC) |
| `EventBridgeMediator.java` | Ponte Interna -> Externa | Mediator / Observer |

---

##  Por que esta abordagem? | Why this approach?

1.  **Resiliência Financeira | Financial Resilience:** * **PT:** Uso de `@TransactionalEventListener` para evitar falsos positivos em transações falhas.
    * **EN:** Use of `@TransactionalEventListener` to avoid false positives on failed transactions.
2.  **Desacoplamento | Decoupling:** * **PT:** O motor de cálculo não conhece o RabbitMQ. Trocar o Broker exige mudar apenas o Mediator.
    * **EN:** The calculation engine is unaware of RabbitMQ. Swapping the Broker only requires changing the Mediator.
3.  **Manutenibilidade | Maintainability:** * **PT:** Código limpo, testável e aderente aos princípios SOLID.
    * **EN:** Clean, testable code adhering to SOLID principles.

---

##  Como Validar | How to Validate

1.  **Boot:** * **PT:** Execute a classe `Main`. O console deve exibir: `>>> Motor de Eventos Iniciado com Sucesso!`.
    * **EN:** Run the `Main` class. The console should display: `>>> Motor de Eventos Iniciado com Sucesso!`.
2.  **Logs:** * **PT:** Observe o disparo do evento capturado pelo `EventBridgeMediator`.
    * **EN:** Observe the event dispatch captured by the `EventBridgeMediator`.
3.  **Integridade | Integrity:** * **PT:** Simule uma falha de persistência e confirme que o evento não foi propagado.
    * **EN:** Simulate a persistence failure and confirm the event was not propagated.

### O que mudou no projeto (Resumo):
* **Compilação:** o erro que aconteceu na hora de fazer o projeto,chamado  de "JVM Target 5" foi resolvido forçando o Maven e o IntelliJ a trabalharem em Java 17/21/25.
* **Pacotes:** saí do "default package" (arquivos soltos) para `com.evento`, o que destravou o Spring Boot.



### 🛠️ Comandos de Deploy (Git)

```bash
# Sincronizar mudanças de estrutura e README
git add .
git commit -m "feat: implement domain events engine with spring boot 3 and package refactoring"
git push origin main
