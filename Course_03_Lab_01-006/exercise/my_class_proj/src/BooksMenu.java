import java.util.Scanner;

public class BooksMenu {

    /** FROM PART C, BUT NOT TOLD IN THE GUIDE
     * I want to refactorise the MAX BOOKS ALLOWED Integer
     * 
     * The "final" word BLOCKS! the value for further modifications.
     * IMMUTABLE, UNCHANGEABLE!
     */
    private static final int MAX_BOOKS_ALLOWED = 10;
    private static final String MAX_BOOKS_STRING = "10 books added already. Cannot add any more books!";

    // FROM THIS LAB, PART C
    private static Book getExpensiveBook(Book book1, Book book2) {

        if (book1.getPrice() < book2.getPrice()) {

            return book2;

        } else {

            return book1;

        }

    }

    public static void main(String s[]) {

        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[MAX_BOOKS_ALLOWED];
        int bkIdx = 0;

        while (true) {

            System.out.println("EXERCISE MENU:\n\nPress 1 to LIST all books,\n2 to CLONE books\n3 to CHANGE a price\n4 is the legacy ADD book method,\n5 is the legacy to COMPARE prices,\n6 for Exercise COMPARE books (not overriding .equals() !)\n7 for EXERCISE COMPARE books but OVERRIDING the .equals() method\n ... or any other key to exit");

            String userAction = scanner.nextLine();

            if (userAction.equals("1")) {

                for (int i = 0; i < books.length; i++) {

                    if (books[i] != null) {

                        System.out.println(books[i]);

                    }
                }

            // EXERCISE: 3. Add a menu option 2 within the add a new object menu, to clone one of the existing books instead of creating
            } else if (userAction.equals("2")){

                if ( bkIdx == MAX_BOOKS_ALLOWED  ) {

                    System.out.println(MAX_BOOKS_STRING);
                    continue;

                }

                try {
                
                    System.out.println("Enter the INDEX book to be CLONED: ");
                    int toBeCloned = Integer.parseInt(scanner.nextLine()) -1;

                    if ( books[toBeCloned] != null ) {

                        books[bkIdx++] = (Book) books[toBeCloned].clone();


                    } else {

                        System.out.println("Source index is NOT VALID!");
                    }


                } catch (Exception e) {
                    
                    System.out.println("Error while cloning: ");
                }
                


            // EXERCISE: 4. Add a menu item 3 to the main menu, to change the price of a book at a particular index position.
            } else if (userAction.equals("3")){

                try {

                    System.out.println("Choose a book BY THE SHOWN INDEX to change its price: ");
                    for ( int i = 0; i < books.length; i++ ) {

                        if ( books[i] != null ) {

                            System.out.println("\nBOOK INDEX: " + (i+1) + " - Title: " + books[i].getTitle());

                        }

                    }

                    System.out.println("\n Enter a value: ");
                    int toBePriceModified = Integer.parseInt(scanner.nextLine() ) -1;

                    if ( toBePriceModified >= 0 && toBePriceModified < MAX_BOOKS_ALLOWED && books[toBePriceModified] != null ) {

                        System.out.println("Please, add the new price for '" + (toBePriceModified  +1 ) + "' - Title: '" + books[toBePriceModified].getTitle() + "': ");
                        float newPrice = Float.parseFloat(scanner.nextLine());
                        if ( newPrice < 0 ) {

                            System.out.println("The price CANNOT BE a negative value!");
                        
                        } else {
                            
                            books[toBePriceModified].setPrice(newPrice);
                            System.out.println("Price successfully updated to " + newPrice );
                            
                        }


                    } else {

                        System.out.println("Invalid Index, or book NOT found!");

                    }

                } catch (NumberFormatException e) {

                    System.out.println("TYPE ERROR!: Please, provide numeric value for the desired book index!");


                }



            } else if (userAction.equals("4")) {

                if (bkIdx == MAX_BOOKS_ALLOWED) {

                    System.out.println(MAX_BOOKS_STRING);
                    continue;

                }

                // FROM THIS LAB, PART C
                // CREATING NEW MENU WITH CONSTRUCTOR
                System.out.println("Which constructor do you want to use? Press 1 for DEFAULT, "
                        + "any other key for OVERLOADED constructor");
                String constructor = scanner.nextLine();

                System.out.println("Enter book title");
                String tmpTitle = scanner.nextLine();

                System.out.println("Enter book author");
                String tmpAuthor = scanner.nextLine();

                System.out.println("Enter book price");
                float tmpPrice = Float.parseFloat(scanner.nextLine());

                // LET'S OVERLOAD WITH MULTIPLE CONSTUCTORS!

                // SO, CASE "1", DEFAULT
                if (constructor.equals("1")) {

                    Book bkTmp = new Book();

                    bkTmp.setTitle(tmpTitle);
                    bkTmp.setAuthor(tmpAuthor);
                    bkTmp.setPrice(tmpPrice);

                    books[bkIdx++] = bkTmp;

                // ... CASE "2" (else), PARAMETRISED
                } else {

                    books[bkIdx++] = new Book(tmpTitle, tmpAuthor, tmpPrice);

                }

            // FROM THIS LAB, PART C
            } else if (userAction.equals("5")) {

                // LETS ADD TYPE VALIDATION WITH TRY-CATCH, ONLY FOR STUDINGF PURPOSES
                try {

                    // REMEMEBER THE ZEROBASED, SO -1
                    System.out.println("Enter INDEX of the FIRST book to compare: ");
                    int book1Idx = Integer.parseInt(scanner.nextLine()) - 1;

                    System.out.println("Enter INDEX of the SECOND book to compare: ");
                    int book2Idx = Integer.parseInt(scanner.nextLine()) - 1;

                    /**
                     * * DUE THE NONZEROBASED, LETS ADD ANOTHER PRE_VALIDATION
                     * 1. For the non-zero based
                     * 2. if < 10 (from the max 10 books allowed)
                     * 3. If not int
                     *
                     * BUT, remember...
                     * - At this point, bookXIdx WAS CONVERTED, PREVIOUSLY, TO NON-ZERO VALUES
                     * - The better way to add an Integer validation is by using try-catcg blocks
                     * * So...
                     */
                    if (book1Idx >= 0 && book1Idx < MAX_BOOKS_ALLOWED && book2Idx >= 0 && book2Idx < MAX_BOOKS_ALLOWED) {

                        if (books[book1Idx] != null && books[book2Idx] != null) {

                            System.out.println("Details of expensive book is \n"
                                    + getExpensiveBook(books[book1Idx], books[book2Idx]));

                        } else {

                            System.out.println("One of the selected book index is null!");

                        }

                    } else {

                        System.out.println("The original exercise is using ZERO-BASED Idx values,\n but I added a NON-ZERO BASED VALUES for the UX\n and, also, for handling more methods, so, please, use NON-ZERO BASED index values for this action!");

                    }

                } catch (NumberFormatException e) {

                    System.out.println("TYPE ERROR!: Please, provide numeric values for this menu");

                }



            // EXERCISE 7.ompare the books in index 0 and 1. 
            // THIS --_> Add the code to print a statement saying the two books are the same.
            // MODE 1 -> NOT OVERRIDING EQUALS METHOD!
            } else if (userAction.equals("6")) {

                System.out.println("Choose a book BY THE SHOWN INDEX to be fully compared with the another:  \n  (This option WON'T @Override .equals(), using the BookAccess.compareBooksNotOverridingEqualsCoreMethod() instead! )");
                for ( int i = 0; i < books.length; i++ ) {

                        if ( books[i] != null ) {

                            System.out.println("\nBOOK INDEX: " + (i+1) + " - Title: " + books[i].getTitle());

                        }

                    }

                try {

                    System.out.println("Enter INDEX of the FIRST book to compare: ");
                    int book1toBeFullyCompared = Integer.parseInt(scanner.nextLine()) - 1;

                    System.out.println("Enter INDEX of the SECOND book to compare: ");
                    int book2toBeFullyCompared = Integer.parseInt(scanner.nextLine()) - 1;

                    if ( book1toBeFullyCompared >= 0 && book1toBeFullyCompared < MAX_BOOKS_ALLOWED && book2toBeFullyCompared >= 0 && book2toBeFullyCompared < MAX_BOOKS_ALLOWED ) {

                        BookAccess.compareBooksNotOverridingEqualsCoreMethod(books[book1toBeFullyCompared],books[book2toBeFullyCompared]);
                    
                    } 
                
                
                } catch (Exception e) {

                    System.out.println("Error: " + e.getMessage());

                }
            // MODE 2 -> OVERRIDING EQUALS!
            } else if (userAction.equals("7")) {

                System.out.println("Choose a book BY THE SHOWN INDEX to be fully compared with the another: \n  (This option WILL @Override .equals() )");
                for ( int i = 0; i < books.length; i++ ) {

                        if ( books[i] != null ) {

                            System.out.println("\nBOOK INDEX: " + (i+1) + " - Title: " + books[i].getTitle());

                        }

                    }

                try {

                    System.out.println("Enter INDEX of the FIRST book to compare: ");
                    int book1toBeFullyCompared = Integer.parseInt(scanner.nextLine()) - 1;

                    System.out.println("Enter INDEX of the SECOND book to compare: ");
                    int book2toBeFullyCompared = Integer.parseInt(scanner.nextLine()) - 1;

                    if ( book1toBeFullyCompared >= 0 && book1toBeFullyCompared < MAX_BOOKS_ALLOWED && book2toBeFullyCompared >= 0 && book2toBeFullyCompared < MAX_BOOKS_ALLOWED ) {

                        BookAccess.compareBooksOverridingEquals(books[book1toBeFullyCompared],books[book2toBeFullyCompared]);
                    
                    } 
                
                
                } catch (Exception e) {
                       
                    System.out.println("Error: " + e.getMessage());
                
                }

            
            
            } else {

                break;

            }
        }

        scanner.close();
    }
}


