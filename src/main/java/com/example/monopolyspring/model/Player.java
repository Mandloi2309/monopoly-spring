package com.example.monopolyspring.model;

public class Player {
    private String playerName;
    private Token token;
    private int playerBalance;

    public Player(String playerName, String token) {
        this.playerName = playerName;
        this.token = new Token(token);
        this.playerBalance = 1500;
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

    // TO DO (): Two strats to play against each other
    //
}
