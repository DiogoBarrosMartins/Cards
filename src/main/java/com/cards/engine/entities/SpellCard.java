package com.cards.engine.entities;


public class SpellCard extends Card {


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

    @Override
    public void changeStep() {

    }
}

