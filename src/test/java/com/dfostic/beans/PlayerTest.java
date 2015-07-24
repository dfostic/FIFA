/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dfostic.beans;

import java.util.Currency;
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
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of getFirstName method, of class Player.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Player instance = new Player();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class Player.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        Player instance = new Player();
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class Player.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Player instance = new Player();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class Player.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        Player instance = new Player();
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAge method, of class Player.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        Player instance = new Player();
        int expResult = 0;
        int result = instance.getAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAge method, of class Player.
     */
    @Test
    public void testSetAge() {
        System.out.println("setAge");
        int age = 0;
        Player instance = new Player();
        instance.setAge(age);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCountry method, of class Player.
     */
    @Test
    public void testGetCountry() {
        System.out.println("getCountry");
        Player instance = new Player();
        String expResult = "";
        String result = instance.getCountry();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCountry method, of class Player.
     */
    @Test
    public void testSetCountry() {
        System.out.println("setCountry");
        String country = "";
        Player instance = new Player();
        instance.setCountry(country);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosition method, of class Player.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Player instance = new Player();
        Player.Position expResult = null;
        Player.Position result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosition method, of class Player.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        Player.Position position = null;
        Player instance = new Player();
        instance.setPosition(position);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSalary method, of class Player.
     */
    @Test
    public void testGetSalary() {
        System.out.println("getSalary");
        Player instance = new Player();
        double expResult = 0.0;
        double result = instance.getSalary();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSalary method, of class Player.
     */
    @Test
    public void testSetSalary() {
        System.out.println("setSalary");
        double salary = 0.0;
        Player instance = new Player();
        instance.setSalary(salary);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatistics method, of class Player.
     */
    @Test
    public void testGetStatistics() {
        System.out.println("getStatistics");
        Player instance = new Player();
        Statistics expResult = null;
        Statistics result = instance.getStatistics();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatistics method, of class Player.
     */
    @Test
    public void testSetStatistics() {
        System.out.println("setStatistics");
        Statistics statistics = null;
        Player instance = new Player();
        instance.setStatistics(statistics);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrency method, of class Player.
     */
    @Test
    public void testGetCurrency() {
        System.out.println("getCurrency");
        Player instance = new Player();
        Currency expResult = null;
        Currency result = instance.getCurrency();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrency method, of class Player.
     */
    @Test
    public void testSetCurrency() {
        System.out.println("setCurrency");
        Currency currency = null;
        Player instance = new Player();
        instance.setCurrency(currency);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
