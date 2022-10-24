package processador_de_boletos.src;

import java.util.Date;

public class Pagamento {
    
    private Double valor_pago;
    private Date data;
    private String tipo;

    Pagamento (Double valor_pago, Date data, String tipo) {
        this.valor_pago = valor_pago;
        this.data = data;
        this.tipo = tipo;
    }

    Pagamento () throws Exception {
        throw new Exception("Todos os parâmetros (Double valor_pago, Date data, String tipo)" + 
        "devem ser passados ao construtor");
    }

    //getters e setters

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(Double valor_pago) {
        this.valor_pago = valor_pago;
    }

}
