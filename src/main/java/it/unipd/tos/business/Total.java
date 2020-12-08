////////////////////////////////////////////////////////////////////
// [EMANUELE] [PASE] [1201250]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import it.unipd.tos.business.exception.TakeAwayBillException;

import java.util.ArrayList;
import java.util.Random;


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
        
        if(items.size() > 30) {
            throw new TakeAwayBillException("Troppi ordini");
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
        if(total<10) {
            total += 0.5;
        }
        
        if(total>50) {
            total=total*0.9;
        }
        
        return total;     
    }
    public List < TotalBillDay > FreeBills(List < TotalBillDay > bills) {

    List < TotalBillDay > Free = new ArrayList < TotalBillDay > ();

    for (TotalBillDay i: bills) {
        if (i.getUser().getAge() < 18 && (!Free.contains(i)) && Free.size() < 10 && i.getTime() >= 64800 && i.getTime() <= 68400) {
            Random rand = new Random();
            if (rand.nextBoolean()) {
                Free.add(i);
            }
        }
    }
    for (TotalBillDay i: Free) {
        i.changePrice(0.00);
    }
    return Free;
}



}