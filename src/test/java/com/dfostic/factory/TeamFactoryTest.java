package com.dfostic.factory;

import com.dfostic.beans.Player;
import com.dfostic.beans.Team;
import com.dfostic.beans.Trainer;
import com.dfostic.config.FifaConfig;
import com.dfostic.interfaces.IPlayer;
import com.dfostic.util.Position;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author dfostic
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FifaConfig.class)
public class TeamFactoryTest {
    
    public TeamFactoryTest() {
    }
    
    @Autowired
    private TeamFactory teamFactory;
    
    @Autowired TrainerFactory trainerFactory;
    
    @Autowired PlayerFactory playerFactory;           
    
    
    @Test
    public void teamFacoryNotNull() {
        assertNotNull(teamFactory);
    }
     
    @Test
    public void createValidTeam() throws Exception {
        Team team = teamFactory.generateRandomTeam();
        assertNotNull(team);
    }
    
    @Test 
    public void createTeamNameEmpty() {
        String emptyName = "";
        String message = null;
        String expected = String.format("Team name '%s' is not valid: Name cannot be null or empty", emptyName);

        try {
            Team team = teamFactory.createTeam(emptyName, teamFactory.generateRandomFoundationYear(), trainerFactory.generateRandomTrainer(), teamFactory.generateRandomPlayerList());
        } catch (Exception ex) {
            message = ex.getMessage();
        }

        assertEquals(message, expected);
    }
    
    @Test 
    public void createTeamNameNull() {
        String nullName = null;
        String message = null;
        String expected = String.format("Team name '%s' is not valid: Name cannot be null or empty", nullName);

        try {
            Team team = teamFactory.createTeam(nullName, teamFactory.generateRandomFoundationYear(), trainerFactory.generateRandomTrainer(), teamFactory.generateRandomPlayerList());
        } catch (Exception ex) {
            message = ex.getMessage();
        }

        assertEquals(message, expected);
    }
    
    @Test 
    public void createTeamInvalidYear() {
        int foundationYear = 1949;
        String message = null;
        String expected = String.format("Team foundation year '%s' is not valid: Year should be equal or greater than %s", foundationYear, 1950);

        try {
            Team team = teamFactory.createTeam("AnyTeam", foundationYear, trainerFactory.generateRandomTrainer(), teamFactory.generateRandomPlayerList());
        } catch (Exception ex) {
            message = ex.getMessage();
        }

        assertEquals(message, expected);
    }
    
    @Test 
    public void createTeamTrainerNull() {
        String message = null;
        String expected = "Team's trainer cannot be null";

        try {
            Team team = teamFactory.createTeam("AnyTeam", teamFactory.generateRandomFoundationYear(), null, teamFactory.generateRandomPlayerList());
        } catch (Exception ex) {
            message = ex.getMessage();
        }

        assertEquals(message, expected);
    }
    
    @Test 
    public void createTeamInvalidPlayerNoLess() throws Exception {
        ArrayList<Player> playerList = teamFactory.generateRandomPlayerList();
        playerList.remove(1);
        
        String message = null;
        String expected = String.format("Team players No '%s' is not valid: A team must have 22 players", playerList.size());

        try {
            Team team = teamFactory.createTeam("AnyTeam", teamFactory.generateRandomFoundationYear(), trainerFactory.generateRandomTrainer(), playerList);
        } catch (Exception ex) {
            message = ex.getMessage();
        }

        assertEquals(message, expected);
    }
    
    @Test 
    public void createTeamInvalidPlayerNoMore() throws Exception {
        ArrayList<Player> playerList = teamFactory.generateRandomPlayerList();
        playerList.add(playerFactory.generateRandomPlayer(Position.DEFENDER));
        
        String message = null;
        String expected = String.format("Team players No '%s' is not valid: A team must have 22 players", playerList.size());

        try {
            Team team = teamFactory.createTeam("AnyTeam", teamFactory.generateRandomFoundationYear(), trainerFactory.generateRandomTrainer(), playerList);
        } catch (Exception ex) {
            message = ex.getMessage();
        }

        assertEquals(message, expected);
    }
}
