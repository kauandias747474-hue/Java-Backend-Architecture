
# 🛡️ Resilience & Self-Healing Engine | Motor de Resiliência e Auto-Cura

## 🇺🇸 English
### 📌 Purpose
This module ensures the system remains operational even when external dependencies (APIs, Databases, Brokers) fail. It prevents cascading failures and implements smart recovery strategies.

### 🚀 Key Components
* **Circuit Breaker:** Monitors failure rates. If a threshold is reached, it "trips" the circuit, blocking requests to the failing service to allow it to recover.
* **Retry Manager:** Implements **Exponential Backoff**. It retries failed operations with increasing delays to avoid overwhelming a struggling service.

---

## 🇧🇷 Português
### 📌 Objetivo
Este módulo garante que o sistema permaneça operacional mesmo quando dependências externas (APIs, Bancos de Dados, Brokers) falham. Ele evita falhas em cascata e implementa estratégias inteligentes de recuperação.

### 🚀 Componentes Principais
* **Circuit Breaker:** Monitora taxas de falha. Se um limite é atingido, ele "abre" o circuito, bloqueando requisições para o serviço instável para que ele possa se recuperar.
* **Retry Manager:** Implementa o **Exponential Backoff**. Ele tenta novamente operações falhas com atrasos crescentes para não sobrecarregar um serviço que está tentando voltar ao ar.
