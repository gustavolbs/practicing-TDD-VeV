package processador_de_boletos.src;

/**
 * Classe que representa um Boleto, possuindo
 * código, data e valor
 */
public class Boleto {
    
    private String codigo;
    private String data;
    private Double valor_pago;

    Boleto (String codigo, String data, Double valor_pago) {
        this.codigo = codigo;
        this.data = data;
        this.valor_pago = valor_pago;
    }

    Boleto () throws Exception {
        throw new Exception("Todos os parâmetros (String codigo, String data, Double valor_pago)" + 
        "devem ser passados ao construtor");
    }

    //getters e setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(Double valor_pago) {
        this.valor_pago = valor_pago;
    }

    @Override
    public String toString() {
        return "Boleto (" +
            "codigo = '" + this.codigo + 
            "', data = '" + this.data +
            "', valor_pago = " + this.valor_pago +
            ")";
    }
}
