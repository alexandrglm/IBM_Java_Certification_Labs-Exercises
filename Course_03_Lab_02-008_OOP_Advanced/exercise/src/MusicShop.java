// Step 1: Create an abstract class Instrument
// This should include:
// - private String name
// - protected int year (year of manufacture)
// - constructor that initializes both fields
// - abstract method play() that returns a String
// - concrete method getInstrumentDetails() that returns information about the instrument

import java.util.ArrayList;

abstract class Instrument {

    // 1. INITS
    private String name;
    protected int year;

    // 2. CONSTRUCTORS
    // DEFAULT
    public Instrument(String name, int year){

        this.name = name;
        this.year = year;
    }

    // 2.1 GETTER SETTER
    // As it mandatory to get PRIVATE instead of protected init vars...
    public String getName(){
        return this.name;
    }
    public void setName(String name) {

        this.name = name;

    }
    // And, even other vars AREN'T private, for conveinance will set their getters/setters
    public int getYear() {
        return this.year;
    }
    public void setYear(int year){

        this.year = year;
    }

    public abstract void play();

    public String getInstrumentDetails(){

        return "This generic " + this.name + " from " + this.year + " is so generic!";

    }
}

// Step 2: Create an interface Tunable
// This should include:
// - abstract method tune() that returns a String
// - abstract method adjustPitch(boolean up) that returns a String (up means increase pitch)
interface Tunable {

    abstract String tune();
    abstract String adjustPitch(boolean up);

}

// Step 3: Create an interface Maintainable
// This should include:
// - abstract method clean() that returns a String
// - abstract method inspect() that returns a String
interface Maintainable {

    abstract String clean();
    abstract String inspect();

}

// Step 4: Create a concrete class StringedInstrument that extends Instrument
// This should include:
// - private int numberOfStrings
// - constructor that initializes name, year, and numberOfStrings
// - implementation of the abstract play() method
// - override getInstrumentDetails() to include number of strings
class StringedInstrument extends Instrument {

    // 1. INITS
    private int numberOfStrings;

    // 2. CONSTRUCTOR
    public StringedInstrument(String name, int year,int numberOfStrings) {

        super(name, year);
        this.numberOfStrings = numberOfStrings;
    
    }
    // 2.2 GETTERS SETTER
    public int getNumberOfStrings(){
        return this.numberOfStrings;
    }
    public void setNumberOfStrings(int numberOfStrings){

        this.numberOfStrings = numberOfStrings;

    }

    public void play(){

        System.out.println("The instrument is playing a melody!");

    }

    @Override
    public String getInstrumentDetails(){

        return "This stringed instrument, " + getName() + ", from " + this.year + ", has " + this.numberOfStrings + "strings!";
    }

}

// Step 5: Create a concrete class Guitar that extends StringedInstrument 
// and implements Tunable and Maintainable
// This should include:
// - private String guitarType (acoustic, electric, etc.)
// - constructor that initializes all fields
// - implementation of all required interface methods
class Guitar extends StringedInstrument implements Tunable, Maintainable {

    private String guitarType;

    public Guitar (String name, int year, int numberOfStrings, String guitarType){

        super(name, year, numberOfStrings);
        this.guitarType = guitarType;
    }
    public String getGuitarType() {

        return this.guitarType;

    }
    public void setGuitarTyp(String guitarType){

        this.guitarType = guitarType;
    }


    public void play(){

        System.out.println("\n    Kling kling kling!");

    }

    @Override
    public String getInstrumentDetails(){

        return "This stringed instrument, an " + this.guitarType + " " + this.getName() + ", from " + this.year + ", " +  ", has " + getNumberOfStrings() + "strings!";

    }

        @Override
    public String tune(){

        return "Each key-string was tuned! The guitar now sounds so great";
        
    }
        

    @Override
    public String adjustPitch(boolean up) {

        return "Pitching up this string ... Hope the key don't explode!";
    }
    @Override     
    public String clean(){

        return "Wow! This " + this.getName() + " looks like the Jimmy Hendrix first guitar!";

    }
    @Override
    public String inspect(){

        return "This " + this.getName() + " passed all the checks and inspection";

    }

}


// Step 6: Create a concrete class Piano that extends Instrument
// and implements Tunable and Maintainable
// This should include:
// - private boolean isGrand
// - constructor that initializes all fields
// - implementation of the abstract play() method
// - implementation of all required interface methods
class Piano extends Instrument implements Tunable, Maintainable {

    private boolean isGrand;

    public Piano(String name, int year, boolean isGrand ){

        super(name, year);
        this.isGrand = isGrand;

    }
    public boolean getIsGrand(){
        return this.isGrand;
    }
    public void setIsGrands(boolean isGrand){

        this.isGrand = isGrand;

    }

    public void play(){

        System.out.println("\n    Tiri tiri tiri tiri ri!");

    }

    @Override
    public String getInstrumentDetails(){

        if ( this.isGrand ) {

            return "This Grand" + this.getName() + ", from " + this.year + ", " +  ", has a warm and magical sound! ";

            
        } else {

            return "This electric " + this.getName() + ", from " + this.year + ", " +  ", sounds so techno and electronic! ";

        }


    }

    @Override
    public String tune(){

        if ( this.isGrand ) {

            return "Each key-string was tuned! The piano now sounds so great";
        
        } else {

            return "This type of piano doesn't need be tuned!";

        }
        

    }
    @Override
    public String adjustPitch(boolean up) {
                
        if ( this.isGrand && up ) {

            return "Pitching up your key";
        
        } else {

            return "This electric piano has no strings to be pitched, but we can pitch notes in a digital way!";
        }

        
    }
    @Override     
    public String clean(){

        return "Wow! This " + this.getName() + " looks so immaculate now!";

    }
    @Override
    public String inspect(){

        return "This " + this.getName() + " passed all the checks and inspection";

    }

}

// Step 7: Create a public class MusicShop to test the classes
// This should include:
// - main method that:
//   1. Creates an array of Instrument objects including Guitar and Piano instances
//   2. Iterates through the array calling play() for each instrument
//   3. Demonstrates polymorphism by testing if each instrument is Tunable or Maintainable
//      and if so, calls the appropriate methods
public class MusicShop {

    public static void main(String[] args) {

        ArrayList<Instrument> instruments = new ArrayList<>();

        instruments.add( new Guitar("Fender Telecaster", 1981, 6, "Electric") );
        instruments.add( new Guitar("Admira Valenia", 2014, 7, "Acoustic" ) );
        
        instruments.add( new Piano("Yamaha CFX", 2021, true) );
        instruments.add( new Piano("Yamaha MK-100", 1989, false) );

        for ( Instrument instrument : instruments) {
            
            System.out.println(instrument.getInstrumentDetails());
            System.out.println("Admire its sound: ");
            instrument.play();

            if ( instrument instanceof Tunable ) {

                Tunable tunableInstrument = (Tunable) instrument;
                

                System.out.println(tunableInstrument.tune());
                System.out.println(tunableInstrument.adjustPitch(true));

            }

            if ( instrument instanceof Maintainable) {

                Maintainable maintainableInstrument = (Maintainable) instrument;
                
                System.out.println(maintainableInstrument.clean());
                System.out.println(maintainableInstrument.inspect());
            }

        }
    }


}