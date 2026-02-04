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
- **EN:** Orchestration of microservices using Docker for high availability and portability.
- **PT:** Orquestração de microsserviços utilizando Docker para alta disponibilidade e portabilidade.

---

## 📂 Project Structure & Component Index | Organização e Engenharia

O projeto utiliza uma arquitetura modular em `org.engine`, organizada para refletir a separação estrita de responsabilidades.

### **I. Core Engines & Domain (`/core`, `/domain`)**
* **`domain/`**: Regras puras e imutáveis.
    * `MonetaryValue.java`: Value Object para precisão absoluta com `BigDecimal`.
    * `TransactionRecord.java`: DTO imutável para integridade financeira.
    * `Events/`: Sistema de eventos para desacoplamento de motores.
* **`core/`**: Motores de execução e resiliência.
    * `IdempotencyEngine.java`: Prevenção de duplicidade em transações.
    * `FlowController.java` & `Throttling`: Gestor de vazão e limites de carga.
    * `EngineTelemetry.java`: Monitoramento de performance em tempo real.
    * `Resilience/`: `CircuitBreaker.java` e `RetryManager.java` para auto-cura do sistema.
    * `Context/`: Gestão de rastreabilidade via `CorrelationIdContext.java`.

### **II. Infrastructure & Active Security (`/infrastructure`)**
* **`security/`**: Proteção ativa e auditoria.
    * `AuditLogger.java`: Registro persistente de trilhas de auditoria.
    * `encryption/`: `DataProtector.java` para criptografia AES-256 de dados sensíveis.
    * `sanitization/`: `InputCleaner.java` para proteção contra XSS e Injeções.
* **`docker/`**: Infraestrutura como código para padronização de ambientes.
* **`services/`**: Ecossistema de microsserviços distribuídos.
    * `api-gateway`, `audit-service`, `cache-service` (Redis), `message-broker` (RabbitMQ), `discovery-server`.

### **III. Immutable Audit Chain (`/security/audit/chain`) ⛓️**
* **`cryptographic-audit/`**:
    * `TransactionHasher.java`: Motor SHA-256 para digitais matemáticas.
    * `AuditChainManager.java`: Orquestrador de custódia imutável dos logs.
    * `IntegrityChecker.java`: Fiscal de integridade contra violações (Anti-Tampering).

### **IV. Strategy & Rules (`/rules`, `/strategy`)**
* **`TaxStrategy.java`**: Padrão Strategy para cálculos fiscais internacionais.
* **`InternationalTax.java`**: Implementação de políticas fiscais globais.

---

## 🛡️ Resilience & Security Ecosystem | Detalhes de Segurança

### ⚡ Resilience & Self-Healing | Resiliência e Auto-Cura

Proteção contra falhas em cascata via **Circuit Breakers** e **Retry Manager** com *Exponential Backoff*.

### ⛓️ Immutable Audit Chain | Cadeia de Auditoria Imutável
Trilha de auditoria criptográfica onde cada log é vinculado ao anterior via **SHA-256**. Torna impossível alterar o histórico sem quebrar a integridade da corrente.

### 🚦 Infrastructure Security | Segurança de Infraestrutura
Defesa ativa via **Rate Limiting** (anti-DoS), **Sanitização** de inputs e **Criptografia** de dados em repouso.

---

## ⚙️ Fluxo de Trabalho e Integração

1.  **Ingress:** O `SecurityInterceptor` valida a entrada enquanto o `Throttling` protege a infraestrutura.
2.  **Contexto:** Injeção de `Correlation ID` para rastreabilidade total (Distributed Tracing).
3.  **Processamento:** O motor executa a lógica protegida por `Idempotency` e `Resilience`.
4.  **Auditoria:** O `AuditChainManager` gera o elo criptográfico imutável da operação.

---

## 💡 Engineering Best Practices (Evitando Erros)

> **Anti-Error Pattern:** Nunca utilizamos `new BigDecimal(double)`.
> **Solução:** Todos os cálculos utilizam `new BigDecimal(String)` ou `BigDecimal.valueOf(double)`, garantindo precisão decimal exata e evitando bugs financeiros.

---

## 🛠️ Tech Stack | Tecnologias
* **Language:** Java 21 (Virtual Threads).
* **Messaging:** RabbitMQ.
* **Performance:** Redis (Caching).
* **Database:** PostgreSQL 15.
* **Infrastructure:** Docker & Docker-Compose.

---

## 👨‍💻 Author | Engenharia
**Kauan Oliveira** - *Systems & Security Engineer*

**PT-BR:** Focado em Freelance de Alta Performance e Arquiteturas Robustas.
**EN-US:** Focused on High-Performance Freelancing and Robust Architectures.

### 📩 Contato
- **LinkedIn:** [Kauan Oliveira](https://www.linkedin.com/in/kauan-oliveira-324264378/)
- **GitHub:** [kauandias747474-hue](https://github.com/kauandias747474-hue)

---
*Feito em 2026 por Kauan Oliveira*
