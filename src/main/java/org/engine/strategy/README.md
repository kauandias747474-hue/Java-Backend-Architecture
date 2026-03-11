# ♟️ Tax Strategy Engine (Showcase Técnico)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Clean Code](https://img.shields.io/badge/Clean_Code-AABBCC?style=for-the-badge&logo=clean-code&logoColor=black)

Este repositório é um **Showcase de Engenharia de Software** focado em demonstrar o domínio de padrões de projeto, performance e governança de dados no ecossistema Java moderno. 

> **Nota de Portfólio:** Não se trata de uma aplicação completa, mas de uma **Prova de Conceito (PoC)** sobre como construir o "Core" financeiro de um sistema escalável, resiliente e agnóstico a leis fiscais.

---

## 🚀 Pilares do Projeto

A lógica do sistema está dividida em quatro pilares fundamentais que garantem a manutenibilidade, independente da complexidade das regras de negócio:

### 1. O Contrato (Strategy Pattern) ♟️
Utilizamos o padrão **Strategy** para isolar as regras fiscais de diferentes jurisdições. O motor de cálculo é totalmente agnóstico: ele apenas executa um contrato definido por uma interface.
* **Benefício:** Permite adicionar novos impostos (Brasil, EUA, Europa) sem alterar uma única linha de código do motor principal (**Princípio Aberto/Fechado**).



### 2. O Motor (Parallel Processing) ⚙️
Para lidar com grandes volumes de dados, o processamento é feito via **Parallel Streams**. O sistema distribui as tarefas entre os múltiplos núcleos da CPU, garantindo alta performance.
* **Simulação de Latência:** Implementação de `TimeUnit` (TimeSleep) para demonstrar o comportamento multithread e o ganho de performance em tempo real.



### 3. O Porteiro (Fail-Fast & Imutabilidade) 🛡️
Utilizamos **Java Records** para garantir que os dados sejam imutáveis e seguros entre threads (Thread-safety).
* **Fail-Fast:** Validação rigorosa no construtor. O sistema impede a criação de objetos com valores negativos ou nulos, travando o erro na entrada e evitando a propagação de dados corrompidos.

### 4. A Blindagem (Precisão Bancária) 💰
Cálculos financeiros exigem precisão absoluta. O uso exaustivo de **BigDecimal** em toda a camada de cálculo elimina erros de arredondamento inerentes aos tipos primitivos (`double`/`float`), garantindo integridade centavo a centavo.

---

## 🛠️ Tecnologias e Conceitos Aplicados

| Categoria | Tecnologias / Conceitos |
| :--- | :--- |
| **Java Moderno** | Records (17+), Functional Interfaces, Lambdas, Streams API. |
| **Arquitetura** | Princípios SOLID, Strategy Design Pattern, Engenharia Defensiva. |
| **Performance** | Parallelism, Multithreading, Concurrent API. |
| **I/O & I18n** | Java NIO (Files/Paths), Internacionalização (Locale/NumberFormat). |
| **Segurança** | Privacy by Design (Anonimização de dados/Masking). |

---

## 🧠 Mentalidade de Desenvolvimento

Este projeto reflete a mentalidade de **"Privacy by Design"** através de métodos de anonimização de dados sensíveis e a aplicação de **Clean Code** para garantir que o código seja legível por humanos e executável por máquinas.

---