// THIS OLD CLASS... FROM Lab 01-003
// import java.util.Scanner;

// public class BooksMenu {
	
//     public static void main(String s[]) {
		
//         Scanner scanner = new Scanner(System.in);
// 		Book[] books = new Book[10];
// 		int bkIdx = 0;
		
//         while(true) {
			
//             System.out.println("Press 1 to view books, 2 to add books, any other key to exit");
			
//             String userAction = scanner.nextLine();
			
//             if (userAction.equals("1")) {
			
//                 for(int i=0;i<books.length;i++) {
			
//                     if(books[i] != null) {
			
//                         System.out.println(books[i]);
			
//                     }
// 				}
			
//             } else if (userAction.equals("2")) {
			
            
//                 if(bkIdx == 10) {
			
//                     System.out.println("10 books added already. Cannot add any more books!");
// 					continue;
			
//                 }
			
//                 System.out.println("Enter book title");
			
//                 String tmpTitle = scanner.nextLine();
			
//                 System.out.println("Enter book author");
			
//                 String tmpAuthor = scanner.nextLine();
			
//                 System.out.println("Enter book price");
			
//                 float tmpPrice = Float.parseFloat(scanner.nextLine());
// 				Book bkTmp = new Book();
			
//                 bkTmp.setTitle(tmpTitle);
// 				bkTmp.setAuthor(tmpAuthor);
// 				bkTmp.setPrice(tmpPrice);
			
//                 books[bkIdx++] = bkTmp;

// 			} else {
			
//                 break;
			
//             }
// 		}

//         scanner.close();
// 	}
// }