import java.util.Scanner;

// ShapeDemo class to demonstrate polymorphism with Shapes
public class ShapeDemo {
    public static void main(String[] args) {
        // Step 1: Create an array of Shape objects with size 5
        // Hint: Shape[] shapes = new Shape[5];
        Shape[] shapes = new Shape[5];
        
        // Step 2: Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Step 3: Create an interactive menu to add shapes to the array
        // Hint: Use a loop and a counter to keep track of how many shapes are added
        // The menu should allow users to:
        // 1. Add a Circle
        // 2. Add a Rectangle
        // 3. Add a Triangle
        // 4. Display all shapes
        // 5. Exit
        int counter = 0;
        int counterNonZero = counter + 1;
        boolean rompeWhile = false;




        while ( !rompeWhile && counter < shapes.length ) {


            System.out.println("\n // POLIEDRIC MENU! //\n");
            System.out.println("   1. Add CIRCLE automatically");
            System.out.println("   2. Add RECTANGLE automatically");
            System.out.println("   3. Add TRIANGLE automatically");
            System.out.println("   4. Add a polyhedron MANUALLY");
            System.out.println("   5. Display all shapes");
            System.out.println("      Any other key to exit");

            String menuChoice = scanner.nextLine();

            switch (menuChoice){

                case "1":

                    shapes[counter] = new Circle("Circulito", "Red", 5.0d);
                    counter++;

                    System.out.println("\n   New object added succesfully! (Actual objects in the list: " + counterNonZero );
                    break;

                case "2":

                    shapes[counter] = new Rectangle("El Rectángulo Molón", "Green", 3.0d, 7.0d);
                    counter++;

                    System.out.println("\n   New object added succesfully! (Actual objects in the list: " + counterNonZero );
                    break;

                case "3":

                    shapes[counter] = new Triangle("Triángulo", "Purple", 3.5d, 7.2d, 7.2d);
                    counter++;

                    System.out.println("\n   New object added succesfully! (Actual objects in the list: " +  counterNonZero) ;
                    break;
                
                
                    // Step 4: For each shape type, prompt the user for the required attributes
                    // For Circle: name, color, radius
                    // For Rectangle: name, color, length, width
                    // For Triangle: name, color, side1, side2, side3

                    // Step 5: After adding a shape, display its details
                case "4":

                    System.out.println("\n   Choose a type:\n    1. Circle\n    2.Rectangle\n    3.Triangle");
                    String manualChoice = scanner.nextLine();

                    if ( "1".equals(manualChoice) ) {

                        System.out.println("\n Circle's name?: ");
                        String circleName = scanner.nextLine();

                        System.out.println("\n Circle's colour?: ");
                        String circleColor = scanner.nextLine();

                        System.out.println("\n Circle's radius?: ");
                        String circleRadius = scanner.nextLine();
                        double circleRadiusParsed = Double.parseDouble(circleRadius);

                        shapes[counter] = new Circle(circleName, circleColor, circleRadiusParsed);
                        counter++;

                        System.out.println("\n These are the created object details:");
                        System.out.println(shapes[counter]);

                        break;

                    } else if ( "2".equals(manualChoice) ) {

                        System.out.println("\n Rectangle's name?: ");
                        String rectangleName = scanner.nextLine();

                        System.out.println("\n Rectangle's colour?: ");
                        String rectangleColor = scanner.nextLine();

                        System.out.println("\n Rectangle's width?: ");
                        String rectangleWidth = scanner.nextLine();
                        double rectangleWidthParsed = Double.parseDouble(rectangleWidth);

                        System.out.println("\n Rectangle's length?: ");
                        String rectangleLength = scanner.nextLine();
                        double rectangleLengthParsed = Double.parseDouble(rectangleLength);

                        shapes[counter] = new Rectangle(rectangleName, rectangleColor, rectangleWidthParsed, rectangleLengthParsed);
                        counter++;

                        System.out.println("\n These are the created object details:");
                        System.out.println(shapes[counter]);

                        break;

                    } else if ( "2".equals(manualChoice) ) {

                        System.out.println("\n Triangle's name?: ");
                        String triangleName = scanner.nextLine();

                        System.out.println("\n Triangle's colour?: ");
                        String triangleColor = scanner.nextLine();

                        System.out.println("\n Triangle's side 1?: ");
                        String triangleSide1 = scanner.nextLine();
                        double triangleSide1Parsed = Double.parseDouble(triangleSide1);

                        System.out.println("\n Triangle's side 2?: ");
                        String triangleSide2 = scanner.nextLine();
                        double triangleSide2Parsed = Double.parseDouble(triangleSide2);

                        System.out.println("\n Triangle's side 3?: ");
                        String triangleSide3 = scanner.nextLine();
                        double triangleSide3Parsed = Double.parseDouble(triangleSide3);

                        shapes[counter] = new Triangle(triangleName, triangleColor, triangleSide1Parsed, triangleSide2Parsed, triangleSide3Parsed);
                        counter++;

                        System.out.println("\n These are the created object details:");
                        System.out.println(shapes[counter]);

                        break;

                    }else {

                        break;
                    }

                

                // Step 6: When displaying all shapes, loop through the array and call each shape's
                // toString(), area(), and perimeter() methods
                // This will demonstrate polymorphism as each shape type will use its own implementation
                case "5":

                    if ( shapes[0] != null  ) {

                        for ( int i = 0; i < counter; i++  ) {

                            System.out.println(shapes[i]);


                        }

                        break;

                    } else {

                        System.out.println("\n   Sorry, there are NOT objects in the list yet!");
                        break;

                    }
                
                default:

                    rompeWhile = true;
                    break;

            }



        }



        
        scanner.close();
        

    }
}
