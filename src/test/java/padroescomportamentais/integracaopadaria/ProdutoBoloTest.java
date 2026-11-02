package padroescomportamentais.integracaopadaria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoBoloTest {

    @BeforeEach
    void setUp() {
        Padaria.getInstance().setTaxaCartaoCredito(0.03f);
        Padaria.getInstance().zerarCaixa();
    }

    @Test
    void deveIniciarComPagamentoDebito() {
        Produto produto = ProdutoFactory.obterProduto("Bolo");
        produto.setPrecoUnitario(40.0f);
        produto.setQuantidade(1);
        assertTrue(produto.getPagamento() instanceof PagamentoDebito);
    }

    @Test
    void deveRetornarPrecoFinal1UnidadesComPagamentoDebito() {
        Produto produto = ProdutoFactory.obterProduto("Bolo");
        produto.setPrecoUnitario(40.0f);
        produto.setQuantidade(1);
        produto.setPagamento(PagamentoFactory.obterPagamento("Debito"));
        assertEquals(45.0f, produto.calcularPrecoFinal(), 0.01f);
    }

    @Test
    void deveRetornarPrecoFinal1UnidadesComPagamentoDinheiro() {
        Produto produto = ProdutoFactory.obterProduto("Bolo");
        produto.setPrecoUnitario(40.0f);
        produto.setQuantidade(1);
        produto.setPagamento(PagamentoFactory.obterPagamento("Dinheiro"));
        assertEquals(42.75f, produto.calcularPrecoFinal(), 0.01f);
    }

    @Test
    void deveRetornarPrecoFinal1UnidadesComPagamentoPix() {
        Produto produto = ProdutoFactory.obterProduto("Bolo");
        produto.setPrecoUnitario(40.0f);
        produto.setQuantidade(1);
        produto.setPagamento(PagamentoFactory.obterPagamento("Pix"));
        assertEquals(43.65f, produto.calcularPrecoFinal(), 0.01f);
    }

    @Test
    void deveRetornarPrecoFinal1UnidadesComPagamentoCredito() {
        Produto produto = ProdutoFactory.obterProduto("Bolo");
        produto.setPrecoUnitario(40.0f);
        produto.setQuantidade(1);
        produto.setPagamento(PagamentoFactory.obterPagamento("Credito"));
        assertEquals(46.35f, produto.calcularPrecoFinal(), 0.01f);
    }

    @Test
    void deveRetornarPrecoFinal2UnidadesComPagamentoDebito() {
        Produto produto = ProdutoFactory.obterProduto("Bolo");
        produto.setPrecoUnitario(40.0f);
        produto.setQuantidade(2);
        produto.setPagamento(PagamentoFactory.obterPagamento("Debito"));
        assertEquals(90.0f, produto.calcularPrecoFinal(), 0.01f);
    }

    @Test
    void deveRetornarInformacoes() {
        Produto produto = ProdutoFactory.obterProduto("Bolo");
        produto.setPrecoUnitario(40.0f);
        produto.setQuantidade(1);
        produto.setNome("Bolo de cenoura");
        produto.setCodigo(2);
        assertEquals("ProdutoConfeitaria{codigo=2, nome='Bolo de cenoura', precoFinal=45.0}", produto.getInfo());
    }
}
