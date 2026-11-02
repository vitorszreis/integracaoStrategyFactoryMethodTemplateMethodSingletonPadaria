package padroescomportamentais.integracaopadaria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoPaoTest {

    @BeforeEach
    void setUp() {
        Padaria.getInstance().setTaxaCartaoCredito(0.03f);
        Padaria.getInstance().zerarCaixa();
    }

    @Test
    void deveIniciarComPagamentoDebito() {
        Produto produto = ProdutoFactory.obterProduto("Pao");
        produto.setPrecoUnitario(1.0f);
        produto.setQuantidade(1);
        assertTrue(produto.getPagamento() instanceof PagamentoDebito);
    }

    @Test
    void deveRetornarPrecoFinal5UnidadesComPagamentoDebito() {
        Produto produto = ProdutoFactory.obterProduto("Pao");
        produto.setPrecoUnitario(1.0f);
        produto.setQuantidade(5);
        produto.setPagamento(PagamentoFactory.obterPagamento("Debito"));
        assertEquals(5.0f, produto.calcularPrecoFinal(), 0.01f);
    }

    @Test
    void deveRetornarPrecoFinal10UnidadesComPagamentoDebito() {
        Produto produto = ProdutoFactory.obterProduto("Pao");
        produto.setPrecoUnitario(1.0f);
        produto.setQuantidade(10);
        produto.setPagamento(PagamentoFactory.obterPagamento("Debito"));
        assertEquals(9.0f, produto.calcularPrecoFinal(), 0.01f);
    }

    @Test
    void deveRetornarPrecoFinal10UnidadesComPagamentoDinheiro() {
        Produto produto = ProdutoFactory.obterProduto("Pao");
        produto.setPrecoUnitario(1.0f);
        produto.setQuantidade(10);
        produto.setPagamento(PagamentoFactory.obterPagamento("Dinheiro"));
        assertEquals(8.55f, produto.calcularPrecoFinal(), 0.01f);
    }

    @Test
    void deveRetornarPrecoFinal10UnidadesComPagamentoPix() {
        Produto produto = ProdutoFactory.obterProduto("Pao");
        produto.setPrecoUnitario(1.0f);
        produto.setQuantidade(10);
        produto.setPagamento(PagamentoFactory.obterPagamento("Pix"));
        assertEquals(8.73f, produto.calcularPrecoFinal(), 0.01f);
    }

    @Test
    void deveRetornarPrecoFinal10UnidadesComPagamentoCredito() {
        Produto produto = ProdutoFactory.obterProduto("Pao");
        produto.setPrecoUnitario(1.0f);
        produto.setQuantidade(10);
        produto.setPagamento(PagamentoFactory.obterPagamento("Credito"));
        assertEquals(9.27f, produto.calcularPrecoFinal(), 0.01f);
    }

    @Test
    void deveRetornarInformacoes() {
        Produto produto = ProdutoFactory.obterProduto("Pao");
        produto.setPrecoUnitario(1.0f);
        produto.setQuantidade(10);
        produto.setNome("Pão francês");
        produto.setCodigo(1);
        assertEquals("Produto{codigo=1, nome='Pão francês', precoFinal=9.0}", produto.getInfo());
    }
}
