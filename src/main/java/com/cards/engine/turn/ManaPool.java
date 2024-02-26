package com.cards.engine.turn;

import com.cards.engine.resources.Colour;

import java.awt.*;

public class ManaPool {
    private int whiteMana;
    private int blueMana;
    private int blackMana;
    private int redMana;
    private int greenMana;
    private int colorlessMana;

    public ManaPool(int whiteMana, int blueMana, int blackMana, int redMana, int greenMana, int colorlessMana) {
        this.whiteMana = whiteMana;
        this.blueMana = blueMana;
        this.blackMana = blackMana;
        this.redMana = redMana;
        this.greenMana = greenMana;
        this.colorlessMana = colorlessMana;
    }

    // Initialize all mana to 0
    public ManaPool() {
        this.whiteMana = this.blueMana = this.blackMana = this.redMana = this.greenMana = this.colorlessMana = 0;
    }
    public void resetManaPool() {
        whiteMana = blueMana = blackMana = redMana = greenMana = colorlessMana = 0;
    }

    public int getWhiteMana() {
        return whiteMana;
    }

    public void setWhiteMana(int whiteMana) {
        this.whiteMana = whiteMana;
    }

    public int getBlueMana() {
        return blueMana;
    }

    public void setBlueMana(int blueMana) {
        this.blueMana = blueMana;
    }

    public int getBlackMana() {
        return blackMana;
    }

    public void setBlackMana(int blackMana) {
        this.blackMana = blackMana;
    }

    public int getRedMana() {
        return redMana;
    }

    public void setRedMana(int redMana) {
        this.redMana = redMana;
    }

    public int getGreenMana() {
        return greenMana;
    }

    public void setGreenMana(int greenMana) {
        this.greenMana = greenMana;
    }

    public int getColorlessMana() {
        return colorlessMana;
    }

    public void setColorlessMana(int colorlessMana) {
        this.colorlessMana = colorlessMana;
    }

    // Methods to add mana
    public void addMana(Colour type, int amount) {
        switch (type) {
            case WHITE:
                whiteMana += amount;
                break;
            case BLUE:
                blueMana += amount;
                break;
            case BLACK:
                blackMana += amount;
                break;
            case RED:
                redMana += amount;
                break;
            case GREEN:
                greenMana += amount;
                break;
            case COLORLESS:
                colorlessMana += amount;
                break;
        }
    }
    public void reset() {
        whiteMana = blueMana = blackMana = redMana = greenMana = colorlessMana = 0;
    }
}
