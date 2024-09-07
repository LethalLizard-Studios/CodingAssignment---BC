package org.codingassignment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit Tests for the Update System
 */
class UpdateSystemTest {

    List<Appliance> appliances = new ArrayList<>();

    @BeforeEach
    void setUp() {
        // Reset the version and current date & time to default
        UpdateSystem.currentVersionYear = 2023;
        UpdateSystem.currentDate = LocalDate.now();
        UpdateSystem.currentTime = LocalTime.now();

        // Generate and fill in the appliance list
        appliances = new ArrayList<>();

        Light light = new Light();
        appliances.add(light);

        Fan fan = new Fan();
        appliances.add(fan);

        AirConditioner airConditioner = new AirConditioner();
        appliances.add(airConditioner);
    }

    @AfterEach
    void tearDown() {
        // Clear the appliance list for a fresh start
        appliances.clear();
    }

    /**
     * Tests when the newest version is already installed
     */
    @Test
    void testNoUpdateRequired() {
        UpdateSystem.currentVersionYear = LocalDate.now().getYear()+1;
        assertFalse(UpdateSystem.checkForUpdateAndInstall(appliances));

        UpdateSystem.currentVersionYear = LocalDate.now().getYear()-10;
        assertTrue(UpdateSystem.checkForUpdateAndInstall(appliances));
    }

    /**
     * Tests that the specific set date (January 1st) for the update works
     */
    @Test
    void testUpdateDay() {
        UpdateSystem.currentDate = LocalDate.of(LocalDate.now().getYear(), 1, 2);
        assertTrue(UpdateSystem.checkForUpdateAndInstall(appliances));

        UpdateSystem.currentDate = LocalDate.of(LocalDate.now().getYear()-1, 12, 25);
        assertFalse(UpdateSystem.checkForUpdateAndInstall(appliances));
    }

    /**
     * Tests that the specific set time (1:00am) for the update works
     */
    @Test
    void testUpdateTime() {
        UpdateSystem.currentDate = LocalDate.of(LocalDate.now().getYear(), 1, 2);

        UpdateSystem.currentTime = LocalTime.of(1, 0);
        assertTrue(UpdateSystem.checkForUpdateAndInstall(appliances));

        UpdateSystem.currentTime = LocalTime.of(0, 30);
        assertFalse(UpdateSystem.checkForUpdateAndInstall(appliances));
    }

    /**
     * Tests that all devices turn off for the update
     */
    @Test
    void testDevicesTurningOff() {
        UpdateSystem.currentDate = LocalDate.of(LocalDate.now().getYear(), 1, 2);
        UpdateSystem.currentTime = LocalTime.of(1, 0);
        UpdateSystem.checkForUpdateAndInstall(appliances);

        for (Appliance appliance : appliances) {
            assertTrue(appliance.isOff());
        }
    }
}