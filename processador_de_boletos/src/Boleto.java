package processador_de_boletos.src;

import java.util.Date;

public class Boleto {
    
    private String codigo;
    private Date data;
    private Double valor_pago;

    Boleto (String codigo, Date data, Double valor_pago) {
        this.codigo = codigo;
        this.data = data;
        this.valor_pago = valor_pago;
    }

    Boleto () throws Exception {
        throw new Exception("Todos os parâmetros (String codigo, Date data, Double valor_pago)" + 
        "devem ser passados ao construtor");
    }

    //getters e setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(Double valor_pago) {
        this.valor_pago = valor_pago;
    }
}
