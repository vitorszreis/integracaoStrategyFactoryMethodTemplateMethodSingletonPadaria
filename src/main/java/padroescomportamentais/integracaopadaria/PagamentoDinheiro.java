package padroescomportamentais.integracaopadaria;

public class PagamentoDinheiro implements Pagamento {

    public float calcular(float valor) {
        return valor * 0.95f;
    }
}
