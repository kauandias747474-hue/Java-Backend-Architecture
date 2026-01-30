# 🛡️ Infrastructure Security Layer | Camada de Segurança de Infraestrutura

## 🇧🇷 Português

### 📌 Objetivo
Esta camada é responsável por proteger a integridade e a confidencialidade dos dados que entram e saem do sistema. Ela serve como a blindagem técnica contra ataques comuns e vazamento de informações sensíveis.

### 🚀 Componentes Adicionados
* **`sanitization/`**: Responsável por limpar inputs do usuário (XSS, SQL Injection) antes que cheguem aos motores.
* **`encryption/`**: Implementa a criptografia de campos sensíveis (Field-Level Encryption) para proteger dados no banco de dados.
* **`audit/`**: (Já existente) Garante a imutabilidade dos registros de transação via hashing.

---

## 🇺🇸 English

### 📌 Purpose
This layer is responsible for protecting the integrity and confidentiality of data entering and leaving the system. It acts as the technical shield against common attacks and sensitive data leaks.

### 🚀 Added Components
* **`sanitization/`**: Cleans user inputs (XSS, SQL Injection) before they reach the engines.
* **`encryption/`**: Implements Field-Level Encryption to protect sensitive data within the database.
* **`audit/`**: (Existing) Ensures transaction record immutability via hashing.
