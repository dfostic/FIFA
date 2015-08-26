package com.dfostic.data;

import com.dfostic.data.PlayerRepository;
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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DFostic1
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = RootConfig.class)
@WebAppConfiguration
public class PlayerRepositoryTest {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    private PlayerFactory playerFactory;

    /**
     * Tests inserting a user and asserts it can be loaded again.
     * @throws java.lang.Exception
     */
    @Test
    public void testSavePlayer() throws Exception {

        Player player = playerFactory.generateRandomPlayer(Position.DEFENDER);
        
        System.out.println("\n\n ------------------------------------------  before save ------------------------------------------\n\n");

        player = playerRepository.save(player);

        assertEquals(player, playerRepository.findByLastName(player.getLastName()).get(0));
    }

    @Test
    public void testAbc() {
        assertEquals(5, 5);
    }

}
