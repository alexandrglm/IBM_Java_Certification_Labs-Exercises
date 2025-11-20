/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Module 5 - Grading Exercise 1, Grocery Store
 * 
 * 03 - Inventory
*/

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Inventory {

    // ArrayLists { {itemName},{itemPrice},{itemQuantity} }
    private ArrayList<Items> items = new ArrayList<>();

    // Create at least one empty item
    public Inventory() {

        // inits items, empty
        items.add(new Items("", "", ""));

    }

    // Methods
    // get()
    public Items get(int idx) {
        
        return items.get(idx +1); 
    }
    
    // getItems()
    public ArrayList<Items> getItems(){

        return items;

    }

    
    // createItem()
    public void createItem(String itemName, String itemPrice, String itemQuantity) {

        items.add(new Items(itemName, itemPrice, itemQuantity));

    }
    
    // readAllInventory()
    public void readAllInventory(){

        System.out.println("\n\n---> INVENTORY <--- ");

        // PENDING FIX LOOP INCREMENTING
        // .length but on arraylists. -> directly .size()
        for (
            int i = 0;
            i < items.size();
            i++
        ) {

            Items item = items.get(i);

            System.out.println(
                "  " + (i + 1) + ") " +
                item.getItemName() + " " +
                "| Price : " + item.getItemPrice() + " " +
                "| Available Stock : " + item.getItemQuantity() + " |"
            );

        }

    }
    
    // findByName()
    public int findByName(String choiceName) {

        for (
            int i = 0;
            i < items.size();
            i++
        ) {
            if( items.get(i).getItemName().toUpperCase().contains(choiceName) || items.get(i).getItemName().contains(choiceName) || items.get(i).getItemName().equalsIgnoreCase(choiceName)) {

                return i;
            }

            return -1;
        }
    }

    // findByIndex()
    // PENDING FIX
    public String findByIndex(int choiceIdx) {
        
        int choiceIdxOneBased = choiceIdx - 1;

        // if +0 or idx
        if (choiceIdxOneBased < 0 && choiceIdxOneBased <= items.size()) {

            return null;
        }

    } 

    // deteteItem()
    public void deleteItem(int choiceIndex) {

        // PENDING VALIDATION TRYCATCH ETC
        items.remove(choiceIndex);

    }

    // averagePrice()
    public float averagePrice() {

        // SUM all, divide by items index
        float summed = 0;
        float pending = 0;
        for(Items item : items) {

            // PENDINFG FIXES > Floats/Ints, private vars, applying redondeo()
            summed += item.getItemPrice();

            pending = summed / items.size();

            return pending.redondeo();

        }

        

    }
    
    // filterByPrice()
    public void filterByPrice(float maxPrice) {

        // PENDING VALIDATION, but not here, in GroceryShop
        for(Items item : items) {

            // Pending Parsing funcs to string again, not here, in 
            if(item.getItemPrice()1 < maxPrice ) {
                
                System.out.println( "\n\n --- AVAILABLE PRODUCTS UNDER " + maxPrice +" ---");
                System.out.println("   \n\n -> " + item.getItemName());

            }
        }

    }





    
}

