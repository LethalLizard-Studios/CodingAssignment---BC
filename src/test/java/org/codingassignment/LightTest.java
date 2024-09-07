package org.codingassignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Tests for the Light
 */
class LightTest {
    Light light;

    @BeforeEach
    void setUp() {
        light = new Light();
    }

    /**
     * Tests that the force off works for updates and other uses
     */
    @Test
    void testForceOff() {
        light.forceOff();
        assertTrue(light.isOff());
    }

    /**
     * Tests to make sure the appliance is off by default
     */
    @Test
    void testOffByDefault() {
        assertTrue(light.isOff());
    }

    /**
     * Tests toggling the light switch on and off
     */
    @Test
    void testSwitchState() {
        light.toggleSwitch(true);
        assertFalse(light.isOff());

        light.toggleSwitch(false);
        assertTrue(light.isOff());
    }
}