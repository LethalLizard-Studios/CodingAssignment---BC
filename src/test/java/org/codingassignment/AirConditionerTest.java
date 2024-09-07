package org.codingassignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Tests for the Air Conditioner
 */
class AirConditionerTest {
    AirConditioner airConditioner;

    @BeforeEach
    void setUp() {
        airConditioner = new AirConditioner();
    }

    /**
     * Tests that the force off works for updates and other uses
     */
    @Test
    void testForceOff() {
        airConditioner.forceOff();
        assertTrue(airConditioner.isOff());
    }

    /**
     * Tests to make sure the appliance is off by default
     */
    @Test
    void testOffByDefault() {
        assertTrue(airConditioner.isOff());
    }

    /**
     * Tests the boundaries to make sure they return false to warn the user
     */
    @Test
    void testModeLimits() {
        assertFalse(airConditioner.setMode(-1));
        assertFalse(airConditioner.setMode(6));
    }

    /**
     * Tests all the various modes to make sure they're applicable
     */
    @Test
    void testModes() {
        assertTrue(airConditioner.setMode(0));
        assertTrue(airConditioner.setMode(1));
        assertTrue(airConditioner.setMode(2));
        assertTrue(airConditioner.setMode(3));
        assertTrue(airConditioner.setMode(4));
        assertTrue(airConditioner.setMode(5));
    }

    /**
     * Tests setting the mode to 0 to make sure it means off
     */
    @Test
    void testZeroIsOff() {
        airConditioner.setMode(0);
        assertTrue(airConditioner.isOff());
    }
}