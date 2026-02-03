# Java Backend Architecture ☕

<p align="center">
  <img src="https://img.shields.io/badge/Focus-High--Performance%20Backend-red?style=for-the-badge" alt="Focus">
  <img src="https://img.shields.io/badge/Language-Java-007396?style=for-the-badge&logo=java&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/Architecture-Clean%20Code%20|%20SOLID-orange?style=for-the-badge" alt="Architecture">
</p>

---

### 🌐 Enterprise Solutions & Engineering
<p align="left">
  <img src="https://img.shields.io/badge/Languages-🇺🇸%20EN%20|%20🇩🇪%20DE%20|%20🇪🇸%20ES-white?style=flat-square" alt="Languages">
</p>

**EN:** This technical ecosystem is dedicated to developing high-performance Java backend solutions. The focus is on the transition between **abstract logical modeling** and **robust system implementation**, prioritizing algorithmic efficiency and modularity for the international freelance market.

**PT:** Este ecossistema técnico é dedicado ao desenvolvimento de soluções backend de alta performance em Java. O foco central é a transição entre a **modelagem lógica abstrata** e a **implementação de sistemas robustos**, priorizando eficiência algorítmica e modularidade para o mercado freelance internacional.

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
## 🏗️ Core Engineering Engines & Architecture

O projeto utiliza uma arquitetura modular em `org.engine`, separando responsabilidades para garantir fácil manutenção e auditoria.

### ⚙️ Core Engines (`/core`)
* **Finance Engine:** Núcleo de cálculo monetário de alta precisão utilizando `BigDecimal`. Implementado para evitar erros de arredondamento em transações complexas.
* **Task Processor:** Unidade de execução assíncrona para processamento pesado de dados (Heavy Data Processing), garantindo que a aplicação permaneça responsiva.
* **Task Scheduler:** Orquestrador temporal para agendamentos inteligentes e rotinas de manutenção automática.

### 🏛️ Domain & Rules (`/domain`, `/rules`, `/strategy`)
* **Monetary Value (Domain):** Value Objects ricos para representação de moeda, prevenindo estados inválidos no domínio.
* **International Tax (Rules):** Centralização de regras fiscais internacionais, facilitando a expansão global do sistema.
* **Tax Strategy (Strategy):** Aplicação de Design Patterns para alternância dinâmica de algoritmos de cálculo de impostos em tempo de execução.

  ---

### 🔄 Integração e Fluxo de Trabalho

Embora o **Task Scheduler** e o **Task Processor** funcionem como unidades independentes, eles foram projetados para operar em sinergia através de um modelo de **comunicação desacoplada**:

1.  **Gatilho (Scheduler):** O agendador monitora o tempo e as condições do sistema. Quando um critério é atingido, ele gera uma instrução de tarefa.
2.  **Fila de Execução (Task Queue):** As instruções são organizadas em uma fila, permitindo que o sistema priorize o que é mais importante sem sobrecarregar a memória.
3.  **Processamento (Processor):** O executor retira as tarefas da fila e as processa em segundo plano, devolvendo apenas o resultado final ou o log de conclusão.



> **Diferencial Técnico:** Esta arquitetura permite que cada módulo seja atualizado ou substituído sem afetar os demais. É uma estrutura pronta para crescer, suportando desde scripts simples até sistemas de automação industrial de grande porte.

---

### 🛠️ Benefícios da Arquitetura Modular

* **Resiliência:** Falhas em processos pesados dentro do `Processor` não interrompem o funcionamento do `Scheduler`.
* **Manutenibilidade:** Código limpo e dividido, facilitando correções e upgrades pontuais sem efeitos colaterais.
* **Performance:** O uso de threads assíncronas impede travamentos de interface, proporcionando uma experiência de uso fluida.


### 🔌 Infrastructure (`/infrastructure`)
* **Audit Logger:** Sistema de logging persistente para rastreabilidade total (Audit Trail) e conformidade com normas de segurança.

---
## 🛡️ Resilience & Security Ecosystem | Ecossistema de Resiliência e Segurança

### 🌐 Context Management | Gerenciamento de Contexto
* **PT:** Gerencia o **Rastreamento Distribuído** via `Correlation ID`. Cada ação é vinculada a uma identidade única em logs distribuídos.
* **EN:** Manages **Distributed Tracing** via `Correlation ID`. Every action is linked to a unique identity across distributed logs.

