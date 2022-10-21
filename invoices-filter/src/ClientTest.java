import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

public class ClientTest {

  private Client client;
  private Calendar date = Calendar.getInstance();
  private String name = "Everton Leandro Alves";
  private String state = "Paraíba";
  
  /**
   * SHOULD FAIL if any of Client fields is empty
   * CLIENT MUST HAVE NAME, STATE and DATE
   * @throws Exception
   */
  @Test(expected = Exception.class)
  public void createClientWithNoFields() throws Exception {
    client = new Client();
  }

  /**
   * SHOULD CREATE a CLIENT properly
   * CLIENT MUST HAVE NAME, STATE and DATE
   */
  @Test
  public void createInvoiceProperly() {
    client = new Client(name, date, state);
    
    assertEquals(name, client.getName());
    assertEquals(date, client.getDate());
    assertEquals(state, client.getState());
  }
}
