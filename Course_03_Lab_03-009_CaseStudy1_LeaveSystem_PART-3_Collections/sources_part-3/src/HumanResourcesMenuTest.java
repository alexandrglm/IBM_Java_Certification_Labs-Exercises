//
import java.util.Scanner;

import javax.print.attribute.HashAttributeSet;

// ARRAYS -> This is how ArrayList must be imported
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class HumanResourcesMenuTest {

    /*
    FORM PART 3, E) QUEUEs
        para las listaPeticiones, procesarlas en el mismo
        orden que se reciben, hacemos Queue

    */
    // 1. INIT 
    private static Queue<SolicitaLibrar> peticionesPendientes = new LinkedList<>();
    // 2. METHODS QUEUE
    public static void addSolicitudPendiente(SolicitaLibrar peticion){

        peticionesPendientes.add(peticion);

    }
    public static SolicitaLibrar getSiguientePeticionPendiente(){

        return peticionesPendientes.peek();

    }
    public static SolicitaLibrar getAndRemoveSiguientePeticionPendiente (){

        return peticionesPendientes.poll();

    }
    public static int getPeticionesPendientesContador() {

        return peticionesPendientes.size();


    }
    public static boolean getPeticionesPendientesEstado() {

        return ! peticionesPendientes.isEmpty();

    }

    /*
    FORM PART 3, D) HASHMAPS
        Aquí directamente vamos a cambiar el tipo Empleado a hashmap
        y meter sus propios métodos
    */
    // 1. INIT DE HASHMAP int - empleado
    private static HashMap<Integer, Empleado> mapaEmpleados = new HashMap<>();
    // 2. METHODS DEL NUEVO HASHMAP
    public static void addMapaEmpleado(Empleado empleado) {

        mapaEmpleados.put( empleado.getEmpleadoId(), empleado );
    } 
    public static Empleado getMapaEmpleadoPorId(int empleadoId ) {

        return mapaEmpleados.get(empleadoId);

    }
    public static boolean removeMapaEmpleado(int empleadoId ){

        if ( mapaEmpleados.containsKey(empleadoId) ) {

            mapaEmpleados.remove(empleadoId);
            return true;
        }

            return false;

    }

    // PART 3, D)   SYNCRONISE MAPS ARRAYS ALL
    private static HashMap<Integer, SolicitaLibrar> mapaPeticiones = new HashMap<>();
    
    public static void addMapaPeticiones(SolicitaLibrar peticion) {

        mapaPeticiones.put( peticion.getSolicitudId(), peticion );


    }

    public static SolicitaLibrar getMapaPeticiionesPorId(int idPeticion) {

        return mapaPeticiones.get(idPeticion);

    }



    /*
    ARRAYS -> This is How Arrays must be implemented
    
    BUT, FROM PART 3, COLLECTIOS, listaPeticiones MUST
    BE IMPLEMENTED AS AN EMPLEADO CLASS PROTECTED ARRAYLIST

    APARTE, PARA TENER ACCESO REAL A listaEmpleados desde main y 
    desde otros, ENTONCES tenemos que mover el scope de los ArrayList
    */
    private static ArrayList <Empleado> listaEmpleados = new ArrayList<>();
    // ArrayList <SolicitaLibrar> listaPeticiones = new ArrayList<>();

    /**
     * Además, también por PART 3 Collections C) Exploring Sets: HashSet and TreeSet
     * Comenzamos a añadir un HashSet para departmentsWithPendingRequests
     * Se hace FUERA del main, busca arriba
     */

    /**
    * Además, también por PART 3 Collections C) Exploring Sets: HashSet and TreeSet
    *
    * Creamos un HashSet<String> departmentsWithPendingRequests = new HashSet<>(
    */ 
    // 1. INIT
    private static HashSet<String> areasConSolicitudesPendientes = new HashSet<>();

    // 2. HANDLER
    public static void actualizarAreasConSolicitudesPendientes() {

        areasConSolicitudesPendientes.clear();

        // PARA CADA EMPLEADO...
        for ( Empleado empleado : listaEmpleados ) {

            // HACEMOS NUEVA LISTA DE SU HISTORIA DE PETICIONES
            ArrayList<SolicitaLibrar> peticionesEmpleado = empleado.getHistorialPeticiones();

            // Y..:SOLO SI ESTA PENDENTE ALGUNA ...
            for ( SolicitaLibrar peticion : peticionesEmpleado ) {

                if ( "Pending".equals(peticion.getSolicitudEstado()) ){
                    
                    // .. LA AÑADIMOS A AREAS CON SOL PENDIETES RESPECTO AL AREA DEL EMPLEADO
                    areasConSolicitudesPendientes.add( empleado.getEmpleadoArea() );

                    // PARA SALIR
                    break;
                }
            }
        }

    }
    // FROM PART 3, C) 
    public static void eliminarAreaSiNoHaySolicitudesPendientes(String area) {

        boolean todaviaHayPendientes = false;


        for (Empleado empleado : listaEmpleados) {

            if (empleado.getEmpleadoArea().equals(area)) {
                
                for (SolicitaLibrar peticion : empleado.getHistorialPeticiones()) {
                    
                    if ("Pending".equals(peticion.getSolicitudEstado())) {
                    
                        todaviaHayPendientes = true;
                        break;
                    
                    }
                }
            }
            if (todaviaHayPendientes){
                break;
            }
        }

        if ( !todaviaHayPendientes ) {

            areasConSolicitudesPendientes.remove(area);
        
        }
    }
    public static boolean tienePeticionesPendientes( String area ) {

        return areasConSolicitudesPendientes.contains(area);

    }
    


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        
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
            System.out.println("   9. Remove an Employee data BY ID (SYNCRHONISED ArrayList HashMap");
            System.out.println("     0. Exit");
            System.out.print("\n Select an option: ");

            String option = scanner.nextLine();


            /*
            A SWITCH CASE is BETTER than if else if
            */

            /**
             *  DESDE LA PARTE 3, 
             * HAY QUE CAMBBIAR LA FORMA EN QUE SE TRABAJA
             * LA listaEmpleados
             * 
             * AHORA HAY QUE REGISTRARLO DE 3 FORMAS:
             *    - MAPS
             *    - LISTS
             *    - EN EL PROPIO OBJETO
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

                        // 1. REGISTAR EN OBJETO PROPIO...
                        Empleado nuevoEmpleado = new Empleado(id, name, area, email);
                        // 2. REGISTRAR EN ArrayList LISTA EMPLEADOS
                        listaEmpleados.add(nuevoEmpleado);
                        // 3. REGISTRAR EN HashMap de EMPLEADOS
                        addMapaEmpleado(nuevoEmpleado);
                        
                        System.out.println("\n    New Employee record added successfully!");
                    
                    } catch (Exception e) {
                        
                        System.out.println("\n   Error: Numeric value expected for ID.");
                    }
                    
                    break;

                
                case "2":
                    
                    // PART 3, CAMBIAMOS AL MAPA
                    if ( mapaEmpleados.isEmpty() ) {
                        
                        System.out.println("\n   Employees EMPTY list! Try creating one!");
                        break;
                    
                    }
                    
                    
                    // NON-ZERO BASED FORCED AGAIN AS IN LAbs 01-003/01-006
                    try {

                        // CAMBIO CLAVE: Pedimos el ID real para que el Mapa funcione
                        System.out.print("Enter Employee ID: ");
                        int idBuscado = Integer.parseInt(scanner.nextLine());
                        
                        // PART 3, CAMBIAMOS A METODOS MAPA y VALIDACIONES
                        // Usamos el ID que el usuario acaba de teclear
                        Empleado empleado = getMapaEmpleadoPorId(idBuscado);
                        
                        if ( empleado == null ) {

                            System.out.println("\n   Employee with ID " + idBuscado + " not found!");
                            break;

                        }

                        
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
                         * */
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

                            // CAMBIO: Usamos el objeto 'empleado' que ya validamos arriba
                            nuevaPeticion = new Vacaciones(reqId, empleado, start, end, sonPagadas);

                        
                        
                        } else if ( "3".equals(tipoSolicitud) ) {

                            // CAMBIO: Usamos el objeto 'empleado' que ya validamos arriba
                            nuevaPeticion = new Maternidad(reqId, empleado, start, end); 
                        
                        
                        } else {

                            break;
                        }

                        if ( nuevaPeticion != null ) {

                            // 1. REGISTRO EN ARRAYLIST EMPLEAOD
                            empleado.addPeticion( nuevaPeticion );

                            // 2. REGISTRO EN LA QUEUE
                            addSolicitudPendiente( nuevaPeticion );

                            // 3. REGISTRO (ACTUALIZA) EN HASHSET
                            actualizarAreasConSolicitudesPendientes();

                            // 4. REGISTRO EN MAPA GLOBAL DE PETICIONES (NUEVO)
                            addMapaPeticiones(nuevaPeticion);

                            
                            System.out.println("New Request added succesfully!");
                        
                        }

                    } catch (Exception e) {
                        
                        // Mantenemos tu mensaje de error original
                        System.out.println("\n   Error creating request, employee index not found!");
                    }
                    
                    break;
                



                // TESTING EMPLOYEE COPY METHOD 2.2.2. FROM Empleado cklass
                // MODIFIED SINCE PART 2, ABSTRACT to NEW VACATION!
                // AS A QUICK VACATION
                case "3":
                    
                    if ( mapaEmpleados.isEmpty()) {
                        
                        System.out.println("\n   Employees EMPTY list! Try creating one!");
                        break;
                    
                    }
                    
                    try {
                        // SEÑAL 1: Pedimos el ID REAL, no el índice de la lista
                        System.out.print("Enter Employee ID for Quick Vacation: ");
                        int idBuscado = Integer.parseInt(scanner.nextLine());

                        // SEÑAL 2: Búsqueda directa en el MAPA
                        Empleado empleado = getMapaEmpleadoPorId(idBuscado);

                        // VALIDACION DE OBJETO EXISTENTE
                        if (empleado != null) {

                            // 2. DIRECTAMENTE TRRABAJAR CON EL OBJETO VACACIONES
                            // Usamos 'empleado' que ya hemos recuperado del mapa
                            Vacaciones vacacionesPlantilla = new Vacaciones( 
                                (int)(Math.random()*1000), 
                                empleado,
                                "2026/01/01",
                                "2026/01/15",
                                true
                            );

                            // 3. REGISTRAR CORRECTAMENTE LAS SOLICITUDES EN TODAS LAS COLLECTIONS
                            // Añadimos el registro en el MAPA GLOBAL de peticiones
                            addSolicitudPendiente(vacacionesPlantilla);
                            empleado.addPeticion(vacacionesPlantilla);
                            actualizarAreasConSolicitudesPendientes();
                            
                            // PEEEERRO TAMBIEN Registro en el mapa de peticiones para el Case 8
                            addMapaPeticiones(vacacionesPlantilla);
                            
                            System.out.println("Quick Vacation Request generated successfully!");

                        } else {

                            System.out.println("\n    Employee with ID " + idBuscado + " does not exist!");

                        }

                    } catch (NumberFormatException e) {
                        
                        System.out.println("\n   Please enter a numeric value!");

                    } catch (Exception e) {

                        System.out.println("\n   An unexpected error occurred!");

                    }

                    break;


                
                // 4. Clone a Request (COPY CONSTURCTOR)
                // FROM PART 2, ADDED COPY CONSTRUCTORS TO EACH SUBCLASSES
                case "4":

                    if (mapaEmpleados.isEmpty()) {
                        
                        System.out.println("\n   Nothing to clone!");
                        break;
                    
                    }

                    try {
                        
                        // SEÑAL 1: Pedimos el ID REAL del empleado
                        System.out.print("Enter Employee ID to find original request: ");
                        int idBuscado = Integer.parseInt(scanner.nextLine());

                        // SEÑAL 2: Buscamos al empleado en el MAPA
                        Empleado empleadoOriginalValidar = getMapaEmpleadoPorId(idBuscado);

                        // VALIDACIÓN: ¿Existe el empleado y tiene peticiones?
                        if (empleadoOriginalValidar == null || empleadoOriginalValidar.getHistorialPeticiones().isEmpty() ) {

                            System.out.println("Employee not found or has no requests!");
                            break;

                        }

                        // SEÑAL 3: Elegimos la petición de SU historial (aquí sí usamos índice de su lista privada)
                        System.out.println("Select request index from: " + empleadoOriginalValidar.getEmpleadoName() + " (1 to " + empleadoOriginalValidar.getHistorialPeticiones().size() + ") :");
                        int peticionIdx = Integer.parseInt(scanner.nextLine()) - 1;

                        // Obtenemos la original directamente de la lista del empleado
                        SolicitaLibrar original = empleadoOriginalValidar.getHistorialPeticiones().get(peticionIdx);
                        
                        // CLONACIÓN (Polimorfismo)
                        SolicitaLibrar copia = original.noSeQueEresPeroTeDejoClonar();

                        // Le damos un ID nuevo para que no choque en el Mapa Global
                        copia.setSolicitudId( original.getSolicitudId() + 1000 );

                        // SEÑAL 4: EL REGISTRO TRIPLE (Consistencia)
                        // 1. Al historial del empleado
                        empleadoOriginalValidar.addPeticion(copia);

                        // 2. A la cola de trabajo (Queue)
                        addSolicitudPendiente(copia);

                        // 3. Al radar de áreas (HashSet)
                        actualizarAreasConSolicitudesPendientes();
                        
                        // 4. PEEEERO TAMIEN AL MAPA GLOBAL DE PETICIONES (Para el Case 8)
                        addMapaPeticiones(copia);

                        System.out.println("Request cloned! (New ID: " + copia.getSolicitudId() + ")");
                        System.out.println("Type of cloned object: " + copia.getClass().getSimpleName());

                    } catch (Exception e) {
                        
                        System.out.println("Error during cloning process: " + e );

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

                
                
                // TEST .toString() FROM SolicitaLibrar (AND the nested .toString from Empleado, IF WORKS WELL)
                case "6":
                    
                    System.out.println("\n /// LEAVE REQUESTS LIST /// ");


                    // PART4, VALIDATRIOSN IN LISTAEMPLEADO
                    if ( listaEmpleados.isEmpty() ) {

                        System.out.println("\nNo employees registered, so no requests available!");
                        break;
                    }

                    boolean tienePeticionesPendientes = false;

                    for ( Empleado empleado : listaEmpleados ){

                        // 1. SCAMOS EL PUTO HISTORIAL
                        ArrayList<SolicitaLibrar> historialArrayList = empleado.getHistorialPeticiones();

                        if ( ! historialArrayList.isEmpty() ) {

                            tienePeticionesPendientes = true;

                            System.out.println("\n   Requests for: " + empleado.getEmpleadoName() + " (ID: " + empleado.getEmpleadoId() + ")");


                            for ( SolicitaLibrar peticion : historialArrayList ) {

                                System.out.println( peticion.toString() );

                            }

                        }



                    }

                    if ( ! tienePeticionesPendientes ) {
                        
                        System.out.println("\nNo requests found in any employee's history.");
                    }
                    
                    break;




                // FROM PART 2, POLYMORPHISM
                // TASK 3:  Process all requests using polymorphism
                case "7":

                    System.out.println("\n /// PROCESSING ALL REQUESTS /// ");

                    if ( ! getPeticionesPendientesEstado() ) {

                        System.out.println("Requests EMPTY list! Try creating one Leave Request!");
                        break;

                    } 


                    while ( getPeticionesPendientesEstado() )  {


                        SolicitaLibrar peticion = getAndRemoveSiguientePeticionPendiente();

                        if ( peticion != null ) {

                            String areaAfectada = peticion.getEmpleado().getEmpleadoArea();

                            peticion.procesarSolicitud();

                            eliminarAreaSiNoHaySolicitudesPendientes(areaAfectada);

                        }


                    }

                    System.out.println("All requests was proccessed succesfully!");
                    break;

                

                
                // FROM PART 3, D) SYNCRONISE MAPS -> DIRECT ACCESS BY REQUEST ID
                case "8":
                    
                    if ( mapaPeticiones.isEmpty() ) {
                        
                            System.out.println("\n No requests found in the global system!");
                            break;
                    }

                    try {

                        // 1.   SELECT THE REQUEST DIRECTLY
                        System.out.print("Enter Request ID to view history: ");
                        int idPeticionBuscada = Integer.parseInt(scanner.nextLine());
                        
                        // 2. DIRECT ACCESS USING THE MAP METHOD
                        SolicitaLibrar peticion = getMapaPeticiionesPorId(idPeticionBuscada);

                        if ( peticion != null ) {
                            
                            // PART 2, INNER CLASSES -> SHOW HISTORY
                            peticion.mostrarHistorial();

                        } else {
                            
                            System.out.println("\n Request ID " + idPeticionBuscada + " not found!");
                        }

                    } catch (Exception e) {
                        
                        System.out.println("\n Invalid Request ID error!: " + e);
                    }
                    
                    break;



                // FROM PART 3, D) MAPS -> REMOVE EMPLOYEE
                case "9":
                    
                    if (mapaEmpleados.isEmpty()) {

                        System.out.println("\n   No employees to remove!");
                        break;
                    
                    }

                    try {

                        System.out.print("Enter Employee ID to REMOVE: ");
                        int eliminarId = Integer.parseInt(scanner.nextLine());

                        boolean eliminadoDelMapa = removeMapaEmpleado(eliminarId);

                        if ( eliminadoDelMapa ) {
                            
                            // 1:   SYNCRHONISED ArrayList HashMap
                            listaEmpleados.removeIf(empleado -> empleado.getEmpleadoId() == eliminarId);

                            // PART 3, E) QUEUEs -> REMOVE PENDING REQUESTS FROM REMOVED EMPLOYEE
                            peticionesPendientes.removeIf(peticion -> peticion.getEmpleado().getEmpleadoId() == eliminarId);

                            // PART 3, D) SYNCRONISE MAPS -> REMOVE REQUESTS FROM GLOBAL MAP
                            mapaPeticiones.entrySet().removeIf(entry -> entry.getValue().getEmpleado().getEmpleadoId() == eliminarId);

                            actualizarAreasConSolicitudesPendientes();

                            System.out.println("\n   Employee with ID " + eliminarId + " removed succesfully!");

                        } else {
                            
                            System.out.println("\n   Employee ID not found!");
                        }

                    } catch (Exception e) {
                        
                        System.out.println("\n   Invalid input!: " + e);
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