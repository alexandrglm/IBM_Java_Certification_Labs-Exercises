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

        while (!exitSelection) {

            System.out.println(" /// HR SYSTEM: CONSTRUCTORS & OBJECTS TEST ///");

            System.out.println("\n   1. Create New Employee (PARAMETERISED, All-Args)");
            System.out.println("   2. Create New Leave Request (DEFAULT)");
            System.out.println("   3. Create Quick Vacation Request (PARAMETERISED)");
            System.out.println("   4. Clone a Request (COPY CONSTURCTOR)");
            System.out.println("   5. List All Employees");
            System.out.println("   6. List All Leave Requests");
            System.out.println("   7. Process All Requests");
            System.out.println("   8. Check Requests Historial");
            System.out.println("     0. Exit");
            System.out.print("\n Select an option: ");

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
                        
                        System.out.println("\n    New Employee record added successfully!");
                    
                    } catch (Exception e) {
                        
                        System.out.println("\n   Error: Numeric value expected for ID.");
                    }
                    
                    break;

                
                case "2":
                    
                    if (listaEmpleados.isEmpty()) {
                        
                        System.out.println("\n   Employees EMPTY list! Try creating one!");
                        break;
                    
                    }
                    
                    
                    // NON-ZERO BASED FORCED AGAIN AS IN LAbs 01-003/01-006
                    try {


                        System.out.println("Select employee by index (1 to " + listaEmpleados.size() + "):");
                        int empIdx = Integer.parseInt(scanner.nextLine()) - 1;
                        Empleado empleado = listaEmpleados.get(empIdx);
                        
                        System.out.print("Request ID: ");
                        int reqId = Integer.parseInt(scanner.nextLine());
                        
                        System.out.print("Start Date (YYYY/MM/DD): ");
                        String start = scanner.nextLine();
                        
                        System.out.print("End Date (YYYY/MM/DD): ");
                        String end = scanner.nextLine();
                        
                        //System.out.print("Reason: ");
                        //String reason = scanner.nextLine();


                        // PART 2, ASBTRACTION
                        /**
                         * As for the changes made to superclass as abstract,
                         * now .. new SolicitaLibrar WONT WORK!
                         * 
                         */
                        System.out.println("\nSelect Request Type:\n\n   1. Sick Leave\n   2. Vacation\n   3. Maternity ");
                        String tipoSolicitud = scanner.nextLine();

                        SolicitaLibrar nuevaPeticion = null;

                        if ( "1".equals(tipoSolicitud) ) {
                            
                            System.out.print("\n Has MD Certificate? (true/false): ");
                            boolean tieneCertificado = Boolean.parseBoolean(scanner.nextLine());
                                
                            nuevaPeticion = new BajaEnfermedad(reqId, empleado, start, end, tieneCertificado);
                            
                        
                        
                        } else if ( "2".equals(tipoSolicitud) ) {

                            System.out.print("Is it paid? (true/false): ");
                            boolean sonPagadas = Boolean.parseBoolean(scanner.nextLine());

                            nuevaPeticion = new Vacaciones(reqId, listaEmpleados.get(empIdx), start, end, sonPagadas);

                        
                        
                        } else if ( "3".equals(tipoSolicitud) ) {

                            nuevaPeticion = new Maternidad(reqId, listaEmpleados.get(empIdx), start, end); 
                        
                        
                        } else {

                            break;
                        }

                        if ( nuevaPeticion != null ) {

                            listaPeticiones.add(nuevaPeticion);
                            System.out.println("New Request added succesfully!");
                        
                        }

                    } catch (Exception e) {
                        
                        System.out.println("\n   Error creating request, employee index not found!");
                    }
                    
                    break;

                
