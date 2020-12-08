////////////////////////////////////////////////////////////////////
// [EMANUELE] [PASE] [1201250]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class TotalTest {
	
	 private List<MenuItem> items;
	 private Total prova; 
	 private User user;
	
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
	 
	 
	 @Test(expected=TakeAwayBillException.class)
	  public void TotaleConListaVuotaTest() {
	   List<MenuItem> Item=null;
	   prova.getOrderPrice(Item, user);
	  }
	 
	 @Test
	 public void TotaleConSconto50suGelatoCostoMinTest() {
		 for (int i=0; i<5; i++) {
			 items.add(new MenuItem(ItemType.Bevanda,"Cola",2.50));
		 }
		 assertEquals(13,prova.getOrderPrice(items,user),0.0);
	 }
	
	 @Test(expected=TakeAwayBillException.class)
	  public void OltreTrentaElementiPerOrdineTest() {
       for(int i=0; i<35; i++) {
        items.add(new MenuItem( ItemType.Gelato, "Coppa Nafta",3.00));
        }
        prova.getOrderPrice(items, user);
       }

	 @Test
	  public void CommissioneSeImportoInferioreA10EuroTest() {
	   items.add(new MenuItem( ItemType.Gelato, "Banana Split",2.00));
	   items.add(new MenuItem( ItemType.Bevanda, "Cola",2.50));
	   assertEquals(5.00, prova.getOrderPrice(items,user), 0.0);
	  }
	 
} 
	