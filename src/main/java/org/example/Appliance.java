package org.example;

public interface Appliance {

    // Returns if appliance is in the off state
    boolean isOff();

    // Used to force appliances off when updating system
    void forceOff();
}
