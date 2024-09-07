package org.codingassignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Tests for the Fan
 */
class FanTest {
    Fan fan;

    @BeforeEach
    void setUp() {
        fan = new Fan();
    }

    /**
     * Tests that the force off works for updates and other uses
     */
    @Test
    void testForceOff() {
        fan.forceOff();
        assertTrue(fan.isOff());
    }

    /**
     * Tests to make sure the appliance is off by default
     */
    @Test
    void testOffByDefault() {
        assertTrue(fan.isOff());
    }

    /**
     * Tests increased the speed multiple times
     */
    @Test
    void testIncreaseSpeed() {
        fan.increaseSpeed();
        assertFalse(fan.isOff());

        fan.increaseSpeed();
        assertFalse(fan.isOff());

        fan.reduceSpeed();
        assertFalse(fan.isOff());
    }

    /**
     * Tests decreasing the speed multiple times
     */
    @Test
    void testReduceSpeed() {
        fan.reduceSpeed();
        assertTrue(fan.isOff());

        fan.increaseSpeed();
        assertFalse(fan.isOff());

        fan.reduceSpeed();
        assertTrue(fan.isOff());
    }

    /**
     * Tests reducing the speed until 0 is hit to make sure it means off
     */
    @Test
    void testZeroIsOff() {
        fan.reduceSpeed();
        fan.reduceSpeed();
        fan.reduceSpeed();
        fan.reduceSpeed();
        fan.reduceSpeed();
        fan.reduceSpeed();

        assertTrue(fan.isOff());
    }
}