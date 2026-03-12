import java.util.Scanner;

public class BooksMenuComparingExercise {

    private static void comparaPrecio(Book book1, Book book2){

        float book1Price = book1.getPrice();
        float book2Price = book2.getPrice();
        String comparadoPrecio = "";
        
		if (book1Price > book2Price) {
			
			comparadoPrecio = book2.getTitle() + " is cheaper than " + book1.getTitle();
		
		} 
		
		else if (book1Price == book2Price) {
		
			comparadoPrecio = book1.getTitle() + " has the same price as " + book2.getTitle();

		} 
		else {
			
			comparadoPrecio = book2.getTitle() + " is more expensive than " + book1.getTitle();
		
		}

        System.out.println(comparadoPrecio);

    }

	public static void main(String s[]) {
		
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
		Book[] books = new Book[10];
		int bkIdx = 0;
		
        while(true) {
		
            System.out.println("Press 1 to view books, 2 to add books, 3 to compare prices of two books,  any other key to exit");
			String userAction = scanner.nextLine();
			
            if (userAction.equals("1")) {
				
                for(int i=0;i<books.length;i++) {
					if(books[i] != null) {
						System.out.println(books[i]);
					}
				}
			
            } else if (userAction.equals("2")) {
				if(bkIdx == 10) {
					System.out.println("10 books added already. Cannot add any more books!");
					continue;
				}
				System.out.println("Enter book title");
				String tmpTitle = scanner.nextLine();
				System.out.println("Enter book author");
				String tmpAuthor = scanner.nextLine();
				System.out.println("Enter book price");
				float tmpPrice = Float.parseFloat(scanner.nextLine());
				Book bkTmp = new Book();
				bkTmp.setTitle(tmpTitle);
				bkTmp.setAuthor(tmpAuthor);
				bkTmp.setPrice(tmpPrice);
				books[bkIdx++] = bkTmp;
			

			} else if (userAction.equals("3")) {
				
				if(bkIdx < 2) {
				
					System.out.println("Sorry, more books need to be added ((Existing Books: ))" + bkIdx);
					continue;
				
				}
				
				System.out.println("AVAILABLE BOOKS:\n");
				
				for(int i=0; i<books.length; i++) {
					
					if(books[i] != null) {

						System.out.println("BOOK INDEX: " + (i+1) + " - Title: " + books[i].getTitle());
					}
				
				}
				
				System.out.println("BOOK 1) Please, choose the first book by its index: ");
				String choiceOne = scanner.nextLine();
				int idxBookOne = Integer.parseInt(choiceOne) - 1;

				if (idxBookOne >= 0 && idxBookOne < books.length && books[idxBookOne] != null) {

				} else {

					System.out.println("First book does not exist!!");
					continue;
				}
				
				System.out.println("BOOK 2) Please, choose the second book by its index: ");
				String choiceTwo = scanner.nextLine();
				int idxBookTwo = Integer.parseInt(choiceTwo) - 1; 

				if (idxBookTwo >= 0 && idxBookTwo < books.length && books[idxBookTwo] != null) {

				} else {

					System.out.println("Second book does not exist!!");
					continue;
				}
				
				comparaPrecio(books[idxBookOne], books[idxBookTwo]);
				
				
            } else {
				break;
			}
		
		}

        scanner.close();
        
	}
}