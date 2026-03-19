import java.util.HashMap;
import java.util.Scanner;

public class TodoList {


    // MI DECISIÓN DE CÓDIGO, HACER Taks
    // COMO INNER CLASS, PARA VARIAR
    //  YSABER CÓMO INSTANCIAR TODO CORRECTAMENTE
    class Task {

        // INITS
        protected String name;
        protected String description;
        protected String priority;
        protected String status;

        // CONSTRUCTORS
        public Task(String name, String description, String priority, String status){
            this.name = name;
            this.description = description;
            this.priority = priority;
            this.status = status;

        }

        // GETTER
        public String getName(){
            return this.name;
        }
        public String getDescription(){
            return this.description;
        }
        public String getPriority(){
            return this.priority;
        }
        public String getStatus(){
            return this.status;
        }

        // SETTERS
        public void setName(String name){
            this.name = name;
        }
        public void setDescription(String description){
            this.description = description;
        }
        public void setPriority(String priority){
            this.priority = priority;
        }
        public void setStatus(String status) {
            this.status = status;
        }
        
        // METHODS
        /*
        - You should be able to add, view, delete and update tasks.
         */
        // LO PASO AL MAIN, NO VAMOS A HACER toString ni otros para rapidez,
        // EL EJERCICIO TRATA DE MAPS



    }
    


    // 2. MAIN
    public static void main(String[] args) {


        // INITS
        Scanner scanner = new Scanner(System.in);

        /**
         * - Create a `HashMap` which stores `TaskName` as key and the `Task` as value.
         * 
         * - You should be able to add, view, delete and update tasks.
         */
        HashMap<String, Task> todoList = new HashMap<>();


        while (true) {

            try {


                System.out.println(
                    "\n\n  ToDo List Demo Exercise: \n" +
                    "\n   1. ADD a task" +
                    "\n   2. LIST ALL tasks" + 
                    "\n   3. REMOVE a task" + 
                    "\n   4. UPDATE task's data value" + 
                    "\n      Any other key to EXIT"

                );

                String userChoice = scanner.nextLine();

                // 1. ADD a task
                if ( "1".equals(userChoice)  ) {

                    System.out.println("\n  Task NAME?: " );
                    String addName = scanner.nextLine();

                    if ( todoList.containsKey(addName) ) {

                        System.out.println("The tasks already exists! Do you want to update the task data? (y/n");
                        String confirmReplace = scanner.nextLine();

                        if ( confirmReplace.equalsIgnoreCase("n") ) {

                            continue;

                        }

                    }


                    System.out.println("\n  Task DESCRIPTION?: " );
                    String addDesc = scanner.nextLine();

                    System.out.println("\n  Task PRIORITY ( HIGH or MEDIUM or LOW ) ?: " );
                    String addPriority = scanner.nextLine();

                    System.out.println("\n  Task STATUS ( PENDING or DONE ): " );
                    String addStatus = scanner.nextLine();


                    // IMPORTANTE, USAMOS LA CLASSE !
                    // PARA CONSTRUIR EL OBNJETO COMPLETO!!!!!!
                    Task addTask = new TodoList().new Task(
                        addName, addDesc, addPriority, addStatus
                    );
                    // Y PARA GUARDAR ELONJETO EN EL MAPA.....
                    // TENDRÉ QUE ELEGITR UNO DE LOS VALORES
                    // POR EL CUAL HACERLO, EL QUE SERÁ UNICO
                    //      POR EJEMPLO... EL NOMBRE!
                    // NUNCA JAMAS HACER PUT() POR CADA PAR
                    // SI NO, DUPLICARA ENTRADAS
                    todoList.put(addName, addTask);


                    System.out.println("\n  New task ('" + addName + "') added successfully!" );

                // LIST ALL tasks
                } else if ( "2".equals(userChoice)  ) {

                    System.out.println("\n Todo List: \n" );


                    // REMEMBER, .keySet() for Maps of many key-values = .values()
                    for ( Task task : todoList.values() ) {

                        System.out.print(  
                            "\n Task Name: " + task.getName() +
                            "\n Task Description: " + task.getDescription() +
                            "\n Task Priority: " + task.getPriority() +
                            "\n Task Status: " + task.getStatus()
                        );
                    }


                // 3. REMOVE a task
                } else if ( "3".equals(userChoice)  ) {

                    System.out.println("\n   Please, choose a task BY EXACT NAME to be removed: ");
                    String removeTask = scanner.nextLine();

                    if ( ! todoList.containsKey( removeTask ) ) {

                        System.out.println("The tasks does not exists, please type the exact name");
                        continue;


                    }

                    todoList.remove( removeTask );

                    System.out.println("\n  Taks ('" + removeTask + "') removed successfully!" );


                // 4. UPDATE task's data value
                } else if ( "4".equals(userChoice)  ) {

                                        
                    System.out.println("\n  Please enter the EXACT task NAME: " );
                    // IMPORTANTE
                    // Ya que se piden KEYS unicas, Evidentemente,  
                    // al editar un objeto de Task, cambiar su nombre
                    // usando .put(), si se permite editar NAME, que
                    // actua como ident unico, 
                    // NO SE EDITARÁ, SE AÑADIRA COMO NUEVA
                    System.out.println("\n    (Task NAME CANNOT BE RENAMED, so, if you need, DELETE IT)\n\n");
                    String nameSearch = scanner.nextLine();

                    if (! todoList.containsKey(nameSearch) ) {

                        System.out.println("The tasks does not exists, please type the exact name");
                        continue;

                    }

                    // IMPORTANTE OTRA VEZ
                    // Para acceder al key-value concreto del objeto,
                    // instancialo otra vez,
                    // todas las vecves que hagan falta
                    Task task = todoList.get(nameSearch);
                    // Y, ya después, vas usando los métodos de la class

                    System.out.print("\n WORKING WITH:  " + task.getName() );

                    System.out.println("\n   New Task DESCRIPTION (Actual: " + task.getDescription() + ") ?: " );
                    String editDesc = scanner.nextLine();

                    System.out.println("\n   New Task PRIORITY (Actual: " + task.getPriority() + ") ?: " );
                    String editPriority = scanner.nextLine();

                    System.out.println("\n   New Task STATUS (Actual: " + task.getStatus() + ") ?: " );
                    String editStatus = scanner.nextLine();


                    // // IMPORTANTE, USAMOS LA CLASSE
                    // Del mismo modo que la uso antes!
                    Task editTask = new TodoList().new Task(
                         task.getName(), editDesc, editPriority, editStatus
                    );
                    // Y, POR ENDE, EL PUT SOLO PUEDE IR AL VALOR EXISTENTE
                    // Y NUNCA A TODOS LOS PARES!
                    todoList.put( task.getName(), editTask );



                    System.out.println("\n  Task ('" + task.getName() + "') UPDATED successfully!" );


                } else {

                    break;
                }

            



            } catch (Exception e) {

                System.out.print("La exception: " + e);



            }

        }
        
        scanner.close();


    }
    

}
