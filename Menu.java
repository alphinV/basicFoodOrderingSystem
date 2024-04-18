import java.util.*;

public class Menu{
    
    ArrayList<Item> menu = new ArrayList();
   
    public Menu() {
        
        generateMenu();
    
    }
    
    
    
    private void generateMenu() {
    
        Item item1 = new Item(1,"Chicken Over Rice", 7.99);
        Item item2 = new Item(2,"lamb Over Rice",7.99);
        Item item3 = new Item(3,"Chicken & lamb Combo",7.99);
        Item item4 = new Item(4,"Chicken Gyro",8.99);
        Item item5 = new Item(5,"Lamb Gyro",8.99);
        Item item6 = new Item(6,"Combo Gyro",8.99);
        Item item7 = new Item(7,"Chicken Salad",7.99);
        Item item8 = new Item(8,"Falafel Over Rice",8.99 );
        Item item9 = new Item(9,"Water",1.11);
        Item item10 = new Item(10,"Soda",1.81 );
        
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);
        menu.add(item5);
        menu.add(item6);
        menu.add(item7);
        menu.add(item8);
        menu.add(item9);
        menu.add(item10);
        
    }
 


    public ArrayList<Item> getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Menu:\n");
        for (Item item : menu) {
            sb.append(item.getId() +" "+item.getDish()).append(": $").append(item.getPrice()).append("\n");
        }
        return sb.toString();
    }

}
