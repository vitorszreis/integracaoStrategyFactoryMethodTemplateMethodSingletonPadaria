package padroescomportamentais.integracaopadaria;

public class PagamentoCredito implements Pagamento {

    public float calcular(float valor) {
        return valor * (1 + Padaria.getInstance().getTaxaCartaoCredito());
    }
}
