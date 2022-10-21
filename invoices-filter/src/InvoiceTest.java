import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

public class InvoiceTest {

  private Invoice invoice;
  private Client client;
  private Calendar date = Calendar.getInstance();
  private Double value = 56.93;
  private Integer id = 1231231232;
  
  /**
   * SHOULD FAIL if any of Invoice fields is empty
   * INVOICE MUST HAVE CLIENT, ID, VALUE and DATE
   * @throws Exception
   */
  @Test(expected = Exception.class)
  public void createInvoiceWithNoFields() throws Exception {
    invoice = new Invoice();
  }
  
  /**
   * SHOULD FAIL if Client field at Invoice is empty
   * INVOICE MUST HAVE CLIENT, ID, VALUE and DATE
   * @throws Exception
   */
  @Test(expected = Exception.class)
  public void createInvoiceWithNoClient() throws Exception {
    invoice = new Invoice(id, value, date);
  }

  /**
   * SHOULD CREATE an Invoice properly
   * INVOICE MUST HAVE CLIENT, ID, VALUE and DATE
   */
  @Test
  public void createInvoiceProperly() {
    client = new Client();
    invoice = new Invoice(id, value, date, client);
    
    assertEquals(id, invoice.getId());
    assertEquals(value, invoice.getValue());
    assertEquals(date, invoice.getDate());
    assertEquals(client, invoice.getClient());
  }
}
