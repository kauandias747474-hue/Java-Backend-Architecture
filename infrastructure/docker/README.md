# 🐳 Infrastructure - Containerization (Docker)

Este diretório contém as definições de infraestrutura como código (IaC) para garantir que o ecossistema funcione de forma idêntica em qualquer ambiente (Desenvolvimento, Staging ou Produção).

## 🚀 O que este módulo resolve?

O uso de Docker elimina o problema do "na minha máquina funciona". Ele encapsula todas as dependências do Java Backend, variáveis de ambiente e configurações de rede em containers isolados e leves.

## 🛠️ Componentes

* **`docker-compose.yml`**: Orquestra o backend e seus serviços auxiliares (como bancos de dados ou caches), permitindo subir todo o ambiente com um único comando: `docker-compose up`.
* **Ambiente Isolado**: Protege a máquina hospedeira e garante que o sistema tenha exatamente os recursos (CPU/Memória) que precisa.

## 💡 Valor para o Freelance
Entregar um projeto com Docker significa que o seu cliente não terá dor de cabeça para instalar o sistema. Você entrega uma solução "chave na mão", onde o deploy é rápido, seguro e profissional.
