public class BookAccess {

    /**
     * Read each statement in the following program.
     * Evaluate how the program creates instances or objects of Book class.
    */

    public static void main(String s[]) throws CloneNotSupportedException {

        // A)   PARAMETRISED
        Book book1 = new Book("Atomic Habits", "James Clear", 30.00f);

        // B)   NoArg, THEN USING SETTERS
        Book book2 = new Book();
        book2.setTitle("Sapiens");
        book2.setAuthor("Yuval Noah");
        book2.setPrice(25.00f);


        // From this Lab, part B CLoneable
        // CLONING ONE OBJECT INTO ANOTHER NEW OBJECT
        Book book3 = (Book)(book1.clone()); 
        /** 
         * This creates a clone of the object book1
         * book3 and book1 are identical though they are two different objects
         * BUT ...
         * REMEMBER THE  public static void main(String s[]) throws CloneNotSupportedException !!!!
         *      OUTPUT:           Unhandled exception type CloneNotSupportedException
         *      COMPILING TIME:   error: unreported exception CloneNotSupportedException; must be caught or declared to be thrown
         * Any method within which clone() method of an object is being invoked 
         * should handle CloneNotSupportedException. 
         * You will learn more about exception handling at a later point in time. 
         * Adding throws CloneNotsupportedException is like adding a warning 
         * to anticipate the exception.
         * 
         * SO ....
         * CHECK AGAIN THE SENTENCE public static void main(String s[]) throws CloneNotSupportedException {
         * NEEDS TO BE WITH THE throws!
         * AND, NOW, THIS CLASS COMPILES WITH NOT ERROR!
         */
        



        System.out.println("The 1st book object is: ");
        System.out.println(book1);

        System.out.println("The 2nd book object is: ");
        System.out.println(book2);

        System.out.println("The 3rd book object is: ");
        System.out.println(book3);
    }


    // EXERCISE: 2. Add a method in BookAccess which will compare the equality of two books
    // MODE 1, USING THE EXERCISE MODE 1 WITH NO @Override
    public static void compareBooksNotOverridingEqualsCoreMethod(Book book1Compare, Book book2Compare) {

        if ( book1Compare != null && book2Compare != null )  {

            if ( book1Compare.equals(book2Compare) ) {

                System.out.println("The two books ARE EQUALS (And the method used for comparing was NOT @Override equals()");
                

            } else {

                System.out.println("The two books ARE NOT EQUALS (And the method used for comparing was NOT @Override equals()!");

            }

        } else {

            System.out.println("CANNOT BE COMPARED! One of both ARE NULL (And the method used for comparing was NOT @Override equals()!");

        }

    }
    // MODE 2, MODE 2: Using @Override for .equals()
    public static void compareBooksOverridingEquals(Book book1Compare, Book book2Compare) {

        if ( book1Compare != null && book2Compare != null )  {

            if ( book1Compare.equals(book2Compare) ) {

                System.out.println("The two books ARE EQUALS! (And the method used for comparing was @Override-ing equals()");
                

            } else {

                System.out.println("The two books ARE NOT EQUALS (And the method used for comparing was @Override-ing equals()!");

            }

        } else {

            System.out.println("CANNOT BE COMPARED! One of both ARE NULL (And the method used for comparing was @Override-ing equals()!");

        }

    }





}


// THIS OLD CLASS... FROM Lab 01-003
// public class BookAccess {
    
//     private static void comparePrices(Book book1, Book book2) {
        
//         float book1Price = book1.getPrice();
//         float book2Price = book2.getPrice();
//         String priceCmp = "";
        
//         if (book1Price < book2Price) {
        
//             priceCmp = book1.getTitle()+" costs less than " + book2.getTitle();
        
//         } else if (book1Price == book2Price) {
        
//             priceCmp = book1.getTitle()+" costs as much as " + book2.getTitle();
        
//         } else {
        
//             priceCmp = book1.getTitle()+" costs more than " + book2.getTitle();
        
//         }
        
        
//         System.out.println(priceCmp);
//     }

//     public static void main(String s[]) {
		
//         Book book1 = new Book();
// 		book1.setTitle("Atomic Habits");
// 		book1.setAuthor("James Clear");
// 		book1.setPrice(30.00f);

// 		Book book2 = new Book();
// 		book2.setTitle("Sapiens");
// 		book2.setAuthor("Yuval Noah Harari");
// 		book2.setPrice(25.00f);

// 		System.out.println("The first book object is ");
//         System.out.println(book1);
//         System.out.println("The second book object is ");
//         System.out.println(book2);
        
//         comparePrices(book1, book2);
//     }
// }
