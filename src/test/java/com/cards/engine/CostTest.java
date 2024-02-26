package com.cards.engine;

import com.cards.engine.resources.Cost;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CostTest {


    @Test
    public void testGetTotalCost() {
        Cost cost = new Cost(1, 2, 3, 4, 5, 6);
        int expectedTotal = 1 + 2 + 3 + 4 + 5 + 6;
        Assertions.assertEquals(expectedTotal, cost.getTotalCost(), "Total cost should be the sum of all costs.");
    }

    @Test
    public void testIsCostMetExact() {
        Cost cost = new Cost(1, 1, 1, 1, 1, 1);
        boolean result = cost.isCostMet(0, 1, 1, 1, 1, 1, 1);
        Assertions.assertTrue(result, "Cost should be met exactly by the available resources.");
    }

    @Test
    public void testIsCostMetExcess() {
        Cost cost = new Cost(1, 1, 1, 1, 1, 1);
        boolean result = cost.isCostMet(5, 2, 2, 2, 2, 2, 2);
        Assertions.assertTrue(result, "Cost should be met with excess resources available.");
    }

    @Test
    public void testIsCostNotMet() {
        Cost cost = new Cost(2, 2, 2, 2, 2, 2);
        boolean result = cost.isCostMet(1, 1, 1, 1, 1, 1, 1);
        Assertions.assertFalse(result, "Cost should not be met due to insufficient resources.");
    }

    @Test
    public void testIsCostMetWithGenericOnly() {
        Cost cost = new Cost(0, 0, 0, 0, 0, 5); // Requires only 5 generic resources
        boolean result = cost.isCostMet(5, 0, 0, 0, 0, 0, 0);
        Assertions.assertTrue(result, "Cost should be met with generic resources only.");
    }

    @Test
    public void testIsCostNotMetWithInsufficientGeneric() {
        Cost cost = new Cost(0, 0, 0, 0, 0, 10); // Requires 10 generic resources
        boolean result = cost.isCostMet(5, 0, 0, 0, 0, 0, 0);
        Assertions.assertFalse(result, "Cost should not be met due to insufficient generic resources.");
    }

    @Test
    public void testIsCostMetWithExactColorAndGenericMix() {
        Cost cost = new Cost(1, 1, 1, 1, 1, 1); // Requires 1 of each color and 1 generic
        boolean result = cost.isCostMet(1, 1, 1, 1, 1, 1, 1);
        Assertions.assertTrue(result, "Cost should be met with an exact mix of color and generic resources.");
    }

    @Test
    public void testIsCostNotMetWithMissingOneColor() {
        Cost cost = new Cost(1, 1, 1, 1, 1, 0); // Requires 1 of each color except colorless
        boolean result = cost.isCostMet(0, 1, 1, 1, 1, 0, 0);
        Assertions.assertFalse(result, "Cost should not be met due to missing one color.");
    }

    @Test
    public void testMultiColorCardCostMet() {
        Cost cost = new Cost(2, 2, 0, 0, 0, 3); // Multi-color card requiring 2 white, 2 blue, and 3 generic
        boolean result = cost.isCostMet(3, 2, 2, 0, 0, 0, 0);
        Assertions.assertTrue(result, "Cost should be met for a multi-color card.");
    }

    @Test
    public void testMultiColorCardCostNotMet() {
        Cost cost = new Cost(2, 2, 0, 0, 0, 3); // Multi-color card requiring 2 white, 2 blue, and 3 generic
        boolean result = cost.isCostMet(2, 1, 1, 0, 0, 0, 0); // Insufficient white and blue
        Assertions.assertFalse(result, "Cost should not be met due to insufficient specific colors.");
    }

}