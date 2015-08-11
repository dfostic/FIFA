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

    public Statistics(int goals, int bookings) {
        this.goals = goals;
        this.bookings = bookings;
    }   

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getBookings() {
        return bookings;
    }

    public void setBookings(int bookings) {
        this.bookings = bookings;
    }
    
    
}
