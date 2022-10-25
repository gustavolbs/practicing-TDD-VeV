package processador_de_boletos.src;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PagamentoTest {

    private Pagamento pagamento;
    private Double valor_pago = 130.0;
    private String data = "12-12-2020";
    private String tipo = "BOLETO";

    /**
     * Esse teste deve falhar em criar um novo Pagamento, pois os campos são vazios
     * Todos os parâmetros (Double valor_pago, String data, String tipo)
     * devem ser passados ao construtor 
     * @throws Exception
     */
    @Test
    public void createPagamentoSemCampos() throws Exception {
        pagamento = new Pagamento();
    }

    /**
     * Esse teste deve criar um Pagamento com sucesso
     * Todos os parâmetros (Double valor_pago, String data, String tipo)
     * devem ser passados ao construtor 
     */
    @Test
    public void createPagamentoCertinho() {
        pagamento = new Pagamento(valor_pago, data, tipo);

        assertEquals(valor_pago, pagamento.getValor_pago());
        assertEquals(data, pagamento.getData());
        assertEquals(tipo, pagamento.getTipo());
        
    }

}