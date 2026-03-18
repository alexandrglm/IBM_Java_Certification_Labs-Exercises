//

public class Task {

    // 1. INITS
    public static int HIGH = 3;
    public static int MEDIUM = 2;
    public static int LOW = 1;

    public static String COMPLETED = "Completed";
    public static String IN_PROGRESS = "In Progress";
    public static String NEW = "New";

    private String taskName;
    private int priority = LOW;
    private String status = NEW;

    // 2. CONSTURCTORS
    // OVERLOADED SUPERPOBLADOS
    public Task (String taskName) {
        this.taskName = taskName;
    }
    public Task (String taskName, int priority) {
        this.taskName = taskName;
        this.priority = priority;

    }
    
    // SETTERS
    public void setStatus(String status) {

        this.status = status;
    }
    public void setPriority(int priority) {
        this.priority = priority;

    }
    // GETTERS
    public String getStatus(){
        return this.status;
    }
    public int getPriority(){
        return this.priority;
    }
    
    // METHODS
    public String toString(){

        return ("\n").concat(" Task Name: '" + (taskName) )
            .concat("' | Priority: " + (priority))
            .concat(" | Status: " + (status)
            );

    }



}