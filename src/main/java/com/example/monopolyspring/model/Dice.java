package com.example.monopolyspring.model;

import java.util.Random;

public class Dice {
    int die1;
    int die2;
    Random random = new Random();
    public Dice() {
    }

    public int roll(){
        int max = 5;
        die1 = random.nextInt(max)+1;
        die2 = random.nextInt(max)+1;
        return getRolledSum();
    }

    public int getRolledSum(){
        return die1+die2;
    }

    public boolean getIsSameValueOnBothDie(){
        return die1 == die2;
    }

    public int getDie1() {
        return die1;
    }

    public void setDie1(int die1) {
        this.die1 = die1;
    }

    public int getDie2() {
        return die2;
    }

    public void setDie2(int die2) {
        this.die2 = die2;
    }
}
