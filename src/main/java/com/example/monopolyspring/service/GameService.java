package com.example.monopolyspring.service;

import com.example.monopolyspring.dto.BoardDTO;
import com.example.monopolyspring.dto.PlayerDTO;
import com.example.monopolyspring.dto.PropertyDTO;
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
    private boolean hasActivePlayerMoved;

    public GameService() {
        this.board = new Board();
        this.players = new ArrayList<>();
        this.dice = new Dice();
        this.isGameStarted = false;
        this.activePlayerIndex = 0;
        this.hasActivePlayerMoved = false;
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


    public boolean finishTurn(){
        //update the activePlayerIndex to the next player, make sure no overflow
        if (activePlayerIndex >= players.size()) {
            activePlayerIndex = 0;
        }else{
            activePlayerIndex += 1;
        }
        hasActivePlayerMoved = false;
        return true;
    }

    public boolean checkPlayerCanAct(String playerName){
    // check if player exists, active player and not bankrupt
        Player activePlayer = players.get(activePlayerIndex);
        if(activePlayer != null){
            if(playerName.equals(activePlayer.getPlayerName())){
                if(!activePlayer.isBankrupt()){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean movePlayerToken(String playerName) {
        if (!checkPlayerCanAct(playerName)) return  false;
        if (hasActivePlayerMoved) return false;
        Player activePlayer = players.get(activePlayerIndex);
        moveToken(activePlayer);
        Property property = board.getBoardFields().get(activePlayer.getToken().getBoardPosition());
        if (property.getOwner() != null && !property.getOwner().equals(activePlayer)) {
            boolean rentPaid = payRent(property, activePlayer);
        }
        return true;
    }
    private void moveToken(Player activePlayer){
        int roll = dice.roll();
        boolean passedGoField = activePlayer.getToken().moveToken(roll);
        if(passedGoField) {
            activePlayer.setPlayerBalance(activePlayer.getPlayerBalance() + 200);
        }
        hasActivePlayerMoved = true;
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

    /**
     * Returns true if the action was taken successfully, returns false otherwise
     * @param playerName
     * @param action
     * @return true/false
     */
    // Build property rules: can you build a house, should own all prop in group, House difference should be of 1

    public boolean takeAction(String playerName, String action){
        //check if playerName is the active player, don't let to take action otherwise
        Player activePlayer = players.get(activePlayerIndex);
        if (playerName == activePlayer.getPlayerName()){
            int currentTokenPosition = activePlayer.getToken().getBoardPosition();
            Property property = board.getBoardFields().get(currentTokenPosition);
            if (action.equals("buy")){
                if(property.getOwner() == null && property.isBuyable()){
                    if(property.getPrice() < activePlayer.getPlayerBalance()){
                        property.buy(activePlayer);
                        return true;
                    }
                }
            }
            if(action.equals("build") && canBuildHouse(activePlayer, property)){

                buildHouseOnProperty(activePlayer, property);
            }
            //action: mortgage/demortgage
            //          sell houses
            //          sell it to bank (lower price)
        }
        return false;
    }
    // method to calculate price for mortgage/selling (75%bank).

    //Refactor removing hotels to 5 houses. Property object: remove hotels

    private void buildHouseOnProperty(Player player, Property property){
        property.setNumberOfHouses(property.getNumberOfHouses()+1);
        player.setPlayerBalance(player.getPlayerBalance()-property.getHouseCost());
    }

    public boolean canBuildHouse(Player player, Property property){
         return  property.getOwner()!=null && property.getOwner().equals(player) && canPlayerAffordToBuildHouseOnProperty(player, property)
                && isPlayerOwnerOfTheGroup(player, property) && property.isCanBuildOn() && canOneHouseBeBuiltOnProperty(property);
    }
    private boolean canPlayerAffordToBuildHouseOnProperty(Player player, Property property){
        return player.getPlayerBalance() > property.getHouseCost();
    }
    private boolean canOneHouseBeBuiltOnProperty(Property property){
        String groups = property.getGrouping();
        if(property.getNumberOfHouses() == 5) return false;
        for (Property p: board.getPropertiesByGroup(groups)){
            int difference = property.getNumberOfHouses() + 1 - p.getNumberOfHouses();
            if(Math.abs(difference) > 1 ) return false;
        }
        return true;
    }
    private boolean isPlayerOwnerOfTheGroup(Player player, Property property){
        String groups = property.getGrouping();
        for (Property p: board.getPropertiesByGroup(groups)){
            if(p.getOwner()== null || !p.getOwner().equals(player)) return false;
        }
        return true;
    }


    public BoardDTO getBoardDTO(){
        List<PropertyDTO> properties = getPropertyListDTO();
        List<PlayerDTO> players = getPlayerListDTO();
        return new BoardDTO(properties, players);
    }

    public List<PropertyDTO> getPropertyListDTO(){
        List<PropertyDTO> properties = new ArrayList<>();
        for(Property p: board.getBoardFields()){
            //check if no owner, then show no owner instead of null. Implement null checks
            String owner = "";
            if(p.getOwner() != null) owner = p.getOwner().getPlayerName();
            properties.add(new PropertyDTO(p.getStreetName(), p.getGrouping(), p.getPrice(), owner, p.getNumberOfHouses()));
        }
        return properties;
    }

}
