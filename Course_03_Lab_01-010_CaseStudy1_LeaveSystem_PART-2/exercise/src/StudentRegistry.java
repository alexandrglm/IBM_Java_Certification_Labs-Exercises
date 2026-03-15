// StudentRegistry class to test the Student class


public class StudentRegistry {
    public static void main(String[] args) {
        // Step 1: Create two instances of the Student class
        Student studentOne = new Student();
        Student studentTwo = new Student();



        // Step 2: Use setter methods to set values for all attributes of first student
        // Example values: ID "S001", name "John Doe", grade 85.5, active true
        studentOne.setStudentId("S0001");
        studentOne.setStudentName("Pepito Perez");
        studentOne.setStudentGrade(52.25d);
        studentOne.setIsActive(true);


        // Step 3: Set values for second student
        // Example values: ID "S002", name "Jane Smith", grade 92.0, active true
        studentTwo.setStudentId("S0002");
        studentTwo.setStudentName("Juanito Lopez");
        studentTwo.setStudentGrade(79.69d);
        studentTwo.setIsActive(true);


        // Step 4: Display details of both students
        System.out.println(studentOne);
        System.out.println(studentTwo);


        // Step 5: Compare the grades of the two students and print who has the higher grade
        // Hint: Create a separate method for this comparison
        if ( studentOne.getStudentGrade() > studentTwo.getStudentGrade() ) {

            System.out.print("Higher grade is for: " + studentOne.getStudentName());

        } else {

            System.out.print("Higher grade is for: " + studentTwo.getStudentName());

        }


        // Step 6: Test the letter grade method for both students
        System.out.println("\nStudent Name: " + studentOne.getStudentName() + " , has this Grading: " + studentOne.letterGrading());
        System.out.println("\nStudent Name: " + studentTwo.getStudentName() + " , has this Grading: " + studentTwo.letterGrading());

        // Step 7: Test the passing status method for both students
        if ( studentOne.isGrading() == false ) {

            System.out.println("Unfortunately, the student '" + studentOne.getStudentName() + "' has not passed this course due to his grading score (" + studentOne.getStudentGrade() + ")");

        } else {

            System.out.println("The student '" + studentOne.getStudentName() + "' has passed this course due to his grading score (" + studentOne.getStudentGrade() + ")");
        }

        if ( studentTwo.isGrading() == false ) {

            System.out.println("Unfortunately, the student '" + studentTwo.getStudentName() + "' has not passed this course due to his grading score (" + studentTwo.getStudentGrade() + ")");

        } else {

            System.out.println("The student '" + studentTwo.getStudentName() + "' has passed this course due to his grading score (" + studentTwo.getStudentGrade() + ")");
        }


        // Step 8: Change one student to inactive and display the updated information
        studentTwo.setIsActive(false);
        System.out.println(studentTwo);



    }


    // Step 9: Create a static method to compare two students' grades and return the student with the higher grade
    // Hint: Take two Student objects as parameters
    public void compareGrades(Student st1Compare, Student st2Compare){

        if ( st1Compare.getStudentGrade() > st2Compare.getStudentGrade() ) {

            System.out.print("(STEP 9 Separated) Higher grade is for: " + st1Compare.getStudentName());

        } else {

            System.out.print("(STEP 9 Separated) Higher grade is for: " + st2Compare.getStudentName());

        }
    }
}
