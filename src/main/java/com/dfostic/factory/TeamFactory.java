package com.dfostic.factory;

import com.dfostic.beans.Player;
import com.dfostic.beans.Team;
import com.dfostic.beans.Trainer;
import com.dfostic.interfaces.IPlayer;
import java.util.ArrayList;
import java.util.Random;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 *
 * @author DFostic1
 */
@Component
public class TeamFactory {

    TrainerFactory trainerFactory = new TrainerFactory();
    PlayerFactory playerFactory = new PlayerFactory();

    private static final int minFoundationYear = 1950;

    /* To BE FINISHED LATER- made for fun*/
    private static final Team PSG = new Team("PSG", 1970, TrainerFactory.LaurentBlanc, null);
    private static final Team FCB = new Team("FCB", 1899, TrainerFactory.LuisEnrique, null);
    private static final Team CHELSEA = new Team("Chelsea", 1905, TrainerFactory.JoseMourinho, null);
    private static final Team MFC = new Team("Real Madrid", 1902, TrainerFactory.RafaelBenitez, null);

    public Team createTeam(String name, int foundationYear, Trainer trainer, ArrayList<Player> playerList) throws Exception {
        if (playerList == null) {
            playerList = new ArrayList<Player>(22);
        }

        Team team = new Team(name, foundationYear, trainer, playerList);
        String validation = this.isTeamValid(team);

        if (validation.isEmpty()) {
            return team;
        } else {
            throw new Exception(validation);
        }

    }

    public Team generateRandomTeam() throws Exception {
        Team team = new Team();

        team.setName(RandomStringUtils.randomAlphabetic(8));
        team.setFoundationYear(this.generateRandomFoundationYear());

        team.setTrainer(trainerFactory.generateRandomTrainer());
        team.setPlayerList(this.generateRandomPlayerList());

        String validation = this.isTeamValid(team);

        if (validation.isEmpty()) {
            return team;
        } else {
            throw new Exception(validation);
        }
    }
    
    public int generateRandomFoundationYear() {
        Random randomInt = new Random();
        return randomInt.nextInt(2015 - minFoundationYear) + minFoundationYear;
    }

    public ArrayList<Player> generateRandomPlayerList() throws Exception {
        ArrayList<Player> playerList = new ArrayList<Player>(22);

        for (int x = 0; x < 2; x++) {
            playerList.add(playerFactory.generateRandomPlayer(IPlayer.Position.GOALKEEPER));
        }

        for (int x = 0; x < 8; x++) {
            playerList.add(playerFactory.generateRandomPlayer(IPlayer.Position.DEFENDER));
        }

        for (int x = 0; x < 6; x++) {
            playerList.add(playerFactory.generateRandomPlayer(IPlayer.Position.MIDFIELDER));
        }

        for (int x = 0; x < 6; x++) {
            playerList.add(playerFactory.generateRandomPlayer(IPlayer.Position.FORWARD));
        }
        return playerList;
    }

    private String isTeamValid(Team team) {
        String validation = "";

        if (team.getName() == null || team.getName().isEmpty()) {
            validation += String.format("Team name '%s' is not valid: Name cannot be null or empty", team.getName());
        }

        if (team.getFoundationYear() < minFoundationYear) {
            validation += String.format("Team foundation year '%s' is not valid: Year should be equal or greater than %s", team.getFoundationYear(), minFoundationYear);
        }

        if (team.getTrainer() == null) {
            validation += "Team's trainer cannot be null";
        }

        if (team.getPlayerList().size() != 22) {
            validation += String.format("Team players No '%s' is not valid: A team must have 22 players", team.getPlayerList().size());
        }

        return validation;
    }

//    public Team getTeam(String teamName) {
//        Team team = null;
//
//        if (teamName.equals("PSG")) {
//            team = new Team(teamName, 1970, trainerFactory.getTrainer(teamName));
//        } else if (teamName.equals("FCB")) {
//            team = new Team(teamName, 1899, trainerFactory.getTrainer(teamName));
//        } else if (teamName.equals("Chelsea")) {
//            team = new Team(teamName, 1905, trainerFactory.getTrainer(teamName));
//        } else if (teamName.equals("Los Blancos")) {
//            team = new Team(teamName, 1902, trainerFactory.getTrainer(teamName));
//        } else {
//            team = new Team();
//        }
//        return team;
//    }
}
