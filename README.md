# Java Backend Architecture ☕

<p align="center">
  <img src="https://img.shields.io/badge/Focus-High--Performance%20Backend-red?style=for-the-badge" alt="Focus">
  <img src="https://img.shields.io/badge/Language-Java-007396?style=for-the-badge&logo=java&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/Architecture-Clean%20Code%20|%20SOLID-orange?style=for-the-badge" alt="Architecture">
  <img src="https://img.shields.io/badge/Security-Immutable%20Audit-blue?style=for-the-badge" alt="Security">
</p>

---

### 🌐 Enterprise Solutions & Engineering
<p align="left">
  <img src="https://img.shields.io/badge/Languages-🇺🇸%20EN%20|%20🇩🇪%20DE%20|%20🇪🇸%20ES-white?style=flat-square" alt="Languages">
</p>

**EN:** This technical ecosystem is dedicated to developing high-performance Java backend solutions. The focus is on the transition between **abstract logical modeling** and **robust system implementation**, prioritizing algorithmic efficiency, modularity, and cryptographic integrity for the global market.

**PT:** Este ecossistema técnico é dedicado ao desenvolvimento de soluções backend de alta performance em Java. O foco central é a transição entre a **modelagem lógica abstrata** e a **implementação de sistemas robustos**, priorizando eficiência algorítmica, modularidade e integridade criptográfica para o mercado global.

---

## 🏗️ Core Engineering Pillars | Pilares de Engenharia

### 🧠 Algorithmic Complexity ($O(n)$)
- **EN:** Mathematical validation of every solution before implementation to ensure scalability.
- **PT:** Validação matemática de cada solução antes da implementação para garantir escalabilidade.

### 💼 Message-Driven Architecture
- **EN:** Implementation of asynchronous communication with **RabbitMQ** for high resilience.
- **PT:** Implementação de comunicação assíncrona com **RabbitMQ** para alta resiliência.

### 🧱 Robust Object Design & Cache
- **EN:** Application of **SOLID**, **Clean Code**, and **Redis** for low-latency performance.
- **PT:** Aplicação de **SOLID**, **Clean Code** e **Redis** para performance de baixa latência.

### ☁️ Distributed Infrastructure
- **EN:** Orchestration of microservices using Docker and Kubernetes for high availability.
- **PT:** Orquestração de microsserviços utilizando Docker e Kubernetes para alta disponibilidade.

---

## 📂 Project Structure & Component Index | Organização e Engenharia

O projeto utiliza uma arquitetura modular em `org.engine`, numerada para refletir a hierarquia de execução e separação de responsabilidades.

### **I. Core Engines & Domain (`/core`, `/domain`)**

* **`01-finance-engine/`**: Núcleo de cálculo monetário de alta precisão.
    * `MonetaryValue.java`: Value Object para precisão absoluta com `BigDecimal`.
    * `TransactionRecord.java`: DTO imutável para registros financeiros.
    * `IdempotencyEngine.java`: Prevenção de duplicidade de transações.
* **`02-monetary-domain-rules/`**: 
    * `InternationalTax.java`: Centralização de regras fiscais internacionais.
    * `SchemaIntegrity.java`: Validação estrutural de entrada (Fail-Fast).
* **`03-task-orchestration/`**: Sinergia de processamento.
    * `TaskProcessor.java`: Unidade de execução assíncrona para processamento pesado.
    * `HighPerformanceValidator.java`: Orquestrador paralelo via **Virtual Threads** (Java 21).
    * `FlowController.java`: Gestor de estado do fluxo financeiro.
    * `EngineTelemetry.java`: Monitoramento de performance em tempo real.

### **II. Infrastructure, Resilience & Security (`/infrastructure`)**

* **`04-infrastructure-layer/`**: Persistência e Mensageria.
    * `PostgreSQL 15`, `Redis 7` e `RabbitMQ`.
    * `AuditLogger.java`: Sistema de logging persistente (Audit Trail).
* **`05-resilience-self-healing/`**: Proteção contra falhas em cascata.
    * `CircuitBreaker.java`: Monitoramento de saúde de dependências.
    * `RetryManager.java`: Recuperação via *Exponential Backoff*.
* **`06-context-security-ecosystem/`**: 
    * **Context:** `CorrelationIdContext.java`, `RequestContext.java`, `ContextInterceptor.java`.
    * **Active Security:** `RateLimiter.java` (anti-DoS), `SecurityInterceptor.java` (Sanitização).
    * **Data Protection:** `InputCleaner.java` e `DataProtector.java` (Encryption AES-256).

### **III. Immutable Audit Chain (`/security/audit/chain`) ⛓️**

