package com.example.monopolyspring.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class DiceTest {

    Dice dice = new Dice();

    @Test
    public void given_Dice_when_rollIsCalled_then_correctSumIsReturned(){
        dice.roll();
        Assert.assertEquals(dice.getDie1() + dice.getDie2(), dice.getRolledSum());
        dice.setDie1(2);
        dice.setDie2(3);
        Assert.assertEquals(5, dice.getRolledSum());
    }


    @Test
    public void given_Dice_when_twoIdenticalDiceValuesAreSet_then_getIsSameValueOnBothDieReturnsCorrect(){
        dice.setDie1(1);
        dice.setDie2(2);
        Assert.assertEquals(false, dice.getIsSameValueOnBothDie());
        dice.setDie1(2);
        dice.setDie2(2);
        Assert.assertEquals(true, dice.getIsSameValueOnBothDie());
    }
}
