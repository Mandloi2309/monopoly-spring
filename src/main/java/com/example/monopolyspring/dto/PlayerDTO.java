package com.example.monopolyspring.dto;

public class PlayerDTO {

    private String playerName;
    private String playerToken;
    private int playerBalance;
    private int tokenPosition;

    public PlayerDTO(String playerName, String playerToken, int playerBalance, int tokenPosition) {
        this.playerName = playerName;
        this.playerToken = playerToken;
        this.playerBalance = playerBalance;
        this.tokenPosition = tokenPosition;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerToken() {
        return playerToken;
    }

    public void setPlayerToken(String playerToken) {
        this.playerToken = playerToken;
    }

    public int getPlayerBalance() {
        return playerBalance;
    }

    public void setPlayerBalance(int playerBalance) {
        this.playerBalance = playerBalance;
    }

    public int getTokenPosition() {
        return tokenPosition;
    }

    public void setTokenPosition(int tokenPosition) {
        this.tokenPosition = tokenPosition;
    }
}
