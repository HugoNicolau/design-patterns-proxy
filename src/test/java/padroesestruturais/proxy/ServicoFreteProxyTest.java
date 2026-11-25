package padroesestruturais.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicoFreteProxyTest {

    ServicoFreteExterno servicoReal;
    ServicoFreteProxy proxy;

    @BeforeEach
    void setUp() {
        servicoReal = new ServicoFreteExterno();
        proxy = new ServicoFreteProxy(servicoReal);
    }

    @Test
    void deveRetornarFreteLocal() {
        assertEquals(5.0f, proxy.calcularFrete("36036000"), 0.01f);
    }

    @Test
    void deveRetornarFreteOutraCidade() {
        assertEquals(15.0f, proxy.calcularFrete("01001000"), 0.01f);
    }

    @Test
    void deveConsultarServicoRealUmaVezParaMesmoCep() {
        proxy.calcularFrete("36036000");
        proxy.calcularFrete("36036000");
        proxy.calcularFrete("36036000");

        assertEquals(1, servicoReal.getTotalConsultas());
    }

    @Test
    void deveConsultarServicoRealParaCadaCepDiferente() {
        proxy.calcularFrete("36036000");
        proxy.calcularFrete("01001000");
        proxy.calcularFrete("36036000");

        assertEquals(2, servicoReal.getTotalConsultas());
    }

    @Test
    void deveRetornarExcecaoCepInvalidoSemConsultarServicoReal() {
        try {
            proxy.calcularFrete("123");
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("CEP inválido", e.getMessage());
            assertEquals(0, servicoReal.getTotalConsultas());
        }
    }
}
