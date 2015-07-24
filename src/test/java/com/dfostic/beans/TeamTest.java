/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dfostic.beans;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DFostic1
 */
public class TeamTest {
    
    public TeamTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Team.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Team instance = new Team();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Team.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Team instance = new Team();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFoundationYear method, of class Team.
     */
    @Test
    public void testGetFoundationYear() {
        System.out.println("getFoundationYear");
        Team instance = new Team();
        int expResult = 0;
        int result = instance.getFoundationYear();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFoundationYear method, of class Team.
     */
    @Test
    public void testSetFoundationYear() {
        System.out.println("setFoundationYear");
        int foundationYear = 0;
        Team instance = new Team();
        instance.setFoundationYear(foundationYear);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerList method, of class Team.
     */
    @Test
    public void testGetPlayerList() {
        System.out.println("getPlayerList");
        Team instance = new Team();
        ArrayList<Player> expResult = null;
        ArrayList<Player> result = instance.getPlayerList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlayerList method, of class Team.
     */
    @Test
    public void testSetPlayerList() {
        System.out.println("setPlayerList");
        ArrayList<Player> playerList = null;
        Team instance = new Team();
        instance.setPlayerList(playerList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTrainer method, of class Team.
     */
    @Test
    public void testGetTrainer() {
        System.out.println("getTrainer");
        Team instance = new Team();
        Trainer expResult = null;
        Trainer result = instance.getTrainer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTrainer method, of class Team.
     */
    @Test
    public void testSetTrainer() {
        System.out.println("setTrainer");
        Trainer trainer = null;
        Team instance = new Team();
        instance.setTrainer(trainer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
