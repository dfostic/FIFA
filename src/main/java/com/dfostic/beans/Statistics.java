package com.dfostic.beans;

import com.dfostic.interfaces.IStatistics;
import org.springframework.stereotype.Component;

/**
 * @author DFostic1
 */

@Component
public class Statistics implements IStatistics{
    
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
