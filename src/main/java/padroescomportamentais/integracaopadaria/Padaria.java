package padroescomportamentais.integracaopadaria;

public class Padaria {

    private Padaria() {};
    private static Padaria instance = new Padaria();
    public static Padaria getInstance() {
        return instance;
    }

    private String nome = "Padaria JF";
    private float taxaCartaoCredito = 0.03f;
    private float faturamento;
    private int quantidadeVendas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getTaxaCartaoCredito() {
        return taxaCartaoCredito;
    }

    public void setTaxaCartaoCredito(float taxaCartaoCredito) {
        this.taxaCartaoCredito = taxaCartaoCredito;
    }

    public float getFaturamento() {
        return faturamento;
    }

    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }

    public float registrarVenda(Produto produto) {
        float valor = produto.calcularPrecoFinal();
        this.faturamento += valor;
        this.quantidadeVendas++;
        return valor;
    }

    public void zerarCaixa() {
        this.faturamento = 0.0f;
        this.quantidadeVendas = 0;
    }
}
