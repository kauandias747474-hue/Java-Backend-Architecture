# ⛓️ Immutable Audit Chain | Cadeia de Auditoria Imutável

## 🇧🇷 Português

### 📌 Objetivo
Este projeto implementa uma **Trilha de Auditoria Criptográfica**. Cada log de transação é vinculado ao anterior via hash SHA-256, criando uma cadeia de custódia imutável e à prova de violação para dados financeiros.

### 🚀 Funcionalidades Principais
* **Cadeia de Hashing (Hashing Chain):** Cada nova entrada armazena o hash da transação antecessora. Isso cria uma dependência matemática que torna impossível deletar ou alterar o histórico sem quebrar toda a corrente.
* **Auditoria de Integridade:** Um motor de segundo plano (`IntegrityChecker`) que percorre o banco de dados validando cada elo da corrente para garantir que não houve corrupção de dados ou intervenção externa.
* **Não-Repúdio:** Garante que, uma vez que uma transação é registrada, sua existência e histórico não podem ser negados ou forjados.

### 🏗️ Organização do Módulo
* `model/AuditEntry.java`: Define a estrutura do bloco de auditoria (ID, Hash Atual, Hash Anterior, Dados).
* `hashing/TransactionHasher.java`: O motor criptográfico que gera as "impressões digitais" usando SHA-256.
* `AuditChainManager.java`: O orquestrador que vincula a transação atual com a última registrada no banco.
* `validation/IntegrityChecker.java`: O fiscal que valida a saúde de toda a corrente.

---

## 🇺🇸 English

### 📌 Purpose
This project implements a **Cryptographic Audit Trail**. Every transaction log is linked to the previous one via SHA-256 hashing, creating a tamper-evident and immutable chain of custody for financial data.

### 🚀 Key Features
* **Hashing Chain:** Each new entry stores the hash of its predecessor. This creates a mathematical dependency that makes it impossible to delete or alter history without breaking the entire chain.
* **Integrity Auditing:** A background engine (`IntegrityChecker`) that traverses the database validating every link in the chain to ensure zero data corruption or external intervention.
* **Non-Repudiation:** Ensures that once a transaction is logged, its existence and history cannot be denied or forged.

### 🏗️ Module Organization
* `model/AuditEntry.java`: Defines the audit block structure (ID, Current Hash, Previous Hash, Data).
* `hashing/TransactionHasher.java`: The cryptographic engine that generates "fingerprints" using SHA-256.
* `AuditChainManager.java`: The orchestrator that links the current transaction with the last one recorded in the DB.
* `validation/IntegrityChecker.java`: The auditor that validates the health of the entire chain.
