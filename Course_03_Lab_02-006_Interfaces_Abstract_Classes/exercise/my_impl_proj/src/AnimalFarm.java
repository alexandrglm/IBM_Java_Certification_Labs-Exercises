// Come from 02-003 Lab, but in an abstract mode 
// SUPERCLASS -> ASBTRACT
import java.util.Scanner;

public class AnimalFarm {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        Animal[] animals = new Animal[10];

        int animalIdx = 0;

        while(true) {

            System.out.println("\nANIMAL FARM MENU:\n  1 to list the animals\n  2 to ADD animals\n  any other key to EXIT");

            String userAction = scanner.nextLine();

            if ( "1".equals(userAction) ) {

                if ( animalIdx == 0 ) {
                    
                    System.out.print("\n   No animals in the list, try creating one!\n");
                    continue;
                }

                System.out.println(" // ANIMAL LIST //\nWe got " + animalIdx + " animals in the list:\n");
                for ( int i = 0; i < animalIdx; i++ ) {

                    if (animals[i] != null) {

                        System.out.println(" - " + (i + 1)  + ") " + animals[i]);

                    }

                }




            } else if (  "2".equals(userAction)) {

                if ( animalIdx == 10 ) {

                    System.out.println("10 animals already added, MAX animals cannot be > 10 !");
                    continue;

                }

                System.out.println("\nWhich animal do you want to create?: "
                    + "\n  Press 1 for a DOG"
                    + "\n  Press 2 for a CAT"
                    + "\n  Press 3 for a COW"
                );

                String userActionAdd = scanner.nextLine();

                if ( "1".equals(userActionAdd) ) {

                    System.out.println("\n  Enter the dog's name: ");
                    String userActionDogName = scanner.nextLine();

                    Animal dogTempReference = new Dog(userActionDogName);

                    // EXERCISE
                    System.out.println("\n  Enter dog's food:  ");
                    String userActionsDogFood = scanner.nextLine();

                    dogTempReference.setFood(userActionsDogFood);

                    animals[animalIdx++] = dogTempReference;
                    continue;


                } if ( "2".equals(userActionAdd) ) {

                    System.out.println("\n  Enter the cat's name: ");
                    String userActionCatName = scanner.nextLine();

                    Animal catTempReference = new Cat(userActionCatName);

                    // EXERCISE
                    System.out.println("\n  Enter cat's food:  ");
                    String userActionsCatFood = scanner.nextLine();

                    catTempReference.setFood(userActionsCatFood);

                    animals[animalIdx++] = catTempReference;
                    continue;

                } if ( "3".equals(userActionAdd) ) {

                    System.out.println("\n  Enter the cow's name: ");
                    String userActionCowName = scanner.nextLine();

                    Animal cowTempReference = new Cow(userActionCowName);

                    // EXERCISE
                    System.out.println("\n  Enter cow's food:  ");
                    String userActionsCowFood = scanner.nextLine();

                    cowTempReference.setFood(userActionsCowFood);

                    animals[animalIdx++] = cowTempReference;
                    continue;



                } else {
                    break;
                }



            } else {

                break;

            }

        }


        scanner.close();
        // Animal animal1 = new Dog("Toby");
        // Animal animal2 = new Cat("Whiskas");
        // Animal animal3 = new Cow("La Vaca Lechera");

        // System.out.println("animal1 sound :" + animal1.sound());
        // System.out.println("animal2 sound :" + animal2.sound());
        // System.out.println("animal3 sound :" + animal3.sound());

    }
    
}
