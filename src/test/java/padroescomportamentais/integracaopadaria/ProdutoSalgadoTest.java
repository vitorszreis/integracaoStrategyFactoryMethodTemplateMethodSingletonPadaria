package padroescomportamentais.integracaopadaria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoSalgadoTest {

    @BeforeEach
    void setUp() {
        Padaria.getInstance().setTaxaCartaoCredito(0.03f);
        Padaria.getInstance().zerarCaixa();
    }

    @Test
    void deveIniciarComPagamentoDebito() {
        Produto produto = ProdutoFactory.obterProduto("Salgado");
        produto.setPrecoUnitario(6.0f);
        produto.setQuantidade(1);
        assertTrue(produto.getPagamento() instanceof PagamentoDebito);
    }

    @Test
    void deveRetornarPrecoFinal2UnidadesComPagamentoDebito() {
        Produto produto = ProdutoFactory.obterProduto("Salgado");
        produto.setPrecoUnitario(6.0f);
        produto.setQuantidade(2);
        produto.setPagamento(PagamentoFactory.obterPagamento("Debito"));
        assertEquals(12.0f, produto.calcularPrecoFinal(), 0.01f);
    }

    @Test
    void deveRetornarPrecoFinal6UnidadesComPagamentoDebito() {
        Produto produto = ProdutoFactory.obterProduto("Salgado");
        produto.setPrecoUnitario(6.0f);
        produto.setQuantidade(6);
        produto.setPagamento(PagamentoFactory.obterPagamento("Debito"));
        assertEquals(30.6f, produto.calcularPrecoFinal(), 0.01f);
    }

    @Test
    void deveRetornarPrecoFinal6UnidadesComPagamentoDinheiro() {
        Produto produto = ProdutoFactory.obterProduto("Salgado");
        produto.setPrecoUnitario(6.0f);
        produto.setQuantidade(6);
        produto.setPagamento(PagamentoFactory.obterPagamento("Dinheiro"));
        assertEquals(29.07f, produto.calcularPrecoFinal(), 0.01f);
    }

    @Test
    void deveRetornarPrecoFinal6UnidadesComPagamentoCredito() {
        Produto produto = ProdutoFactory.obterProduto("Salgado");
        produto.setPrecoUnitario(6.0f);
        produto.setQuantidade(6);
        produto.setPagamento(PagamentoFactory.obterPagamento("Credito"));
        assertEquals(31.518f, produto.calcularPrecoFinal(), 0.01f);
    }

    @Test
    void deveRetornarInformacoes() {
        Produto produto = ProdutoFactory.obterProduto("Salgado");
        produto.setPrecoUnitario(6.0f);
        produto.setQuantidade(2);
        produto.setNome("Coxinha");
        produto.setCodigo(3);
        assertEquals("ProdutoLanchonete{codigo=3, nome='Coxinha', precoFinal=12.0}", produto.getInfo());
    }
}
