package com.example.monopolyspring.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private List<Property> boardFields;
    private Map<String, List<Property>> boardGroups;

    public Board() {
        this.boardFields = new ArrayList<>();
        this.boardGroups = new HashMap<>();
        initBoard();
    }

    private void initBoard(){
        addPropertiesToBoard();
        createBoardGroups();
    }

    private void createBoardGroups(){
        for(Property p:boardFields){
            addPropertyToGroup(p);
        }
    }

    private void addPropertyToGroup(Property property){
        if(!boardGroups.containsKey(property.getGrouping())){
            boardGroups.put(property.getGrouping(), new ArrayList<>());
        }
        boardGroups.get(property.getGrouping()).add(property);
    }

    private void addPropertiesToBoard(){
        boardFields.add(new Property("Start", "", 0, 0,false, false));
        boardFields.add(new Property("Mediterranean Avenue", "Purple", 60, 2,true, true));
        boardFields.add(new Property("Community Chest", "", 0, 0,false, false));
        boardFields.add(new Property("Baltic Avenue", "Purple", 60,4, true, true));
        boardFields.add(new Property("Income Tax", "", 0, 0,false, false));
        boardFields.add(new Property("Reading Railroad", "Rail", 200, 0,true, false));
        boardFields.add(new Property("Oriental Avenue", "Light Blue", 100, 6,true, false));
        boardFields.add(new Property("Chance", "", 0, 0,false, false));
        boardFields.add(new Property("Vermont Avenue", "Light Blue", 100, 6,true, true));
        boardFields.add(new Property("Connecticut Avenue", "Light Blue", 120, 8,true, true));
        boardFields.add(new Property("Jail", "", 0, 0,false, false));
        boardFields.add(new Property("St. Charles Place", "Pink", 140, 10, true, true));
        boardFields.add(new Property("Electric Company", "Service", 150, 0,true, false));
        boardFields.add(new Property("States Avenue", "Pink", 140, 10,true, true));
        boardFields.add(new Property("Virginia Avenue", "Pink", 160, 12, true, true));
        boardFields.add(new Property("Pensylvania Railroad", "Rail", 200, 0,true, false));
        boardFields.add(new Property("St. James Place", "Orange", 180, 14,true, true));
        boardFields.add(new Property("Community Chest", "", 0, 0,false, false));
        boardFields.add(new Property("Tennessee Avenue", "Orange", 180, 14,true, true));
        boardFields.add(new Property("New York Avenue", "Orange", 200, 16,true, true));
        boardFields.add(new Property("Free Parking", "", 0, 0,false, false));
        boardFields.add(new Property("Kentucky Avenue", "Red", 220,18, true, true));
        boardFields.add(new Property("Chance", "", 0, 0,false, false));
        boardFields.add(new Property("Indiana Avenue", "Red", 220, 18,true, true));
        boardFields.add(new Property("Illinois Avenue", "Red", 240, 20,true, true));
        boardFields.add(new Property("BO Railroad", "Rail", 200, 0, true, false));
        boardFields.add(new Property("Atlantic Avenue", "Yellow", 260, 22,true, true));
        boardFields.add(new Property("Ventnor Avenue", "Yellow", 260, 22,true, true));
        boardFields.add(new Property("Water Works", "Service", 150, 0,true, false));
        boardFields.add(new Property("Marvin Gardens", "Yellow", 280, 24,true, true));
        boardFields.add(new Property("Go to Jail", "", 0, 0,false, false));
        boardFields.add(new Property("Pacific Avenue", "Green", 300, 26, true, true));
        boardFields.add(new Property("North Carolina Avenue", "Green", 300, 26, true, true));
        boardFields.add(new Property("Community Chest", "", 0, 0, false, false));
        boardFields.add(new Property("Pensylvania Avenue", "Green", 320, 28,true, true));
        boardFields.add(new Property("Short Line", "Rail", 200, 0,true, false));
        boardFields.add(new Property("Chance", "", 0, 0,false, false));
        boardFields.add(new Property("Park Place", "Blue", 350, 35,true, true));
        boardFields.add(new Property("Luxury Tax", "", 0, 0,false, false));
        boardFields.add(new Property("Boardwalk", "", 400, 50,true, true));
    }

    public List<Property> getBoardFields() {
        return boardFields;
    }

    public void setBoardFields(List<Property> boardFields) {
        this.boardFields = boardFields;
    }

    public void printBoard(){
        for(Property p:boardFields){
            System.out.println(p);
        }
        System.out.println("Board size:"+boardFields.size());
    }
}
