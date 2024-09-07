package org.codingassignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for the Smart Home Appliance Controller
 */
public class SmartHomeControl {
    /**
     * Main method for the Smart Home Appliance Controller
     */
    public static void main(String[] args) {
        List<Appliance> applianceList = new ArrayList<>();

        Light light = new Light();
        applianceList.add(light);

        Fan fan = new Fan();
        applianceList.add(fan);

        AirConditioner airConditioner = new AirConditioner();
        applianceList.add(airConditioner);

        //If the version is below the current update and past or equal to the update date it will automatically update
        UpdateSystem.checkForUpdateAndInstall(applianceList);

        System.out.println(MessageColor.SUCCESS + "Welcome to Smart Home Appliance Control\n" + MessageColor.RESET);

        // Instructions
        System.out.println("""
                Input Ex: a2 sets the AC to FAN mode\s
                Lights (l), 0 = OFF, 1 = ON\s
                Fans (f), 0 = Reduce Speed, 1 = Increase Speed\s
                AC (a), 0 = OFF, AUTO = 1, FAN = 2, DRY = 3, COOL = 4, SLEEP = 5""");

        Scanner scanner = new Scanner(System.in);

        char applianceType;
        int mode;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.length() == 1 && line.charAt(0) == 'x')
                break;

            if (line.length() == 2 && Character.isDigit(line.charAt(1))) {
                applianceType = Character.toLowerCase(line.charAt(0));

                // Subtract by the char of 0 to get the true integer value
                mode = line.charAt(1) - '0';

                switch (applianceType) {
                    case 'l':
                        if (mode < 0 || mode > 1)
                            warningMessage("Warning: A light may only be On (1) or Off (0)");
                        else
                            light.toggleSwitch(mode == 1);
                        break;
                    case 'f':
                        if (mode == 0)
                            fan.reduceSpeed();
                        else if (mode == 1)
                            fan.increaseSpeed();
                        else
                            warningMessage("Warning: A fan can increase speed (1) or reduce speed (0)");
                        break;
                    case 'a':
                        if (!airConditioner.setMode(mode))
                            warningMessage("Warning: AC modes are OFF (0), AUTO (1), FAN (2), DRY (3), COOL (4), SLEEP (5)");
                        break;
                }
            }
            else
                warningMessage("Warning: Input must be 2 characters (Ex. f1)");
        }
    }

    /**
     * Prints warning message in yellow with an underline
     */
    public static void warningMessage(String message) {
        System.out.println(MessageColor.WARNING + message + MessageColor.RESET);
    }
}