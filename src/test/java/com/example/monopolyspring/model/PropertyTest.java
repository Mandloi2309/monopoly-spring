package com.example.monopolyspring.model;

import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PropertyTest {
    Property property = new Property("Vermont Avenue", "Light Blue", 100, 6,true, true);
    Player player1 = new Player("Player 1", "Ship");
    Player player2 = new Player("Player 2", "Car");

    @Test
    public void given_Board_when_gameOn_then_checkPropertyInitialisation(){
        Assert.assertEquals(100 , property.getPrice());
        Assert.assertEquals(null, property.getOwner());
        Assert.assertEquals("Light Blue", property.getGrouping());
        Assert.assertEquals(6, property.getRent());
        Assert.assertEquals(6, property.getPayableRent());
        Assert.assertEquals("Vermont Avenue", property.getStreetName());
        Assert.assertEquals(0, property.getNumberOfHouses());
        Assert.assertEquals(0, property.getNumberOfHotels());
        Assert.assertEquals(true, property.isBuyable());
        Assert.assertEquals(false, property.isMortgaged());
        Assert.assertEquals(true, property.isCanBuildOn());
        Assert.assertEquals(true, property.isPurchasable());
    }

    @Test
    public void given_Property_when_bought_then_changeOwner(){
        Assert.assertEquals(true, property.buy(player1));
        Assert.assertEquals(player1, property.getOwner());
        System.out.println(property.getOwner());
        Assert.assertEquals(false, property.buy(player1));
        Assert.assertEquals(false, property.buy(player2));
    }

    @Test
    public void given_propertyOwned_when_houseBuilt_then_checkRent(){
        property.setNumberOfHouses(1);
        Assert.assertEquals(1, property.getNumberOfHouses());
        Assert.assertEquals(6*5, property.getPayableRent());

        property.setNumberOfHouses(2);
        Assert.assertEquals(2, property.getNumberOfHouses());
        Assert.assertEquals(6*15, property.getPayableRent());

        property.setNumberOfHouses(3);
        Assert.assertEquals(3, property.getNumberOfHouses());
        Assert.assertEquals(6*45, property.getPayableRent());

        property.setNumberOfHouses(4);
        Assert.assertEquals(4, property.getNumberOfHouses());
        Assert.assertEquals(6*55, property.getPayableRent());

    }

    @Test
    public void given_propertyOwned_when_hotelBuilt_then_checkRent(){
        property.setNumberOfHotels(1);
        Assert.assertEquals(1, property.getNumberOfHotels());
        Assert.assertEquals(6*75, property.getPayableRent());
    }
}
