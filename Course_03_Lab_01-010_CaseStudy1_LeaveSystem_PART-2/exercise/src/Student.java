// Student class to store and manage student information
public class Student {
    // Step 1: Declare private variables for studentId, name, grade, and isActive
    // Hint: Use appropriate data types (String, String, double, boolean)
    private String studentId;
    private String studentName;
    private double studentGrade;
    private boolean isActive;

    // Step 2: Create getter methods for each variable
    // Hint: Use the format: public returnType getVariableName()
    public String getStudentId(){
        return this.studentId;
    }
    public String getStudentName(){
        return this.studentName;
    }
    public double getStudentGrade(){

        return this.studentGrade;
    }
    public boolean getIsActive(){
        return this.isActive;
    }

    // Step 3: Create setter methods for each variable
    // Hint: Use the format: public void setVariableName(parameter)
    // Add simple validation:
    // - For grade: Ensure it is between 0 and 100
    // - For studentId: No special validation needed
    // - For name: No special validation needed
    // - For isActive: No special validation needed
    public void setStudentId(String studentId){

        this.studentId = studentId;

    }
    public void setStudentName(String studentName){

        this.studentName = studentName;

    }
    public void setStudentGrade(double studentGrade) {

        if( studentGrade >= 0 && studentGrade <= 100 ) {

            this.studentGrade = studentGrade;

        } else {

            System.out.println("Please, set Grade bretween 0~100!");

        }

    }
    public void setIsActive(boolean isActive) {

        // Even if it's not needed but
        if ( isActive == true || isActive == false ) {

            this.isActive = isActive;
        } else {

            System.out.println("Please, set isActive as a BOOLEAN!");

        }


    }


    // Step 4: Create a method to display student details
    // Hint: Use System.out.println() to print all student information
    // Format should include ID, name, grade, and status (Active/Inactive)
    @Override
    public String toString(){

        return (
            "\n   Student ID: " + studentId
            + "\n    Student Name: " + studentName
            + "\n    Grade : " + studentGrade
            + "\n    Is Active?: " + isActive
        );

    }

    // Step 5: Create a method that returns a letter grade based on the numeric grade
    // Hint: A: 90-100, B: 80-89, C: 70-79, D: 60-69, F: below 60
    public String letterGrading(){

        if ( this.studentGrade < 60 ) {

            return "F";

        } else if ( this.studentGrade <= 60 ) {

            return "D";
        } else if ( this.studentGrade <= 70 ) {

            return "C";
        } else if ( this.studentGrade <= 80 ) {

            return "B";

        } else {

            return "A";
        }

    }


    // Step 6: Create a method to check if the student is passing (grade >= 60)
    // Hint: Return a boolean value
    public boolean isGrading() {


        if ( this.studentGrade >=60 ) {

            return true;
        } else {

            return false;
        }


    }
}
