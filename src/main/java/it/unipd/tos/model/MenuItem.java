////////////////////////////////////////////////////////////////////
// [EMANUELE] [PASE] [1201250]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class MenuItem {
    ItemType itemType; 
    String name; 
    double price; 

    public MenuItem(ItemType itemType, String name, double price) {
 
    if(itemType == null) {
            throw new IllegalArgumentException("Elemento nullo");
        }
        
        if(name.isEmpty()) {
            throw new IllegalArgumentException("Nome non valido");
        }
        
        this.name = name; 
        this.price = price; 
        this.itemType = itemType; 
        
    }

    public double getPrice() {
        return price; 
    }

    public ItemType getType() {
        return itemType;
    }
    
    public String getName() {
        return name;
    }

}