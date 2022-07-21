public class CalculadoraPorcentagemTest {
    public static void main(String[] args) {
        testCalculadoraPorcentagemValida();
        testCalculadoraPorcentagemInvalida();
    }
    public static void testCalculadoraPorcentagemValida() {
        CalculadoraPorcentagem calc = new CalculadoraPorcentagem();
        String resultado = calc.calcular(50, 1000.0);
        String resultadoEsperado = "50% de 1000,0 = 500,0";

        if(resultado.equals(resultadoEsperado)) {
            System.out.println("Teste bem sucedido!");
        } else {
            System.out.println("Teste mal sucedido!");
            System.out.println(resultado);
        }
    }

    public static void testCalculadoraPorcentagemInvalida() {
        CalculadoraPorcentagem calc = new CalculadoraPorcentagem();
        String resultado = calc.calcular(-40, 1000.0);

        if(resultado == null) {
            System.out.println("Teste bem sucedido!");
        } else {
            System.out.println("Teste mal sucedido!");
            System.out.println(resultado);
        }
    }
}

// Calculadora Porcentagem
// 1) Percentual (0 a 100)
// 2) Total = double
// "50% de 1000, 0 = 500,0"
