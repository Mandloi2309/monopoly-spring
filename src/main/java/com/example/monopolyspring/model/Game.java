package com.example.monopolyspring.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private Dice dice;

    public Game() {
        this.board = new Board();
        this.players = new ArrayList<>();
        this.dice = new Dice();
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void playGame(){
        boolean isGameFinished = false;

        while(!isGameFinished){

            for(Player player:players){
                //player takes turn if not bankrupt
                if(!player.isBankrupt())
                    takeGameTurn(player);

                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                //check for win condition
                isGameFinished = isAllButOneBankrupt();
            }
        }
        System.out.println("Game ended, winning player: "+getWinner());
    }

    private void takeGameTurn(Player player){

        movePlayerToken(player);
        int newTokenPosition = player.getToken().getBoardPosition();
        Property property = board.getBoardFields().get(newTokenPosition);
        arriveAtProperty(property, player);
    }

    private void movePlayerToken(Player player){
        //roll the dice
        int roll = dice.roll();
        int currentTokenPosition = player.getToken().getBoardPosition();
        //move the token on the board and check if it passed the Go field
        boolean passedGoField = player.getToken().moveToken(roll);
        int newTokenPosition = player.getToken().getBoardPosition();
        System.out.println("Player "+player.getPlayerName()+ " rolled "+roll+ " and moves from "+currentTokenPosition + " to "+newTokenPosition);
        if(passedGoField) {
            player.setPlayerBalance(player.getPlayerBalance() + 200);
            System.out.println("Player "+player.getPlayerName()+ " passed Go, so receives 200. New balance:"+player.getPlayerBalance());
        }
    }

    private void arriveAtProperty(Property property, Player player){

        if(property.getOwner() == null && property.isBuyable()){
            // if player can afford it, buys it
            if(property.getPrice() < player.getPlayerBalance()){
                property.buy(player);
                System.out.println("Player "+player.getPlayerName()+ " buys property, new balance: "+player.getPlayerBalance());
            }

        }
        else if(property.getOwner() != null && !property.getOwner().equals(player)){
            Player propertyOwner = property.getOwner();
            int rent = property.getPayableRent();
            if(player.isAbleToPay(rent)){
                player.setPlayerBalance(player.getPlayerBalance() - rent);
                propertyOwner.setPlayerBalance(propertyOwner.getPlayerBalance() + rent);
                System.out.println("Player "+player.getPlayerName()+ " pays "+rent+" rent to "+propertyOwner.getPlayerName());
            }
            else{
                player.setBankrupt(true);
                System.out.println("Player "+player.getPlayerName()+ " can't afford to pay, so bankrupt. ");
            }

        }
        else{
            System.out.println("Nothing happens.");
        }
    }


    private boolean isAllButOneBankrupt(){
        int numOfBankruptPlayers = 0;
        for(Player p:players){
            if(p.isBankrupt()) numOfBankruptPlayers++;
        }
        return numOfBankruptPlayers == players.size()-1;
    }


    private Player getWinner(){
        for(Player p:players){
            if(!p.isBankrupt()) return p;
        }
        return null;
    }
}
