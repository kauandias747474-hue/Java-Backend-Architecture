# 💱 Conversion Service
**Pilar:** Precisão Monetária Absoluta

Responsável pela conversão de moedas e aplicação de taxas internacionais (`02-monetary-domain-rules`).

### 🧮 Regras de Engenharia
- **No Double Policy:** Uso estrito de `BigDecimal(String)` para evitar erros de arredondamento de ponto flutuante.
- **Tax Orchestration:** Integração com o `InternationalTax.java` para cálculos de tributação em tempo real.
- **Fail-Fast:** Validação de esquemas de moeda antes do processamento.
