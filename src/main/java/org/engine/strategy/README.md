# ♟️ Strategy Pattern - Tax Calculation

Este módulo utiliza o padrão de projeto **Strategy** para gerenciar a complexidade de cálculos tributários. Através da interface `TaxStrategy.java`, o sistema isola as regras fiscais de diferentes jurisdições, permitindo que o motor financeiro permaneça agnóstico às leis de cada país.

## 📝 O que é o TaxStrategy?

O `TaxStrategy.java` define um contrato único para o cálculo de impostos. Em vez de o sistema ter um código gigante cheio de `if/else` para cada país, ele simplesmente chama a "estratégia" correta para aquele contexto específico.



[Image of strategy design pattern diagram]


## 🚀 Funcionalidades

* **Intercambiabilidade**: Alterne entre regras de impostos (ex: Brasil vs EUA) em tempo de execução sem alterar o núcleo do sistema.
* **Extensibilidade**: Para suportar um novo país, basta implementar a interface `TaxStrategy` em uma nova classe.
* **Cálculo Preciso**: Trabalha em conjunto com o `MonetaryValue` para garantir que arredondamentos e conversões de moeda sigam as normas fiscais vigentes.

## 🛠️ Aplicação Prática (Freelance)

Em projetos internacionais, a capacidade de adaptar o software a diferentes leis fiscais é um diferencial crítico. 
1. **Flexibilidade**: Você pode entregar uma versão para o mercado brasileiro e, com apenas uma nova classe, expandir para o mercado americano.
2. **Segurança**: Erros em cálculos de impostos são custosos. Isolar essa lógica em estratégias testáveis minimiza riscos financeiros para o cliente.

---

## 🏗️ Como a Estrutura é Organizada

1.  **Interface (`TaxStrategy.java`)**: Define o método padrão (ex: `calculateTax(MonetaryValue amount)`).
2.  **Estratégias Concretas**: Classes como `InternationalTax` que implementam a interface com regras específicas.
3.  **Contexto**: O motor de cobrança que recebe uma `TaxStrategy` e executa o cálculo sem precisar saber os detalhes internos da lei fiscal.

---

## 🚀 Por que isso é importante?
Implementar o padrão Strategy demonstra que você domina o princípio **Open/Closed** (SOLID). O seu código está "aberto para extensão, mas fechado para modificação", o que é a marca registrada de um backend profissional e escalável.
