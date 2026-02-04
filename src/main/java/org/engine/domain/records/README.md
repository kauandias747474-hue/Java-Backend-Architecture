# 🗄️ Domain Records & Persistence

O módulo `records` é responsável pela representação imutável dos dados e pelo histórico de estado do sistema.

## 📁 Componentes Principais
* **`TransactionRecord.java`**: Representa uma "foto" imutável de uma transação financeira ou de uma tarefa processada. Uma vez criado, um Record não pode ser alterado, garantindo a integridade dos dados.

## 🛠️ Por que usar Records?
* **Segurança de Thread:** Como os dados são imutáveis, eles podem ser lidos por vários motores ao mesmo tempo (Finance, Scheduler, Processor) sem risco de corrupção.
* **Integridade Financeira:** Garante que o valor calculado pelo `FinanceEngine` seja exatamente o mesmo que será salvo pelo `TaskProcessor`.
* **Compliance:** Ideal para sistemas que exigem auditoria, onde cada mudança de estado deve ser documentada e preservada.

## 💡 Aplicação em Bug Bounty/Freelance
Em ferramentas de automação, o uso de `Records` permite salvar o estado exato de uma vulnerabilidade encontrada ou de um pagamento processado, servindo como prova técnica inalterável.
