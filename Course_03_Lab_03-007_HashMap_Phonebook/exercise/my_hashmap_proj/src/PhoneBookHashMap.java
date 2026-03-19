import java.util.HashMap;
import java.util.Scanner;
// From PArt B, Sort and Store
import java.util.TreeMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PhoneBookHashMap {

    // 1. DIRECT METHOPS
    private static boolean isNameValid(String name){

        String nameRegex = "^[A-Za-z' -]+$";
        if ( name.matches( nameRegex ) == false ) {

            System.out.print("Invalid Name!");
            return false;

        }

        return true;

    }

    private static boolean isNumberValid(String number) {

        String numberRegex = "^\\+\\d{1,4}([\\s\\-\\(\\)]*\\d+)+$";
        if ( number.matches( numberRegex ) == false ) {

            System.out.println("Invalid Phone Number Format!");
            return false;

        }

        return true;
    }



    // 2. MAIN
    public static void main(String[] args) {

        // 1. INITS
        Scanner scanner = new Scanner(System.in);

        HashMap<String, String> phonebook = new HashMap<>();


        while (true) {

            try {

                System.out.println(
                    "\n // PHONEBOOK TEST MENU //\n" +
                    "\n   1 to ADD an entry in the phonebook," +
                    "\n   2 to LIST ALL the entries" +
                    "\n   3 to SEARCH by name" +
                    "\n   4 to REMOVE an entry" +
                    "\n   5 to SORT list by NAME" +
                    "\n   6 to WRITE entries ON A FILE" +
                    "\n     Any other key to exit"
                );

                String userChoice = scanner.nextLine();

                // 1 to ADD an entry in the phonebook
                if ( "1".equals(userChoice) ) {

                    System.out.println("\n User NAME?: ");
                    String addName = scanner.nextLine();

                    if ( ! isNameValid(addName) ) {

                        continue;

                    }

                    if ( phonebook.containsKey(addName) ) {

                        System.out.println("This name already exists! Do you want to replace the number? y/n");
                        String confirmReplace = scanner.nextLine();

                        if ( confirmReplace.equalsIgnoreCase("n") ) {

                            continue;

                        }

                    }

                    System.out.println("\n User PHONE NUMBER?: ");
                    String addNumber = scanner.nextLine();

                    if ( ! isNumberValid(addNumber) ) {

                        continue;
                    }

                    phonebook.put(addName, addNumber);

                    System.out.println("\n  New entry added succesfully! ");

                    continue;

                // 2 to LIST ALL the entries
                } else if ( "2".equals(userChoice) ) {

                    if ( phonebook.size() <= 0 ) {

                        System.out.println("\n  Phonebook is Empty!");
                        continue;

                    }
                    
                    System.out.println("\n PHONEBOOK ALL ENTRIES:");
                    // int[] counterForEachElegante = {1};
                    // phonebook.forEach( entry -> {

                    //     System.out.println(phonebook.peek(entry));
                    //     counterForEachElegante[0]++;

                    // });
            
                    
                    for ( String name : phonebook.keySet() ) {

                        System.out.println( name + ": " + phonebook.get(name));

                    }



                    continue;


                // 3 to SEARCH by name
                } else if ( "3".equals(userChoice) ) {

                    System.out.println("\n Please, provide a NAME to SEARCH: ");
                    String nameSearch = scanner.nextLine();

                    if ( phonebook.containsKey(nameSearch) ) {

                        System.out.println( "\n   The phone number for " + nameSearch + " is: " + phonebook.get(nameSearch) );


                    } else {

                        System.out.println("\n  No matches found!");
                    }

                    continue;
                
                // 4 to REMOVE an entry
                } else if ( "4".equals(userChoice) ) {

                    System.out.println("\n Please, provide a NAME to be REMOVED: ");
                    String nameRemove = scanner.nextLine();

                    if ( phonebook.containsKey(nameRemove) ) {

                        phonebook.remove(nameRemove);

                        System.out.println( "\n   ".concat(nameRemove) + " has been removed from phonebook succesfully! ");

                    } else { 

                        System.out.println("\n  No matches found!");
                    }

                    continue;

                // 5 to SORT list by NAME"
                } else if ( "5".equals(userChoice) ) {

                    System.out.println("\n Entries SORTED by NAME:");

                    TreeMap phoneTreeMap = new TreeMap<String, String>( phonebook );

                    for ( Object keyName : phoneTreeMap.keySet() ) {

                        System.out.println( keyName + ": " + phoneTreeMap.get( (String ) keyName ) );

                    }




                // 6 to WRITE entries ON A FILE
                } else if ( "6".equals(userChoice) ) {

                    /**
                     * PASS TO A PREW OBJECT, TO ANALYSE NEW LEARNT IO METHODS
                     * 
                     * It is not possible to unroll everything as much as I would like,
                     * if the PrintWriter and FileWriter class methods are not passed
                     * as arguments inside the try, then IO exceptions cannot be handled
                     * 
                     * But the idea, the flow, is this:
                     *      1. CREATE PrintWriter varName = new PrintWriter(args)
                     *      2. The args are the creation of the FileWriter class:
                     *              new FileWriter("theFileName")
                     * 
                     */
                    String filename = "phonebook.txt";
                    
                
                    try ( PrintWriter writer = new PrintWriter( new FileWriter(filename) ) ) {

                        for ( String name : phonebook.keySet() ) {

                            writer.println( name + ": " + phonebook.get(name) );
                            
                        }

                        System.out.println("\n The entries were written to a file successfully!");

                    } catch ( IOException ioe ) {

                        System.out.print("\n   Error writing ot a file: " + ioe);

                    }

                    continue;

                
                
                } else {

                    break;
                }
        
            } catch (NumberFormatException nfe ){

                System.out.println("Invalid input...Please enter a valid number!");
            }

        }

        scanner.close();

    }

}