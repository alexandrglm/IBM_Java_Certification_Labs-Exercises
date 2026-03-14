# Course 3 - Lab 01-006: Constructors

Estimated time needed: 30 minutes

In this lab, you will learn how to create a special overloaded constructor for a class and create its instances in Java.  

## Learning Objectives

After completing this lab, you will be able to:

- Create an overloaded constructor
- Learn how to implement encapsulation using constructor overloading
- Explain how to create instances of the class using overloaded constructors
- Clone an object of the class

---

## A) Adding an overloaded constructor

If your `Book.java` and BookAccess.java programs and classes from the previous exercise is still intact, you can go step 6 on this page.

> CHECK PREVIOUS EXERCISE [HERE](../../Course_03_Lab_01-003/01-003_LAB_Classes-Guide.md)

Steps 1 through 5 to create the classes.

- Create a project directory by running the following command.

```bash
mkdir my_class_proj
```

- Run the following code to create the directory structure.

```bash
mkdir -p my_class_proj/src
mkdir -p my_class_proj/classes
mkdir -p my_class_proj/test
cd my_class_proj
```

- Create a file named Book.java inside the src directory.

```bash
touch /home/project/my_class_proj/src/Book.java
```

- Select the following button to open the file for editing.

- Read each statement in the following program and focusing on how the program defines the attributes and functions of Book class.

Paste the following content in Book.java.

```java
public class Book {
    private String title;
    private String author;
    private float price;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public float getPrice() {
        return this.price;
    }

    public String toString() {
        return "Title - " + this.title + "\nAuthor - "
            + this.author + "\nPrice - "+ String.format("%.2f", this.price);
    }
}
```

When you create an overloaded constructor, another constructor with the same name (using the class name) but different sets of parameters, you need to also create a default constructor.

- Add the following code in Book.java, after the attributes.

```java
public Book() {
    this.title = null;
    this.author = null;
}

public Book(String title, String author, float price) {
    this.title = title;
    this.author = author;
    this.price = price;
}
```

**`public Book()`** - This is the default constructor, which will create an instance but the values will have to be explicitly set with the setters.

**`public Book(String title, String author, float price)`** - This is the constructor of the class which takes three parameters for each of the attribute. The value of each of the attribute is set with the parameter passed.

- Compile the java program, specifying the destination directory as the classes directory that you created.

```bash
javac -d classes src/Book.java
```

- Set the CLASSPATH variable.

```bash
export CLASSPATH=$CLASSPATH:/home/project/my_class_proj/classes
```

- Create a new file named BookAccess.java.

```bash
touch /home/project/my_class_proj/src/BookAccess.java
```

- Select the following button to open the file for editing.

- Read each statement in the following program. Evaluate how the program creates instances or objects of Book class.

Paste the following content in BookAccess.java.

```java
public class BookAccess {
    public static void main(String s[]) {
        Book book1 = new Book("Atomic Habits", "James Clear", 30.00f);

        Book book2 = new Book();
        book2.setTitle("Sapiens");
        book2.setAuthor("Yuval Noah Harari");
        book2.setPrice(25.00f);

        System.out.println("The first book object is ");
        System.out.println(book1);
        System.out.println("The second book object is ");
        System.out.println(book2);
    }
}
```

- Compile the Java program, specifying the destination directory as the classes directory that you created.

```bash
javac -d classes src/BookAccess.java
```

- Run the program.

```bash
java BookAccess
```

You will see the following output:

```plaintext
The first book object is
Title - Atomic Habits
Author - James Clear
Price - 30.00
The second book object is
Title - Sapiens
Author - Yuval Noah Harari
Price - 25.00
```

---

## B) Implement Cloneable interface to allow cloning

An Object of a class is not by default cloneable. To create a clone of the object, you will need to create an object and explicitly use setters and getters. This technique is not ideal, especially when the class has too many attributes. Java provides the Cloneable interface for this purpose.

- Select the following button to open Book.java for editing.

- Add the following code within the Book class in place of the existing code.

