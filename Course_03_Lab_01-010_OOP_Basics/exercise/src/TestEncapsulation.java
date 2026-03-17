// TestEncapsulation class to test the Employee class
public class TestEncapsulation {
    public static void main(String[] args) {
        // Step 1: Create two instances of the Employee class
        // One using the parameterized constructor and one using default constructor with setters
        Employee empleadoOne = new Employee("Pepito Parametrizado", 23, 1400.95d);

        Employee empleadoTwo = new Employee();
        empleadoTwo.setEmpleadoNombre("Juanito Default");
        empleadoTwo.setEmpleadoEdad(25);
        empleadoTwo.setEmpleadoSalario(1547.72d);

        // Step 2: Print details of both employees
        System.out.println(empleadoOne);
        System.out.println(empleadoTwo);

        // Step 3: Try setting invalid values (null name, age outside range, negative salary)
        // and see if your validation works
        Employee empleadoThree = new Employee(null, 77, -1400d);


        // Step 4: Give both employees a 10% raise and display their details again
        empleadoOne.giveRaise(10d);
        empleadoTwo.giveRaise(10d);
        System.out.println(empleadoOne);
        System.out.println(empleadoTwo);

        // Step 5: Clone the first employee and display the cloned employee details
        // Hint: Use try-catch block to handle CloneNotSupportedException
        // Employee clonedEmployee = (Employee) employee1.clone();
        Employee empleadoCloned = null;

        try {

            empleadoCloned = (Employee) empleadoOne.clone();

        } catch (CloneNotSupportedException e) {

            System.out.println("Clone Not Supported reason:" + e);
        }
        // Step 6: Modify the original employee and verify that the clone remains unchanged
        // This demonstrates that cloning creates a separate object
        empleadoOne.setEmpleadoNombre("Andres Juarez");
        empleadoOne.setEmpleadoEdad(33);
        empleadoOne.setEmpleadoSalario(3333.22d);

        System.out.print(empleadoOne.getempleadoNombre());
        System.out.print(empleadoCloned.getempleadoNombre());



    }

    // Step 7: Create a method that compares the salaries of two employees
    // and returns the name of the employee with the higher salary
    // If salaries are equal, return "Equal salaries"
    public static void compareSalary(Employee empleadoOneCompare, Employee empleadoTwoCompare){


        if ( empleadoOneCompare.getEmpleadoSalario() > empleadoTwoCompare.getEmpleadoSalario() ) {

            System.out.println("Higher salary is for: " + empleadoOneCompare.getempleadoNombre());

        } else if ( empleadoOneCompare.getEmpleadoSalario() == empleadoTwoCompare.getEmpleadoSalario() ) {

            System.out.println("Equal salaries");

        } else {

            System.out.println("Esta frase no debería existir");
        }


    }
}
