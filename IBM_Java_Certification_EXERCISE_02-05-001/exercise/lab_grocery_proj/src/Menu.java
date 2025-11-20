/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Module 5 - Grading Exercise 1, Grocery Store
 * 
 * 05 - Menus
 *
*/

import java.util.Scanner;

public class Menu {


    // inits
    private Scanner sc;
    private Inventory inventory;
    private GroceryShop shop;

    //constr
    public Menu(Inventory inventory, GroceryShop shop, Scanner sc) {

        this.inventory = inventory;
        this.shop = shop;
        this.sc = sc;

    }

    // methods

    // mainMenu() - public, accessed by Main
    public void mainMenu() {

        /*
        1. Administrar inventarios
        2. Comprar

        3. Buscar
        4. Filtrar por precio
        5. Precio medio del inventario

        6. Salir
        
        */
        System.out.println("\n -_- GROCERY STORE -_-");
        System.out.println("  1 - INVENTORY");
        System.out.println("  2 - BUY");
        System.out.println("  3 - SEARCH ITEMS FROM INVENTORY");
        System.out.println("  4 - FILTER ITEMS BY PRICE");
        System.out.println("  5 - AVERAGE PRICE FROM INVENTORY TODAY");
        System.out.println("  6 - EXIT");

        // Scanner String choice - if "1" || menuChoice.equalsIgnoringCase("blablabla") , or contains()
        String menuChoice = sc.nextLine();


        try {

            // IF ELSE IF
            if (menuChoice.equals("1") || menuChoice.toUpperCase().contains("INVENTORY")) {

                return;
            } else if (menuChoice.equals("2") || menuChoice.toUpperCase().contains("BUY")) {

                return;
            } else if (menuChoice.equals("3") || menuChoice.toUpperCase().contains("SEARCH")) {

                return;
            } else if (menuChoice.equals("4") || menuChoice.toUpperCase().contains("FILTER"))  {

                return;
            } else if (menuChoice.equals("5") || menuChoice.toUpperCase().contains("AVERAGE")) {

                return;
            } else if (menuChoice.equals("6") || menuChoice.toUpperCase().contains("EXIT")) {

                return;
            
            } else {

                System.out.println("\n\n   [!]  Please, enter a valid option!");
                // pending a continue statement
            }


        } catch (Exception e) {

            System.out.println("\n\n    [EXCEPTION!] An error ocurred: " + e);
        
        } finally {

            sc.close();
        }
    }


    // inventoryMenu(), private, accessed by others (Menu, Inventory) but through this Menu class (1 to many)
    // TASK 4  - while
    private void inventoryMenu() {

        /*
            1. Create item
            2. Read Item
            3. Read Full Inventory
            4. Update Item
            5. Delete Item
            6. Exit
        
        
        */
        while(true) {


            System.out.println("\n\n-_-_- INVENTORY MENU -_-_-");
            System.out.println("  1 - Create Item");
            System.out.println("  2 - Read (find) ONE Item");
            System.out.println("  3 - Read (find) ALL Items");
            System.out.println("  4 - Update an Item");
            System.out.println("  5 - Delete an Item");
            System.out.println("  6 - Exit");
            


            String menuChoice = sc.nextLine();

            try {
                
                // IF ELSE IF
                if (menuChoice.equals("1")) {

                    return;

                } else if (menuChoice.equals("2")) {

                    return;
                } else if (menuChoice.equals("3")) {

                    return;
                } else if (menuChoice.equals("4")) {

                    return;
                } else if (menuChoice.equals("5")) {

                    return;
                } else if (menuChoice.equals("6") || menuChoice.toUpperCase().contains("EXIT")) {

                    return;
                
                } else {

                    System.out.println("\n\n   [!]  Please, enter a valid option!");
                    // pending a continue statement
                }

            } catch (Exception e) {

                System.out.println("\n\n    [EXCEPTION!] An error ocurred: " + e);
        
            } finally {

                sc.close();
            }

        }


        // METHODS like CRUD
        
        // createItem()
        public void createItem(){

            System.out.println("\n\n INVENTORY TOOLS:   Add new product");
            
            System.out.println("\n   -> Product Name? : ");
            String choiceName = sc.nextLine();

            System.out.println("\n   -> Product Price (includes .00 decimals) ? : ");
            String choicePrice = sc.nextLine();

            System.out.println("\n   -> How many single products will be added to stock  ? : ");
            String choiceQuantity = sc.nextLine();

            inventory.createItem(choiceName, choicePrice, choiceQuantity);



        }

        // readItem()
        public void readItem(){
            
            // pending
            
        }
        // readItems()
        public void readItems() {

        }

        // updateItems()
        public void updateItem(){

        }

        // deleteItem()
        public void deleteItem(){


            System.out.println("\n\n INVENTORY TOOLS:   Delete a product\n");
            inventory.readAllInventory();
            System.out.println("\n Type the product to be deleted: ");

            // PENDING FIX
            String choiceDelete = Integer.parseInt(sc.nextLine());
            
            int indexDelete = inventory.findByIndex(choiceDelete);
            // PENDING VALIDATION

            inventory.deleteItem(indexDelete);

        }


        // searchItem()
        public void serchItem(){

            // pending

        }
       
        // filterItem()
        public void filterItem(){

            System.out.println("\n\n INVENTORY TOOLS:   Filter Items by maxPrice\n");
            System.out.println("\n Type the product to be deleted: ");
            String choiceMaxPrice = sc.nextLine();
 
            float maxPrice = Float.parseFloat(choiceMaxPrice);

            inventory.filterByPrice(maxPrice);



        }

}