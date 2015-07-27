package com.dfostic.beans;

import com.dfostic.interfaces.ITeam;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

/**
 * @author dfostic
 */
public class Team implements ITeam {

    private String name;
    private int foundationYear;

    private Trainer trainer;
    private ArrayList<Player> playerList;

    public Team() {
    }

    public Team(String name, int foundationYear, Trainer trainer, ArrayList<Player> playerList) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.trainer = trainer;
        this.playerList = playerList;
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
