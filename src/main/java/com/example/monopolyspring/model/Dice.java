package com.example.monopolyspring.model;

public class Dice {
    int die1;
    int die2;

    public Dice() {
    }

    public int roll(){
        int min = 1;
        int max = 6;
        die1 = (int)Math.floor(Math.random()*(max-min+1)+min);
        die2 = (int)Math.floor(Math.random()*(max-min+1)+min);
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
