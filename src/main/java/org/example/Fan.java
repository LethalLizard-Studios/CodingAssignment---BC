package org.example;

public class Fan implements Appliance {

    int currentSpeed = 0;

    @Override
    public boolean isOff() {
        return currentSpeed == 0;
    }

    @Override
    public void forceOff() {
        currentSpeed = 0;
    }

    public int reduceSpeed() {
        return setCurrentSpeed(currentSpeed - 1);
    }

    public int increaseSpeed() {
        return setCurrentSpeed(currentSpeed + 1);
    }

    private int setCurrentSpeed(int speed) {
        currentSpeed = Math.max(0, Math.min(speed, 2));
        return currentSpeed;
    }
}
