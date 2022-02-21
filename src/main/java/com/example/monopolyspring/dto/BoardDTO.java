package com.example.monopolyspring.dto;

import java.util.ArrayList;
import java.util.List;

public class BoardDTO {
    List<PropertyDTO> boardFields= new ArrayList<>();
    List<PlayerDTO> players = new ArrayList<>();

    public BoardDTO(List<PropertyDTO> boardFields, List<PlayerDTO> players) {
        this.boardFields = boardFields;
        this.players = players;
    }

    public List<PropertyDTO> getBoardFields() {
        return boardFields;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }
}
