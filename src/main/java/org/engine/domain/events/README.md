# 📡 Domain Events Engine

Este módulo implementa o padrão de **Eventos de Domínio**, permitindo que o sistema opere de forma reativa e desacoplada.

## 📝 O que é?
Eventos de domínio são notificações de que algo importante aconteceu dentro da lógica de negócio. Em vez de um motor chamar o outro diretamente (o que criaria dependência), ele simplesmente dispara um evento para o sistema.

## 🚀 Funcionalidades
* **Desacoplamento:** O `FinanceEngine` pode disparar um evento de `TransactionCompleted` sem precisar saber quem vai receber essa informação.
* **Extensibilidade:** Permite adicionar novas funções (como enviar um e-mail ou logar um alerta) apenas "ouvindo" os eventos, sem mexer no código principal.
* **Auditabilidade:** Cria um rastro histórico de todas as ações importantes que ocorreram nos motores.

## 🔄 Fluxo de Exemplo
1.  O **FinanceEngine** conclui um cálculo.
2.  Um evento `PaymentProcessedEvent` é disparado.
3.  O **TaskLogger** captura o evento e registra no log.
4.  O **TaskScheduler** captura o evento e agenda a próxima tarefa automática.
