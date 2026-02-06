# 🔍 Observability Module | Módulo de Observabilidade

## EN: Overview
This module acts as the "nervous system" of the infrastructure, ensuring the application is fully traceable, privacy-secure, and operationally resilient.

### 🛠️ Key Components:
* **OpenTelemetryConfig.java**: Configures distributed tracing. It generates and propagates `Trace IDs` across microservices to identify bottlenecks.
* **LogMasker.java**: A high-performance interceptor that uses Regex to identify and mask sensitive data (PII) like CPFs or Credit Cards in logs.
* **HealthCheckProvider.java**: Implements Liveness (process health) and Readiness (dependency health) probes for Docker/Kubernetes.

---

## PT: Visão Geral
Este módulo atua como o "sistema nervoso" da infraestrutura, garantindo que a aplicação seja totalmente rastreável, segura em termos de privacidade e resiliente operacionalmente.

### 🛠️ Componentes Principais:
* **OpenTelemetryConfig.java**: Configura o rastreamento distribuído. Gera e propaga `Trace IDs` entre microsserviços para identificar gargalos.
* **LogMasker.java**: Interceptor de alta performance que usa Regex para identificar e mascarar dados sensíveis (PII), como CPFs ou Cartões, nos logs.
* **HealthCheckProvider.java**: Implementa sondas de Liveness (saúde do processo) e Readiness (saúde das dependências) para Docker/Kubernetes.
