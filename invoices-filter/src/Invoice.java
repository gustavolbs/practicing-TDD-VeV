import java.util.Calendar;

public class Invoice {

  private Client client;
  private Calendar date;
  private Double value;
  private Integer id;

  public Invoice(Integer id, Double value, Calendar date, Client client) {
    this.client = client;
    this.date = date;
    this.value = value;
    this.id = id;
  }

  public Invoice() throws Exception {
    throw new Exception("You should provide all params properly");
  }

  public Invoice(Integer id, Double value, Calendar date) throws Exception {
    throw new Exception("You should provide a Client");
  }

  public Integer getId() {
    return id;
  }

  public Double getValue() {
    return value;
  }

  public Calendar getDate() {
    return date;
  }

  public Client getClient() {
    return client;
  }
}
