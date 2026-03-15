//
import java.util.Scanner;
// ARRAYS -> This is how ArrayList must be imported
import java.util.ArrayList;

public class HumanResourcesMenuTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /*
        ARRAYS -> This is How Arrays must be implemented
        */
        ArrayList <Empleado> listaEmpleados = new ArrayList<>();
        ArrayList <SolicitaLibrar> listaPeticiones = new ArrayList<>();
        
        boolean exitSelection = false;

        System.out.println(" /// HR SYSTEM: CONSTRUCTORS & OBJECTS TEST ///");

        while (!exitSelection) {

            System.out.println("\n1. Create New Employee (PARAMETERISED, All-Args)");
            System.out.println("2. Create New Leave Request (DEFAULT)");
            System.out.println("3. Create Quick Vacation Request (PARAMETERISED)");
            System.out.println("4. Clone a Request (COPY CONSTURCTOR)");
            System.out.println("5. List All Employees");
            System.out.println("6. List All Leave Requests");
            System.out.println("0. Exit");
            System.out.print("\nSelect an option: ");

            String option = scanner.nextLine();


            /*
            A SWITCH CASE is BETTER than if else if
            */
            switch (option) {

                case "1":
                    
                    try {
                        
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        
                        System.out.print("Enter Area: ");
                        String area = scanner.nextLine();
                        
                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();

                        listaEmpleados.add(new Empleado(id, name, area, email));
                        
                        System.out.println("New Employee record added successfully!");
                    
                    } catch (Exception e) {
                        
                        System.out.println("Error: Numeric value expected for ID.");
                    }
                    
                    break;

                
                case "2":
                    
                    if (listaEmpleados.isEmpty()) {
                        
                        System.out.println("\nEmployees EMPTY list! Try creating one!");
                        break;
                    
                    }
                    
                    
                    // NON-ZERO BASED FORCED AGAIN AS IN LAbs 01-003/01-006
                    try {

                        System.out.println("Select employee by index (1 to " + listaEmpleados.size() + "):");
                        int empIdx = Integer.parseInt(scanner.nextLine()) - 1;
                        
                        System.out.print("Request ID: ");
                        int reqId = Integer.parseInt(scanner.nextLine());
                        
                        System.out.print("Start Date (YYYY/MM/DD): ");
                        String start = scanner.nextLine();
                        
                        System.out.print("End Date (YYYY/MM/DD): ");
                        String end = scanner.nextLine();
                        
                        System.out.print("Reason: ");
                        String reason = scanner.nextLine();

                        listaPeticiones.add(new SolicitaLibrar(reqId, listaEmpleados.get(empIdx), start, end, reason));
                        
                        System.out.println("Request created with 'Pending' status.");
                    
                    } catch (Exception e) {
                        
                        System.out.println("Error creating request. Check your inputs.");
                    }
                    
                    break;

                
                // TESTING EMPLOYEE COPY METHOD 2.2.2. FROM Empleado cklass
                case "3":
                    
                    if (listaEmpleados.isEmpty()) {
                        
                        System.out.println("\nEmployees EMPTY list! Try creating one!");
                        break;
                    
                    }
                    
                    System.out.println("Select employee index:");
                    int idx = Integer.parseInt(scanner.nextLine()) - 1;
                    
                    listaPeticiones.add(new SolicitaLibrar(listaEmpleados.get(idx)));
                    
                    System.out.println("Quick Vacation Request generated successfully!");
                    
                    break;

                
                // TEST COPY CONSTURCTOR
                case "4":
                    
                    if (listaPeticiones.isEmpty()) {
                        
                        System.out.println("Nothing to clone!");
                        break;
                    }
                    
                    System.out.println("Select request index to clone:");
                    int cloneIdx = Integer.parseInt(scanner.nextLine()) - 1;
                    
                    SolicitaLibrar original = listaPeticiones.get(cloneIdx);
                    
                    SolicitaLibrar copia = new SolicitaLibrar(original);
                    
                    copia.setSolicitudId(original.getSolicitudId() + 1000);
                    
                    listaPeticiones.add(copia);
                    
                    System.out.println("Request cloned! (New ID assigned for testing: " + copia.getSolicitudId() + ")");
                    
                    break;

                
                // TEST Empleado .toString() Overrided
                case "5":
                
                    System.out.println("\n /// EMPLOYEE LIST ///");

                                        /** 
                     * WHEN USING <ArrayList> ...
                     * 
                     * .length DOES NOT EXIST !
                     * 
                     * .size() method instead!
                     * ...
                     * or .isEmpty() -> True/False
                    */
                    if (listaEmpleados.size() == 0 ) {

                        System.out.println("\nEmployees EMPTY list! Try creating one!");


                    } else {

                    for (Empleado e : listaEmpleados) {
                    
                        System.out.println(e.toString());
                    
                        }

                    }

                    break;

                
                
                // TEST .toString() FRO SolicitaLibrar (AND the nested .toString from Empleado, IF WORKS WELL)
                case "6":
                    
                    System.out.println("\n /// LEAVE REQUESTS LIST /// ");

                    if ( ! listaPeticiones.isEmpty() ) {
                    
                        for (SolicitaLibrar r : listaPeticiones) {
                        
                            System.out.println(r.toString());
                        
                        }

                    } else {

                        System.out.println("\nEMPTY Leave Request list!");

                    }
                    
                    break;

                
                
                case "0":
                    
                    exitSelection = true;
                    break;

                default:
                    
                    System.out.println("Invalid option!");
            }
        
        }
        
        
        
        scanner.close();
    }
}