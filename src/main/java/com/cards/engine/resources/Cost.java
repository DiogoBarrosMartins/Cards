package com.cards.engine.resources;

public class Cost {
    private final int colorless; // Represents a generic cost that can be paid with any color

    // Fields for specific colors
    private final int white;
    private final int blue;
    private final int black;
    private final int red;
    private final int green;

    // Constructor for setting both generic and specific color costs
    public Cost( int white, int blue, int black, int red, int green, int colorless) {
        this.white = white;
        this.blue = blue;
        this.black = black;
        this.red = red;
        this.green = green;
        this.colorless = colorless;
    }

    // Getters
    public int getWhite() { return white; }
    public int getBlue() { return blue; }
    public int getBlack() { return black; }
    public int getRed() { return red; }
    public int getGreen() { return green; }
    public int getColorless() { return colorless; }

    // Method to calculate the total cost of the card
    public int getTotalCost() {
        return  white + blue + black + red + green + colorless;
    }

    // Method to check if a set of resources (provided as parameters) meets or exceeds the cost
    public boolean isCostMet(int availableGeneric, int availableWhite, int availableBlue,
                             int availableBlack, int availableRed, int availableGreen, int availableColorless) {
        // Check if the specific color costs are met
        if (white > availableWhite || blue > availableBlue || black > availableBlack ||
                red > availableRed || green > availableGreen || colorless > availableColorless) {
            return false;
        }

        // Calculate the total available resources including generic
        int totalAvailable = availableGeneric + availableWhite + availableBlue +
                availableBlack + availableRed + availableGreen + availableColorless;

        // Check if the total cost is met
        return getTotalCost() <= totalAvailable;
    }

}
