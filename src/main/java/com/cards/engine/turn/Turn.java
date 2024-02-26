package com.cards.engine.turn;


import com.cards.engine.resources.Colour;

public class Turn {
        private ManaPool manaPool;
        private Step currentStep;

        public Turn() {
            // Assuming ManaPool's constructor without parameters initializes all mana types to 0
            this.manaPool = new ManaPool();
            this.currentStep = Step.UNTAP;
        }

        public ManaPool getManaPool() {
            return manaPool;
        }

        public Step getCurrentStep() {
            return currentStep;
        }

        public void setCurrentStep(Step currentStep) {
            this.currentStep = currentStep;
        }

        // Resets the mana pool at the beginning of the turn or whenever appropriate
        public void resetManaPool() {
            this.manaPool.reset();
        }

        // Example method to add mana of a specific type and amount
        public void addMana(Colour type, int amount) {
            this.manaPool.addMana(type, amount);
        }



        public void setManaPool(ManaPool manaPool) {
            this.manaPool = manaPool;
        }

        // Additional methods as needed for turn management...
    }