```java
public class Book implements Cloneable {
    private String title;
    private String author;
    private float price;

    public Book() {
        this.title = null;
        this.author = null;
    }

    public Book(String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Overriding the clone() method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public float getPrice() {
        return this.price;
    }

    public String toString() {
        return "Title - " + this.title + "\nAuthor - "
            + this.author + "\nPrice - "+ String.format("%.2f", this.price);
    }
}
```

**`public class Book implements Cloneable`** - This code explicitly says that the class will implement the clone method which will enable clone of instances or objects of this class.

**`protected Object clone() throws CloneNotSupportedException`** - This method calls the super class clone method which would internally clone all the attributes of the object into a new object.

- Compile the java program, specifying the destination directory as the classes directory that you created.

```bash
javac -d classes src/Book.java
```

- Select the following button to open the file for editing.

- Read each statement in the following program and evaluate how program creates the instances or objects of Book class.

Paste the following content in BookAccess.java.

```java
public class BookAccess {
    public static void main(String s[]) throws CloneNotSupportedException {
        Book book1 = new Book("Atomic Habits", "James Clear", 30.00f);

        Book book2 = new Book();
        book2.setTitle("Sapiens");
        book2.setAuthor("Yuval Noah Harari");
        book2.setPrice(25.00f);

        System.out.println("The first book object is ");
        System.out.println(book1);
        System.out.println("The second book object is ");
        System.out.println(book2);

        Book book3 = (Book)(book1.clone());
        System.out.println("The third book cloned object is ");
        System.out.println(book3);

    }
}
```

**`public static void main(String s[]) throws CloneNotSupportedException`** - Any method within which clone() method of an object is being invoked should handle CloneNotSupportedException. You will learn more about exception handling at a later point in time. Adding throws CloneNotSupportedException is like adding a warning to anticipate the exception.

**`Book book3 = (Book)(book1.clone());`** - This creates a clone of the object book1. book3 and book1 are identical though they are two different objects.

- Compile the java program, specifying the destination directory as the classes directory that you created.

```bash
javac -d classes src/BookAccess.java
```

- Run the program.

```bash
java BookAccess
```

You will see the following output:

```plaintext
The first book object is
Title - Atomic Habits
Author - James Clear
Price - 30.00
The second book object is
Title - Sapiens
Author - Yuval Noah Harari
Price - 25.00
The third book cloned object is
Title - Atomic Habits
Author - James Clear
Price - 30.00
```

---

## C) Provide user menu

You will now change a command line app to manage books allowing the user to select the constructor.

- Create a file named BooksMenu.java inside the src directory.

```bash
touch /home/project/my_class_proj/src/BooksMenu.java
```

- Select the following button to open the file for editing.

- Read each statement in the following program and review how the program creates the Books array, how the program adds books to the array, and the program retrieves books. Paste the following content in BooksMenu.java.

```java
import java.util.Scanner;


public class BooksMenu {
    private static Book getExpensiveBook(Book book1, Book book2) {
        if (book1.getPrice()<book2.getPrice()) {
            return book2;
        } else {
            return book1;
        }
    }

    public static void main(String s[]) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[10];
        int bkIdx = 0;
        while(true) {
            System.out.println("Press 1 to view books, 2 to add books, "+
                                "3 to compare prices of books, any other key to exit");
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
                System.out.println("Which constructor do you want to use? Press 1 for default,"+
                                    "any other key for overloaded constructor");
                String constructor = scanner.nextLine();
                System.out.println("Enter book title");
                String tmpTitle = scanner.nextLine();
                System.out.println("Enter book author");
                String tmpAuthor = scanner.nextLine();
                System.out.println("Enter book price");
                float tmpPrice = Float.parseFloat(scanner.nextLine());
                if (constructor.equals("1")) {
                    Book bkTmp = new Book();
                    bkTmp.setTitle(tmpTitle);
                    bkTmp.setAuthor(tmpAuthor);
                    bkTmp.setPrice(tmpPrice);
                    books[bkIdx++] = bkTmp;
                } else {
                    books[bkIdx++] = new Book(tmpTitle, tmpAuthor, tmpPrice);
                }
            } else if (userAction.equals("3")) {
                System.out.println("Enter index of first book to compare");
                int book1Idx = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter index of second book to compare");
                int book2Idx = Integer.parseInt(scanner.nextLine());

                if (books[book1Idx] != null && books[book2Idx] != null ) {
                    System.out.println("The details of expensive book is \n"+getExpensiveBook(books[book1Idx],books[book2Idx]));
                } else {
                    System.out.println("One of the books is null");
                }
            } else {
                break;
            }
        }
    }
}
```

