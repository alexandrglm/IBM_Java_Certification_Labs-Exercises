// FROM PART 2, LocalDate IMPORTS
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


// FROM PART 2, INTERFACES Y ABSTRACTs
interface Aprobable {

    /**
     * Para recordar!
     * Todos los métodos de un interface SON PUBLICOS POR DEFECTO
     * ES REDUNDANTE ESPECIFICARLOS public
     * PERO POR APRENDIZAJE LO DEJARÉ TAL CUAl
     * Tanto aquí como en cada Override
     * Recuerda  en el futuro que si lo quitas de un lado,
     * también deberás quitarlo en el otro!!
     */

    public boolean aprobable( String quienLoProcesa);
    public boolean noAprobable( String quienQuienLoProcesa, String motivo );

}


// FROM PART 1
// Then, from part 2, this class is the superclass
public abstract class SolicitaLibrar implements Aprobable {

    // 1. INIT PROPERTIES
    /**
     * FROM PART 2
     * To implement inheritance properly, the superclass attributes 
     * must be changed to PROTECTED!!
     * * This way, subclasses can access and work with these values directly
     * The 'protected' modifier grants scope to all child classes while 
     * keeping them hidden from the rest
     */
    protected int solicitudId;
    protected Empleado empleado;
    protected String solicitudFechaInicio;
    protected String solicitudFechaFin;
    protected String solicitudEstado;
    protected String solicitudMotivo;


    // FROM PART 2, INNER CLASSES
    private ArrayList<CambiosDeEstado> historialEstados = new ArrayList<>();


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

