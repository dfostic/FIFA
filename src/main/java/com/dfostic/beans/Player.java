package com.dfostic.beans;

/**
 * @author dfostic
 */
import com.dfostic.util.Position;
import com.dfostic.interfaces.IPlayer;
import com.dfostic.util.ValidAge;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Currency;
import java.util.Locale;
import javax.persistence.Column;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "player")
public class Player implements IPlayer, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playerrowid")
    private long playerId;

    @NotEmpty(message = "{player.firstNameEmpty}")
    @Size(min = 2, max = 16, message = "{player.firstName}")
    @Pattern(regexp = "[a-zA-Z\\-']+", message = "{player.firstNameDigit}")
    private String firstName;

    @Column(name = "lastname")
    @NotEmpty(message = "{player.lastNameEmpty}")
    @Size(min = 2, max = 16, message = "{player.lastName}")
    @Pattern(regexp = "[a-zA-Z\\-']+", message = "{player.lastNameDigit}")
    private String lastName;

    @Column(name = "dateofbirth")
    @NotNull(message = "{player.ageNull}")
    @ValidAge(min = 19, max = 23, message = "{player.age}") /* CUSTOM MADE validator */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;

    private Locale country;

    private Position position;

    @NotNull(message = "{player.salaryNull}")
    @DecimalMin(value = "25000.00", message = "{player.salarySize}")
    @NumberFormat(style = Style.CURRENCY)
    private BigDecimal salary;

    @OneToOne
    @Transient
    private Statistics statistics;

    @Transient
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

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (int) (this.playerId ^ (this.playerId >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Player other = (Player) obj;
        if (this.playerId != other.playerId) return false;
        return true;
    }

    
    
    

}
