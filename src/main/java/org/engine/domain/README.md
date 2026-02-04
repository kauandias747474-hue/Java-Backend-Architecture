# 🏛️ Domain Layer (Core Business Logic)

Esta camada contém o coração da inteligência de negócio do ecossistema. O domínio é isolado de detalhes técnicos (como frameworks ou bancos de dados), seguindo os princípios de **Domain-Driven Design (DDD)**.

## 🧱 Componentes do Domínio

### 💎 Value Objects
* **`MonetaryValue.java`**: Representa um valor monetário imutável. Ao invés de usar tipos primitivos, utilizamos este objeto para encapsular regras de arredondamento, validação de moeda e precisão matemática. Isso evita erros clássicos de "pontos flutuantes" em sistemas financeiros.

### 📡 Eventos (`/events`)
Gerencia o desacoplamento do sistema. Quando uma regra de negócio é satisfeita, um evento é disparado para que outros motores (como o `TaskProcessor`) saibam que devem agir, sem que o Domínio precise conhecer quem são os executores.

### 🗄️ Records (`/records`)
Define os modelos de dados imutáveis. Os `Records` garantem que, uma vez que uma transação ou estado seja definido pelo Domínio, ele não sofra alterações acidentais durante o transporte entre os motores.

---

## 🛠️ Princípios Aplicados

1. **Imutabilidade**: Objetos de valor e registros não podem ser alterados após a criação, garantindo segurança em ambientes multi-thread.
2. **Encapsulamento Total**: As regras de validação financeira residem dentro dos objetos de domínio, impedindo a circulação de dados inválidos pelo sistema.
3. **Lógica Pura**: Este código é agnóstico a infraestrutura, facilitando testes unitários e portabilidade para diferentes tipos de integração (Freelance ou Ferramentas de Segurança).

---

## 🚀 Por que isso é importante?
Em projetos de **Freelance de alto nível**, a organização da camada de domínio é o que diferencia um sistema que "apenas funciona" de um sistema que "pode ser escalado". No contexto de **Bug Bounty**, essa estrutura permite criar scanners e validadores extremamente precisos, onde o dado é tratado com rigor técnico antes de qualquer execução.
