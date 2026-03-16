// A)   Superclass
public class Animal {

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

        /**
     * EXERCISE 1
     * Add another method setFood to the superclass
     *  takes String food as parameter 
     * and sets it to the attribute food 
     * and returns nothing (void) 
     * and override it in each of the animal classes.
     */

    
    public void setFood(String food) {

        this.food = food;

    }
    public String getFood(){

        return food;

    }

    // EXERCISE
    //@Override
    public String toString() {

        return name.concat(" says ").concat(sound().concat(". The food meal will be ").concat(getFood()) );

    }
        



    
}
// B) Subclass Dog
class Dog extends Animal {
    
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
}

// C) Subclass Dog
class Cat extends Animal {

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
}

// D) Subclass Dog
class Cow extends Animal {
    
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
}