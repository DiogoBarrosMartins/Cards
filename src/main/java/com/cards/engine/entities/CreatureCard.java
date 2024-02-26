 package com.cards.engine.entities;

public class CreatureCard extends Card {
    private int power;
    private int toughness;

    public CreatureCard(Colour colour, Cost cost, Place place, int power, int toughness) {
        // Initialize Card properties
        setColour(colour);
        setCost(cost);
        setType1(CardType.CREATURE);
        setPlace(place);
        // Initialize CreatureCard properties
        this.power = power;
        this.toughness = toughness;
    }

    @Override
    public void changeStep() {
        // Implement behavior for changeStep, if any specific to CreatureCards
    }

    // Additional methods specific to CreatureCards, like attack or block
    public int getPower() {
        return power;
    }

    public int getToughness() {
        return toughness;
    }

    @Override
    public boolean isActivatable() {
        return false;
    }

    @Override
    public void activate() {

    }

    @Override
    public boolean isPlayable() {
        return false;
    }

    @Override
    public void play() {

    }
}

