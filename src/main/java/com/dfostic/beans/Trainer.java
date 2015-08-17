package com.dfostic.beans;

/**
 * @author dfostic
 */
import com.dfostic.interfaces.ITrainer;
import com.dfostic.util.ValidAge;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Currency;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class Trainer implements ITrainer {

    @NotEmpty(message = "{trainer.firstNameEmpty}")
    @Size(min = 2, max = 16, message = "{trainer.firstName}")
    @Pattern(regexp = "[a-zA-Z\\-']+", message = "{trainer.firstNameDigit}")
    private String firstName;

    @NotEmpty(message = "{trainer.lastNameEmpty}")
    @Size(min = 2, max = 16, message = "{trainer.lastName}")
    @Pattern(regexp = "[a-zA-Z\\-']+", message = "{trainer.lastNameDigit}")
    private String lastName;

    @ValidAge(min = 40, message = "{trainer.age}") /* CUSTOM MADE validator */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;

    @NotNull(message = "{trainer.salaryNull}")
    @DecimalMin(value = "25000.00", message = "{trainer.salarySize}")
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal salary;

    private ArrayList<Team> previousTeams;

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
