package com.example.monopolyspring.dto;

public class DiceDTO {

    private int num1;
    private int num2;
    private int sum;

    public DiceDTO(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.sum = num1 + num2;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int getSum() {
        return sum;
    }
}
