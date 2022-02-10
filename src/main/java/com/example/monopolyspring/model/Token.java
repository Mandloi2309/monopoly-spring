package com.example.monopolyspring.model;

public class Token {
    private String shape;
    private int boardPosition;

    public Token(String shape) {
        this.shape = shape;
        this.boardPosition = 0;
    }

    public boolean moveToken(int steps){
        if(boardPosition + steps <=39){
            boardPosition += steps;
            return false;
        }
        else{
            boardPosition = boardPosition + steps - 40;
            return true;
        }
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public int getBoardPosition() {
        return boardPosition;
    }

}
