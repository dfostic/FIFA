package com.dfostic.beans;

import com.dfostic.interfaces.IStatistics;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

/**
 * @author DFostic1
 */
@Entity
@Table(name = "statistics")
public class Statistics implements IStatistics, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "statisticsrowid")
    private long statisticsId;

    @NotNull(message = "{statistics.goalsNull}")
    @NotEmpty(message = "{statistics.goalsNull}")
    @Min(0)
    private int goals;

    @NotNull(message = "{statistics.bookingsNull}")
    @NotEmpty(message = "{statistics.bookingsNull}")
    @Min(0)
    private int bookings;

    public Statistics() {
        this.goals = 0;
        this.bookings = 0;
    }

    public Statistics(int goals, int bookings) {
        this.goals = goals;
        this.bookings = bookings;
    }

    public long getStatisticsId() {
        return statisticsId;
    }

    public void setStatisticsId(long statisticsId) {
        this.statisticsId = statisticsId;
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
