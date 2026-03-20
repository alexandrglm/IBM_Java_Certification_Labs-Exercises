//

import java.util.ArrayList;

public class Empleado implements Cloneable {

    // 1. Init PROPERTIES
    private int empleadoId;
    private String empleadoName;
    private String empleadoArea;
    private String empleadoEmail;
    // FROM PART 3
    // private ArrayList listaPeticiones;
    private ArrayList <SolicitaLibrar> listaPeticiones = new ArrayList<>(); 

    // 2. CONSTRUCTORS
    // 2.1 DEFAULT constructor
    public Empleado (){

        this.empleadoId = 0;
        this.empleadoName = null;
        this.empleadoArea = null;
        this.empleadoEmail = null;
        this.listaPeticiones = new ArrayList<>();

    }
    // 2.2 OVERCHARGED ALL-ARGS
    // PART 3, LO CREAMOS, DE MOMENTO NO LO ESTAMOS USANDO
    public Empleado (int empleadoId, String empleadoName, String empleadoArea, String empleadoEmail, ArrayList listaPeticiones) {

        this.empleadoId = empleadoId;
        this.empleadoName = empleadoName;
        this.empleadoArea = empleadoArea;
        this.empleadoEmail = empleadoEmail;
        this.listaPeticiones = listaPeticiones;

    }
    // PART 3, EL CONSTRUCTOR DE SIEMPRE, NECESARIO PARA EL MENU CASE "1"
    public Empleado (int empleadoId, String empleadoName, String empleadoArea, String empleadoEmail) {

        this.empleadoId = empleadoId;
        this.empleadoName = empleadoName;
        this.empleadoArea = empleadoArea;
        this.empleadoEmail = empleadoEmail;

    }
    // 2.3 COPY CONSTRUCTOR (NOT MENTIONED BUT INTERESING, SIMILAR TO clone())
    public Empleado (Empleado plantilla) {

        if ( plantilla != null ){

            this.empleadoId = plantilla.empleadoId;
            this.empleadoName = plantilla.empleadoName;
            this.empleadoArea = plantilla.empleadoArea;
            this.empleadoEmail = plantilla.empleadoEmail;
            this.diasLibresRestantes = plantilla.getDiasLibresRestantes();
            this.listaPeticiones = new ArrayList<>(plantilla.listaPeticiones);

        }
    }
    // 2.4 CLONEABLE WAY
    @Override 
    protected Object clone() throws CloneNotSupportedException {

        return super.clone();
    }


    // 3. METHODS
    private int diasLibresRestantes = 31;

    // 3.1 GETTERs
    public int getDiasLibresRestantes() {

        return diasLibresRestantes;

    }
    public int getEmpleadoId(){

        return this.empleadoId;
    }
    public String getEmpleadoName(){

        return this.empleadoName;
    }
    public String getEmpleadoArea() {

        return this.empleadoArea;
    }
    public String getEmpleadoEmail(){

        return this.empleadoEmail;
    }
    /**
     * DESDE PART 3 COLLECTIONS
     * 
     * SIEMPRE AÑADIR ArrayList<LaClaseQueHayDentro>
     */
    public ArrayList<SolicitaLibrar> getListaPeticiones(){
        return this.listaPeticiones;
    }


    // 3.2 SETTERs
    public void setDiasLibresRestantes(int diasLibresRestantes) {

        try {

            if ( diasLibresRestantes >= 0 ) {

                this.diasLibresRestantes = diasLibresRestantes;

            } else {

                System.out.println("Leave Balance CANNOT be a negative value!");

            }


        } catch (NumberFormatException e) {

            System.out.println("Leave Balance MUST be a numeric value!");

        }



    }
    public void setEmpleadoId(int empleadoId){

        this.empleadoId = empleadoId;
        
    }
    public void setEmpleadoName(String empleadoName){

        this.empleadoName = empleadoName; 
    }
    public void setEmpleadoArea(String empleadoArea) {

        this.empleadoArea = empleadoArea;
    }
    public void setEmpleadoEmail(String empleadoEmail){

        this.empleadoEmail = empleadoEmail;
    }
    /**
     * DESDE PART 3 COLLECTIONS
     * 
     * SIEMPRE AÑADIR ArrayList<LaClaseQueHayDentro>
     */
    public void setListaPeticiones(ArrayList<SolicitaLibrar> listaPeticiones) {
        this.listaPeticiones = listaPeticiones;
    }


    // 3.3 Other METHODS
    @Override
    public String toString() {

        return ( "\nEmployee ID: " + this.empleadoId
            + "\nName: " + this.empleadoName
            + "\nDepartment: " + this.empleadoArea
            + "\nE-mail: " + this.empleadoEmail
        );


    }


    // FROM PART 3, COLLECTIONS
    /**
     * Desde esta parte, añadimos métodos para trabajar las
     * peticiones desde el propio objeto Empleado
     * Que éste sea "dueño" de sus propias listas
     * Después, en el main, instanciamos de la manera correcta
     * 
     */
    // addLeaveRequest()
    /* El ejercicio pide void, pero quiero anticipar y
    trabajar con bool para manejar el estado de la acción */
    public boolean addPeticion(SolicitaLibrar peticionLibrar){
        
        listaPeticiones.add(peticionLibrar);
        return true;

    }
    // getLeaveHistory()
    public ArrayList<SolicitaLibrar> getHistorialPeticiones(){

        // de momento así
        return listaPeticiones;
    }
    // getLeaveRequestById()
    public SolicitaLibrar getPeticionLibrarPorId(int peticionId){
        
        for ( SolicitaLibrar peticion : listaPeticiones ) {

            if ( peticion.getSolicitudId() != peticionId ) {

                return peticion;

            }

        }

        return null;

    }



}