// Come from 02-003 Lab, but in an abstract mode 


interface Mammal {

    int getGestationPeriod();

}


// SUPERCLASS -> ASBTRACT
// A)   Superclass
public abstract class Animal implements Cloneable {

    // 1. INIT
    private String name;
    // EXERCISE
    private String food; 

    // 2. CONSTRUCTOR
    public Animal(String name) {

        this.name = name;

    }

    // 3. METHODS
    public String sound(){

        return null;

    }

    // 3.1 SETTER
    public void setFood(String food) {

        this.food = food;

    }
    // 3.2 GETTER
    public String getFood(){

        return food;

    }


    // 3.3 OVERRIDABLE
    //@Override
    public String toString() {

        return name
            .concat(" says ")
            .concat(sound())
            .concat("; the food meal will be ")
            .concat(food);

    }
    
}

  

// B) Subclass Dog
class Dog extends Animal implements Mammal {
    
    public Dog(String name) {
    
        super(name);
    
    }

    //@Override
    public String sound() {
    
        return "Wooof!";
    
    }

    //@Override
    public void setFood(String food) {
    
        super.setFood(food);
    
    }

    @Override
    public int getGestationPeriod() {

        return 60;

    }

    @Override
    public String toString() {
        
        String gestationStr = String.valueOf(getGestationPeriod());

        return super
            .toString()
            .concat("; the gestation period is ")
            .concat(gestationStr)
            .concat(" days!");
    }

}

// C) Subclass Dog
class Cat extends Animal implements Mammal {

    public Cat(String name) {
    
        super(name);
    
    }

    //@Override
    public String sound() {

        return "Meoooow!";

    }

    //@Override
    public void setFood(String food) {

        super.setFood(food);

    }

    @Override
    public int getGestationPeriod(){

        return 70;

    }
    @Override
    public String toString() {
        
        String gestationStr = String.valueOf(getGestationPeriod());

        return super
            .toString()
            .concat("; the gestation period is ")
            .concat(gestationStr)
            .concat(" days!");
    }

}

// D) Subclass Cow
class Cow extends Animal implements Mammal {
    
    public Cow(String name) {
    
        super(name);
    
    }

    //@Override
    public String sound() {
    
        return "Muuuuuu!";
    
    }

    //@Override
    public void setFood(String food) {
    
        super.setFood(food);
    
    }

    @Override
    public int getGestationPeriod(){

        return 300;

    }


    @Override
    public String toString() {
        
        String gestationStr = String.valueOf(getGestationPeriod());

        return super
            .toString()
            .concat("; the gestation period is ")
            .concat(gestationStr)
            .concat(" days!");
    }
}