**`import java.util.Scanner;`** - Allows the program to use the Scanner class for taking input from the user.

**`Scanner scanner`** - Used to read user input from the console.

**`Book[] books = new Book[10]`** - Creates an array of size 10 to store up to 10 Book objects. At a later point when you learn about collections, you can replace the fixed size array with an expandable collection.

**`int bkIdx = 0`** - Keeps track of how many books have been added to the books array.

**`while(true)`** - The program runs an infinite loop to continuously display the menu until the user chooses to exit. The program prompts the user to select from the following options:

- 1 To view books.
- 2 To add books.
- 3 To get the most expensive of two books
- Any other key to exit.

If the user presses 1 the program iterates over the books array. If a Book object is not null, the program prints its details.

If the user presses 2 the program checks if bkIdx has reached 10 (array is full). If so, it prevents further additions. Else it prompts the user for the choice of constructor the user wants to use. If the user presses 1 default constructor is used. If the user presses any other key, the program uses the overloaded constructor. Then the user is prompted for the book's:

- Title (tmpTitle)
- Author (tmpAuthor)
- Price (tmpPrice, converted from string to float using Float.parseFloat)

The code creates a new Book object with the choice of constructor and stores the object in the books array at the bkIdx position. The code then increments bkIdx to prepare for the next book object.

- Compile the java program, specifying the destination directory as the classes directory that you created.

```bash
javac -d classes src/BooksMenu.java
```

- Now run the java program.

```bash
java BooksMenu
```

The output for this program depends on the user input. Next, view a sample of the output.

```plaintext
Press 1 to LIST all books, 2 to ADD books, 3 to COMPARE prices, any other key to exit
2
Which constructor do you want to use? Press 1 for DEFAULT, any other key for OVERLOADED constructor
Book 1
Enter book title
DEFAULT
Enter book author
12.99
Enter book price
12.99
Press 1 to LIST all books, 2 to ADD books, 3 to COMPARE prices, any other key to exit
2
Which constructor do you want to use? Press 1 for DEFAULT, any other key for OVERLOADED constructor
1
Enter book title
Book 2
Enter book author
PARAMETRISED
Enter book price
33.33
Press 1 to LIST all books, 2 to ADD books, 3 to COMPARE prices, any other key to exit
3
Enter INDEX of the FIRST book to compare: 
1
Enter INDEX of the SECOND book to compare: 
2
Details of expensive book is 
Title: Book 2
Author: PARAMETRISED
Price: 33.33
Press 1 to LIST all books, 2 to ADD books, 3 to COMPARE prices, any other key to exit
3
Enter INDEX of the FIRST book to compare: 
2
Enter INDEX of the SECOND book to compare: 
1
Details of expensive book is 
Title: Book 2
Author: PARAMETRISED
Price: 33.33
Press 1 to LIST all books, 2 to ADD books, 3 to COMPARE prices, any other key to exit
3
Enter INDEX of the FIRST book to compare: 
11
Enter INDEX of the SECOND book to compare: 
2
The original exercise is using ZERO-BASED Idx values,
 but I added a NON-ZERO BASED VALUES for the UX
 and, also, for handling more methods, so, please, use NON-ZERO BASED index values for this action!
Press 1 to LIST all books, 2 to ADD books, 3 to COMPARE prices, any other key to exit
```

---

