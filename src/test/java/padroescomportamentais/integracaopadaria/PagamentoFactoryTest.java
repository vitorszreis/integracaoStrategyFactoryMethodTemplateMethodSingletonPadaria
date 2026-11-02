package padroescomportamentais.integracaopadaria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoFactoryTest {

    @Test
    void deveRetornarPagamentoPix() {
        assertTrue(PagamentoFactory.obterPagamento("Pix") instanceof PagamentoPix);
    }

    @Test
    void deveRetornarExcecaoParaPagamentoInexistente() {
        try {
            Pagamento pagamento = PagamentoFactory.obterPagamento("Boleto");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Pagamento inexistente", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaPagamentoInvalido() {
        try {
            Pagamento pagamento = PagamentoFactory.obterPagamento("Cheque");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Pagamento inválido", e.getMessage());
        }
    }
}