        BETTER START WITH CASE.equals(VARIABLE
        
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


    // 3.4 PART 2 METHODS


    // FROM PART 2, INHERITANCE
    public long getDuracion(){
        /**
         * PART 2:  TIME! DATE FORMATS! DATE COMPARISONS!
         * * Although using Date/LocalDate is not yet required,
         * for now, I am going to perform it
         * 
         * * Date manipulation requires the following:
         *  1. The imports:
         *      DATE CLASS       -> java.time.LocalDate
         *      DATE FORMATTERS  -> java.time.format.DateTimeFormatter
         *      DATE COMPARISONS -> java.time.temporal.ChronoUnit
         * 
         *  2. Setting the format using its own class:
         *      DateTimeFormatter useFormat = DateTimeFormatter.ofPattern(pattern)
         * 
         *  3. If our dates are Strings, we can parse them quickly:
         *      LocalDate newDateObject = LocalDate.parse(theDateString, useFormat)
         * 
         *  4. COMPARISONS work like this; the result is a long, and it CAN be 
         *     compared afterward as an Integer:
         *      long requestedMaternityDays = ChronoUnit.DAYS.between(startDate, endDate);
         */

        long diasSolicitados;

        // 1.1 TIME FORMAT
        DateTimeFormatter formatoDateEnUso = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        // 2. PARSE TO DATES, ITS NEW
        try {

            // 2.1 PARSE TO LocalDate
            LocalDate fechaInicio = LocalDate.parse(this.solicitudFechaInicio, formatoDateEnUso);
            LocalDate fechaFin = LocalDate.parse(this.solicitudFechaFin, formatoDateEnUso);

            // 2.2 CALCULATE DAYS
            diasSolicitados = ChronoUnit.DAYS.between(fechaInicio, fechaFin);


            // 2.3 FOR A BETTER DAYS HANDLER SUMS +1
            return diasSolicitados + 1;


        } catch (Exception e) {
            
            System.out.println("DATE FORMAT ERROR:" + e + "\nPlease, use the correct format yyyy/mm/dd");
            
            /**
             * To ensure it returns a long (or an int, or whatever), 
             * MUST ALWAYS return something in the catch block! 
             * If I don't write this down, I'll neither fix it nor remember it
             */
            return -1;
        }



    }
    
    // FROM PART 2, POLYMORPHISM
    public boolean procesarSolicitud(){

        System.out.println("\nProcessing a generic Leave Request ...");
        
        this.solicitudEstado = "Pending";
        
        return true;

    }



    // FROM PART 2, INTERFACES Y ABSTRACTs
    @Override
    public boolean aprobable(String quienLoProcesa) {

        // FROM PART 2, INNER CLASES
        registrarCambiosEstado("Approved", quienLoProcesa);

        System.out.println("\nRequest Approved by: " + quienLoProcesa );

        return true;
    

    }


    @Override 
    public boolean noAprobable(String quienLoProcesa, String motivo){
        
        // FROM PART 2, INNER CLASES
        registrarCambiosEstado("Rejected", quienLoProcesa);
        this.solicitudMotivo = motivo;
        System.out.println("\nRequest Rejected by: " + quienLoProcesa );

        return false;
    }


    public abstract int calculaLosDiasTotales();


    public abstract SolicitaLibrar noSeQueEresPeroTeDejoClonar();


    // FROM PART 2, INNER CLASSES
    public void registrarCambiosEstado( String nuevoEstado, String quienLoProcesa) {

        String estadoPrevio = this.solicitudEstado;

        this.solicitudEstado = nuevoEstado;

        CambiosDeEstado nuevoRegistro = new CambiosDeEstado(estadoPrevio, nuevoEstado, quienLoProcesa);

        historialEstados.add(nuevoRegistro);

    }


    public void mostrarHistorial() {

        System.out.println("\n // REQUEST HISTORY //");

        if ( historialEstados.isEmpty() ) {

            System.out.println("\n No Resquest Historial available!");

        } else  {

            for ( CambiosDeEstado cambio : historialEstados ) {

                System.out.println(cambio.toString());

            }

        }

    }


    // FROM PART 2, INNER CLASS DEFINITION
    public class CambiosDeEstado {

        // 1. INITS
        private String estadoAnterior;
        private String estadoNuevo;
        private String fechaCambio;
        private String quienLoProcesa;

        // 2. CONSTURCTORS
        public CambiosDeEstado(
            String estadoAnterior,
            String estadoNuevo,
            String quienLoProcesa
        ) {

            this.estadoAnterior = estadoAnterior;
            this.estadoNuevo = estadoNuevo;
            this.fechaCambio = java.time.LocalDate.now().toString();
            this.quienLoProcesa = quienLoProcesa;

        }

        // 3. METHODS
        // 3.1 OVERRIDES
        @Override 
        public String toString(){

            return String.format(
                "[%s] Changes made from %s to %s, by %s",
                fechaCambio,
                estadoAnterior,
                estadoNuevo,
                quienLoProcesa
            );

        }

    }


}



// From Part 2
/**
 * EXERCISE: Create a hierarchy of leave types:
 *   `SickLeaveRequest`
 *   `VacationLeaveRequest`
 *   `MaternityLeaveRequest`
 *
 * Add specific attributes and methods to each leave type
 * Use the parent class constructor in child classes using super()
 */ 
class BajaEnfermedad extends SolicitaLibrar {

    // 1. INITS
    private boolean tieneCertificado;
    private final int DIAS_MAXIMOS_SIN_CERTIFICADO = 3;

    // 2. CONSTRUCTOR
    // 2.1 CONSTUCTOR PRINCIPAL
    public BajaEnfermedad(
        int solicitudID,
        Empleado empleado,
        String solicitudFechaInicio,
        String solicitudFechaFin,
        boolean tieneCertificado
    ){

        super(
            solicitudID,
            empleado,
            solicitudFechaInicio,
            solicitudFechaFin,
            "Sick Leave"
        );

        this.tieneCertificado = tieneCertificado;

    }


    // FROM PART 2, ABSTRACTS
    // 2.2 COPY CONSTURCTOR
    public BajaEnfermedad(BajaEnfermedad plantilla) {

        super(plantilla);

        this.tieneCertificado = plantilla.tieneCertificado;

    }