## D) Practice Exercise

1. Implement equals method in Book class which will return true if the title, author and price are equal.

2. Add a method in BookAccess which will compare the equality of two books.

3. Add a menu option 2 within the add a new object menu, to clone one of the existing books instead of creating.

4. Add a menu item 3 to the main menu, to change the price of a book at a particular index position.

5. Create a book object and add it into index 0.

```bash
$ java BooksMenu
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices, any other key to exit
1
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices, any other key to exit
4
Which constructor do you want to use? Press 1 for DEFAULT, any other key for OVERLOADED constructor
1
Enter book title
Book 1
Enter book author
DEFAULT CONSTURCTOR
Enter book price
12.99
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices, any other key to exit
2
Enter the INDEX book to be CLONED: 
1
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices, any other key to exit
1
Title: Book 1
Author: DEFAULT CONSTURCTOR
Price: 12.99
Title: Book 1
Author: DEFAULT CONSTURCTOR
Price: 12.99
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices, any other key to exit
4
Which constructor do you want to use? Press 1 for DEFAULT, any other key for OVERLOADED constructor
2
Enter book title
Book 3
Enter book author
PARAMETERISED constructor method used
Enter book price
99.99 
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices, any other key to exit
1
Title: Book 1
Author: DEFAULT CONSTURCTOR
Price: 12.99
Title: Book 1
Author: DEFAULT CONSTURCTOR
Price: 12.99
Title: Book 3
Author: PARAMETERISED constructor method used
Price: 99.99
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices, any other key to exit
3
Choose a book BY THE SHOWN INDEX to change its price: 

BOOK INDEX: 1 - Title: Book 1

BOOK INDEX: 2 - Title: Book 1

BOOK INDEX: 3 - Title: Book 3

 Enter a value: 
2
Please, add the new price for '2' - Title: 'Book 1': 
16.66
Price successfully updated to 16.66
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices, any other key to exit
3
Choose a book BY THE SHOWN INDEX to change its price: 

BOOK INDEX: 1 - Title: Book 1

BOOK INDEX: 2 - Title: Book 1

BOOK INDEX: 3 - Title: Book 3

 Enter a value: 
2
Please, add the new price for '2' - Title: 'Book 1': 
sadasd
TYPE ERROR!: Please, provide numeric value for the desired book index!
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices, any other key to exit
3
Choose a book BY THE SHOWN INDEX to change its price: 

BOOK INDEX: 1 - Title: Book 1

BOOK INDEX: 2 - Title: Book 1

BOOK INDEX: 3 - Title: Book 3

 Enter a value: 
2
Please, add the new price for '2' - Title: 'Book 1': 
-12.99
The price CANNOT BE a negative value!
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices, any other key to exit
1
Title: Book 1
Author: DEFAULT CONSTURCTOR
Price: 12.99
Title: Book 1
Author: DEFAULT CONSTURCTOR
Price: 16.66
Title: Book 3
Author: PARAMETERISED constructor method used
Price: 99.99

```

6. Clone the object and add it to index 1.

```bash
alexander@hostname:~/Desktop/repo/IBM_Java_Certification_Labs-Exercises/Course_03_Lab_01-006/exercise/my_class_proj$ java BooksMenu
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices,
6 for Exercise COMPARE books (not overriding .equals() !)
7 for EXERCISE COMPARE books but OVERRIDING the .equals() method
 ... or any other key to exit
4
Which constructor do you want to use? Press 1 for DEFAULT, any other key for OVERLOADED constructor
2
Enter book title
Book 1
Enter book author
OVERLOADED (parameterised) CONSTURCTOR!
Enter book price
12.99
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices,
6 for Exercise COMPARE books (not overriding .equals() !)
7 for EXERCISE COMPARE books but OVERRIDING the .equals() method
 ... or any other key to exit
1
Title: Book 1
Author: OVERLOADED (parameterised) CONSTURCTOR!
Price: 12.99
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices,
6 for Exercise COMPARE books (not overriding .equals() !)
7 for EXERCISE COMPARE books but OVERRIDING the .equals() method
 ... or any other key to exit
2
Enter the INDEX book to be CLONED: 
1
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices,
6 for Exercise COMPARE books (not overriding .equals() !)
7 for EXERCISE COMPARE books but OVERRIDING the .equals() method
 ... or any other key to exit
1
Title: Book 1
Author: OVERLOADED (parameterised) CONSTURCTOR!
Price: 12.99
Title: Book 1
Author: OVERLOADED (parameterised) CONSTURCTOR!
Price: 12.99
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices,
6 for Exercise COMPARE books (not overriding .equals() !)
7 for EXERCISE COMPARE books but OVERRIDING the .equals() method
 ... or any other key to exit
```

