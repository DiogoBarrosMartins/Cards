package com.cards.engine.services;

import com.cards.engine.game.Player;

import java.util.List;

public class TurnService {
    private int currentPlayerIndex;
    private List<Player> players;
    private StepService stepService;

    public TurnService(List<Player> players, StepService stepService) {
        this.players = players;
        this.currentPlayerIndex = 0; // assuming starting with the first player
        this.stepService = stepService;
    }

    public void startNextTurn() {
        // End the current turn if necessary (cleanup, triggers, etc.)
        endCurrentTurn();

        // Move to the next player
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        Player currentPlayer = players.get(currentPlayerIndex);

        System.out.println("It's now " + currentPlayer.getName() + "'s turn.");

        // Start the first step of the new turn
        stepService.startTurn(currentPlayer);
    }

    private void endCurrentTurn() {
        // Perform any end-of-turn actions here
        System.out.println("Ending the current turn.");
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

}
