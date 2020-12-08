////////////////////////////////////////////////////////////////////
// [EMANUELE] [PASE] [1201250]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import it.unipd.tos.business.exception.TakeAwayBillException;

public class Total implements TakeAwayBill {
    
public double getOrderPrice(List<MenuItem> items, User user) throws TakeAwayBillException {
        double total = 0.0;        
        int gelComprati=0;
        double minimo=200;
        
        if (items == null) {
            throw new TakeAwayBillException("Lista nulla");
        }
        
        if (items.isEmpty()) {
            throw new TakeAwayBillException("Lista vuota");
        }

        for (MenuItem i: items) { 
            total += i.getPrice();
            double actual=i.getPrice();
            if(i.getType().equals(ItemType.Gelato)) {
               gelComprati++;
            }
            if(actual<minimo)
            {
               minimo=actual;
            }
            
            if(gelComprati>6) {
               total = total - minimo*(1/2);
            }
            
        }
        return total;     
    }
}