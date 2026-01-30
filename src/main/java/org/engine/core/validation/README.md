# ⚖️ Validation Pipeline Architecture | Arquitetura do Pipeline de Validação

## 🏗️ Structure & Responsibility | Estrutura e Responsabilidades

Para evitar códigos gigantes e bagunçados, este módulo é dividido em camadas de responsabilidade única:

### 1. `HighPerformanceValidator.java` (The Orchestrator)
* **EN:** The entry point. It uses **Java Virtual Threads** to run multiple validations in parallel. It orchestrates the flow between the schema, rules, and constraints.
* **PT:** O ponto de entrada. Usa **Virtual Threads** para rodar múltiplas validações em paralelo. Orquestra o fluxo entre o schema, as regras e as restrições.

### 2. `SchemaIntegrity.java` (Level 1: Structural)
* **EN:** Checks if the data structure is complete (Null checks, required fields, data types).
* **PT:** Verifica se a estrutura de dados está completa (Checks de nulo, campos obrigatórios, tipos de dados).

### 3. `RulesValidator.java` (Level 2: Business Logic)
* **EN:** Validates the financial logic (Non-negative amounts, correct currency codes, scale precision).
* **PT:** Valida a lógica financeira (Valores não negativos, códigos de moeda corretos, precisão decimal).

### 4. `ConstraintValidator.java` (Level 3: Hard Limits)
* **EN:** Validates technical and security limits (Maximum transaction value, protection against overflow).
* **PT:** Valida limites técnicos e de segurança (Valor máximo de transação, proteção contra overflow).

### 5. `TransactionValidator.java` (The Legacy/Bridge)
* **EN:** Acts as the main validator interface for simple or legacy transaction flows.
* **PT:** Atua como a interface principal de validação para fluxos de transação simples ou legados.

---

## 🛠️ Validation Flow | Fluxo de Validação



1.  **Request** enters `HighPerformanceValidator`.
2.  **Virtual Thread** is spawned for each transaction.
3.  `SchemaIntegrity` blocks malformed data (**Fail-Fast**).
4.  `RulesValidator` ensures the money logic is sound.
5.  `ConstraintValidator` applies security and hardware limits.
6.  **Data** is cleared for processing in the `FinanceEngine`.
