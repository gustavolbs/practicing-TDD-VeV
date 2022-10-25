package processador_de_boletos.src;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoletoTest {

    private Boleto boleto;
    private String codigo = "1234";
    private String data = "21-12-2020";
    private Double valor_pago = 130.0;

    /**
     * Esse teste deve falhar em criar um novo Boleto, pois os campos são vazios
     * Todos os parâmetros (String codigo, String data, Double valor_pago) 
     * devem ser passados ao construtor 
     * @throws Exception
     */
    @Test
    public void createBoletoSemCampos() throws Exception {
        boleto = new Boleto();
    }

    /**
     * Esse teste deve criar um Boleto com sucesso
     * Todos os parâmetros (String codigo, String data, Double valor_pago) 
     * devem ser passados ao construtor 
     */
    @Test
    public void createBoletoCertinho() {
        boleto = new Boleto(codigo, data, valor_pago);

        assertEquals(codigo, boleto.getCodigo());
        assertEquals(data, boleto.getData());
        assertEquals(valor_pago, boleto.getValor_pago());
    }

}