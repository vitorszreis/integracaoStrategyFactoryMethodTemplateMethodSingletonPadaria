package padroescomportamentais.integracaopadaria;

public class ProdutoBolo extends Produto {

    public float calcularDesconto() {
        return 0.0f;
    }

    @Override
    public float calcularTaxaEmbalagem() {
        return 5.0f * this.getQuantidade();
    }

    @Override
    public String getTipo() {
        return "ProdutoConfeitaria";
    }
}
