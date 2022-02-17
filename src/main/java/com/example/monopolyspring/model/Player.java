package com.example.monopolyspring.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerName;
    private Token token;
    private int playerBalance;
    private List<Property> ownedProperties;
    private boolean isBankrupt;

    public Player(String playerName, String token) {
        this.playerName = playerName;
        this.token = new Token(token);
        this.playerBalance = 500;
        this.ownedProperties = new ArrayList<>();
        this.isBankrupt = false;
    }

    public void addOwnedProperty(Property p){
        this.ownedProperties.add(p);
    }

    public boolean isAbleToPay(int owedMoney){
        return (owedMoney < playerBalance ? true : false);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public int getPlayerBalance() {
        return playerBalance;
    }

    public void setPlayerBalance(int playerBalance) {
        this.playerBalance = playerBalance;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public List<Property> getOwnedProperties() {return ownedProperties;}

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", token=" + token +
                ", playerBalance=" + playerBalance +
                ", ownedProperties=" + ownedProperties +
                ", isBankrupt=" + isBankrupt +
                '}';
    }
}
