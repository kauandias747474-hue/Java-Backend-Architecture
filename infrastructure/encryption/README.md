# 🔐 Infrastructure - Encryption Module

Este módulo é responsável pela proteção de dados sensíveis em repouso. O `DataProtector.java` implementa padrões de criptografia forte para garantir que informações críticas nunca sejam armazenadas em texto claro.

## 📝 O que é o Data Protector?

É a camada de defesa que transforma dados legíveis em cifras criptográficas. Mesmo que haja um acesso indevido ao banco de dados, a informação permanece protegida e ilegível sem a chave mestra.

## 🚀 Funcionalidades

* **Criptografia Simétrica**: Utiliza algoritmos como AES-256 para proteger campos sensíveis (como chaves de API ou detalhes financeiros).
* **Gestão de Salt**: Adiciona camadas extras de segurança para impedir ataques de dicionário ou rainbow tables.
* **Abstração de Segurança**: O resto do sistema não precisa saber como criptografar; ele apenas chama o `DataProtector`.

## 🏗️ Por que isso é vital?
Para sistemas que lidam com dinheiro ou dados de clientes, a criptografia não é opcional, é obrigatória. Isso demonstra que você constrói softwares resilientes a vazamentos de dados.
