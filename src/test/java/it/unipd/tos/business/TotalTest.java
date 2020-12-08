////////////////////////////////////////////////////////////////////
// [EMANUELE] [PASE] [1201250]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import it.unipd.tos.business.TotalBillDay;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;


public class TotalTest {
	
	 private List<MenuItem> items;
	 private Total prova; 
	 private User user;
	
	 @Rule
	 public ExpectedException Expected = ExpectedException.none();
	 
	 @Before
	  public void setup() {
	  user = new User("Emanuele","Pase",21);
	  items = new ArrayList<MenuItem>();
	  prova = new Total();
	}	 
	
	 @Test
	  public void calcoloTotaleTest(){
	  items.add(new MenuItem( ItemType.Gelato, "BananaSplit",2.00));
	  items.add(new MenuItem( ItemType.Bevanda, "Cola", 2.50));
	  items.add(new MenuItem( ItemType.Budino, "Biancaneve", 3.25));

	  assertEquals(8.25, prova.getOrderPrice(items,user), 0.0);
	 } 
	 

	 @Test
	  public void TotaleConListaVuotaTest() throws TakeAwayBillException {
	     Expected.expect(TakeAwayBillException.class);
         prova.getOrderPrice(null, user);
	    }
	 
	 @Test
	 public void TotaleConSconto50suGelatoCostoMinTest() {
		 for (int i=0; i<5; i++) {
			 items.add(new MenuItem(ItemType.Bevanda,"Cola",2.50));
		 }
		 assertEquals(12.5,prova.getOrderPrice(items,user),0.0);
	 }
	
	 @Test(expected=TakeAwayBillException.class)
	  public void OltreTrentaElementiPerOrdineTest() {
       for(int i=0; i<31; i++) {
        items.add(new MenuItem( ItemType.Gelato, "Coppa Nafta",3.00));
        }
        prova.getOrderPrice(items, user);
       }

	 @Test
	  public void PiuDi6Gelati() {
      for(int i=0; i<8; i++) {
       items.add(new MenuItem( ItemType.Gelato,"Coppa Nafta",3.00));
       }
      assertEquals(24, prova.getOrderPrice(items,user), 0.0);
      }
       
	 @Test
	  public void CommissioneSeImportoInferioreA10EuroTest() {
	   items.add(new MenuItem( ItemType.Gelato, "Banana Split",2.00));
	   items.add(new MenuItem( ItemType.Bevanda, "Cola",2.50));
	   assertEquals(5.00, prova.getOrderPrice(items,user), 0.0);
	  }
	 
	 @Test
	  public void ScontoSeCostoOrdineE50PiuEuro() {
		 for(int i=0;i<21;i++)
         {
		   items.add(new MenuItem( ItemType.Bevanda, "Cola",2.50));
		 }
	   assertEquals(47.25, prova.getOrderPrice(items,user), 0.0);
	  }
	
     @Test
      public void OrdiniGratisTest() throws TakeAwayBillException {
       User user = null;
       List<TotalBillDay> orders = new ArrayList<TotalBillDay>();
       items.add(new MenuItem(ItemType.Gelato,"Banana Split",5.00));
       for(int i=6; i<=18; i++) {
         user = new User("Emanuele","Pase",i);
         orders.add(new TotalBillDay(items,user,LocalTime.of(18, 20, 45),prova.getOrderPrice(items, user)));
       }
       List<TotalBillDay> free = prova.FreeBills(orders);
       boolean b = false;
       if(free.size()<=10) {
       b = true;
       }	
       assertEquals(true,b);
       for(TotalBillDay i: free) {
        assertEquals(0.00,i.getPrice(),0.0);
       }
      }
}
	  
	