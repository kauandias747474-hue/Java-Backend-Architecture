**♟️ Tax Strategy Engine (Showcase Técnico)**
*Este projeto é um Showcase de Engenharia de Software focado em demonstrar o domínio de padrões de projeto, performance e governança de dados no ecossistema Java moderno. Não se trata de uma aplicação completa, mas de uma prova de conceito (PoC) sobre como construir o "Core" financeiro de um sistema escalável.*

**🚀 O que este código demonstra?**
A lógica do sistema está dividida em quatro pilares fundamentais que garantem que o software seja resiliente e fácil de manter, independente da complexidade das regras de negócio:

---
**1. O Contrato (Strategy Pattern)**
Utilizamos o padrão Strategy para isolar as regras fiscais. O motor de cálculo é totalmente agnóstico: ele apenas executa um contrato. Isso permite adicionar novos impostos (Brasil, EUA, Europa) sem alterar uma única linha de código do motor principal.

**2. O Motor (Parallel Processing)**
Para lidar com grandes volumes de dados, o processamento é feito via Parallel Streams. O sistema distribui as tarefas entre os múltiplos núcleos da CPU, garantindo alta performance. Uma simulação de latência (TimeSleep) é aplicada para demonstrar o comportamento multithread em tempo real.

**3. O Porteiro (Fail-Fast & Imutabilidade)**
Utilizamos Java Records para garantir que os dados sejam imutáveis e seguros entre threads. Aplicamos o conceito de Fail-Fast: o sistema valida os dados (como valores negativos ou nulos) no momento da criação do objeto, impedindo a propagação de erros para camadas de persistência.

**4. A Blindagem (Precisão Bancária)**
Cálculos financeiros exigem precisão absoluta. O uso de BigDecimal em toda a camada de cálculo evita erros de arredondamento inerentes aos tipos primitivos (double/float), garantindo integridade centavo a centavo.
---
**🛠️ Tecnologias e Conceitos Aplicados**
Java Moderno (17+): 
*Records, Functional Interfaces, Lambdas.*

**Performance:**
*Parallel Streams e Concurrent API.*

**I/O & I18n:**
*Java NIO (Files/Paths) e Internacionalização (Locale/NumberFormat).*

**Arquitetura:**
*Princípios SOLID, Strategy Design Pattern e Engenharia Defensiva.*

*Nota de Portfólio: Este repositório serve como demonstração de fundamentos de backend e arquitetura limpa. Ele reflete a mentalidade de "Privacy by Design" (via anonimização de dados) e "Clean Code".*
