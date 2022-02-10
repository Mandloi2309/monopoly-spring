package com.example.monopolyspring;


import com.example.monopolyspring.model.Game;
import com.example.monopolyspring.model.Player;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MonopolyCli implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        Game game = new Game();
        game.addPlayer(new Player("Player1", "Horse"));
        game.addPlayer(new Player("Player2", "Ship"));
        //game.playGame();

    }
}
