package com.example.monopolyspring.controller;

import com.example.monopolyspring.dto.DiceDTO;
import com.example.monopolyspring.dto.PlayerDTO;
import com.example.monopolyspring.model.Dice;
import com.example.monopolyspring.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {

    GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/addPlayer")
    public List<PlayerDTO> addNewPlayer(@RequestParam(value="name") String name, @RequestParam(value="token") String token){
        return gameService.addPlayer(name, token);
    }

    @GetMapping("/listPlayers")
    public List<PlayerDTO> listPlayers(){
        return gameService.getPlayerListDTO();
    }

    @GetMapping("/startGame")
    public boolean startGame(){
        return gameService.startGame();
    }

    @GetMapping("/isGameStarted")
    public String getIsGameStarted(){
        boolean isGameStarted = gameService.isGameStarted();
        if(isGameStarted) return "Game Started";
        return "Game not Started";
    }
    @GetMapping("/performAction")
    public String performAction(@RequestParam(value="name") String name, @RequestParam(value="action") String action){
        boolean isGameStarted = gameService.isGameStarted();
        if(isGameStarted) gameService.takeAction(name, action);
        return "Game not Started";
    }


}
