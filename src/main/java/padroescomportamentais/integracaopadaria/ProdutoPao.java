package padroescomportamentais.integracaopadaria;

public class ProdutoPao extends Produto {

    public float calcularDesconto() {
        if (this.getQuantidade() >= 10) {
            return this.calcularValorItens() * 0.10f;
        }
        else {
            return 0.0f;
        }
    }

}
