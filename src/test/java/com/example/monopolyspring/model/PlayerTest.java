package com.example.monopolyspring.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    Player player1 = new Player("Player 1", "Ship");
    Property property = new Property("Mediterranean Avenue", "Purple", 60, 2,true, true);
    Token horse = new Token("Horse");

    @Test
    public void given_Player_when_Initialised_then_showPlayerAttributes() {
        Assert.assertEquals("Player 1", player1.getPlayerName());
        Assert.assertEquals(500, player1.getPlayerBalance());
        Assert.assertEquals("Ship", player1.getToken().getShape());
    }

    @Test void given_Player_when_Initialised_then_updatePlayerAttributes(){
            player1.setPlayerName("Alpha");
            Assert.assertEquals("Alpha",player1.getPlayerName());
            player1.setToken(horse);
            Assert.assertEquals("Horse", player1.getToken().getShape());
    }

    @Test
    public void given_Player_when_boughtProperty_then_showPropertyAndUpdateBalance(){
        player1.addOwnedProperty(property);
        player1.setPlayerBalance(player1.getPlayerBalance() - property.getPrice());
        Assert.assertEquals(440, player1.getPlayerBalance());
        Assert.assertEquals( "Mediterranean Avenue", player1.getOwnedProperties().get(0).getStreetName());
    }

    @Test
    public void given_Player_when_boughtProperty_then_checkBankruptcy(){
        Assert.assertEquals(false, player1.isBankrupt());
        player1.setBankrupt(true);
        Assert.assertEquals(true, player1.isBankrupt());
    }
    @Test
    public void given_Player_when_buyProperty_then_checkIfAffordable(){
        Assert.assertEquals(true, player1.isAbleToPay(100));
        player1.setPlayerBalance(0);
        Assert.assertEquals(0, player1.getPlayerBalance());
        Assert.assertEquals(false, player1.isAbleToPay(100));
    }
}