// TESTING EMPLOYEE COPY METHOD 2.2.2. FROM Empleado cklass
                // MODIFIED SINCE PART 2, ABSTRACT to NEW VACATION!
                // AS A QUICK VACATION
                case "3":
                    
                    if (listaEmpleados.isEmpty()) {
                        
                        System.out.println("\n   Employees EMPTY list! Try creating one!");
                        break;
                    
                    }
                    
                    try {

                        System.out.println("Select employee index (1 to " + listaEmpleados.size() + "):");
                        int idx = Integer.parseInt(scanner.nextLine()) - 1;

                        // VALIDACION DE INDICE EXISTENTE
                        if (idx >= 0 && idx < listaEmpleados.size()) {

                            listaPeticiones.add(
                                new Vacaciones( (int)(Math.random()*1000), 
                                listaEmpleados.get(idx),
                                "2026/01/01",
                                "2026/01/15",
                                true)
                            );
                            
                            System.out.println("Quick Vacation Request generated successfully!");

                        } else {

                            System.out.println("\n    Employee  (by its index: " + (idx + 1) + ") does not exist!");

                        }

                    } catch (NumberFormatException e) {
                        
                        System.out.println("\n   Please enter a numeric value!");

                    } catch (Exception e) {

                        System.out.println("\n   An unexpected error occurred!");

                    }

                    break;



                
                // TEST COPY CONSTURCTOR
                // FROM PART 2, ADDED COPY CONSTRUCTORS TO EACH SUBCLASSES
                case "4":

                    if (listaPeticiones.isEmpty()) {
                        
                        System.out.println("\n   Nothing to clone!");
                        break;
                    
                    }

                    try {
                        
                        System.out.println("Select request index to clone:");
                        int cloneIdx = Integer.parseInt(scanner.nextLine()) - 1;

                        SolicitaLibrar original = listaPeticiones.get(cloneIdx);
                        Empleado empleadoOriginalValidar = original.getEmpleado();

                        if (empleadoOriginalValidar != null && empleadoOriginalValidar.getEmpleadoId() != 0) {

                            SolicitaLibrar copia = original.noSeQueEresPeroTeDejoClonar();

                            copia.setSolicitudId(original.getSolicitudId() + 1000); 

                            listaPeticiones.add(copia);

                            System.out.println("Request cloned! (New ID: " + copia.getSolicitudId() + ")");
                            System.out.println("Type of cloned object: " + copia.getClass().getSimpleName());

                        } else {
                            
                            System.out.println("\nThis request has no valid Employee to clone!");
                        }

                    } catch (Exception e) {
                        
                        System.out.println("Error cloning: Check the index or inputs.");
                    }
                    
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

                    for (Empleado empleado : listaEmpleados) {
                    
                        System.out.println(empleado.toString());
                    
                        }

                    }

                    System.out.println("\n");

                    break;

                
                
                // TEST .toString() FRO SolicitaLibrar (AND the nested .toString from Empleado, IF WORKS WELL)
                case "6":
                    
                    System.out.println("\n /// LEAVE REQUESTS LIST /// ");

                    if ( ! listaPeticiones.isEmpty() ) {
                    
                        for (SolicitaLibrar peticion : listaPeticiones) {
                        
                            System.out.println(peticion.toString());
                        
                        }

                    } else {

                        System.out.println("\nEMPTY Leave Request list!");

                    }
                    
                    break;




                // FROM PART 2, POLYMORPHISM
                // TASK 3:  Process all requests using polymorphism
                case "7":

                    System.out.println("\n /// PROCESSING ALL REQUESTS /// ");

                    if ( listaPeticiones.isEmpty() ) {

                        System.out.println("Requests EMPTY list! Try creating one Leave Request!");

                    } else {

                        for ( SolicitaLibrar peticion : listaPeticiones  ) {

                            peticion.procesarSolicitud();

                        }

                        System.out.println("All requests was proccessed succesfully!");

                    }
                    

                    break;

                

                
                // FROM PART 2, INNER CLASSES -> CHANGES HISTORIAL
                case "8":
                    
                    if (listaPeticiones.isEmpty()) {
                        
                            System.out.println("No requests to check history!");
                            break;
                    }

                    try {

                        System.out.println("Select request index to view history (1 to " + listaPeticiones.size() + "):");
                        int histIdx = Integer.parseInt(scanner.nextLine()) - 1;

                        listaPeticiones.get(histIdx).mostrarHistorial();

                    } catch (Exception e) {
                        
                        System.out.println(" Invalid Petition index!");
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