    public boolean getTieneCertificado(){

        return tieneCertificado;

    }


    public boolean esSolicitudEnfermedadValida() {

        long diasDeBaja = getDuracion();

        if ( diasDeBaja == -1) return false;

        if ( diasDeBaja > DIAS_MAXIMOS_SIN_CERTIFICADO && !tieneCertificado ) {


            System.out.println("\nSorry, max allowed days WITH NO MD CERT is 3!");
            return false;

        }

        return true;

    }


    // 3. OVERRIDES PARA CADA CASO; EN ESTE, BAJA MEDICA
    @Override
    public String toString(){

        String certificadoBajaString = tieneCertificado ? "YES" : "NO";
        String esSolicitudValidaString = esSolicitudEnfermedadValida() ? "Yes" : "No";

        return super.toString()
            .concat("\nHas MD Certificate?: " + certificadoBajaString )
            .concat("\n" + esSolicitudValidaString );
    }


    // FROM PART 2, POLYMORPHISM
    // - Override the `processRequest()` method in each leave type subclass
    @Override
    public boolean procesarSolicitud() {

        System.out.println("\nProcessing a Medical Leave Request ... ");
        
        try {


            if ( esSolicitudEnfermedadValida() ) {

                // FROM PART 2, INNER CLASES
                aprobable("System Auto-Process");

                System.out.println("\nMedical Leave Request approved!");
                return true;

            } else {

                // FROM PART 2, INNER CLASES
                noAprobable("System Auto-Process", "No MD Certificate provided for > 3 days");

                System.out.println("\nMedical Leave Request rejected!");

                return false;
            
            }
            

        } catch (Exception e) {

            this.solicitudEstado = "Pending";
            return false;

        }



    }


    // FROM PART 2, INTERFACES Y ABSTRACTs
    @Override
    public int calculaLosDiasTotales() {

        int parseoDiasCalculados = (int) getDuracion();
        
        return parseoDiasCalculados;

    }


    // DEL COPY CONSTUCRTOR, QUE VIENE DE ABSTRATC EN SUPERCLASS
    @Override
    public SolicitaLibrar noSeQueEresPeroTeDejoClonar(){

        return new BajaEnfermedad(this);

    }


}


class Vacaciones extends SolicitaLibrar {

    // 1. INITS
    private boolean sonPagadas;
    private final int DIAS_MAXIMOS_VACACIONES = 31;

    // 2. CONSTRUCTOR
    public Vacaciones(
        int solicitudID,
        Empleado empleado,
        String solicitudFechaInicio,
        String solicitudFechaFin,
        boolean sonPagadas

    ){

        super(
            solicitudID,
            empleado,
            solicitudFechaInicio,
            solicitudFechaFin,
            "Vacations"
        );

        this.sonPagadas = sonPagadas;

    }


    // FROM PART 2, ABSTRACTS
    // 2.2 COPY CONSTURCTOR
    public Vacaciones(Vacaciones plantilla) {

        super(plantilla);

        this.sonPagadas = plantilla.sonPagadas;

    }


    // 3. OVERRIDES FOR toString()
    @Override
    public String toString(){

        String sonPagadasString = sonPagadas ? "Yes" : "No";
        String tieneDiasString = compruebaSiTieneDiasSuficientes() ? "Yes" : "No";

        return super.toString()
            .concat("\nPaid Vacation?: " + sonPagadasString )
            .concat("\nHas Enough Days?: " + tieneDiasString );
    }


    // 3.1 PART 2, INHERITANCE
    public boolean compruebaSiTieneDiasSuficientes() {

        long diasSolicitadosVacaciones = getDuracion();

        boolean compruebalo = diasSolicitadosVacaciones <= DIAS_MAXIMOS_VACACIONES;

        return compruebalo;
    }


