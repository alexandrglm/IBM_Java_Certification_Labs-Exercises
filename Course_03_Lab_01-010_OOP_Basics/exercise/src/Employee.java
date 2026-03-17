// Employee class to demonstrate encapsulation
public class Employee implements Cloneable {


    // Step 1: Declare private variables for name, age, and salary
    // Hint: Use appropriate data types (String, int, double)
    private String empleadoNombre;
    private int empleadoEdad;
    private double empleadoSalario;

    // Step 2: Create constructors
    // 2.1: Create a default constructor that sets name to "Unknown", age to 18, and salary to 0.0
    // Hint: public Employee()
    public Employee() {

        this.empleadoNombre = "Unknown";
        this.empleadoEdad = 18;
        this.empleadoSalario = 0.0d;

    }
    // 2.2: Create an overloaded constructor that initializes all three variables
    // Hint: public Employee(String name, int age, double salary)
    public Employee(String empleadoNombre, int empleadoEdad, double empleadoSalario) {

        this.empleadoNombre = empleadoNombre;
        this.empleadoEdad = empleadoEdad;
        this.empleadoSalario = empleadoSalario;

    }

    // Step 3: Create public getter methods for each variable
    // Hint: Use the format: public returnType getVariableName()
    public String getempleadoNombre(){
        return this.empleadoNombre;
    }
    public int getEmpleadoEdad(){
        return this.empleadoEdad;
    }
    public double getEmpleadoSalario(){
        return this.empleadoSalario;
    }

    // Step 4: Create public setter methods for each variable
    // Hint: Use the format: public void setVariableName(parameter)
    // Add validation logic in the setter methods:
    // - For name: Ensure it is not null or empty
    // - For age: Ensure it is between 18 and 65 (inclusive)
    // - For salary: Ensure it is greater than or equal to 0
    public void setEmpleadoNombre(String empleadoNombre){

        if ( empleadoNombre != null && empleadoNombre != "" ){

            this.empleadoNombre = empleadoNombre;

        } else {

            System.out.println("Please, check NAME again as it is not valid!");
        }


    }
    public void setEmpleadoEdad (int empleadoEdad) {

        if ( empleadoEdad >= 18 && empleadoEdad <= 65 ) {

            this.empleadoEdad = empleadoEdad;

        } else {
            System.out.println("Error, check wether the age is between 18~65!");
        }

    }
    public void setEmpleadoSalario (double empleadoSalario) {

        if ( empleadoSalario >= 0 ) {

            this.empleadoSalario = empleadoSalario;

        } else {
            System.out.println("Please, check the salary is greater than 0!!!º  ");
        }

    }

    // Step 5: Create a public method to calculate annual salary (monthly salary * 12)
    // Hint: public double calculateAnnualSalary()
    public double calculateAnnualSalary(double empleadoSalario){

        double annualSalary;

        annualSalary = (this.empleadoSalario * 12);

        return annualSalary;

    }

    // Step 6: Create a public method to give a raise (percentage)
    // This method should increase the salary by the given percentage
    // Hint: public void giveRaise(double percentage)
    public double giveRaise(double percentage){

        double actualSalary;
        double raisedSalary;

        actualSalary = getEmpleadoSalario();
        raisedSalary = ( ( actualSalary * 100) / percentage );

        return raisedSalary;

    }

    // Step 7: Create a public method to display employee details
    // Hint: Use System.out.println() to print name, age, monthly salary, and annual salary
    public void getEmpleadoDetalles(){

        System.out.println("\n   EMPLOYEE DETAILS");
        System.out.println("  - Name: " + empleadoNombre);
        System.out.println("  - Age:  " + empleadoEdad );
        System.out.println("  - Monthly Salary: " + empleadoSalario);
        System.out.println("  - Annual Salary:  " + (empleadoSalario * 12) );

    }

    // Step 8: Override the clone method to make Employee objects cloneable
    // Hint: @Override protected Object clone() throws CloneNotSupportedException
    // Return super.clone() to create a shallow copy of the object
    @Override
    protected Object clone() throws CloneNotSupportedException {

        return super.clone();
    }

    // EXTRA STEP -> toString() method to "prettify" test outputs
    @Override
    public String toString(){

        return (
            "\nEmployee Name: " + this.empleadoNombre
            + "\nEmployee Age: " + this.empleadoEdad
            + "\nMonthly Salary: " + this.empleadoSalario
            + "\nAnnual Salary:  " + (this.empleadoSalario * 12)
        );

    }
}
