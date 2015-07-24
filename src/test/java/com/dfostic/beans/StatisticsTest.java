/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dfostic.beans;

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
public class StatisticsTest {
    
    public StatisticsTest() {
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
     * Test of getGoalsScored method, of class Statistics.
     */
    @Test
    public void testGetGoalsScored() {
        System.out.println("getGoalsScored");
        Statistics instance = new Statistics();
        int expResult = 0;
        int result = instance.getGoalsScored();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGoalsScored method, of class Statistics.
     */
    @Test
    public void testSetGoalsScored() {
        System.out.println("setGoalsScored");
        int goalsScored = 0;
        Statistics instance = new Statistics();
        instance.setGoalsScored(goalsScored);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookingsNo method, of class Statistics.
     */
    @Test
    public void testGetBookingsNo() {
        System.out.println("getBookingsNo");
        Statistics instance = new Statistics();
        int expResult = 0;
        int result = instance.getBookingsNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBookingsNo method, of class Statistics.
     */
    @Test
    public void testSetBookingsNo() {
        System.out.println("setBookingsNo");
        int bookingsNo = 0;
        Statistics instance = new Statistics();
        instance.setBookingsNo(bookingsNo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
