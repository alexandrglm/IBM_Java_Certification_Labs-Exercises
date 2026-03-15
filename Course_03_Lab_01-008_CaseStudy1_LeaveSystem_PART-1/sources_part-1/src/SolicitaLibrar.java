//
public class SolicitaLibrar {

    // 1. INIT PROPERTIES
    private int solicitudId;
    private Empleado empleado;
    private String solicitudFechaInicio;
    private String solicitudFechaFin;
    private String solicitudEstado;
    private String solicitudMotivo;


    // 2. CONSTRUCTORS
    // 2.1 DEFAULT constructor, No-Args
    public SolicitaLibrar() {

        this.solicitudId = 0;
        this.empleado = null;
        this.solicitudFechaInicio = null;
        this.solicitudFechaFin = null;
        this.solicitudEstado = null;
        this.solicitudMotivo = null;

    }
    // 2.2.1  OVERLOADED Constructor, PARAMETERISED (but NOT All-Args)
    public SolicitaLibrar( int solicitudId, Empleado empleado, String solicitudFechaInicio, String solicitudFechaFin, String solicitudMotivo) {

        this.solicitudId = solicitudId;
        this.empleado = empleado;
        this.solicitudFechaInicio = solicitudFechaInicio;
        this.solicitudFechaFin = solicitudFechaFin;
        // MANUAL ARG! PEnding by default!
        this.solicitudEstado = "Pending";
        this.solicitudMotivo = solicitudMotivo;


    }
    // 2.2.2 OVERLOADED Constructor, PARAMETERISED (All-Args)
    public SolicitaLibrar(Empleado empleado) {
        
        this.solicitudId = (int)(Math.random() * 1000 );
        this.empleado = empleado;
        this.solicitudFechaInicio = "2026/05/15";
        this.solicitudFechaFin = "2026/05/25";
        this.solicitudEstado = "Pending";
        this.solicitudMotivo = "Vacaciones Trimestrales";

    }
    // 2.3 COPY CONSTUCTOR
    public SolicitaLibrar (SolicitaLibrar plantilla) {

        if ( plantilla != null ) {

            this.solicitudId = plantilla.solicitudId;

            /*
            A VERY IMPORTANT NOTE ABOUT CLONING/COPYNG OBJETCS

            This is a DEEP COPY ( new Object(variable.object) )
            NO MEMORY LINKED, ITS A NEW OBJECT
            SO...
            LATER, THE COPIED OBJECT CAN BE MANIPULATED ...
            ... WITHOUT EDITINT THE ORIGIN!!!!
            */
            this.empleado = new Empleado(plantilla.empleado);
            
            
            this.solicitudFechaInicio = plantilla.solicitudFechaInicio;
            this.solicitudFechaFin = plantilla.solicitudFechaFin;
            this.solicitudEstado = plantilla.solicitudEstado;
            this.solicitudMotivo = plantilla.solicitudMotivo;

        }

    }



    // 3. METHODS

    // 3.1 GETTERs
    public int getSolicitudId(){
        return this.solicitudId;
    }
    public Empleado getEmpleado(){
        return this.empleado;
    }
    public String getSolicitudFechaInicio() {
        return this.solicitudFechaInicio;
    }
    public String getSolicitudFechaFin() {
        return this.solicitudFechaFin;
    }
    public String getSolicitudEstado() {
        return this.solicitudEstado;
    }
    public String getSolicitudMotivo() {
        return this.solicitudMotivo;
    }

    // 3.2 SETTERS
    public void setSolicitudId(int solicitudId){

        this.solicitudId = solicitudId;
    }
    public void setEmpleado(Empleado empleado){
        
        this.empleado = empleado;
    }
    public void setSolicitudFechaInicio(String solicitudFechaInicio){

        this.solicitudFechaInicio = solicitudFechaInicio;
    }
    public void setSolicitudFechaFin(String solicitudFechaFin){

        this.solicitudFechaFin = solicitudFechaFin;
    }
    public void setSolicitudEstado(String solicitudEstado) {

        // FIX TO 3 STATUS -> "Pending", "Approved" ORRRRRR "Rejected"
        // DO NOT FEAR WHEN USING SETTERS AS YOUR OWN, SO...
        // AND ... COMPARES UPSIDE DOWN
        /*
        OLD (and BAD) example:
        if ( solicitudEstado.equals("Pending") 
            || solicitudEstado.equals("Approved")
            || solicitudEstado.equals("Rejected") ) {

        BETTER START WITH CASE.equals(VARIABLE)

        AND ... IN THE FUTURE, BETTER USE ENUM !
        */
        if ( 
            "Pending".equals(solicitudEstado) 
            || "Approved".equals(solicitudEstado)
            || "Rejected".equals(solicitudEstado) 
        ) {

                this.solicitudEstado = solicitudEstado;
            
            } else {

                System.out.println("STATUS SETTE ERROR: '" + solicitudEstado + "' MUST be 'Pending', 'Approved' OR 'Rejected'");
            }
        

    }
    public void setSolicitudMotivo(String solicitudMotivo) {

        this.solicitudMotivo = solicitudMotivo;
    }

    // 3.3 OTHER METHODS

    @Override
    public String toString() {

        return ( "\nRequest ID: " + this.solicitudId
            + "\nEmployee: " + this.getEmpleado()
            + "\nStart Date: " + this.solicitudFechaInicio
            + "\nEnd Date: " + this.solicitudFechaFin
            + "\nStatus: " + this.solicitudEstado
            + "\nReason: " + this.solicitudMotivo );

    }


}
