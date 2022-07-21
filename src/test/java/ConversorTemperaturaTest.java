import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Numa classe de testes, cada método é um teste diferente
public class ConversorTemperaturaTest {
    private ConversorTemperatura conversor = new ConversorTemperatura();

    @Test
    public void testConverterCParaF() {
        double resultado = conversor.celsiusToFahrenheit(80.0);
        assertTrue(resultado == 176.0); // se o resultado da condição for true o teste deu certo
        // AssertTrue -> 'Essa condicão tem que ser verdadeira'
    }

    @Test
    public void testConverterFParaC() {
        double resultado = conversor.fahrenheitToCelsius(176.0);
        assertEquals(80.0, resultado, 0.0);
        // comparar o esperado com o resultado atual
        // AssertEquals -> 'Essa condição precisa ser exatamente igual'
    }
}