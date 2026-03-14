# 💱 Conversion Service

## 🇧🇷 Português | 🇺🇸 English

---

### 🎯 Pilar: Precisão Monetária Absoluta
**Pillar: Absolute Monetary Precision**

O **Conversion Service** é o motor de cálculo central para operações multi-moeda. Ele garante que cada centavo seja rastreado e convertido sem perdas de precisão, aplicando regras fiscais internacionais em tempo real.
*The **Conversion Service** is the core calculation engine for multi-currency operations. It ensures every cent is tracked and converted without precision loss, applying international tax rules in real-time.*

---

### 🧮 Regras de Engenharia | Engineering Rules

* **No Double Policy:** Uso estrito de `BigDecimal(String)` para evitar erros de arredondamento inerentes ao ponto flutuante (`double`/`float`). / *Strict use of BigDecimal to avoid floating-point rounding errors.*
* **Tax Orchestration:** Integração dinâmica com o componente `InternationalTax.java` para cálculos de tributação (IOF, VAT, etc) baseados na geolocalização da transação. / *Real-time tax calculation integration.*
* **Fail-Fast Validation:** Validação rigorosa de esquemas de moeda (ISO 4217) e paridades antes de iniciar qualquer processamento custoso. / *Strict currency schema validation before processing.*

---

### ☕ Conceitos Java & Programação Aplicados

* **Banker's Rounding:** Uso de `RoundingMode.HALF_EVEN`. Este é o padrão para cálculos financeiros, pois minimiza o desvio cumulativo em grandes volumes de transações ao arredondar para o vizinho par mais próximo.
* **Strategy Pattern:** As regras de taxas por país são implementadas como estratégias desacopladas, permitindo que novas regras fiscais sejam adicionadas sem alterar o motor de conversão principal.
* **Imutabilidade:** O uso de `Java Records` para os resultados de conversão garante que os valores calculados não sofram mutação indesejada durante o fluxo de resposta.



---

### ⚙️ Funcionamento do Código | How it Works

O serviço opera sob o princípio da **Imutabilidade Financeira**. Quando um pedido de conversão chega:
1.  **Sanitização:** O valor é transformado de `String` para `BigDecimal` imediatamente.
2.  **Lookup:** Busca a paridade atual no cache (Redis).
3.  **Orquestração:** O motor de cálculo chama as estratégias de impostos aplicáveis.
4.  **Arredondamento:** Aplica a escala de precisão configurada (ex: 4 casas decimais para cálculos internos, 2 para exibição).

---
