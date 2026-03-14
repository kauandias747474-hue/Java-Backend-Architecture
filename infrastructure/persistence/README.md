# 💾 Persistence & Data Integrity | Persistência e Integridade

## 🇧🇷 Português | 🇺🇸 English

---

### 🛡️ Visão Geral | Overview
Esta camada de abstração é responsável por mediar a comunicação entre o **Core Engine** e os mecanismos de armazenamento (PostgreSQL 15). Seu objetivo principal é garantir o desacoplamento total e a consistência estrutural, assegurando que o esquema do banco de dados evolua em sincronia com o código-fonte.
*This abstraction layer mediates communication between the **Core Engine** and storage mechanisms. It ensures full decoupling and structural consistency, making sure the database schema evolves in sync with the source code.*

---

### 🛠️ Componentes Principais | Key Components

* **RepositoryRegistry.java:** Uma Fachada (*Facade*) central para todos os repositórios. Ele resolve o problema de "Constructor Hell" em serviços complexos e simplifica a injeção de dependências em testes unitários. / *A central facade for repositories, preventing "Constructor Hell" and simplifying unit testing.*
* **SchemaVersionChecker.java:** Um validador *Fail-Fast* executado na inicialização do sistema. Ele verifica se as migrações (Flyway/Liquibase) foram aplicadas corretamente antes de permitir que o serviço aceite conexões. / *A fail-fast startup validator that checks migration versions to prevent runtime crashes.*

---

### ☕ Conceitos Java & Programação Aplicados

* **Facade Pattern:** O `RepositoryRegistry` utiliza o padrão Facade para esconder a complexidade da camada de dados, oferecendo uma interface única e limpa para as regras de negócio.
* **Fail-Fast Principle:** Através do `SchemaVersionChecker`, o sistema prefere "morrer" no boot do que operar com um banco de dados em versão incompatível, o que causaria corrupção de dados silenciosa.
* **Dependency Decoupling:** Uso de interfaces para os repositórios, permitindo que o mecanismo de storage seja trocado ou mockado sem alterar uma única linha da lógica de negócio.



---

### ⚙️ Funcionamento do Código | How it Works

1.  **Startup Validation:** Ao iniciar, o `SchemaVersionChecker` consulta a tabela de metadados do banco. Se a versão do código exigir a coluna `tax_id` e ela não existir, o sistema aborta o boot imediatamente.
2.  **Repository Access:** Em vez de um Service injetar 10 repositórios diferentes, ele injeta apenas o `RepositoryRegistry`. Isso reduz o acoplamento e facilita a manutenção do construtor da classe.
3.  **Data Consistency:** Centraliza o gerenciamento de transações, garantindo que operações complexas sigam o princípio **ACID**.



---
