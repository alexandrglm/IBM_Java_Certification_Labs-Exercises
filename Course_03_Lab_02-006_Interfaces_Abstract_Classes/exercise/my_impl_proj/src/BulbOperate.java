public class BulbOperate {
    
    // 5.  MAIN for ALL THE IFACES CREATED
    public static void main(String[] args) {
        
        
        // 5.1 Create an array of Switchable objects to hold different types of bulbs
        Switchable switchables[] = new Switchable[3];

        // 5.2  Create instances

        // SmartBulb:  Switchable, Adjustable, and Connectable
        SmartBulb sb = new SmartBulb();
        // DimmableBulb:  Switchable and Adjustable
        DimmableBulb db = new DimmableBulb();
        // RegularBulb:  Only Switchable
        RegularBulb rb = new RegularBulb();



        // 5.3  Populate the array with the bulb instances
        switchables[0] = sb; // Add SmartBulb to the array
        switchables[1] = db; // Add DimmableBulb to the array
        switchables[2] = rb; // Add RegularBulb to the array


        // 5.4  Loop through the array and turn each bulb on and off
        for (int i = 0; i < switchables.length; i++) {
            
            switchables[i].turnOn(); // Turn on the bulb
            switchables[i].turnOff(); // Turn off the bulb
        
        }

        // 5.5  Increase brightness of the SmartBulb directly
        sb.increase(); // Calls the increase() method of SmartBulb

        // 5.6  Decrease brightness of the DimmableBulb by casting to Adjustable
        ((Adjustable) switchables[1]).decrease(); // Cast switchables[1] (DimmableBulb) to Adjustable and call decrease()

        // 5.7  Connect the SmartBulb to the network by casting to Connectable
        ((Connectable) switchables[0]).connect(); // Cast switchables[0] (SmartBulb) to Connectable and call connect()
    
        
        // EXERCISE
        /**
         * 0. Create Objects for fan and speaker
         * 1. Turn on Speaker
         * 2. Increase vol
         * 3. Decrease vol
         * 4. Turn off
         * 5. Turn on Fan
         * 6. Decrease RPM
         */

        Switchable switchableOther[] = new Switchable[2];

        SmartSpeaker sp = new SmartSpeaker();
        Fan f = new Fan();

        switchableOther[0] = sp;
        switchableOther[1] = f;

        for (int i = 0; i < switchableOther.length; i++) {

            switchableOther[i].turnOn();
        }

        sp.increaseVol();
        sp.decreaseVol();
        f.decreaseRpm();

        sp.turnOff();
    }
}
