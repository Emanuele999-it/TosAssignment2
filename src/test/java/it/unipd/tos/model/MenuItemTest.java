////////////////////////////////////////////////////////////////////
// [EMANUELE] [PASE] [1201250]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class MenuItemTest {

    private MenuItem Bevanda;
    private MenuItem Gelato;

    @Rule
    public ExpectedException Expected = ExpectedException.none();
    
    @Before
    public void setup() {
        Gelato = new MenuItem( ItemType.Gelato, "Banana Split",3.00);    
    }

    @Test
    public void TipologiaElementoNulloTest() {
    	Expected.expect(IllegalArgumentException.class);
    	Expected.expectMessage("Elemento nullo");
    	new MenuItem(null,"The", 3.00);
    }

    @Test
    public void NomeElementoNulloTest() {
    	Expected.expect(IllegalArgumentException.class);
    	Expected.expectMessage("Nome non valido");
        new MenuItem(ItemType.Bevanda,"", 2.50);
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
