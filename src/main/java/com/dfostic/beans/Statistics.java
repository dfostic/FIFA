package com.dfostic.beans;

import org.springframework.stereotype.Component;

/**
 * @author DFostic1
 */

@Component
public class Statistics {
    
    private int goals;
    private int bookings;

    public Statistics() {
        this.goals = 0;
        this.bookings = 0;
    }    

    public Statistics(int goalsScored, int bookingsNo) {
        this.goals = goalsScored;
        this.bookings = bookingsNo;
    }   

    public int getGoalsScored() {
        return goals;
    }

    public void setGoalsScored(int goalsScored) {
        this.goals = goalsScored;
    }

    public int getBookingsNo() {
        return bookings;
    }

    public void setBookingsNo(int bookingsNo) {
        this.bookings = bookingsNo;
    }
    
    
}
