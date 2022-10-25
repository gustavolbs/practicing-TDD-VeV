import java.util.Calendar;

public class Client {

  private Calendar date;
  private String name;
  private String state;

  public Client(String name, Calendar date, String state) {
    this.date = date;
    this.name = name;
    this.state = state;
  }

  public Client() throws Exception {
    throw new Exception("You should provide all params properly");
  }

  public Calendar getDate() {
    return date;
  }

  public String getName() {
    return name;
  }

  public String getState() {
    return state;
  }
}
