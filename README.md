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

### 🔌 Infrastructure (`/infrastructure`)
* **Audit Logger:** Sistema de logging persistente para rastreabilidade total (Audit Trail) e conformidade com normas de segurança.

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