### ⚡ Resilience & Self-Healing | Resiliência e Auto-Cura
* **PT:** Proteção contra falhas em cascata via **Circuit Breakers** e **Retry Manager** com *Exponential Backoff*.
* **EN:** Protection against cascading failures via **Circuit Breakers** and **Retry Manager** with *Exponential Backoff*.

### ⛓️ Immutable Audit Chain | Cadeia de Auditoria Imutável
* **PT:** Trilha de auditoria criptográfica onde cada log é vinculado ao anterior via **SHA-256** (Anti-Tampering).
* **EN:** Cryptographic audit trail where each log is linked to the previous one via **SHA-256** (Anti-Tampering).

### 🚦 Infrastructure Security | Segurança de Infraestrutura
* **PT:** Defesa ativa via **Rate Limiting** (anti-DoS) e **Interceptors** para sanitização de inputs (SQLi/XSS).
* **EN:** Active defense via **Rate Limiting** (anti-DoS) and **Interceptors** for input sanitization (SQLi/XSS).


---

## 📂 Project Roadmap | Roteiro de Projetos

| Project / Component | Technical Goal (Objetivo Técnico) |
| :--- | :--- |
| **Finance Engine** | High-precision tax & currency system (Precisão Absoluta) |
| **Infrastructure** | Docker-compose for DB, Cache & Broker |
| **Task Orchestration** | Background processing & scheduled jobs |
| **Security Layer** | Rate Limiting & Input Sanitization |
| **API Edge Gateway** | Centralized routing and security |
| **K8s Cluster Config** | Self-healing and automated scalability |

---

## 💡 Engineering Best Practices (Evitando Erros)

Para garantir a integridade financeira, este projeto segue regras rígidas de desenvolvimento:

> **Anti-Error Pattern:** Nunca utilizamos `new BigDecimal(double)`. 
> **Por que?** O construtor de `double` em Java introduz imprecisões de ponto flutuante. 
> **Solução:** Todos os cálculos utilizam `new BigDecimal(String)` ou `BigDecimal.valueOf(double)`, garantindo precisão decimal exata.

---


## 🐳 Infrastructure & Deployment (DevOps)

Ambiente totalmente Dockerizado para garantir paridade entre desenvolvimento e produção.

* **Database:** PostgreSQL 15 (Relacional)
* **Caching:** Redis 7 (Alta performance)
* **Messaging:** RabbitMQ (Mensageria assíncrona para o Task Processor)

---
## 🛠️ Tech Stack & Hard Skills | Tecnologias e Habilidades

* **Language / Linguagem:** Java (LTS Versions).
* **Frameworks:** Spring Cloud (Gateway, Discovery, Config Server).
* **Messaging / Mensageria:** **RabbitMQ / Apache Kafka** (Event-Driven).
* **Performance:** **Redis** (Distributed Caching / Cache Distribuído).
* **Database / Banco de Dados:** PostgreSQL + **Flyway** (Migrations).
* **Infrastructure / Infra:** Docker & Kubernetes (Orchestration / Orquestração).
* **Standards / Padrões:** Design-First, SOLID, Clean Code.

---

## 👨‍💻 Author & Engineering Mindset | Autoria e Engenharia
**Kauan Oliveira** - *Systems & Security Engineer*

<p align="left">
  <img src="https://img.shields.io/badge/Java-Enterprise-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java Enterprise">
  <img src="https://img.shields.io/badge/SOLID-Design-316192?style=for-the-badge" alt="SOLID">
  <img src="https://img.shields.io/badge/Clean-Architecture-red?style=for-the-badge" alt="Clean Arch">
</p>

**PT-BR:** Modelagem baseada em padrões estruturais para sistemas de missão crítica. Toda a lógica de desacoplamento e gestão de threads foi validada em folhas A4.

**EN-US:** Modeling based on structural patterns for mission-critical systems. All decoupling logic and thread management were validated on A4 sheets.

### 🎯 Objective / Objetivo
**EN:** Focused on High-Performance Freelancing and Bug Bounty Research.
**PT:** Atualmente focado em Freelance de Alta Performance e Pesquisa em Bug Bounty.

### 📩 Connect with Me / Contato
- **LinkedIn:** [Kauan Oliveira](https://www.linkedin.com/in/kauan-oliveira-324264378/)
- **GitHub:** [kauandias747474-hue](https://github.com/kauandias747474-hue)

---
*Developed in 2026 by Kauan Oliveira / Feito em 2026 por Kauan Oliveira*
