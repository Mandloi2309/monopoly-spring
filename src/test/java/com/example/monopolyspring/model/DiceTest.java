package com.example.monopolyspring.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class DiceTest {

    Dice dice = new Dice();

    @Test
    public void given_Dice_when_rollIsCalled_then_correctSumIsReturned(){
        dice.roll();
        Assert.assertEquals(dice.getDie1() + dice.getDie2(), dice.getRolledSum());

    }
}
