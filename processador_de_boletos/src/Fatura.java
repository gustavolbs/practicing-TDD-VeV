package processador_de_boletos.src;

import java.util.ArrayList;
import java.util.List;

public class Fatura {
    
    private String data;
    private Double valor_total;
    private String nome_cliente;
    private String status;
    private ArrayList<Pagamento> pagamentos;

    Fatura ( String data, Double valor_total, String nome_cliente) {
        this.data = data;
        this.valor_total = valor_total;
        this.nome_cliente = nome_cliente;
        this.status = "PENDENTE";
        this.pagamentos = new ArrayList<Pagamento>();
    }

    Fatura () throws Exception {
        throw new Exception("Todos os parâmetros (String data, Double valor_total, String nome_cliente)" + 
        "devem ser passados ao construtor");
    }

    //getters e setters

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(ArrayList<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    //métodos

    public void addPagamento (Pagamento pagamento) {
        if (pagamentos != null) {
            this.pagamentos.add(pagamento);
        }
    }

    @Override
    public String toString() {
        return "Fatura (" +
            "data = '" + this.data +
            "', valor_pago = " + this.valor_total +
            ", nome_cliente = '" + this.nome_cliente +
            "', status = '" + this.status +
            "')";
    }

}
