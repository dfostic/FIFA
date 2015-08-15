package com.dfostic.web;

import com.dfostic.beans.Statistics;
import com.dfostic.interfaces.IPlayerModifier;
import org.springframework.stereotype.Component;


/**
 * @author dfostic1
 */
@Component
public class PlayerModifier  implements IPlayerModifier{
    
    private Statistics statistics;
    
    public void setGoals(int goals) {
        if (this.statistics == null)
            this.statistics = new Statistics();
        
        this.statistics.setGoals(goals);
    }
    
    public void setBookings(int bookings) {
        if (this.statistics == null)
            this.statistics = new Statistics();
        
        this.statistics.setBookings(bookings);
    }
}
