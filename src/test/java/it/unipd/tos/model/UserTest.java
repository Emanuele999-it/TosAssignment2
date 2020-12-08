////////////////////////////////////////////////////////////////////
// [EMANUELE] [PASE] [1201250]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private User user;

	@Before
	public void setup() {
		user = new User("Emanuele","Pase",21);
	}

	@Test
	public void getNameTest() {
		assertEquals("Emanuele", user.getName());
	}

	@Test
	public void getSurnameTest() {
		assertEquals("Pase", user.getSurname());
	}

	@Test
	public void getAgeTest() {
		assertEquals(21, user.getAge());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getNameTest2() {
		new User("", "Pase",21);
	}

    @Test(expected = IllegalArgumentException.class)
    public void DataNonValidaTest() {
        new User("Emanuele","Pase",-21);
    }
}