import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class Filter {
  
  public ArrayList<Invoice> result(ArrayList<Invoice> invoices) {
    Calendar oneMonthAgo = Calendar.getInstance();
    oneMonthAgo.add(Calendar.MONTH, -1);
    Calendar twoMonthsAgo = Calendar.getInstance();
    twoMonthsAgo.add(Calendar.MONTH, -2);

    for (Iterator<Invoice> it = invoices.iterator(); it.hasNext();) {
      Invoice invoice = it.next();
      
      if (invoice.getValue() < 2000.00) {
          it.remove();
      }

      Boolean isValueGreaterEqual2000 = invoice.getValue() >= 2000.00;
      Boolean isValueSmallerEqual2500 = invoice.getValue() <= 2500.00;
      Boolean isDateBeforeEqualOneMonth = invoice.getDate().after(oneMonthAgo);
      if (isValueGreaterEqual2000 && isValueSmallerEqual2500 && isDateBeforeEqualOneMonth) {
        it.remove();
      }
      
      Boolean isValueGreaterEqual2500 = invoice.getValue() >= 2500.00;
      Boolean isValueSmallerEqual3000 = invoice.getValue() <= 3000.00;
      Boolean isClientDateSmallerEqualTwoMonths = invoice.getClient().getDate().after(twoMonthsAgo);
      if (isValueGreaterEqual2500 && isValueSmallerEqual3000 && isClientDateSmallerEqualTwoMonths) {
        it.remove();
      }

      String brazilSouthRegion = "Paraná|Rio Grande do Sul|Santa Catarina";
      Boolean isValueGreater4000 = invoice.getValue() > 4000.00;
      Boolean isClientStateABrazilSouthRegionState = brazilSouthRegion.contains(invoice.getClient().getState());
      if (isValueGreater4000 && isClientStateABrazilSouthRegionState) {
        it.remove();
      }
    } 
    return invoices;
  }
};
