package com.cards.engine.turn;

public enum Step {
    UNTAP("Untap"),
    UPKEEP("Upkeep"),
    DRAW("Draw"),
    MAIN1("Main Phase 1"),
    BEGIN_COMBAT("Begin Combat"),
    DECLARE_ATTACKERS("Declare Attackers"),
    DECLARE_BLOCKERS("Declare Blockers"),
    COMBAT_DAMAGE("Combat Damage"),
    END_COMBAT("End Combat"),
    MAIN2("Main Phase 2"),
    END_STEP("End Step"),
    CLEANUP("Cleanup");

    private final String name;

    Step(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Step next() {
        // Returns the next step, wrapping back to the first step after the last
        int nextOrdinal = (this.ordinal() + 1) % Step.values().length;
        return Step.values()[nextOrdinal];
    }

    @Override
    public String toString() {
        return name;
    }
}
