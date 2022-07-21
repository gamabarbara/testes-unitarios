import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class VeiculoTest {
    static int totalTests;
    static DateTimeFormatter timeFormatter;

    @BeforeAll // executa antes de todos os testes
    public static void beforeAll() {
        totalTests = 0;
        timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    }

    @AfterAll // ao final de todos os testes
    public static void afterAll() {
        System.out.println("Total de testes: " + totalTests);
    }

    @BeforeEach // executa antes de CADA teste
    public void beforeEach() {
        totalTests++;
        LocalDateTime agora = LocalDateTime.now();
        System.out.println("[START] Teste #" + totalTests + " | " + agora.format(timeFormatter));
    }

    @AfterEach // executa após CADA teste
    public void afterEach() {
        LocalDateTime agora = LocalDateTime.now();
        System.out.println("[END] Teste #" + totalTests + " | " + agora.format(timeFormatter));
    }

    @Test
    public void testVeiculoNaoViajaDesligado() {
        Veiculo v1 = new Veiculo(4, 20, 2000, 10);
        boolean viajou = v1.viajar(1);
        assertFalse(viajou);
    }

    @Test
    public void testVeiculoContaCorretamenteCombustivel() {
        Veiculo v1 = new Veiculo(4, 30, 2000, 30);
        v1.ligar();
        v1.viajar(60);
        assertEquals(28.0, v1.getTanque(), 0.0);
    }

    @Test
    public void testVeiculoViajaApenasOPossivel() {
        Veiculo v1 = new Veiculo(4, 30, 2000, 30);
        v1.ligar();
        boolean viajou = v1.viajar(100_000_000);
        assertFalse(viajou);
    }

    @Test
    public void testVeiculoNaoGastaCombustivel() {
        Veiculo v1 = new Veiculo(4, 30, 2000, 30);
        double tanqueAtual = v1.getTanque();
        v1.ligar();
        v1.viajar(100_000_000);
        assertEquals(tanqueAtual, v1.getTanque(), 0.0);
    }

    // Prática I: Ajustar o método viajar() para não aceitar valores negativos
    // e criar um @Test para essa situação.
    // Prática II: Fazer teste unitário da classe CalculadoraPorcentagem (aplicar JUNIT)
    @Test
    public void testVeiculoAntigoNaoLiga() {
        Veiculo v1 = new Veiculo(4, 20, 1900, 10);
        v1.ligar();
        assertFalse(v1.getLigado());
    }

    @Test
    public void testVeiculoRecenteLiga() {
        Veiculo v1 = new Veiculo(4, 20, 2000, 10);
        v1.ligar();
        assertTrue(v1.getLigado());
    }
    // TODO Ajustar o método viajar() para não aceitar valores negativos
    // TODO Fazer teste unitario da classe CalculadoraPorcentagem (aplicar JUNIT)
}