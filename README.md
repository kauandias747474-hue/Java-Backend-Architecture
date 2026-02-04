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
  <img src="https://img.shields.io/badge/Languages-🇺🇸%20EN%20|%20🇵🇹%20PT-white?style=flat-square" alt="Languages">
</p>

**EN:** This technical ecosystem is dedicated to developing high-performance Java backend solutions. The focus is on the transition between **abstract logical modeling** and **robust system implementation**, prioritizing algorithmic efficiency, modularity, and cryptographic integrity for the global market.

**PT:** Este ecossistema técnico é dedicado ao desenvolvimento de soluções backend de alta performance em Java. O foco central é a transição entre a **modelagem lógica abstrata** e a **implementação de sistemas robustos**, priorizando eficiência algorítmica, modularidade e integridade criptográfica para o mercado global.

---

## 🏗️ Core Engineering Pillars | Pilares de Engenharia

### 🧠 Algorithmic Complexity | Complexidade Algorítmica ($O(n)$)
- **EN:** Mathematical validation of every solution before implementation to ensure scalability.
- **PT:** Validação matemática de cada solução antes da implementação para garantir escalabilidade.

### 💼 Message-Driven Architecture | Arquitetura Orientada a Mensagens
- **EN:** Implementation of asynchronous communication with **RabbitMQ** for high resilience.
- **PT:** Implementação de comunicação assíncrona com **RabbitMQ** para alta resiliência.

### 🧱 Robust Object Design & Cache | Design de Objetos e Cache
- **EN:** Application of **SOLID**, **Clean Code**, and **Redis** for low-latency performance.
- **PT:** Aplicação de **SOLID**, **Clean Code** e **Redis** para performance de baixa latência.

### ☁️ Distributed Infrastructure | Infraestrutura Distribuída
- **EN:** Orchestration of microservices using Docker for high availability and portability.
- **PT:** Orquestração de microsserviços utilizando Docker para alta disponibilidade e portabilidade.

---

## 📂 Project Structure | Estrutura do Projeto

### **I. Core Engines & Domain (`/core`, `/domain`)**
* **`domain/`**: 
    * **PT:** Regras puras e imutáveis. `MonetaryValue.java` para precisão financeira e `Events/` para desacoplamento.
    * **EN:** Pure and immutable rules. `MonetaryValue.java` for financial precision and `Events/` for decoupling.
* **`core/`**: 
    * **PT:** Motores de execução. `IdempotencyEngine.java` contra duplicidade e `Resilience/` com Circuit Breakers.
    * **EN:** Execution engines. `IdempotencyEngine.java` against duplication and `Resilience/` with Circuit Breakers.

### **II. Infrastructure & Active Security (`/infrastructure`)**
* **`security/`**: 
    * **PT:** Proteção ativa via `DataProtector.java` (AES-256) e `InputCleaner.java` (Sanitização).
    * **EN:** Active protection via `DataProtector.java` (AES-256) and `InputCleaner.java` (Sanitization).
* **`docker/`**: 
    * **PT:** Infraestrutura como código para padronização de ambientes.
    * **EN:** Infrastructure as code for environment standardization.
* **`services/`**: 
    * **PT:** Microsserviços: API Gateway, Discovery Server, Message Broker (RabbitMQ) e Redis.
    * **EN:** Microservices: API Gateway, Discovery Server, Message Broker (RabbitMQ), and Redis.

### **III. Immutable Audit Chain (`/security/audit/chain`) ⛓️**
* **PT:** `AuditChainManager.java` orquestra uma trilha de auditoria onde cada elo é vinculado ao anterior via **SHA-256**.
* **EN:** `AuditChainManager.java` orchestrates an audit trail where each link is tied to the previous one via **SHA-256**.

---

## 🛡️ Resilience & Security Ecosystem | Resiliência e Segurança

### ⚡ Self-Healing | Auto-Cura

* **PT:** Proteção contra falhas em cascata via **Circuit Breaker** e **Retry Manager**.
* **EN:** Cascading failure protection via **Circuit Breaker** and **Retry Manager**.

### ⛓️ Immutable Audit | Auditoria Imutável
* **PT:** Torna impossível alterar o histórico de logs sem quebrar a integridade criptográfica da corrente.
* **EN:** Makes it impossible to alter log history without breaking the chain's cryptographic integrity.

### 🚦 Traffic Control | Controle de Tráfego
* **PT:** Defesa ativa via **Throttling** e **Rate Limiting** para proteger a disponibilidade do servidor.
* **EN:** Active defense via **Throttling** and **Rate Limiting** to protect server availability.

---

## 💡 Engineering Best Practices (Anti-Error)

> **PT:** Nunca utilizamos `new BigDecimal(double)`. Usamos `new BigDecimal(String)` para garantir precisão exata.
>
> **EN:** We never use `new BigDecimal(double)`. We use `new BigDecimal(String)` to ensure exact decimal precision.

---

## 🛠️ Tech Stack | Tecnologias
* **Language:** Java 21 (Virtual Threads).
* **Messaging:** RabbitMQ.
* **Cache:** Redis.
* **DB:** PostgreSQL 15.
* **Infra:** Docker & Docker-Compose.

---

## 👨‍💻 Author | Autoria
**Kauan Oliveira** - *Systems & Security Engineer*

**PT-BR:** Focado em Freelance de Alta Performance e Arquiteturas Robustas.  
**EN-US:** Focused on High-Performance Freelancing and Robust Architectures.

### 📩 Contact / Contato
- **LinkedIn:** [Kauan Oliveira](https://www.linkedin.com/in/kauan-oliveira-324264378/)
- **GitHub:** [kauandias747474-hue](https://github.com/kauandias747474-hue)

---
*Developed in 2026 / Desenvolvido em 2026*
