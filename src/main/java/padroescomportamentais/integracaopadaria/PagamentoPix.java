package padroescomportamentais.integracaopadaria;

public class PagamentoPix implements Pagamento {

    public float calcular(float valor) {
        return valor * 0.97f;
    }
}
