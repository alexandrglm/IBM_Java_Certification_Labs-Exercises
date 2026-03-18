
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Student {

    // 1. INITS
    private String name;
    private int age;
    private String major;
    

    // 2. CONSTRUCTORS
    public Student(String name, int age, String major) {

        this.name = name;
        this.age = age;
        this.major = major;
    }
    // GETTER
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getMajor(){
        return this.major;
    }
    // SETTERS
    public void  setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setMajor(String major){
        this.major = major;
    }


    //3. METHODS
    public static int compareByAge(Student student1, Student student2 ){

        int student1Age = student1.getAge();
        int student2Age = student2.getAge();

        return Integer.compare(student1Age, student2Age );
        

    }
    public String toString(){

        return ("").concat(" | Student Name: " + name )
            .concat(" | Age: " + age )
            .concat(" | Major: " + major     
        );

    }



    // 4. AND THE INCLUDED MAIN
    public static void main(String[] args) {

        // 1. INITS MAIN
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> studentList = new ArrayList<>();

        while(true){

            System.out.println(
                "\n // STUDENTS MENU //\n" +
                "\n   1 to ADD an user " +
                "\n   2 to UPDATE an user data " +
                "\n   3 to DELETE an user " +
                "\n   4 to SORT students by AGE" +
                "\n     Any other key to exit"
            );

            String userAction = scanner.nextLine();

            // 1 to ADD an user
            if ( "1".equals(userAction) ) {

                System.out.println("\n  Student name?:");
                String addName = scanner.nextLine();
                

                System.out.println("\n  Student age?:");
                int addAge = Integer.parseInt(scanner.nextLine());

                System.out.println("\n  Student Major?:");
                String addMajor = scanner.nextLine();

                studentList.add(
                    new Student(addName, addAge, addMajor)
                );
                
                System.out.println("\n   The Student has been added to the list succesfully!");

                continue;

            


            // 2 to UPDATE an user data
            } else if ( "2".equals(userAction) ) {

                System.out.println("\n SELECT the user by its index to edit update data:");

                int[] counterForEachElegante = {1};
                studentList.forEach( student -> {

                    System.out.println("\n Student Index: " + counterForEachElegante[0] + student );
                    counterForEachElegante[0]++;

                });
                int editIndex = Integer.parseInt(scanner.nextLine()) - 1;

                System.out.println("\n  Student name? (Original value: " + studentList.get(editIndex).getName() + "):");
                String addName = scanner.nextLine();
                

                System.out.println("\n  Student age? (Original value: " + studentList.get(editIndex).getAge() + "):");
                int addAge = Integer.parseInt(scanner.nextLine());

                System.out.println("\n  Student Major? (Original value: " + studentList.get(editIndex).getMajor() + "):");
                String addMajor = scanner.nextLine();


                Student temp = studentList.get(editIndex);

                temp.setName(addName);
                temp.setAge(addAge);
                temp.setMajor(addMajor);

                System.out.println("\n   The student data has been updated succesfully!");
                continue;
                
            // 3 to DELETE an user    
            } else if ( "3".equals(userAction) ) {

                System.out.println("\n SELECT the user by its index to be REMOVED! :");

                int[] counterForEachElegante = {1};
                studentList.forEach( student -> {

                    System.out.println("\n Student Index: " + counterForEachElegante[0] + student );
                    counterForEachElegante[0]++;

                });

                int removeIndex = Integer.parseInt(scanner.nextLine()) - 1;

                studentList.remove(removeIndex);

                System.out.println("\n   The student has been removed from list succesfully!");
                continue;

                
            // 4 to SORT students by AGE
            } else if ( "4".equals(userAction) ) {
                /**
                 *
                 * EXERCISE PART 3
                 * The traditional WAY of doing everything with
                 *     Collections.sort(...)
                 *     and then using @Override on the compare method
                 *     is GOOD,
                 *
                 * but I am learning a new way to...
                 *      1. ... WITHOUT doing an Override...
                 *      2. ...aince the main method is inside the superclass (or same class)
                 *      3. .. A new syntax to learn:
                 *          listVar.sort( Class::method )
                 *      
                 *      Double colon, "::",
                 *      METHOD REFERENCE !!!
                 *
                 * REQUIRES:
                 *      1. The method() as STATIC
                 *      2. NO Override are perfomr internally
                 *      3. Method Reference is... DIRECT POINTER REFERNCE!
                 *
                 */
                // So, THIS:
                studentList.sort(Student::compareByAge);
                /** 
                 * REPLACES THIS:
                 * 
                 * Collections.sort( studentList, new Comparator<Student>() {
                 *      @Override
                 *      public int compareByAge(User user1, User user2 ) {
                 * 
                 *           return Integer.compare(user2.getAge(), user1.getAge() );
                 *       }                        
                 * } );
                 */

                System.out.println("\n Student Lists order by AGE:");

                int[] counterForEachElegante = {1};
                studentList.forEach( student -> {

                    System.out.println("\n Student Index: " + counterForEachElegante[0] + student );
                    counterForEachElegante[0]++;

                });





            
                
            } else {

                break;

            }



        }


        scanner.close();



    }
    
}
