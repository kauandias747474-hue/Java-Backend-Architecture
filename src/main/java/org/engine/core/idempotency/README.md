# 🛡️ Idempotency Engine

Este módulo é responsável por garantir a **Idempotência** de todas as operações críticas do ecossistema. Ele assegura que realizar a mesma operação múltiplas vezes terá o mesmo efeito que realizá-la uma única vez, prevenindo duplicidade de dados e inconsistências em sistemas de larga escala.

## 📝 O que é Idempotência?

Em termos práticos: se o `FinanceEngine` processar um pagamento e a conexão cair antes de receber a confirmação, o sistema poderá tentar novamente com segurança. O `IdempotencyEngine` reconhece que aquela transação já foi iniciada e evita erros catastróficos, como cobranças duplicadas ou criação de registros repetidos no banco de dados.

## 🚀 Funcionalidades

* **Deduplicação de Requisições**: Filtra chamadas repetidas baseadas em uma `Idempotency-Key` única.
* **Controle de Estado**: Monitora se uma tarefa está em andamento, concluída ou falhou, evitando condições de corrida (*race conditions*).
* **Consistência de Dados**: Garante que, mesmo em caso de retentativas (*retries*) após falhas de rede, o estado final do sistema permaneça íntegro.

## 🛠️ Aplicação em Projetos Freelance

Em sistemas financeiros ou CRMs personalizados, a idempotência é um requisito não-funcional crítico. Ela protege a integridade do `MonetaryValue` e garante que webhooks de terceiros (como Stripe, Juno ou Gateways bancários) não causem efeitos colaterais caso sejam disparados mais de uma vez.

## 🏗️ Princípios de Design

1.  **Baixa Latência**: Camada de verificação ultra-rápida que precede a lógica de negócio.
2.  **Atomicidade**: O registro da chave e a execução da tarefa são tratados para evitar interferência mútua.
3.  **Tolerância a Falhas**: Transforma instabilidades de infraestrutura em operações previsíveis e seguras.
