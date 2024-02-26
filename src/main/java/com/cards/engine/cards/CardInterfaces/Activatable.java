package com.cards.engine.cards.CardInterfaces;

import com.cards.engine.cards.Ability;
import com.cards.engine.turn.Step;

public interface Activatable {
    boolean activable = false;
    boolean isActivatableOnStep(Step step);
    void activateAbility(Ability ability);
}
