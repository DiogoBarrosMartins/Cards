package com.cards.engine.services;

import com.cards.engine.game.GameService;
import com.cards.engine.game.Player;
import com.cards.engine.turn.Step;

import java.util.EnumMap;

public class StepService {
    private Step currentStep;
    private final TurnService turnService;
    private final GameService gameEngine;
    private EnumMap<Step, Runnable> stepActions;

    public StepService(TurnService turnService, GameService gameEngine) {
        this.turnService = turnService;
        this.gameEngine = gameEngine;
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

    }

    private void handleUpkeepStep() {
        // Handle upkeep triggers and effects
    }

    private void handleDrawStep() {

    }

    private void handleMain1Step() {
    }

    private void handleEndStep() {


    }

    private void handleDefaultStep() {
    }

    private void checkCardActivations() {

    }
}