package com.example.monopolyspring.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TokenTest {
    Token token = new Token("Ship");
    @Test
    public void given_Player_when_Initialised_then_checkTokenAttributes(){
        Assert.assertEquals("Ship", token.getShape());
        token.setShape("Horse");
        Assert.assertEquals("Horse", token.getShape());
        Assert.assertEquals(0, token.getBoardPosition());
    }
    @Test
    public void given_gameOn_when_tokenMove_then_moveTokenToNewPosition(){
        Assert.assertEquals(false, token.moveToken(5));
        Assert.assertEquals(5, token.getBoardPosition());
        Assert.assertEquals(true, token.moveToken(45));
    }
}