7. Compare the books in index 0 and 1. Add the code to print a statement saying the two books are the same.

```bash
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices,
6 for Exercise COMPARE books (not overriding .equals() !)
7 for EXERCISE COMPARE books but OVERRIDING the .equals() method
 ... or any other key to exit
6
Choose a book BY THE SHOWN INDEX to be fully compared with the another:  
  (This option WON'T @Override .equals(), using the BookAccess.compareBooksNotOverridingEqualsCoreMethod() instead! )

BOOK INDEX: 1 - Title: Book 1

BOOK INDEX: 2 - Title: Book 1
Enter INDEX of the FIRST book to compare: 
1
Enter INDEX of the SECOND book to compare: 
2
The two books ARE EQUALS (And the method used for comparing was NOT @Override equals()
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices,
6 for Exercise COMPARE books (not overriding .equals() !)
7 for EXERCISE COMPARE books but OVERRIDING the .equals() method
 ... or any other key to exit
7
Choose a book BY THE SHOWN INDEX to be fully compared with the another: 
  (This option WILL @Override .equals() )

BOOK INDEX: 1 - Title: Book 1

BOOK INDEX: 2 - Title: Book 1
Enter INDEX of the FIRST book to compare: 
2
Enter INDEX of the SECOND book to compare: 
1
The two books ARE EQUALS! (And the method used for comparing was @Override-ing equals()
EXERCISE MENU:

```

8. Change the price of the object in index 1.
9. Compare the books in index 0 and 1. Add the code to print a statement saying the two books are not the same.
   - Hint: Use Scanner and Integer.parseInt to get the index number

```bash
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices,
6 for Exercise COMPARE books (not overriding .equals() !)
7 for EXERCISE COMPARE books but OVERRIDING the .equals() method
 ... or any other key to exit
3
Choose a book BY THE SHOWN INDEX to change its price: 

BOOK INDEX: 1 - Title: Book 1

BOOK INDEX: 2 - Title: Book 1

 Enter a value: 
2
Please, add the new price for '2' - Title: 'Book 1': 
qwqqqqeqweqweERROR
TYPE ERROR!: Please, provide numeric value for the desired book index!
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices,
6 for Exercise COMPARE books (not overriding .equals() !)
7 for EXERCISE COMPARE books but OVERRIDING the .equals() method
 ... or any other key to exit
3
Choose a book BY THE SHOWN INDEX to change its price: 

BOOK INDEX: 1 - Title: Book 1

BOOK INDEX: 2 - Title: Book 1

 Enter a value: 
2
Please, add the new price for '2' - Title: 'Book 1': 
99.99
Price successfully updated to 99.99
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices,
6 for Exercise COMPARE books (not overriding .equals() !)
7 for EXERCISE COMPARE books but OVERRIDING the .equals() method
 ... or any other key to exit
6
Choose a book BY THE SHOWN INDEX to be fully compared with the another:  
  (This option WON'T @Override .equals(), using the BookAccess.compareBooksNotOverridingEqualsCoreMethod() instead! )

BOOK INDEX: 1 - Title: Book 1

BOOK INDEX: 2 - Title: Book 1
Enter INDEX of the FIRST book to compare: 
1
Enter INDEX of the SECOND book to compare: 
2
The two books ARE NOT EQUALS (And the method used for comparing was NOT @Override equals()!
EXERCISE MENU:

Press 1 to LIST all books,
2 to CLONE books
3 to CHANGE a price
4 is the legacy ADD book method,
5 is the legacy to COMPARE prices,
6 for Exercise COMPARE books (not overriding .equals() !)
7 for EXERCISE COMPARE books but OVERRIDING the .equals() method
 ... or any other key to exit
7
Choose a book BY THE SHOWN INDEX to be fully compared with the another: 
  (This option WILL @Override .equals() )

BOOK INDEX: 1 - Title: Book 1

BOOK INDEX: 2 - Title: Book 1
Enter INDEX of the FIRST book to compare: 
2
Enter INDEX of the SECOND book to compare: 
1
The two books ARE NOT EQUALS (And the method used for comparing was @Override-ing equals()!
```

