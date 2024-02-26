package com.cards.engine.cards;

import com.cards.engine.cards.CardInterfaces.Activatable;
import com.cards.engine.cards.CardInterfaces.Playable;
import com.cards.engine.places.Place;
import com.cards.engine.resources.Colour;
import com.cards.engine.resources.Cost;

public abstract class
Card implements Activatable, Playable {
    private String name;
    private Colour colour;
    private Cost cost;
    private CardType type1;
    private CardType type2;
    private Place place;
    public abstract void changeStep();

    private Ability ability1;
    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public CardType getType1() {
        return type1;
    }

    public void setType1(CardType type1) {
        this.type1 = type1;
    }

    public CardType getType2() {
        return type2;
    }

    public void setType2(CardType type2) {
        this.type2 = type2;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
