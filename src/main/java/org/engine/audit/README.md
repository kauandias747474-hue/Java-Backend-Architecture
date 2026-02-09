# 🛡️ Audit Module / Módulo de Auditoria

## 🇺🇸 English Version

### 📝 Description
This module provides a robust architecture for system traceability. It separates the execution logic from the logging logic, ensuring that every event is recorded securely.

### 🚀 Solved Problems (Solutions)
* **Data Integrity:** By using **Java Records** (`AuditEntry`), we ensure immutability. Once a log is created, it cannot be altered, preventing fraud or accidental changes.
* **Consistency:** **Enums** (`Status`) eliminate "magic strings", preventing typos and ensuring standardized reports (e.g., always `SUCCESS` instead of "ok" or "done").
* **Scalability:** The **Repository Pattern** (`AuditRepository`) decouples storage. You can switch from in-memory logs to a SQL database by changing only one class.
* **Traceability:** Automatic timestamping via `LocalTime.now()` ensures precise tracking of when tasks started or failed.

---

### 🧠 Explicação Rápida da Estrutura (Para você não esquecer)

* **Status:** É a "lei". Ele diz o que é permitido.
* **AuditEntry:** É a "foto". Ele tira um print do momento (Tarefa + Status + Hora) e não deixa ninguém editar essa foto.
* **AuditRepository:** É o "arquivo". Ele guarda as fotos em ordem.
* **Main:** É o "usuário". Ele usa as ferramentas acima para realizar o trabalho.



## 🇧🇷 Versão em Português

### 📝 Descrição
Este módulo fornece uma arquitetura robusta para rastreabilidade do sistema. Ele separa a lógica de execução da lógica de registro (log), garantindo que cada evento seja gravado de forma segura.

### 🚀 Problemas Resolvidos (Soluções)
* **Integridade de Dados:** Ao usar **Java Records** (`AuditEntry`), garantimos a imutabilidade. Uma vez criado o log, ele não pode ser alterado, evitando fraudes ou modificações acidentais.
* **Consistência:** O uso de **Enums** (`Status`) elimina "strings mágicas", evitando erros de digitação e garantindo relatórios padronizados (ex: sempre `SUCESSO` em vez de "ok" ou "pronto").
* **Escalabilidade:** O padrão **Repository** (`AuditRepository`) isola o armazenamento. Você pode trocar logs em memória por um banco de dados SQL alterando apenas uma classe.
* **Rastreabilidade:** O registro automático de tempo via `LocalTime.now()` garante o rastreio preciso de quando as tarefas iniciaram ou falharam.

---

## 📂 Project Structure / Estrutura do Projeto

1. **`Status.java`**: The Dictionary / O Dicionário (Enum).
2. **`AuditEntry.java`**: The Receipt / O Recibo (Record).
3. **`AuditRepository.java`**: The Storage / O Armazenamento (Repository).
4. **`Main.java`**: The Orchestrator / O Orquestrador.









# 📂 Audit Module / Módulo de Auditoria

## 🇺🇸 English Version

### Description
This module is responsible for the security and traceability of the system. It captures every event as an immutable record to ensure that we have a "black box" of everything that happens during task execution.

### Components
* **Status.java (Enum):** Defines strict states (`PROCESSING`, `SUCCESS`, `FAILURE`, `BLOCKED`).
* **AuditEntry.java (Record):** An immutable data carrier for the log (Task Name, Status, and Timestamp).
* **AuditRepository.java (Repository):** Manages data persistence (saving and retrieving logs).


# 📝 Módulo de Auditoria (Audit System)

Este pacote contém a lógica de rastreabilidade e log do sistema. Ele foi projetado para ser independente, permitindo que qualquer execução de tarefa seja registrada de forma segura e padronizada.

## 📂 Estrutura do Pacote

O módulo é composto por quatro pilares principais:

1. **`Status.java` (Enum)**
   - Define os estados fixos que uma tarefa pode assumir.
   - **Valores:** `PROCESSANDO`, `SUCESSO`, `FALHA`, `BLOQUEADO_DUPLICIDADE`.
   - *Por que:* Evita o uso de textos manuais ("Strings mágicas") e padroniza o banco de dados.

2. **`AuditEntry.java` (Record)**
   - O objeto que carrega os dados do log.
   - **Campos:** `taskName` (String), `status` (Status), `time` (LocalTime).
   - *Por que:* Por ser um `record`, ele é imutável. Uma vez gravado, o registro não pode ser alterado, garantindo a integridade da auditoria.

3. **`AuditRepository.java` (Persistência)**
   - Responsável por salvar e recuperar os registros.
   - Implementa uma lista em memória para simular um banco de dados.
   - *Por que:* Centraliza a forma como os dados são guardados, facilitando uma futura troca para salvar em arquivos `.txt` ou SQL.

4. **`Main.java` (Entry Point / Teste)**
   - Ponto de entrada para validar a integração entre as classes acima.

## 🚀 Como Funciona (Lógica)

O fluxo de funcionamento segue o princípio de **Responsabilidade Única**:
* ***1. Uma ação ocorre no sistema.***
* ***2. Um `AuditEntry` é criado com os detalhes da ação.***
* ***3. O `AuditRepository` recebe esse objeto e o armazena.**

---

### 🧠 Explicação do Código (O que cada parte faz)



#### 1. O `Status.java` (O Dicionário)
* **O que faz:** Ele restringe as palavras que o sistema aceita. 
* **Por que importa:** Sem ele, um programador escreveria "sucesso", outro "Sucesso" e outro "ok". O computador acharia que são 3 coisas diferentes. Com o `Enum`, o Java garante que só existem aquelas 4 opções.

#### 2. O `AuditEntry.java` (O Recibo)
* **O que faz:** É um `record`. Ele apenas "segura" as informações de uma tarefa.
* **A Lógica:** Quando você cria um `new AuditEntry`, ele carimba a hora (`LocalTime.now()`) e guarda o nome e o status. Por ser imutável, ninguém consegue mudar o nome da tarefa depois que o recibo foi gerado.

#### 3. O `AuditRepository.java` (A Gaveta)
* **O que faz:** Ele gerencia uma `List` (uma lista). 
* **A Lógica:** Ele tem o método `salvar()`. Quando você entrega um `AuditEntry` para ele, ele coloca na lista e imprime na tela. Ele separa **o que** é o dado (`Entry`) de **onde** ele é guardado (`Repository`).

#### 4. O `Main.java` (O Diretor)
* **O que faz:** Ele é quem "instancia" (cria) as coisas.
* **A Lógica:** Ele cria o `AuditRepository`, cria alguns `AuditEntry` de teste e manda o repositório salvar. Ele serve para provar que a comunicação entre os arquivos está funcionando sem erros.

---


