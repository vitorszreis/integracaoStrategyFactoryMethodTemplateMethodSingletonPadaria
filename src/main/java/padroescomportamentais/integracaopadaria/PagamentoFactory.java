package padroescomportamentais.integracaopadaria;

public class PagamentoFactory {

    public static Pagamento obterPagamento(String pagamento) {
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("padroescomportamentais.integracaopadaria.Pagamento" + pagamento);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Pagamento inexistente");
        }
        if (!(objeto instanceof Pagamento)) {
            throw new IllegalArgumentException("Pagamento inválido");
        }
        return (Pagamento) objeto;
    }
}
