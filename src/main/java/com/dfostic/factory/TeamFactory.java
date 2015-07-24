package com.dfostic.factory;

import com.dfostic.beans.Team;
import com.dfostic.beans.Trainer;

/**
 *
 * @author DFostic1
 */
public class TeamFactory {

    TrainerFactory trainerFactory = new TrainerFactory();

    public Team createTeam() {
        Team team = new Team();

        team.setName("PSG");
        team.setFoundationYear(1970);
        team.setTrainer(this.trainerFactory.createTrainer());
        team.setPlayerList(null);

        return team;
    }

    public Team getTeam(String teamName) {
        Team team = null;

        if (teamName.equals("PSG")) {
            team = new Team(teamName, 1970, trainerFactory.getTrainer(teamName));
        } else if (teamName.equals("FCB")) {
            team = new Team(teamName, 1899, trainerFactory.getTrainer(teamName));
        } else if (teamName.equals("Chelsea")) {
            team = new Team(teamName, 1905, trainerFactory.getTrainer(teamName));
        } else if (teamName.equals("Los Blancos")) {
            team = new Team(teamName, 1902, trainerFactory.getTrainer(teamName));
        } else {
            team = new Team();
        }
        return team;
    }

}
