package org.example;

/**
 * Easily accessible colors to use in print statements
 */
public enum MessageColor {
    RESET("\033[0m"),
    SUCCESS("\033[1;32m"),
    WARNING("\033[4;33m");

    private final String colorCode;

    MessageColor(String colorCode) {
        this.colorCode = colorCode;
    }

    @Override
    public String toString() {
        return colorCode;
    }
}
