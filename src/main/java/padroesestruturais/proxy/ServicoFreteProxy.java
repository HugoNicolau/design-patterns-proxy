package padroesestruturais.proxy;

import java.util.HashMap;
import java.util.Map;

// Proxy de cache: só consulta o serviço real na primeira vez que vê cada CEP.
public class ServicoFreteProxy implements ServicoFrete {

    private ServicoFreteExterno servicoReal;
    private Map<String, Float> cache = new HashMap<String, Float>();

    public ServicoFreteProxy(ServicoFreteExterno servicoReal) {
        this.servicoReal = servicoReal;
    }

    @Override
    public float calcularFrete(String cep) {
        if (cep == null || !cep.matches("\\d{8}")) {
            throw new IllegalArgumentException("CEP inválido");
        }
        if (!this.cache.containsKey(cep)) {
            this.cache.put(cep, this.servicoReal.calcularFrete(cep));
        }
        return this.cache.get(cep);
    }
}
