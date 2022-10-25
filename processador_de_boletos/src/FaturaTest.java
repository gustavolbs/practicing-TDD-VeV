package processador_de_boletos.src;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FaturaTest {
    
    private Fatura fatura;
    private String data = "21-12-2020";
    private Double valor_total = 130.0;
    private String nome_cliente = "Gabriel";

    /**
     * Esse teste deve falhar em criar uma nova Fatura, pois os campos são vazios
     * Todos os parâmetros (String data, Double valor_total, String nome_cliente)
     * devem ser passados ao construtor 
     * @throws Exception
     */
    @Test
    public void createFaturaSemCampos() throws Exception {
        fatura = new Fatura();
    }

    /**
     * Esse teste deve criar uma Fatura com sucesso
     * Todos os parâmetros (String data, Double valor_total, String nome_cliente)
     * devem ser passados ao construtor 
     */
    @Test
    public void createFaturaCertinho() {
        fatura = new Fatura(data, valor_total, nome_cliente);

        assertEquals(data, fatura.getData());
        assertEquals(valor_total, fatura.getValor_total());
        assertEquals(nome_cliente, fatura.getNome_cliente());
        assertEquals("PENDENTE", fatura.getStatus());
        assertEquals(0, fatura.getPagamentos().size());
    }
}
