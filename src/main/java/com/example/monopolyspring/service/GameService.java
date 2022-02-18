package com.example.monopolyspring.service;

import com.example.monopolyspring.dto.PlayerDTO;
import com.example.monopolyspring.model.Board;
import com.example.monopolyspring.model.Dice;
import com.example.monopolyspring.model.Player;
import com.example.monopolyspring.model.Property;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {


    private Board board;
    private List<Player> players;
    private Dice dice;
    private boolean isGameStarted;
    private int activePlayerIndex;

    public GameService() {
        this.board = new Board();
        this.players = new ArrayList<>();
        this.dice = new Dice();
        this.isGameStarted = false;
        this.activePlayerIndex = 0;
    }

    public List<PlayerDTO> addPlayer(String playerName, String playerTokenName){
        if (isGameStarted) return getPlayerListDTO();
        if (players.contains(new Player(playerName, playerTokenName))){
            //List<String> arr = new ArrayList<String>(1);
            //arr.add("Failed to add the player, try a different name/token");
            //return arr;
        }
        else {
            players.add(new Player(playerName, playerTokenName));
        }
        return getPlayerListDTO();
    }

    public boolean startGame(){
        if(players.size() < 2) return false;
        isGameStarted = true;
        return isGameStarted;
    }

    public List<PlayerDTO> getPlayerListDTO(){
        List<PlayerDTO> dto = new ArrayList<>();
        for(Player p : players){
            dto.add(new PlayerDTO(p.getPlayerName(), p.getToken().getShape(), p.getPlayerBalance(), p.getToken().getBoardPosition()));
        }
        return dto;
    }

    public boolean isGameStarted() {
        return isGameStarted;
    }


    public int finishTurn(){
        //update the activePlayerIndex to the next player, make sure no overflow
        if (activePlayerIndex >= players.size()) {
            activePlayerIndex = 0;
        }else{
            activePlayerIndex += 1;
        }
        return activePlayerIndex;
    }

    /**
     * Returns true if the action was taken successfully, returns false otherwise
     * @param playerName
     * @param action
     * @return true/false
     */
    public boolean takeAction(String playerName, String action){
        //check if playerName is the active player, don't let to take action otherwise
        Player activePlayer = players.get(activePlayerIndex);
        if (playerName == activePlayer.getPlayerName()){
            if(action == "move"){
                moveToken(activePlayer);
                Property property = board.getBoardFields().get(activePlayer.getToken().getBoardPosition());
                if (property.getOwner() != null && !property.getOwner().equals(activePlayer)){
                    boolean rentPaid = payRent(property, activePlayer);
                }
                return true;
            }
            else if (action == "buy"){
                int currentTokenPosition = activePlayer.getToken().getBoardPosition();
                Property property = board.getBoardFields().get(currentTokenPosition);
                if(property.getOwner() == null && property.isBuyable()){
                    if(property.getPrice() < activePlayer.getPlayerBalance()){
                        property.buy(activePlayer);
                        return true;
                    }
                }
            }

        }
        return false;
    }

    private void moveToken(Player activePlayer){
        int roll = dice.roll();
        boolean passedGoField = activePlayer.getToken().moveToken(roll);
        if(passedGoField) {
            activePlayer.setPlayerBalance(activePlayer.getPlayerBalance() + 200);
        }
    }
    private boolean payRent(Property property, Player activePlayer){
        Player propertyOwner = property.getOwner();
        int rent = property.getPayableRent();
        if(activePlayer.isAbleToPay(rent)){
            activePlayer.setPlayerBalance(activePlayer.getPlayerBalance() - rent);
            propertyOwner.setPlayerBalance(propertyOwner.getPlayerBalance() + rent);
            return true;
        }
        activePlayer.setBankrupt(true);
        return false;
    }
    // Function which can return a list of all players and their positions on the board.
    public String boardPositions(){
        return "Board positions";
    }

}
