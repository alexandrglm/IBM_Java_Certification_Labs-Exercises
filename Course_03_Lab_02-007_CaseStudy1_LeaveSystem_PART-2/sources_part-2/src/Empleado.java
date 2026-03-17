//
public class Empleado implements Cloneable {

    // 1. Init PROPERTIES
    private int empleadoId;
    private String empleadoName;
    private String empleadoArea;
    private String empleadoEmail;

    // 2. CONSTRUCTORS
    // 2.1 DEFAULT constructor
    public Empleado (){

        this.empleadoId = 0;
        this.empleadoName = null;
        this.empleadoArea = null;
        this.empleadoEmail = null;

    }
    // 2.2 OVERCHARGED ALL-ARGS
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


    // 3.3 Other METHODS
    @Override
    public String toString() {

        return ( "\nEmployee ID: " + this.empleadoId
            + "\nName: " + this.empleadoName
            + "\nDepartment: " + this.empleadoArea
            + "\nE-mail: " + this.empleadoEmail
        );


    }



}