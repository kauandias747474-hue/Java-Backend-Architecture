# ⚖️ Business Rules Engine (Policy Layer)

Este módulo centraliza as regras de decisão e políticas de conformidade do ecossistema. A pasta `rules/` é onde a lógica de negócio complexa é traduzida em código executável, separada das entidades de domínio para permitir maior flexibilidade e manutenção.

## 📝 O que são Business Rules?

Diferente das regras fundamentais do domínio, as **Business Rules** representam políticas que podem variar conforme o contexto, a legislação ou o país. O `InternationalTax.java` é o exemplo perfeito: a lógica de como o dinheiro é representado não muda (Domínio), mas o cálculo de imposto (Regra) muda dependendo de onde o cliente está.

## 🚀 Funcionalidades

* **Cálculo de Tributação Internacional**: Gerencia alíquotas e regras fiscais para transações em diferentes jurisdições.
* **Isolamento de Políticas**: Permite alterar uma regra de cálculo ou uma política de desconto sem tocar na estrutura principal do motor financeiro.
* **Validação de Conformidade**: Garante que as operações sigam as normas vigentes (ex: retenção de impostos ou limites de transferência).

---

## 🛠️ Aplicação em Projetos Freelance

Para clientes internacionais, a gestão de **International Tax** é um ponto crítico. Ter este módulo organizado demonstra:
1.  **Visão Global**: Capacidade de desenvolver sistemas que operam em múltiplos mercados e moedas.
2.  **Manutenibilidade**: Se uma lei mudar no próximo mês, você altera apenas um arquivo nesta pasta, garantindo que o software do cliente continue operando sem bugs.
3.  **Escalabilidade de Negócio**: Facilita a expansão do sistema para novos países apenas adicionando novas "Policies".

---

## 🏗️ Princípios de Design

1.  **Strategy Pattern**: As regras são implementadas de forma que possam ser trocadas em tempo de execução dependendo do contexto da transação.
2.  **Transparência**: Toda regra aplicada é documentada e pode ser auditada pelo `AuditLogger`, garantindo que o cliente saiba exatamente por que um valor foi aplicado.
3.  **Testabilidade**: Por ser lógica pura, as regras nesta pasta são ideais para testes unitários rigorosos, garantindo precisão matemática absoluta.

---

## 🚀 Por que isso é importante?
A pasta `rules/` mostra que você não "hardcodeia" lógica importante dentro dos motores. Você cria um sistema de **Políticas Flexíveis**. Isso é o que grandes empresas buscam em desenvolvedores sêniores: a capacidade de construir software que se adapta às mudanças do mercado sem precisar ser reescrito.
