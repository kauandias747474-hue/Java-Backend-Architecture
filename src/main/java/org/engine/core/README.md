# 🏗️ Modular Core Engineering Engines

Este repositório contém um ecossistema de processamento modular desenvolvido em Java, focado em alta escalabilidade, resiliência e precisão. A arquitetura é centrada em **Engines** independentes que operam sob os princípios de baixo acoplamento e alta coesão.

## 📂 Arquitetura do Sistema (/core)

A pasta `core` isola a lógica fundamental do sistema, permitindo que cada motor evolua sem afetar os demais:

* **`FinanceEngine`**: Núcleo de cálculo de alta precisão. Gerencia operações monetárias utilizando `BigDecimal` para eliminar erros de arredondamento e garantir integridade financeira.
* **`TaskProcessor`**: Motor de execução assíncrona. Responsável por processar cargas de trabalho pesadas em segundo plano, mantendo o sistema responsivo.
* **`TaskScheduler`**: Orquestrador temporal. Atua como o cérebro de fluxo, gerenciando gatilhos (triggers) e janelas de execução para automatizar processos.

---

## 🛠️ Módulos de Especialização (Advanced Patterns)

O projeto vai além do processamento básico, implementando padrões de nível enterprise para garantir estabilidade:

### 🛡️ Resilience & Throttling
Protege a aplicação contra falhas externas e sobrecarga:
* **Circuit Breaker:** Interrompe chamadas a serviços instáveis para evitar falhas em cascata.
* **Retry Manager:** Automatiza novas tentativas de execução em casos de erros temporários.
* **Flow Controller (Throttling):** Controla a cadência de processamento, essencial para evitar bloqueios de IP em atividades de **Bug Bounty** ou automações de API.

### 🔍 Validation & Context
Garante que apenas dados íntegros circulem pelos motores:
* **Rules & Schema Validator:** Camada de segurança que filtra e valida a estrutura dos dados de entrada.
* **Context Interceptor:** Gerencia o `CorrelationId`, permitindo rastrear uma transação por todos os módulos do sistema.

### 🔄 Idempotency & Telemetry
* **IdempotencyEngine:** Garante que operações críticas (como pagamentos) não sejam duplicadas em caso de reenvio de pacotes.
* **Engine Telemetry:** Coleta métricas de performance e saúde de cada motor para monitoramento contínuo.

---

## 🔄 Fluxo de Operação

1.  **Interceptação:** O `ContextInterceptor` gera o ID de correlação da tarefa.
2.  **Validação:** O `HighPerformanceValidator` confere a integridade dos dados.
3.  **Cálculo:** O `FinanceEngine` processa as regras de negócio e valores.
4.  **Agendamento:** O `TaskScheduler` define o momento ideal para a conclusão.
5.  **Execução:** O `TaskProcessor` realiza a tarefa final (escrita em disco, envio de API, etc).
6.  **Log:** O `EngineTelemetry` registra o sucesso da operação.

---

## 💼 Aplicações Práticas
* **Freelance:** Base sólida para sistemas de ERP, automação bancária e e-commerce.
* **Bug Bounty:** Estrutura pronta para ferramentas de reconhecimento (recon) que exigem controle estrito de requisições e logs detalhados.
* **APIs Profissionais:** Arquitetura pronta para ser exposta via Spring Boot ou Quarkus.

---
Desenvolvido com foco em **Clean Code** e **Design Patterns**.
