# 🏗️ Service Layer - Database Seeding

[🇧🇷 Português](#-português) | [🇺🇸 English](#-english)

---

## 🇧🇷 Português

Este módulo atua como a **camada de orquestração** do sistema. O `DatabaseSeeder.java` não é apenas um povoador de dados; ele é o serviço responsável por garantir que o software transite de um estado "vazio" para um **estado operacional seguro e auditado**.

### 🎯 Para que serve o Database Seeder?
O objetivo principal deste serviço é o **provisionamento automático**. Ele garante que:
1. **O primeiro acesso exista:** Cria o usuário Administrador padrão.
2. **Segurança desde o início:** As senhas iniciais já nascem criptografadas.
3. **Auditabilidade:** O nascimento do sistema gera o primeiro registro na trilha de auditoria.

### 🔗 Integração: Como ele se conecta aos outros códigos?
O `DatabaseSeeder` funciona como um "cliente" que utiliza as ferramentas disponíveis no ecossistema `org.engine`:

* **Domain:** Utiliza `User` e `Status` para criar objetos válidos.
* **Repository:** Usa `UserRepository` para verificar se o banco está vazio e salvar o Admin.
* **Infrastructure:** Usa `PasswordEncoder` para garantir segurança e o **`AuditLogger`** para gerar a primeira prova técnica de que o sistema foi iniciado com sucesso.



---

## 🇺🇸 English

This module acts as the system's **orchestration layer**. The `DatabaseSeeder.java` is more than just a data populator; it is the service responsible for ensuring the software transitions from an "empty" state to a **secure and audited operational state**.

### 🎯 What is the Database Seeder for?
The main goal of this service is **automatic provisioning**. It ensures that:
1. **First access exists:** Creates the default Administrator user.
2. **Security from the start:** Initial passwords are encrypted upon creation.
3. **Auditability:** The system's "birth" generates the first record in the audit trail.

### 🔗 Integration: How does it connect to other codes?
The `DatabaseSeeder` acts as a "client" that utilizes the tools available in the `org.engine` ecosystem:

* **Domain:** Uses `User` and `Status` to create valid objects.
* **Repository:** Uses `UserRepository` to check if the database is empty and persist the Admin.
* **Infrastructure:** Uses `PasswordEncoder` for security and the **`AuditLogger`** to generate the first technical proof that the system was successfully initialized.

---

## 🛠️ Princípios de Design / Design Principles

* **Dependency Injection (DI):** O Seeder recebe ferramentas via construtor, mantendo o código desacoplado. / *The Seeder receives tools via constructor, keeping the code decoupled.*
* **Idempotency:** Ele verifica a existência de dados antes de agir, evitando duplicidade. / *It checks for existing data before acting, avoiding duplicates.*
* **Security by Design:** Integração total com auditoria e criptografia desde o segundo zero. / *Full integration with auditing and encryption from second zero.*

---

> **Portfólio Note:** This structure demonstrates a deep understanding of **Clean Architecture** and **SOLID** principles.
