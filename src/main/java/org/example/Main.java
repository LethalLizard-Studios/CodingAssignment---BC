package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        boolean hasUpdated = false;

        List<Appliance> applianceList = new ArrayList<Appliance>();

        hasUpdated = UpdateSystem.CheckForUpdateAndInstall(applianceList);

        if (hasUpdated)
            System.out.println("System has updated to Version " + UpdateSystem.currentVersionYear);
    }
}