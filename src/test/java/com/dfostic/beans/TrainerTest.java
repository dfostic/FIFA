/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dfostic.beans;

import java.time.LocalDate;
import java.util.ArrayList;
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
public class TrainerTest {
    
    public TrainerTest() {
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
     * Test of getFirstName method, of class Trainer.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Trainer instance = new Trainer();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class Trainer.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        Trainer instance = new Trainer();
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class Trainer.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Trainer instance = new Trainer();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class Trainer.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        Trainer instance = new Trainer();
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAge method, of class Trainer.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        Trainer instance = new Trainer();
        int expResult = 0;
        int result = instance.getAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAge method, of class Trainer.
     */
    @Test
    public void testSetAge() {
        System.out.println("setAge");
        LocalDate dateOfBirth = null;
        Trainer instance = new Trainer();
        instance.setAge(dateOfBirth);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPreviousTeams method, of class Trainer.
     */
    @Test
    public void testGetPreviousTeams() {
        System.out.println("getPreviousTeams");
        Trainer instance = new Trainer();
        ArrayList<Team> expResult = null;
        ArrayList<Team> result = instance.getPreviousTeams();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPreviousTeams method, of class Trainer.
     */
    @Test
    public void testSetPreviousTeams() {
        System.out.println("setPreviousTeams");
        ArrayList<Team> previousTeams = null;
        Trainer instance = new Trainer();
        instance.setPreviousTeams(previousTeams);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSalary method, of class Trainer.
     */
    @Test
    public void testGetSalary() {
        System.out.println("getSalary");
        Trainer instance = new Trainer();
        double expResult = 0.0;
        double result = instance.getSalary();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSalary method, of class Trainer.
     */
    @Test
    public void testSetSalary() {
        System.out.println("setSalary");
        double salary = 0.0;
        Trainer instance = new Trainer();
        instance.setSalary(salary);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrency method, of class Trainer.
     */
    @Test
    public void testGetCurrency() {
        System.out.println("getCurrency");
        Trainer instance = new Trainer();
        Currency expResult = null;
        Currency result = instance.getCurrency();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrency method, of class Trainer.
     */
    @Test
    public void testSetCurrency() {
        System.out.println("setCurrency");
        Currency currency = null;
        Trainer instance = new Trainer();
        instance.setCurrency(currency);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
