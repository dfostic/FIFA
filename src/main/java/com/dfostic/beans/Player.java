package com.dfostic.beans;

/**
 * @author dfostic
 */
import com.dfostic.util.Position;
import com.dfostic.interfaces.IPlayer;
import com.dfostic.util.ValidAge;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Currency;
import java.util.Locale;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class Player implements IPlayer {

    @NotEmpty(message = "{player.firstNameEmpty}")
    @Size(min = 2, max = 16, message = "{player.firstName}")
    @Pattern(regexp = "[a-zA-Z\\-']+", message = "{player.firstNameDigit}")
    private String firstName;

    @NotEmpty(message = "{player.lastNameEmpty}")
    @Size(min = 2, max = 16, message = "{player.lastName}")
    @Pattern(regexp = "[a-zA-Z\\-']+", message = "{player.lastNameDigit}")
    private String lastName;

    @ValidAge(min = 19, max = 23, message = "{player.age}") /* CCUSTOM MADE validator */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;

    private Locale country;

    private Position position;

    @NotNull(message = "{player.salaryNull}")
    @DecimalMin(value = "25000.00", message = "{player.salarySize}")
    @NumberFormat(style = Style.CURRENCY)
    private BigDecimal salary;

    private Statistics statistics;

    private Currency currency;

    public Player() {
        this.statistics = new Statistics();
    }

    public Player(String firstName, String lastName, LocalDate dateOfBirth, Locale country, Position position, BigDecimal salary, Statistics statistics, Currency currency) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.position = position;
        this.salary = salary;
        this.statistics = statistics;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        Period period = Period.between(dateOfBirth, now);
        return period.getYears();
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
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
