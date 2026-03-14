// FROM THIS LAB, PART B, IMPLEMENT A CLONEABLE
public class Book implements Cloneable {
     /**
      * This code explicitly says that the class will implement 
      * the clone method which will enable clone of instances or objects of this class
    */

    private String title;
    private String author;
    private float price;

    // A)   DEFAULT CONSTRUCTOR
    public Book() {

        this.title = null;
        this.author = null;

    }

    // B) PARAMETRISED
    public Book(String title, String author, float price) {

        this.title = title;
        this.author = author;
        this.price = price;
    }


    // C) CLONEABLE, OVERRIFING THE clone() METHOD
    /**
     * This method class the super class clone method 
     * which would internally clone all the attributes of the object into a new object.
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {

        return super.clone();

    }
    // Override SETTERS
    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setPrice(float price){
        this.price = price;
    }
    // @Override GETTERs
    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public float getPrice(){
        return this.price;
    }

    public String toString() {

        return  
            "Title: " + this.title 
            + "\nAuthor: " + this.author
            + "\nPrice: " + String.format("%.2f", this.price); 

    }

    // EXERCISE: 1. Implement equals method in Book class which will return true if the title, author and price are equal.
    // MODE 1 WITH NO @Override
    // WITHOUT OVERRIDING ... LETS FIND WHAT HAPPENS
    public boolean equals(Book theOtherBook){

        if ( theOtherBook == null) {
           
            return false;
        
        }

        return this.title.equals(theOtherBook.title)
            && this.author.equals(theOtherBook.author)
            && this.price == theOtherBook.price;

    }
    // EXERCISE 1
    // MODE 2: Using @Override for .equals()
    @Override
    public boolean equals(Object overrideEquals) {

        if ( this == overrideEquals ) {

            return true;

        }

        if ( overrideEquals == null || getClass() != overrideEquals.getClass() ) {

            return false;

        }

        Book otherBookOverridingEquals = (Book) overrideEquals;

        return this.title.equals(otherBookOverridingEquals.title)
            && this.author.equals(otherBookOverridingEquals.author)
            && this.price == otherBookOverridingEquals.price;



    }



}

// FROM THIS LAB, PART A)
// public class Book {
    
//     private String title;
//     private String author;
//     private float price;

//     // From 01-006
//     // A)   DEFAULT CONSTRUCTOR
//     public Book() {

//         this.title = null;
//         this.author = null;
//     }
//     // B) PARAMETRISED CONSTURCTOR (Using the 3 initialised args)
//     public Book(String title, String author, float price){

//         this.title = title;
//         this.author = author;
//         this.price = price;

//     }


//     // Setters
//     public void setTitle(String title){

//         this.title = title;

//     }

//     public void setAuthor(String author) {

//         this.author = author;

//     }

//     public void setPrice(float price) {

//         this.price = price;

//     }

//     // Y Getters
//         public String getTitle() {
//         return this.title;
//     }

//     public String getAuthor() {
//         return this.author;
//     }

//     public float getPrice() {
//         return this.price;
//     }


//     public String toString() {

//         return "Title - " + this.title 
//             + "\nAuthor - " + this.author 
//             + "\nPrice - " + String.format("%.2f", this.price);

//     }



// }