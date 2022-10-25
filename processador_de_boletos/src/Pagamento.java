package processador_de_boletos.src;

/**
 * Classe que representa um Pagamento, possuindo
 * valor pago, data e tipo. É criada toda vez 
 * que um Boleto é associado a uma Fatura
 */
public class Pagamento {
    
    private Double valor_pago;
    private String data;
    private String tipo;

    Pagamento (Double valor_pago, String data, String tipo) {
        this.valor_pago = valor_pago;
        this.data = data;
        this.tipo = tipo;
    }

    Pagamento () throws Exception {
        throw new Exception("Todos os parâmetros (Double valor_pago, String data, String tipo)" + 
        "devem ser passados ao construtor");
    }

    //getters e setters

    public String getData() {
        return data;
    }

    public void setData(String data) {
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

    //métodos

    public Boolean isIgual(Pagamento pagamento) {
        return (pagamento.toString().equals(this.toString()));
    }

    @Override
    public String toString() {
        return "Pagamento ("+
        "valor_pago = "+this.valor_pago+
        ", data = '"+this.data+
        "', tipo = '"+this.tipo+
        "')";
    }

}
