import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;


public class FilterTest {
  private Calendar date = Calendar.getInstance(); // TODAY
  private Integer id = 1231231232;
  private String name = "Everton Leandro Alves";
  private String state = "Paraíba";
  
  /**
   * Filter should remove invoices with 
   * value smaller than 2000
   */
  @Test
  public void removeInvoicesSmallerThan2000() {
    Filter filter = new Filter();
    // Should be empty initially
    assertEquals(0, filter.result().size());

    Client client = new Client(name, date, state);
    Invoice invoice1 = new Invoice(id, 400.00, date, client);
    Invoice invoice2 = new Invoice(id, 1999.99, date, client);
    Invoice invoice3 = new Invoice(id, 2000.00, date, client);
    Invoice invoice4 = new Invoice(id, 2100.00, date, client);
    
    ArrayList<Invoice> invoices = new ArrayList<Invoice>();
    invoices.add(invoice1);
    invoices.add(invoice2);
    invoices.add(invoice3);
    invoices.add(invoice4);

    ArrayList<Invoice> filteredInvoices = filter.result(invoices);
    // Should have two invoices (invoice3, invoice4)
    assertEquals(2, filteredInvoices.size());
  }

  /**
   * Filter should remove invoices that has 
   * value between 2000 and 2500 and
   * date less equal to one month ago;
   */
  @Test
  public void removeInvoiceBetween2000And2500AndDateLessEqualToOneMonth() {
    Filter filter = new Filter();
    
    Calendar oneMonthAndADayAgo = Calendar.getInstance();
    oneMonthAndADayAgo.add(Calendar.MONTH, -1);
    oneMonthAndADayAgo.add(Calendar.DATE, -1);

    Calendar twoMonthsAndADayAgo = Calendar.getInstance();
    twoMonthsAndADayAgo.add(Calendar.MONTH, -2);
    twoMonthsAndADayAgo.add(Calendar.DATE, -1);


    // This client has more than two months due to next Test Case that checks
    // for client inclusion date
    Client client = new Client(name, twoMonthsAndADayAgo, state);
    Invoice invoice1 = new Invoice(id, 2000.00, oneMonthAndADayAgo, client);
    Invoice invoice2 = new Invoice(id, 2000.00, date, client);
    Invoice invoice3 = new Invoice(id, 2500.00, date, client);
    Invoice invoice4 = new Invoice(id, 2500.00, oneMonthAndADayAgo, client);
    
    ArrayList<Invoice> invoices = new ArrayList<Invoice>();
    invoices.add(invoice1);
    invoices.add(invoice2);
    invoices.add(invoice3);
    invoices.add(invoice4);

    ArrayList<Invoice> filteredInvoices = filter.result(invoices);
    // Should have two invoices (invoice1, invoice4)
    assertEquals(2, filteredInvoices.size());
  }
  
  /**
   * Filter should remove invoices that has 
   * value between 2500 and 3000 and
   * client date less equal to two months ago;
   */
  @Test
  public void removeInvoiceBetween2000And2500AndClientDateLessEqualToTwoMonths() {
    Filter filter = new Filter();

    Calendar twoMonthsAndADayAgo = Calendar.getInstance();
    twoMonthsAndADayAgo.add(Calendar.MONTH, -2);
    twoMonthsAndADayAgo.add(Calendar.DATE, -1);
    
    Client client1 = new Client(name, date, state);
    Client client2 = new Client(name, twoMonthsAndADayAgo, state);
    Invoice invoice1 = new Invoice(id, 2500.00, date, client1);
    Invoice invoice2 = new Invoice(id, 2500.00, date, client2);
    Invoice invoice3 = new Invoice(id, 3000.00, date, client1);
    Invoice invoice4 = new Invoice(id, 3000.00, date, client2);
    
    ArrayList<Invoice> invoices = new ArrayList<Invoice>();
    invoices.add(invoice1);
    invoices.add(invoice2);
    invoices.add(invoice3);
    invoices.add(invoice4);

    ArrayList<Invoice> filteredInvoices = filter.result(invoices);
    // Should have two invoices (invoice2, invoice4)
    assertEquals(2, filteredInvoices.size());
  }
  
  
  /**
   * Filter should remove invoices that has 
   * value greater than 4000 and
   * client state is at Brazil South region;
   */
  @Test
  public void removeInvoiceGreaterThan4000AndClientStateIsAtBrazilSouthRegion() {
    Filter filter = new Filter();

    Client client1 = new Client(name, date, state);
    Client client2 = new Client(name, date, "Paraná");
    Client client3 = new Client(name, date, "Rio Grande do Sul");
    Client client4 = new Client(name, date, "Santa Catarina");
    Invoice invoice1 = new Invoice(id, 4000.01, date, client1);
    Invoice invoice2 = new Invoice(id, 4000.01, date, client2);
    Invoice invoice3 = new Invoice(id, 4000.01, date, client3);
    Invoice invoice4 = new Invoice(id, 4000.01, date, client4);
    Invoice invoice5 = new Invoice(id, 4000.00, date, client1);
    
    ArrayList<Invoice> invoices = new ArrayList<Invoice>();
    invoices.add(invoice1);
    invoices.add(invoice2);
    invoices.add(invoice3);
    invoices.add(invoice4);
    invoices.add(invoice5);

    ArrayList<Invoice> filteredInvoices = filter.result(invoices);
    // Should have two invoices (invoice1, invoice5)
    assertEquals(2, filteredInvoices.size());
  }
}
