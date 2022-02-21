package com.example.monopolyspring.dto;

public class PropertyDTO {
    String propertyName;
    String propertyGroup;
    int price;
    String ownerName;
    int numberOfHouses;
    int numberOfHotels;

    public PropertyDTO(String propertyName, String propertyGroup, int price, String ownerName, int numberOfHouses, int numberOfHotels) {
        this.propertyName = propertyName;
        this.propertyGroup = propertyGroup;
        this.price = price;
        this.ownerName = ownerName;
        this.numberOfHouses = numberOfHouses;
        this.numberOfHotels = numberOfHotels;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getPropertyGroup() {
        return propertyGroup;
    }

    public int getPrice() {
        return price;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getNumberOfHouses() {
        return numberOfHouses;
    }

    public int getNumberOfHotels() {
        return numberOfHotels;
    }
}
