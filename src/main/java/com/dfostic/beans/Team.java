package com.dfostic.beans;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

/**
 * @author DFostic1
 */

@Component
public class Team {
    
    private String name;
    private int foundationYear;
    
    private ArrayList<Player> playerList;
    private Trainer trainer;

    public Team() {
    }

    public Team(String name, int foundationYear, Trainer trainer) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.trainer = trainer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
    
    
    
}
