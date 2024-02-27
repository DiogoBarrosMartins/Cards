package com.cards.engine.services;

import com.cards.engine.game.GameService;
import com.cards.engine.game.Player;
import com.cards.engine.turn.Step;

import java.util.EnumMap;

public class StepService {
    private Step currentStep;
    private final TurnService turnService;
    private final GameService gameEngine; // Assuming a central game engine class exists
    private EnumMap<Step, Runnable> stepActions;

    public StepService(TurnService turnService, GameService gameEngine) {
        this.turnService = turnService;
        this.gameEngine = gameEngine;
        this.currentStep = Step.UNTAP;
        initializeStepActions();
    }
    private void initializeStepActions() {
        stepActions = new EnumMap<>(Step.class);
        stepActions.put(Step.UNTAP, this::handleUntapStep);
        stepActions.put(Step.UPKEEP, this::handleUpkeepStep);
        stepActions.put(Step.DRAW, this::handleDrawStep);
        stepActions.put(Step.MAIN1, this::handleMain1Step);
        // Add other steps as necessary
        stepActions.put(Step.END_STEP, this::handleEndStep);
    }

    public void startTurn(Player player) {
        currentStep = Step.UNTAP;
        proceedToNextStep();
    }

    public void proceedToNextStep() {
        // Transition logic for moving to the next step
        currentStep = currentStep.next();
        System.out.println("Transitioning to " + currentStep + " step.");

        // Execute the specific actions for the current step
        stepActions.getOrDefault(currentStep, this::handleDefaultStep).run();

        // After step-specific actions, perform common checks
        checkCardActivations();
    }

    private void handleUntapStep() {
        // Example: Untap all tapped cards for the current player
        Player currentPlayer = turnService.getCurrentPlayer();
        gameEngine.untapAllCards(currentPlayer);

    }

    private void handleUpkeepStep() {
        // Handle upkeep triggers and effects
    }

    private void handleDrawStep() {
        // Current player draws a card
        Player currentPlayer = turnService.getCurrentPlayer();
        gameEngine.drawCard(currentPlayer);
    }

    private void handleMain1Step() {
        // Main phase actions, such as playing lands, casting spells, etc.
    }

    private void handleEndStep() {
        // Cleanup, end-of-turn triggers, etc.
        // Optionally, clear mana pool at the end of the turn if rules require

    }

    private void handleDefaultStep() {
        // Default action if a step doesn't have specific actions defined
    }

    private void checkCardActivations() {
        // Iterate over all cards in all zones to check for activations

    }
}