---

## PROVIDED SOLUTION BY THE MENTOR

### `Book.java` sample

```java
public class Book implements Cloneable {
    private String title;
    private String author;
    private float price;

    public Book() {
    }

    public Book(String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Overriding the clone() method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public float getPrice() {
        return this.price;
    }

    public String toString() {
        return "Title - " + this.title + "\nAuthor - "
            + this.author + "\nPrice - "+ String.format("%.2f", this.price);
    }

    public boolean equals(Book book2) {
        if (this.title.equals(book2.getTitle()) &&
            this.author.equals(book2.getAuthor()) &&
            this.price == book2.getPrice()) {
                return true;
            } else {
                return false;
            }
    }
}
```

### `BookAccess.java` sample

```java
import java.util.Scanner;

public class BooksMenu {
    private static void compareBooks(Book book1, Book book2) {
        if (book1.equals(book2)) {
            System.out.println("The books are the same");
        } else {
            System.out.println("The books are not the same");
        }
    }

    public static void main(String s[]) throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[10];
        int bkIdx = 0;
        while(true) {
            System.out.println("Press 1 to view books, " +
                                "\n2 to add books, "+
                                "\n3 to change the price of a book" +
                                "\n4 to compare the books, any other key to exit");
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
                System.out.println("How do you want to create a book object? \nPress 1 for default constructor,"+ 
                                    "\n2 for creating a clone of an existing object " +
                                    "\nany other key for overloaded constructor");
                String constructor = scanner.nextLine();
                if (constructor.equals("1")) {
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
                } else if (constructor.equals("2")) {
                    System.out.println("Enter the index of book to clone");
                    int cloneIdx = Integer.parseInt(scanner.nextLine());
                    if (books[cloneIdx] != null) {
                        books[bkIdx++] = (Book)books[cloneIdx].clone();
                    }
                } else {
                    System.out.println("Enter book title");
                    String tmpTitle = scanner.nextLine();
                    System.out.println("Enter book author");
                    String tmpAuthor = scanner.nextLine();
                    System.out.println("Enter book price");
                    float tmpPrice = Float.parseFloat(scanner.nextLine());
                    books[bkIdx++] = new Book(tmpTitle, tmpAuthor, tmpPrice);
                }				
            } else if (userAction.equals("3")) {
                System.out.println("Enter index of book to change price");
                int book1Idx = Integer.parseInt(scanner.nextLine());
                if (books[book1Idx] != null) {
                    System.out.println("Enter the new price for the book");	
                    float newPrice = Float.parseFloat(scanner.nextLine());
                    books[book1Idx].setPrice(newPrice);					
                }
            } else if (userAction.equals("4")) {
                System.out.println("Enter index of first book to compare");
                int book1Idx = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter index of second book to compare");
                int book2Idx = Integer.parseInt(scanner.nextLine());

                if (books[book1Idx] != null && books[book2Idx] != null ) {
                    compareBooks(books[book1Idx],books[book2Idx]);
                } else {
                    System.out.println("One of the books is null");
                }
            } else {
                break;
            }
        }
    }
}
```
