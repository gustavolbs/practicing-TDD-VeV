package processador_de_boletos.src;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Fatura {
    
    private Date data;
    private Double valor_total;
    private String nome_cliente;
    private String status;
    private List<Pagamento> pagamentos;

    Fatura ( Date data, Double valor_total, String nome_cliente) {
        this.data = data;
        this.valor_total = valor_total;
        this.nome_cliente = nome_cliente;
        this.status = "PENDENTE";
        this.pagamentos = new ArrayList<Pagamento>();
    }

    Fatura () throws Exception {
        throw new Exception("Todos os parâmetros (Date data, Double valor_total, String nome_cliente)" + 
        "devem ser passados ao construtor");
    }

    //getters e setters

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    //métodos

    public void addPagamento (Pagamento pagamento) {
        if (pagamentos != null) {
            this.pagamentos.add(pagamento);
        }
    }

}
