package padroescomportamentais.integracaopadaria;

public class ProdutoSalgado extends Produto {

    public float calcularDesconto() {
        if (this.getQuantidade() >= 6) {
            return this.calcularValorItens() * 0.15f;
        }
        else {
            return 0.0f;
        }
    }

    @Override
    public String getTipo() {
        return "ProdutoLanchonete";
    }
}
