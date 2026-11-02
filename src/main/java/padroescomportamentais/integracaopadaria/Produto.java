package padroescomportamentais.integracaopadaria;

public abstract class Produto {

    private int codigo;
    protected String nome;
    private float precoUnitario;
    private int quantidade;
    private Pagamento pagamento = new PagamentoDebito();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public float calcularValorItens() {
        return this.precoUnitario * this.quantidade;
    }

    public abstract float calcularDesconto();

    public float calcularTaxaEmbalagem() {
        return 0.0f;
    }

    public float calcularSubtotal() {
        return this.calcularValorItens() - this.calcularDesconto() + this.calcularTaxaEmbalagem();
    }

    public float calcularPrecoFinal() {
        return this.pagamento.calcular(this.calcularSubtotal());
    }

    public String getTipo() {
        return "Produto";
    }

    public String getInfo() {
        return getTipo() + "{" +
                "codigo=" + this.codigo +
                ", nome='" + this.nome + '\'' +
                ", precoFinal=" + this.calcularPrecoFinal() +
                '}';
    }
}
