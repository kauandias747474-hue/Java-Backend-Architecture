## 📂 Estrutura do Módulo

O projeto está organizado dentro da pasta raiz de infraestrutura, separando a lógica de controle de duplicidade dos demais serviços:

* **`/idempotency`**: Pasta principal do motor de idempotência.
    * `IdempotencyEngine.java`: Classe principal contendo a lógica de cache LRU e controle de estados.
    * `Registro`: Subclasse interna que gerencia o DNA das transações (valor, status e tempo).

---

## 🛡️ Módulo: Idempotency Engine

O `IdempotencyEngine` funciona como um **Interceptor de Estado**. Ele reside entre a entrada da requisição e a lógica de negócio, garantindo que operações críticas não sejam re-executadas indevidamente.

### ⚙️ Funcionamento e Lógica de Negócio
O motor utiliza um **Cache LRU (Least Recently Used)** sincronizado para gerenciar as requisições em memória com alta performance.



#### Diferenciais da Implementação:
1.  **Objeto Registro**: Encapsula os metadados da transação, permitindo uma análise profunda além de chaves simples.
2.  **Thread-Safety**: Proteção nativa contra **Race Conditions** através de `Collections.synchronizedMap`, essencial para ambientes multi-thread.
3.  **Janela Anti-Golpe**: Bloqueio preventivo automático para tentativas idênticas em janelas menores que 30 segundos, mitigando ataques de replay.
4.  **Resiliência de Falha**: O motor diferencia sucessos de falhas. Se uma transação falhou anteriormente, ele permite a re-tentativa imediata, limpando o rastro de erro para garantir a continuidade do fluxo.

---

## 🛡️ Camadas de Defesa contra Ataques

| Ataque / Problema | Mecanismo de Defesa | Objetivo |
| :--- | :--- | :--- |
| **Double Spending** | Chave de Idempotência Única | Impedir cobranças duplicadas em tempo real. |
| **Ataque de Replay** | Validação de Timestamp | Bloquear repetição de pacotes capturados por terceiros. |
| **Race Condition** | Sincronismo de Memória | Evitar que requisições paralelas "furem" as validações de saldo. |
| **Memory Overflow** | Política de Expulsão LRU | Manter a estabilidade do servidor descartando registros antigos sob carga. |
