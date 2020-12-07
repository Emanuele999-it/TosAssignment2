////////////////////////////////////////////////////////////////////
// [EMANUELE] [PASE] [1201250]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MenuItemTest {

    private MenuItem Bevanda;
    private MenuItem Gelato;

    @Before
    public void setup() {
        Gelato = new MenuItem( ItemType.Gelato, "Banana Split",3.00);    
    }

    @Test(expected = IllegalArgumentException.class)
    public void TipologiaElementoNulloTest() {
        new MenuItem(null, "The", 3.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void NomeElementoNulloTest() {
        new MenuItem(ItemType.Bevanda,null, 2.50);
    }
    
    @Test
    public void getNameTest() {
        assertEquals("Banana Split", Gelato.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(3.00, Gelato.getPrice(),0.0);
    }

    @Test
    public void getTypeTest() {
        assertEquals(ItemType.Gelato, Gelato.getType());
    }
    
}
