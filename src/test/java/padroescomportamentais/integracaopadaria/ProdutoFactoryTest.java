package padroescomportamentais.integracaopadaria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoFactoryTest {

    @Test
    void deveRetornarProdutoBolo() {
        assertTrue(ProdutoFactory.obterProduto("Bolo") instanceof ProdutoBolo);
    }

    @Test
    void deveRetornarExcecaoParaProdutoInexistente() {
        try {
            Produto produto = ProdutoFactory.obterProduto("Sorvete");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Produto inexistente", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaProdutoInvalido() {
        try {
            Produto produto = ProdutoFactory.obterProduto("Encomenda");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Produto inválido", e.getMessage());
        }
    }
}
