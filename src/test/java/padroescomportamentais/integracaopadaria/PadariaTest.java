package padroescomportamentais.integracaopadaria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PadariaTest {

    @BeforeEach
    void setUp() {
        Padaria.getInstance().setTaxaCartaoCredito(0.03f);
        Padaria.getInstance().zerarCaixa();
    }

    @Test
    void deveRetornarSempreAMesmaInstancia() {
        assertSame(Padaria.getInstance(), Padaria.getInstance());
    }

    @Test
    void deveRetornarNomePadaria() {
        Padaria.getInstance().setNome("Padaria 1");
        assertEquals("Padaria 1", Padaria.getInstance().getNome());
    }

    @Test
    void deveRegistrarVenda() {
        Produto produto = ProdutoFactory.obterProduto("Bolo");
        produto.setPrecoUnitario(40.0f);
        produto.setQuantidade(1);
        assertEquals(45.0f, Padaria.getInstance().registrarVenda(produto), 0.01f);
        assertEquals(1, Padaria.getInstance().getQuantidadeVendas());
    }

    @Test
    void deveAcumularFaturamentoDeVendas() {
        Produto pao = ProdutoFactory.obterProduto("Pao");
        pao.setPrecoUnitario(1.0f);
        pao.setQuantidade(10);
        Produto bolo = ProdutoFactory.obterProduto("Bolo");
        bolo.setPrecoUnitario(40.0f);
        bolo.setQuantidade(1);
        Produto salgado = ProdutoFactory.obterProduto("Salgado");
        salgado.setPrecoUnitario(6.0f);
        salgado.setQuantidade(2);
        Padaria.getInstance().registrarVenda(pao);
        Padaria.getInstance().registrarVenda(bolo);
        Padaria.getInstance().registrarVenda(salgado);
        assertEquals(66.0f, Padaria.getInstance().getFaturamento(), 0.01f);
        assertEquals(3, Padaria.getInstance().getQuantidadeVendas());
    }

    @Test
    void deveAplicarTaxaCartaoCreditoDefinidaNaPadaria() {
        Padaria.getInstance().setTaxaCartaoCredito(0.05f);
        Produto produto = ProdutoFactory.obterProduto("Bolo");
        produto.setPrecoUnitario(40.0f);
        produto.setQuantidade(1);
        produto.setPagamento(PagamentoFactory.obterPagamento("Credito"));
        assertEquals(47.25f, produto.calcularPrecoFinal(), 0.01f);
    }
}
