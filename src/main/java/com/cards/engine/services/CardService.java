package com.cards.engine.services;

import com.cards.engine.cards.CardInterfaces.Activatable;

import java.util.ArrayList;
import java.util.List;

public class CardService {

    private List<Activatable> cardsInPlay;

    public CardService() {
        this.cardsInPlay = new ArrayList<>();
    }

    // Method to add a card to the manager
    public void addCard(Activatable card) {
        cardsInPlay.add(card);
    }

    // Get all cards
    public List<Activatable> getCardsInPlay() {
        return cardsInPlay;
    }
}