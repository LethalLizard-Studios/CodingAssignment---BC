package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int currentVersionYear = 2023;

        List<Appliance> appliancesList = new ArrayList<Appliance>();

        if (CheckIfUpdateRequired(currentVersionYear)) {
            UpdateSystem(appliancesList);
            currentVersionYear = LocalDate.now().getYear();
        }

        System.out.println("Hello world!");

    }

    // Checks if current date is equal to the updates date and time or after and not yet updated
    public static boolean CheckIfUpdateRequired(int currentVersionYear) {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        //If current version is up-to-date or newer don't update
        if (currentVersionYear >= currentDate.getYear())
            return false;

        // Update each year on January 1st 1:00am local time
        LocalDate updateDate = LocalDate.of(currentDate.getYear(), 1, 1);
        LocalTime updateTime = LocalTime.of(1, 0);

        return !currentDate.isBefore(updateDate) && !currentTime.isBefore(updateTime);
    }

    public static void UpdateSystem(List<Appliance> appliancesList) {
        // Force all appliances to turn off
        for (Appliance appliance : appliancesList) {
            appliance.forceOff();
        }
    }
}