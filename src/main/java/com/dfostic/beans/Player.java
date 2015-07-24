package com.dfostic.beans;

/**
 *
 * @author DFostic1
 */
import java.time.LocalDate;
import java.util.Currency;
import java.util.Locale;
import org.springframework.stereotype.Component;

@Component
public class Player {

    public enum Position {

        GOALKEEPER, DEFENDER, MIDFIELDER, FORWARD
    }

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int age;
    private Locale country;
    private Position position;
    private double salary;
    private Statistics statistics;
    private Currency currency;

    public Player() {
    }

    public Player(String firstName, String lastName, LocalDate dateOfBirth, Locale country, Position position, double salary, Statistics statistics) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.position = position;
        this.salary = salary;
        this.statistics = statistics;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }   

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Locale getCountry() {
        return country;
    }

    public void setCountry(Locale country) {
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

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

}
