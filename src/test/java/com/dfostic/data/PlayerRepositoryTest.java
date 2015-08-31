package com.dfostic.data;

import com.dfostic.beans.Player;
import com.dfostic.config.RootConfig;
import com.dfostic.factory.PlayerFactory;
import com.dfostic.util.Position;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author DFostic1
 */

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class PlayerRepositoryTest {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    private PlayerFactory playerFactory;

    @Test
    public void testAbc() {
        assertEquals(5, 5);
    }

    @Test
    public void testSavePlayer() throws Exception {
        Player player = playerFactory.generateRandomPlayer(Position.DEFENDER);
        playerRepository.save(player);

        assertEquals(player, playerRepository.findByLastName(player.getLastName()).get(0));
    }

    @Test
    public void testSaveMultiplePlayers() throws Exception {
        Player player1 = playerFactory.generateRandomPlayer(Position.DEFENDER);
        playerRepository.save(player1);
        
        Player player2 = playerFactory.generateRandomPlayer(Position.DEFENDER);
        playerRepository.save(player2);
        
        Player player3 = playerFactory.generateRandomPlayer(Position.DEFENDER);
        playerRepository.save(player3);

        assertEquals(player3, playerRepository.findByLastName(player3.getLastName()).get(0));
        assertEquals(player2, playerRepository.findByLastName(player2.getLastName()).get(0));
        assertEquals(player1, playerRepository.findByLastName(player1.getLastName()).get(0));
    }

}
