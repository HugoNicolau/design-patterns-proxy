package padroesestruturais.proxy;

// Cliente: só conhece ServicoFrete, não sabe se fala com o proxy ou com o serviço real.
public class Delivery {

    private ServicoFrete servicoFrete;

    public Delivery(ServicoFrete servicoFrete) {
        this.servicoFrete = servicoFrete;
    }

    public float calcularTotal(float valorPedido, String cep) {
        return valorPedido + this.servicoFrete.calcularFrete(cep);
    }
}
