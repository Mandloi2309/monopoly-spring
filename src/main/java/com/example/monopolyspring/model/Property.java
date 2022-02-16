package com.example.monopolyspring.model;

public class Property {
    private String streetName;
    private String grouping;
    private int price;
    private int rent;
    private boolean purchasable;
    private boolean canBuildOn;
    private boolean isMortgaged;

    private Player owner;

    private int numberOfHouses;
    private int numberOfHotels;

    public Property(String streetName, String grouping, int price, int rent, boolean purchasable, boolean canBuildOn) {
        this.streetName = streetName;
        this.grouping = grouping;
        this.price = price;
        this.rent = rent;
        this.purchasable = purchasable;
        this.canBuildOn = canBuildOn;
        this.owner = null;
        this.numberOfHotels = 0;
        this.numberOfHouses = 0;
        this.isMortgaged = false;
    }


    public boolean isBuyable(){
        return purchasable && owner==null;
    }

    public int getHouseCost(){
        if(price < 140) {
            return 50;
        }
        else if(price < 220){
            return 100;
        }
        else if(price < 300){
            return 150;
        }
        else return 200;
    }

    public int getPayableRent(){
        if(numberOfHouses == 0) {
            return rent;
        }
        else if(numberOfHotels == 1){
            return 75*rent;
        }
        else if(numberOfHouses == 1){
            return 5*rent;
        }
        else if(numberOfHouses == 2){
            return 15*rent;
        }
        else if(numberOfHouses == 3){
            return 45*rent;
        }
        else return 55*rent;
    }

    public boolean buy(Player player){
        if(this.owner == player) return false;

        if(player.getPlayerBalance() > price){
            player.setPlayerBalance(player.getPlayerBalance() - price);
            this.owner = player;
            player.addOwnedProperty(this);
            return true;
        }
        return false;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
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

    public boolean isPurchasable() {
        return purchasable;
    }

    public void setPurchasable(boolean purchasable) {
        this.purchasable = purchasable;
    }

    public boolean isCanBuildOn() {
        return canBuildOn;
    }

    public void setCanBuildOn(boolean canBuildOn) {
        this.canBuildOn = canBuildOn;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public boolean isMortgaged() {
        return isMortgaged;
    }

    public void setMortgaged(boolean mortgaged) {
        isMortgaged = mortgaged;
    }

    @Override
    public String toString() {
        return "{" +
                "streetName='" + streetName + '\'' +
                ", color='" + grouping + '\'' +
                ", price=" + price +
//                ", purchasable=" + purchasable +
//                ", numberOfHouses=" + numberOfHouses +
//                ", numberOfHotels=" + numberOfHotels +
                '}';
    }
}
