package org.example;

public class AirConditioner implements Appliance {

    public enum Mode {
        OFF, LOW, MEDIUM, HIGH;
    }

    private Mode currentMode;

    @Override
    public boolean isOff() {
        return currentMode == Mode.OFF;
    }

    @Override
    public void forceOff() {
        currentMode = Mode.OFF;
    }
}
