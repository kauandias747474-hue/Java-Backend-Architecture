
# 🧪 Proof of Concept (PoC) Lab

Este diretório contém implementações consolidadas para **Provas de Conceito**. O objetivo é isolar e validar lógicas de engenharia complexas antes da sua refatoração e integração no núcleo `org.engine`.

## 🧠 Foco: Resolução de Problemas e Prevenção de Erros

Diferente do código de produção, estas PoCs focam em testar a resistência da lógica sob stress e a mitigação de falhas sistémicas:

### ⚡ Gestão de Concorrência (Thread Safety)
* **Problema:** Corrupção de dados em acessos simultâneos (Race Conditions).
* **Solução:** Implementação de `ReentrantLock` para garantir atomicidade em operações críticas, assegurando que o estado do objeto permaneça consistente mesmo sob alta carga.

### 🛡️ Resiliência e Auto-Defesa
* **Anti-Brute Force:** Uso de `AtomicInteger` para criar contadores de falhas seguros entre threads, disparando bloqueios automáticos de estado após 3 tentativas inválidas.
* **Temporal Access Control (TTL):** Implementação de tokens com tempo de vida definido via `LocalDateTime` para prevenir ataques de repetição e uso de credenciais obsoletas.

### 🔍 Rastreabilidade e Auditoria (Audit Trail)
* **Desacoplamento de Logs:** Uso de interfaces (`IAuditoriaService`) para garantir que toda a atividade do sistema seja registada sem criar dependência direta com o sistema de ficheiros ou base de dados.

### 🔐 Integridade de Dados
* **Hashing Criptográfico:** Validação de integridade utilizando **SHA-256**, garantindo que informações sensíveis nunca circulem ou sejam armazenadas em texto simples (Plain Text).

## 🎯 Utilidade para Freelance & Bug Bounty

1. **Freelance:** Demonstra a capacidade de prototipar rapidamente soluções robustas que não falham em ambientes multi-utilizador.
2. **Bug Bounty:** Serve como laboratório para testar mitigações contra vulnerabilidades de *Broken Access Control* e *Insecure Logging*.

---
*Este laboratório segue o princípio de **Fail-Fast**: validar todas as condições de erro no início do fluxo para evitar o consumo desnecessário de recursos.*
