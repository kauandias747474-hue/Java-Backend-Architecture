# 🌐 Context Management Layer | Camada de Gerenciamento de Contexto

## 🇺🇸 English
### 📌 Purpose
This module is the "Passport" of every request. It handles **Distributed Tracing** and **Request Metadata**, ensuring that every action taken by the `FinanceEngine` or `TaskProcessor` is linked to a unique identity across the entire ecosystem.

### 🚀 Key Features
* **Correlation ID:** A unique UUID assigned to every request for end-to-end traceability.
* **Metadata Capture:** Stores IP Address, User-Agent, and origin details for fraud prevention.
* **Thread-Safety:** Optimized for **Java Virtual Threads**, ensuring context isolation without memory leaks.

---

## 🇧🇷 Português
### 📌 Objetivo
Este módulo é o "Passaporte" de cada requisição. Ele gerencia o **Rastreamento Distribuído** (Distributed Tracing) e os **Metadados da Requisição**, garantindo que cada ação tomada pelo `FinanceEngine` ou `TaskProcessor` esteja ligada a uma identidade única em todo o ecossistema.

### 🚀 Funcionalidades Principais
* **Correlation ID:** Um UUID único atribuído a cada requisição para rastreabilidade de ponta a ponta.
* **Captura de Metadados:** Armazena endereço IP, User-Agent e detalhes de origem para prevenção de fraudes.
* **Thread-Safety:** Otimizado para **Java Virtual Threads**, garantindo isolamento de contexto sem vazamentos de memória (memory leaks).
