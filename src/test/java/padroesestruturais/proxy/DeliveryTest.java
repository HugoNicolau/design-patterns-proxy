package padroesestruturais.proxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryTest {

    @Test
    void deveCalcularTotalComFrete() {
        ServicoFreteExterno servicoReal = new ServicoFreteExterno();
        Delivery delivery = new Delivery(new ServicoFreteProxy(servicoReal));

        assertEquals(55.0f, delivery.calcularTotal(50.0f, "36036000"), 0.01f);
        assertEquals(35.0f, delivery.calcularTotal(30.0f, "36036000"), 0.01f);
        assertEquals(1, servicoReal.getTotalConsultas());
    }
}
