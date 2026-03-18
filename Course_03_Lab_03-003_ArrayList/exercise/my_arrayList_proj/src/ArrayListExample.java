//
import java.util.Scanner;
import java.util.ArrayList;
// PART B) ADDING SORT
import java.util.Collections;
import java.util.Comparator;

public class ArrayListExample {

    public static void main(String[] args) {

        try {


            // 1. INITS
            Scanner scanner = new Scanner(System.in);
            ArrayList<Task> todoList = new ArrayList<>();
            

            while (true) {

                System.out.println(
                    "\n   1 to ADD a task " +
                    "\n   2 to PRINT ALL the tasks " +
                    "\n   3 to GET and SETTER a new status of tasks " +
                    "\n   4 to REMOVE a task " +
                    "\n   5 to SORT and FILTER list based on Priority" +
                    "\n     Any other key to exit"
                );

                String userAction = scanner.nextLine();


                // 1 to ADD a task
                if ( "1".equals(userAction))  {

                    System.out.println("\n Enter the task ");
                    String taskStr = scanner.nextLine();

                    System.out.println("\n Enter Priority:\n   - 1 Low\n   - 2 Medium\n   - 3 High ");
                    int priority = Integer.parseInt(scanner.nextLine());

                    priority = priority > 3 ? 1 : priority;
                    todoList.add(new Task(taskStr, priority));
					
                    System.out.println("\n   The task has been added to the list succesfully!");

                    continue;


                // 2 to PRINT ALL the tasks 
                } else if ( "2".equals(userAction))  {

                    // for ( Task task : todoList) 
                    /**
                     * THE MORE DIRECT SYNTAX, THE BETTER:
                     * 
                     *  listName.forEach( singleVar -> action() )
                    */
                    
                    if ( todoList.size() > 0 ) {

                        int[] counterForEachElegante = {1};

                        todoList.forEach( task -> {

                            System.out.println(counterForEachElegante[0] + " - " + task);
                            counterForEachElegante[0]++;

                        });
                    
                    } else {

                        System.out.println("\nThere is no taks in the list! Try creating one ...");
                    }



                // 3 to GET and SETTER a new status of tasks
                } else if ( "3".equals(userAction))  {

                    System.out.println("\n Enter the index of the status you want to change: ");
                    int chgIdx = Integer.parseInt(scanner.nextLine());


                    if ( chgIdx > (todoList.size() - 1) ) {
                        
                        System.out.println("\nThere is no such index position in the list!");
                    
                    } else {
                        
                        System.out.println("\n Enter the new status for the task\n   - 'P' for 'In Progress'\n   -'C' for 'Completed':");
                        String updatedStatus = scanner.nextLine();


                        if ( updatedStatus.equalsIgnoreCase("P") ) {

                            todoList.get(chgIdx).setStatus(Task.IN_PROGRESS);
                        
                        } else if (updatedStatus.equalsIgnoreCase("C")) {
                            
                            todoList.get(chgIdx).setStatus(Task.COMPLETED);
                        
                        }
                    }
					
                    System.out.println("\n   The task has been changed in the list succesfully!");


                // 4 to REMOVE a task
                } else if ( "4".equals(userAction))  {

                    System.out.println("\n Enter the index of the status you want to delete... ");
                    int choiceRmv = Integer.parseInt(scanner.nextLine());
                    int rmvIdx = choiceRmv - 1;

                    /**
                     * 
                     * PENDING:  Check the NonZero OR ZeroBased values for ArrayList's
                     */
                    if ( rmvIdx < 0 || rmvIdx >= todoList.size() ) {
                        
                        System.out.println("\nThere is no such index position in the list!");
                    
                    } else {
						
                        todoList.remove(rmvIdx);

						System.out.println("\n   The task has been removed from the list successfully!");
                    
                    }

                
                // PART B) ADDING SORT
                //  5 to SORT and FILTER list based on Priority
                } else if ( "5".equals(userAction) ) {

                    Collections.sort( todoList, new Comparator<Task>() {

                        @Override
                        public int compare(Task task1, Task task2 ) {

                            return Integer.compare(task2.getPriority(), task1.getPriority() );

                        }                        
                    } );

                    System.out.println("\n Tasks sorted by Priority (HIGH to LOW):");

                    int[] counterForEachElegante = {1};

                    todoList.forEach( task -> {

                        System.out.println("\n Task Index: " + counterForEachElegante[0] + " | " + task );
                        counterForEachElegante[0]++;

                    });
                    
                    


                } else {

                    break;


                }


            }

            scanner.close();



        } catch (NumberFormatException nfe) {

            System.out.println("\n NoNExpected error (Please, use NUMERIC values as expected!): " + nfe );


        }




    }


}