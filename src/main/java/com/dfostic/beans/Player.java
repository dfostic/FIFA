package com.dfostic.beans;

/**
 *
 * @author DFostic1
 */

import java.util.Currency;


public class Player {
    
    public enum Position {
    GOALKEEPER, DEFENDER, MIDFIELDER, FORWARD 
}
    
    private String firstName;
    private String lastName;
    private int age;
    private String country;
    private Position position;
    private double salary;                                                      /*  ? What about currency ? */
    private int goals;
    private int booking;
    
    

    public Player(String firstName, String lastName, int age, String country, 
            Position position, double salary, int goals, int booking) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
        this.position = position;
        this.salary = salary;
        this.goals = goals;
        this.booking = booking;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getBooking() {
        return booking;
    }

    public void setBooking(int booking) {
        this.booking = booking;
    }
       
    
}
