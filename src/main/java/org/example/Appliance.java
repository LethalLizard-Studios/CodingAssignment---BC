package org.example;

/**
 * Interface for all appliances/devices
 */
public interface Appliance {
    /**
     * Returns true if appliance is in the off state
     */
    boolean isOff();

    /**
     * Used to force appliances off when updating system
     */
    void forceOff();
}
