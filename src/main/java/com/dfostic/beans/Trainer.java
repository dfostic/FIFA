package com.dfostic.beans;

/**
 * @author dfostic
 */
import com.dfostic.interfaces.ITrainer;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Currency;

public class Trainer implements ITrainer {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    private ArrayList<Team> previousTeams;
    private BigDecimal salary;
    private Currency currency;

    public Trainer() {
    }

    public Trainer(String firstName, String lastName, LocalDate dateOfBirth, ArrayList<Team> previousTeams, BigDecimal salary, Currency currency) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.previousTeams = previousTeams;
        this.salary = salary;
        this.currency = currency;
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
        LocalDate now = LocalDate.now();
        Period period = Period.between(dateOfBirth, now);
        return period.getYears();
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ArrayList<Team> getPreviousTeams() {
        return previousTeams;
    }

    public void setPreviousTeams(ArrayList<Team> previousTeams) {
        this.previousTeams = previousTeams;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

}
