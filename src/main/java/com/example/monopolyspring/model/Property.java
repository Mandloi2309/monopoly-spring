package com.example.monopolyspring.model;

public class Property {
    private String streetName;
    private String color;
    private Player owner;

    private int price;
    private int numberOfHouses;
    private int numberOfHotels;

    public Property(String streetName, String color, int price) {
        this.streetName = streetName;
        this.color = color;
        this.price = price;
        this.owner = null;
        this.numberOfHotels = 0;
        this.numberOfHouses = 0;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberOfHouses() {
        return numberOfHouses;
    }

    public void setNumberOfHouses(int numberOfHouses) {
        this.numberOfHouses = numberOfHouses;
    }

    public int getNumberOfHotels() {
        return numberOfHotels;
    }

    public void setNumberOfHotels(int numberOfHotels) {
        this.numberOfHotels = numberOfHotels;
    }
}
