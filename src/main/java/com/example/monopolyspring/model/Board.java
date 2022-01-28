package com.example.monopolyspring.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Property> boardFields;

    public Board() {
        this.boardFields = new ArrayList<>();
        initBoard();
    }

    private void initBoard(){
        // Create fields: Color, Street name, and price
        String[] streetNames = new String[]{"Old Kent road", "Community chest", "Whitechapel road"};
        String[] colors = new String[]{"Brown", "", "Brown"};
        int[] cost = new int[]{60, 0, 60};

        for (int i=0; i<streetNames.length; i++) {
            Property p = new Property(streetNames[i], colors[i], cost[i]);
            boardFields.add(p);
        }
    }

    public List<Property> getBoardFields() {
        return boardFields;
    }

    public void setBoardFields(List<Property> boardFields) {
        this.boardFields = boardFields;
    }
}
