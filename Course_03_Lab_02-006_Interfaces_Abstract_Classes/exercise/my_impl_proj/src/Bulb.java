// 1.   INTERFACE CREATION

// EXERCISE SPECIFIC
// 1. Define an interface `Volume` with two abstract methods, `increaseVol` and `decreaseVol`.
interface Volume {

    void increaseVol();
    void decreaseVol();

}
// 4.
interface Rpm {

    void increaseRpm();
    void decreaseRpm();

}

// GUIDED FROM PART C
interface Switchable {

    void turnOn();
    void turnOff();

}

interface Adjustable {

    void increase();
    void decrease();

}

interface Connectable {

    void connect();
    void disconnect();

}

// EXERCISE SPECIFIC
/**
 * 2.   Create a class `SmartSpeaker` that implements 
 *          `Switchable`, `Connectable` and `Volume` interfaces.
 */
class SmartSpeaker implements Switchable, Connectable, Volume {
    
    //4. Create a program in which you create an object of `SmartSpeaker` and `Fan` and access the methods.
    private boolean isOn = false;
    private int volume = 75;
    private boolean isConnected = false;


    @Override
    public void turnOn(){

        System.out.println("SmartSpeaker is TURNED ON!");

    }
    @Override
    public void turnOff(){

        System.out.println("SmartSpeaker is TURNED OFF!");

    }
    // 2.4  CONNECTABLE METHODS
    @Override
    public void connect() {

        isConnected = true;
        System.out.println("SmartSpeaker was CONNECTED!");

    }

    @Override
    public void disconnect()  {

        isConnected = false;
        System.out.println("SmartSpeaker was DISCONNECTED!");

    }
    
    @Override
    public void increaseVol() {

        if ( volume < 100 ){

            volume += 5;
            System.out.println("Volume increased to " + volume + "%.");

        } else {

            System.out.println("Volume is at MAX level!");

        }

    }

    @Override
    public void decreaseVol(){

        if ( volume > 0 ) {

            volume -= 5;
            System.out.println("Volume decreased to " + volume + "%.");


        } else {

            System.out.println("Volume is at MINIMUM level!");

        }

    }
}
/**
 * 3. Create a `Fan` class that implements:
 *       `Switchable` and `Adjustable`.
 */
class Fan implements Switchable, Rpm {

    //4. Create a program in which you create an object of `SmartSpeaker` and `Fan` and access the methods.
    private boolean isOn = false;
    private int rpm = 3500;
    private boolean isConnected = false;
    
    
    @Override
    public void turnOn(){

        System.out.println("Fan is TURNED ON!");

    }
    @Override
    public void turnOff(){

        System.out.println("Fan is TURNED OFF!");

    }


       
    @Override
    public void increaseRpm() {

        if (  rpm < 5000 ){

            rpm += 500;
            System.out.println("Fan RPM increased to " + rpm + "RPM's");

        } else {

            System.out.println("Fan RPM's is at MAX level!");

        }

    }

    @Override
    public void decreaseRpm(){

        if ( rpm <= 5000 && rpm != 0 ) {

            rpm -= 500;
            System.out.println("Fan RPM decreased to " + rpm + "RPM's");


        } else {

            System.out.println("Fan RPM increased level!");

        }

    }
}
// 2.   SmartBulb class implementing all three interfaces
class SmartBulb implements Switchable, Adjustable, Connectable {

    // 2.1 INITS
    private boolean isOn = false;
    private int brightness = 50;
    private boolean isConnected = false;

    // 2.2 SWITCHABLE METHODS
    @Override
    public void turnOn(){

        System.out.println("SmartBulb is TURNED ON!");

    }
    
    @Override
    public void turnOff(){

        System.out.println("SmartBulb is TURNED OFF!");

    }


    // 2.3. ADJUSTABLE METHODS
    @Override
    public void increase() {

        if ( brightness < 100 ){

            brightness += 10;
            System.out.println("Brightness increased to " + brightness + "%.");

        } else {

            System.out.println("Brightness is at MAX level!");

        }

    }

    @Override
    public void decrease(){

        if ( brightness > 0 ) {

            brightness -= 10;
            System.out.println("Brightness decreased to " + brightness + "%.");


        } else {

            System.out.println("Brightness is at MINIMUM level!");

        }

    }

    // 2.4  CONNECTABLE METHODS
    @Override
    public void connect() {

        isConnected = true;
        System.out.println("SmartBulb was CONNECTED!");

    }

    @Override
    public void disconnect()  {

        isConnected = false;
        System.out.println("SmartBulb was DISCONNECTED!");

    }



}


// 3.   DIMMABLE class implementing two INTEFACES
class DimmableBulb implements Switchable, Adjustable {

    // 3.1 INITS
    private boolean isOn = false;
    private int brightness = 50;

    // 3.2 SWITCHABLE METHODS
    @Override
    public void turnOn(){

        isOn = true;
        System.out.println("DimmableBulb is turned ON!");

    }
    @Override
    public void turnOff() {
        
        isOn = false;
        System.out.println("DimmableBulb is turned OFF.");
    
    }

    // 3.3  Adjustable methods
    @Override
    public void increase() {
        if (brightness < 100) {
            
            brightness += 10;
            System.out.println("Brightness increased to " + brightness + "%.");
        
        } else {
        
            System.out.println("Brightness is already at maximum!");
        
        }
    }

    @Override
    public void decrease() {
        
        if (brightness > 0) {
            
            brightness -= 10;
            System.out.println("Brightness decreased to " + brightness + "%.");
        
        } else {
            
            System.out.println("Brightness is already at minimum.");
        
        }
    }
}

//  4. RegularBulb class implementing one interface
class RegularBulb implements Switchable {
    
    // 4.1 INIT
    private boolean isOn = false;

    // 4.2  Switchable methods
    @Override
    public void turnOn() {
        
        isOn = true;
        System.out.println("RegularBulb is turned ON.");
    
    }

    @Override
    public void turnOff() {
        
        isOn = false;
        System.out.println("RegularBulb is turned OFF.");
    
    }
}