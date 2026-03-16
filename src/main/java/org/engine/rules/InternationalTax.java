import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * 🏛️ PoC: International Tax Engine
 * Architecture: Strategy Pattern, Immutability & Clean Code
 * Java Version: 25 (Implicitly Declared Classes)
 */


@FunctionalInterface
interface InternationalTax {
    BigDecimal calculate(BigDecimal amount);
    default String getName() { return "Imposto Genérico"; }
}

// 2. O RESULTADO (Record - Imutabilidade e Thread-Safety)
record TaxResult(
        BigDecimal originalAmount,
        BigDecimal taxAmount,
        String taxName,
        ZonedDateTime timestamp
) {
    public BigDecimal getTotal() {
        return originalAmount.add(taxAmount);
    }
}

static class TaxEngine {
    static TaxResult compute(BigDecimal amount, InternationalTax strategy) {
       
        Objects.requireNonNull(amount, "O valor base não pode ser nulo");
        Objects.requireNonNull(strategy, "A estratégia de imposto é obrigatória");

        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor negativo não permitido para cálculo fiscal");
        }


        BigDecimal taxValue = strategy.calculate(amount)
                .setScale(2, RoundingMode.HALF_UP);

        return new TaxResult(amount, taxValue, strategy.getName(), ZonedDateTime.now());
    }
}


void main() {
    try {
        BigDecimal valorVenda = new BigDecimal("1000.00");

        // Implementação de Strategy via Lambda (Brasil)
        InternationalTax icmsBrasil = new InternationalTax() {
            @Override public BigDecimal calculate(BigDecimal amt) {
                return amt.multiply(new BigDecimal("0.18"));
            }
            @Override public String getName() { return "ICMS Brasil (18%)"; }
        };

        var resultado = TaxEngine.compute(valorVenda, icmsBrasil);


        System.out.println("--- RELATÓRIO FISCAL ---");
        System.out.println("Regra:   " + resultado.taxName());
        System.out.println("Base:    R$ " + resultado.originalAmount());
        System.out.println("Imposto: R$ " + resultado.taxAmount());
        System.out.println("Total:   R$ " + resultado.getTotal());
        System.out.println("Data:    " + resultado.timestamp());

    } catch (Exception e) {
        System.err.println("Falha Crítica no Cálculo: " + e.getMessage());
    }
}
