# 💾 Persistence & Data Integrity | Persistência e Integridade

## EN: Overview
An abstraction layer responsible for mediating communication between the Core Engine and storage mechanisms, ensuring decoupling and structural consistency.

### 🛠️ Key Components:
* **RepositoryRegistry.java**: A central facade for all repositories. It prevents "Constructor Hell" and simplifies unit testing by allowing easy Mock swapping.
* **SchemaVersionChecker.java**: A fail-fast startup validator. It compares the database migration version with the code's requirements to prevent runtime crashes.

---

## PT: Visão Geral
Camada de abstração responsável por mediar a comunicação entre o Core Engine e os mecanismos de armazenamento, garantindo desacoplamento e consistência estrutural.

### 🛠️ Componentes Principais:
* **RepositoryRegistry.java**: Uma fachada central para todos os repositórios. Evita o "Constructor Hell" e simplifica testes unitários facilitando o uso de Mocks.
* **SchemaVersionChecker.java**: Validador fail-fast de inicialização. Compara a versão de migração do banco com os requisitos do código para evitar quebras em runtime.
