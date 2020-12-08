package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;

import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

import org.junit.Before;
import org.junit.Test;

public class TotalBillDayTest {

	private TotalBillDay totalbill;
	private List<MenuItem> list;
	private User user;

	@Before
	public void setup() {
		user = new User("Emanuele","Pase",21);
		list = new ArrayList<MenuItem>();
		totalbill = new TotalBillDay(list,user,LocalTime.of(18, 10, 59),3.50);
		list.add(new MenuItem(ItemType.Bevanda,"Cola",3.50));
	}

	@Test
    public void getListTest() {
		assertEquals(list, totalbill.getList());
    }

	@Test
    public void getTimeTest() {
    	int second = (18*60*60) + (10*60) + 59;
        assertEquals(second,totalbill.getTime());
    }

    @Test
    public void getPriceTest() {
        assertEquals(3.50,totalbill.getPrice(),0.0);
    }
	
    @Test
    public void getUserTest() {
        assertEquals(user, totalbill.getUser());
    }

    
} 