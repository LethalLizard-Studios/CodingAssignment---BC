package org.codingassignment;

/**
 * Light implements Appliance and can be toggled On and Off
 */
public class Light implements Appliance {

    private boolean isOn;

    public Light() {
        isOn = false;
    }

    @Override
    public boolean isOff() {
        return !isOn;
    }

    @Override
    public void forceOff() {
        isOn = false;
    }

    /**
     * Turns the light On or Off
     */
    public void toggleSwitch(boolean isOn) {
        this.isOn = isOn;
        System.out.println(MessageColor.SUCCESS + "Light switched " + (isOn ? "ON" : "OFF") + MessageColor.RESET);
    }
}