* **`07-cryptographic-audit/`**:
    * `TransactionHasher.java`: Motor SHA-256 para impressões digitais matemáticas.
    * `AuditEntry.java`: Estrutura do elo da corrente (Hash linking).
    * `IntegrityChecker.java`: Fiscal de integridade da cadeia (Anti-Tampering).
    * `AuditChainManager.java`: Orquestrador de custódia imutável.

---

## 🛡️ Resilience & Security Ecosystem | Detalhes de Segurança



### 🌐 Context Management | Gerenciamento de Contexto
* **PT:** Gerencia o **Rastreamento Distribuído** via `Correlation ID`. Cada ação é vinculada a uma identidade única em logs distribuídos.
* **EN:** Manages **Distributed Tracing** via `Correlation ID`. Every action is linked to a unique identity across distributed logs.

### ⚡ Resilience & Self-Healing | Resiliência e Auto-Cura
* **PT:** Proteção contra falhas em cascata via **Circuit Breakers** e **Retry Manager** com *Exponential Backoff*.
* **EN:** Protection against cascading failures via **Circuit Breakers** and **Retry Manager**.

### ⛓️ Immutable Audit Chain | Cadeia de Auditoria Imutável
* **PT:** Trilha de auditoria criptográfica onde cada log é vinculado ao anterior via **SHA-256**. Torna impossível alterar o histórico sem quebrar a corrente.
* **EN:** Cryptographic audit trail where each log is linked to the previous one via **SHA-256**. Makes it impossible to alter history.

### 🚦 Infrastructure Security | Segurança de Infraestrutura
* **PT:** Defesa ativa via **Rate Limiting** (anti-DoS) e **Interceptors** para sanitização de inputs (SQLi/XSS).
* **EN:** Active defense via **Rate Limiting** (anti-DoS) and **Interceptors** for input sanitization.

---

## ⚙️ Fluxo de Trabalho e Integração

1.  **Gatilho (Ingress):** O `SecurityInterceptor` valida a entrada enquanto o `RateLimiter` protege a infraestrutura.
2.  **Contexto:** O `ContextInterceptor` injeta o `Correlation ID` para rastreabilidade total.
3.  **Processamento:** O `HighPerformanceValidator` utiliza **Virtual Threads** para validar regras e integridade em paralelo.
4.  **Auditoria:** O `AuditChainManager` gera o elo criptográfico imutável da transação.
5.  **Resiliência:** Em caso de falha externa, o `CircuitBreaker` e `RetryManager` garantem a continuidade.

---

## 💡 Engineering Best Practices (Evitando Erros)

> **Anti-Error Pattern:** Nunca utilizamos `new BigDecimal(double)`. 
> **Solução:** Todos os cálculos utilizam `new BigDecimal(String)` ou `BigDecimal.valueOf(double)`, garantindo precisão decimal exata e evitando bugs de ponto flutuante.

---

## 📂 Project Roadmap | Roteiro de Projetos

| Project / Component | Technical Goal (Objetivo Técnico) |
| :--- | :--- |
| **Finance Engine** | High-precision tax & currency system (Precisão Absoluta) |
| **Immutable Audit** | Cryptographic tamper-proof ledger (Integridade Criptográfica) |
| **Infrastructure** | Docker-compose for DB, Cache & Broker |
| **Security Layer** | Rate Limiting, Encryption & Sanitization |
| **API Edge Gateway** | Centralized routing and security |

---

## 🛠️ Tech Stack & Hard Skills | Tecnologias e Habilidades

* **Language:** Java 21 (Virtual Threads / Project Loom).
* **Frameworks:** Spring Cloud (Gateway, Discovery, Config Server).
* **Messaging:** **RabbitMQ / Apache Kafka**.
* **Performance:** **Redis** (Distributed Caching).
* **Database:** PostgreSQL 15 + **Flyway**.
* **Infrastructure:** Docker & Kubernetes.

---

## 👨‍💻 Author & Engineering Mindset | Autoria e Engenharia
**Kauan Oliveira** - *Systems & Security Engineer*

<p align="left">
  <img src="https://img.shields.io/badge/Java-Enterprise-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java Enterprise">
  <img src="https://img.shields.io/badge/Security-Cryptography-green?style=for-the-badge" alt="Security">
  <img src="https://img.shields.io/badge/Clean-Architecture-red?style=for-the-badge" alt="Clean Arch">
</p>

**PT-BR:** Atualmente focado em Freelance de Alta Performance e Pesquisa em Bug Bounty.
**EN-US:** Focused on High-Performance Freelancing and Bug Bounty Research.

### 📩 Connect with Me / Contato
- **LinkedIn:** [Kauan Oliveira](https://www.linkedin.com/in/kauan-oliveira-324264378/)
- **GitHub:** [kauandias747474-hue](https://github.com/kauandias747474-hue)

---
*Developed in 2026 by Kauan Oliveira / Feito em 2026 por Kauan Oliveira*
