import java.math.BigDecimal;
import java.math.RoundingMode;

public class FinanceEngine {
    public static void main(String[] args) {

        String valorDaVenda = "150.75";
        String taxaImposto = "0.05";

        try {
            BigDecimal valor = new BigDecimal(valorDaVenda);

            if (valor.signum() <= 0) {
                System.out.println("ERRO:Valor deverá ser positivo.");
                return;
            }

            BigDecimal taxa = new BigDecimal(taxaImposto);
            BigDecimal imposto = valor.multiply(taxa);


            BigDecimal total = valor.add(imposto).setScale(2, RoundingMode.HALF_EVEN);

            System.out.println("Sucesso! Total Com Imposto: " + total);


        } catch (NumberFormatException e) {
            System.out.println("Erro: não digite as letras no lugar dos números!.");
        }
    }
}

