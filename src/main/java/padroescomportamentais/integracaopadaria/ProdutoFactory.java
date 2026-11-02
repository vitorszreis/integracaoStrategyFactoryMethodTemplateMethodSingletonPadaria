package padroescomportamentais.integracaopadaria;

public class ProdutoFactory {

    public static Produto obterProduto(String produto) {
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("padroescomportamentais.integracaopadaria.Produto" + produto);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Produto inexistente");
        }
        if (!(objeto instanceof Produto)) {
            throw new IllegalArgumentException("Produto inválido");
        }
        return (Produto) objeto;
    }
}
