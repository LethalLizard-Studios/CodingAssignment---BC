package org.example;

public class Light implements Appliance {

    private boolean isOn = false;

    @Override
    public boolean isOff() {
        return !isOn;
    }

    @Override
    public void forceOff() {
        isOn = false;
    }
}
