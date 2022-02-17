package com.example.monopolyspring.service;

import com.example.monopolyspring.dto.PlayerDTO;
import com.example.monopolyspring.model.Board;
import com.example.monopolyspring.model.Dice;
import com.example.monopolyspring.model.Player;
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
        players.add(new Player(playerName, playerTokenName));
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
        return 0;
    }

    /**
     * Returns true if the action was taken successfully, returns false otherwise
     * @param playerName
     * @param action
     * @return true/false
     */
    public boolean takeAction(String playerName, String action){
        //check if playerName is the active player, don't let to take action otherwise

        return true;
    }

}
