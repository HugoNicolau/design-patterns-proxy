package padroesestruturais.proxy;

// Objeto real: simula uma consulta externa "cara" e conta quantas vezes foi chamado.
public class ServicoFreteExterno implements ServicoFrete {

    private int totalConsultas = 0;

    @Override
    public float calcularFrete(String cep) {
        this.totalConsultas++;
        if (cep.startsWith("36")) {
            return 5.0f;
        }
        else {
            return 15.0f;
        }
    }

    public int getTotalConsultas() {
        return totalConsultas;
    }
}
