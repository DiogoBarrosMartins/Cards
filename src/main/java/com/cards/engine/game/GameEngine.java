package com.cards.engine.game;

import com.cards.engine.cards.Card;
import com.cards.engine.services.CardService;
import com.cards.engine.services.StepService;
import com.cards.engine.services.TurnService;
import com.cards.engine.turn.Step;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {
    private List<Player> players;
    private TurnService turnService;
    private StepService stepService;
    private CardService cardService;

    public GameEngine() {
        this.players = new ArrayList<>();
        // Initialize card manager with all available cards
        this.cardService = new CardService();
        initializePlayersAndCards();
        this.turnService = new TurnService(players, stepService);
        this.stepService = new StepService(turnService, this);
    }

    // Setup players and assign initial cards or decks
    private void initializePlayersAndCards() {
        // Example setup for two players
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");
        players.add(player1);
        players.add(player2);

        // Initialize player decks/cards here
        // For simplicity, assume addCardToPlayer() is a method that adds cards to a player's deck or hand
        // cardManager.addCardToPlayer(player1, new CreatureCard(...));
        // cardManager.addCardToPlayer(player2, new SpellCard(...));
    }

    public void startGame() {
        // Perform any necessary game start logic
        // For example, shuffle decks, draw initial hands, etc.
        players.forEach(player -> {
            // player.getDeck().shuffle();
            // player.drawInitialHand();
        });

        // Start the first turn
        turnService.startNextTurn();
    }

    public void activateCard(Card card, Step step) {
        // Determine the card's activation logic based on the current step
        // This might involve invoking card-specific methods or applying game rules
        System.out.println("Activating card: " + card.getName() + " during step: " + step);
        // Implement activation logic here
    }

    public void untapAllCards(Player player) {
        // Untap all tapped cards for the specified player
        System.out.println("Untapping all cards for player: " + player.getName());
        // Implement untap logic here
    }

    public void drawCard(Player player) {
        // Allow the player to draw a card from their deck
        System.out.println("Player " + player.getName() + " draws a card.");
        // Implement draw logic here, typically involving removing a card from the deck and adding it to the player's hand
    }

    public List<Player> getPlayers() {
        return players;
    }

    // Add additional methods as necessary to support game logic, such as handling combat, managing game phases, etc.
}