    // FROM PART 2, POLYMORPHISM
    // - Override the `processRequest()` method in each leave type subclass
    @Override
    public boolean procesarSolicitud() {

        System.out.println("\nProcessing a Vacation Leave Request ... ");
        
        try {


            if ( compruebaSiTieneDiasSuficientes() ) {

                // FROM PART 2, INNER CLASES
                aprobable("System Auto-Process");

                System.out.println("\nVacation Leave Request approved!");
                return true;

            } else {

                // FROM PART 2, INNER CLASES
                noAprobable("System Auto-Process", "Exceeds max allowed vacation days");

                System.out.println("\nVacation Leave Request rejected! No enough days!");

                return false;
            
            }
            

        } catch (Exception e) {

            this.solicitudEstado = "Pending";
            return false;

        }



    }


    // FROM PART 2, INTERFACES Y ABSTRACTs
    @Override
    public int calculaLosDiasTotales() {

        int parseoDiasCalculados = (int) getDuracion();
        
        return parseoDiasCalculados;

    }


    @Override
    public SolicitaLibrar noSeQueEresPeroTeDejoClonar(){

        return new Vacaciones(this);

    }

}
    

class Maternidad extends SolicitaLibrar {

    // 1. INITS
    public final int DIAS_MAXIMOS_MATERNIDAD = 10;

    // 2. CONSTRUCTOR
    public Maternidad(
        int solicitudID,
        Empleado empleado,
        String solicitudFechaInicio,
        String solicitudFechaFin
    ){

        super(
            solicitudID,
            empleado,
            solicitudFechaInicio,
            solicitudFechaFin,
            "Baja por Maternidad"
        );

    }


    // FROM PART 2, ABSTRACTS
    // 2.2 COPY CONSTURCTOR
    public Maternidad(Maternidad plantilla) {

        super(plantilla);


    }


    public boolean maximoDiasMaternidad() {


        // 1. INITS FROM GETTERS
        long diasSolicitadosMaternidad = getDuracion();

        if (  diasSolicitadosMaternidad == -1) return false;
        
        if ( diasSolicitadosMaternidad > DIAS_MAXIMOS_MATERNIDAD ) {

            System.out.println("Sorry, but a Maternity Leave can only have 10 consecutive days!");
            return false;
        } 

        return true;



    }


    // 3. OVERRIDES FOR toString()
    // 3. OVERRIDES PARA CADA CASO; EN ESTE, BAJA MEDICA
    @Override
    public String toString(){

        String cumpleONoCumple = maximoDiasMaternidad() ? "Yes" : "No";

        return super.toString()
            .concat("\nMax Consecutive Days: " + DIAS_MAXIMOS_MATERNIDAD )
            .concat("\n Meet Requirements?: " + cumpleONoCumple);
    }



    // FROM PART 2, POLYMORPHISM
    // - Override the `processRequest()` method in each leave type subclass
    @Override
    public boolean procesarSolicitud() {

        System.out.println("\nProcessing a Maternity Leave Request ... ");
        
        try {


            if ( maximoDiasMaternidad() ) {

                // FROM PART 2, INNER CLASES
                aprobable("System Auto-Process");

                System.out.println("\nMaternityLeave Request approved!");
                return true;

            } else {

                // FROM PART 2, INNER CLASES
                noAprobable("System Auto-Process", "Exceeds max maternity days");

                System.out.println("\nMaternity Leave Request rejected! Must be 10 consecutive days! ");

                return false;
            
            }
            

        } catch (Exception e) {

            this.solicitudEstado = "Pending";
            return false;

        }



    }


    // FROM PART 2, INTERFACES Y ABSTRACTs
    @Override
    public int calculaLosDiasTotales() {

        int parseoDiasCalculados = (int) getDuracion();
        
        return parseoDiasCalculados;

    }


    @Override
    public SolicitaLibrar noSeQueEresPeroTeDejoClonar(){

        return new Maternidad(this);

    }


}