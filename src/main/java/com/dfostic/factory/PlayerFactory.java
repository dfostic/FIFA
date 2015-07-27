package com.dfostic.factory;

import com.dfostic.interfaces.IPlayer;
import com.dfostic.beans.Player;
import com.dfostic.beans.Statistics;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Currency;
import java.util.Locale;
import java.security.SecureRandom;
import java.util.Random;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * @author dfostic
 */
@Component
public class PlayerFactory {

    private final Currency defaultCurrency = Currency.getInstance(Locale.US);

    public static final Player NicolasDouchez = new Player("Nicolas", "Douchez", LocalDate.of(1980, Month.APRIL, 22), Locale.FRANCE, Player.Position.GOALKEEPER, new BigDecimal("1440000"), new Statistics(), Currency.getInstance(Locale.FRANCE));
    public static final Player ThiagoSilva = new Player("Thiago", "Silva", LocalDate.of(1984, Month.SEPTEMBER, 22), new Locale("pt_BR", "Brazil"), Player.Position.DEFENDER, new BigDecimal("12000000"), new Statistics(4, 1), Currency.getInstance(Locale.FRANCE));
    public static final Player BenjaminStambouli = new Player("Benjamin", "Stambouli", LocalDate.of(1990, Month.AUGUST, 13), Locale.FRANCE, Player.Position.MIDFIELDER, new BigDecimal("1711667"), new Statistics(5, 2), Currency.getInstance(Locale.FRANCE));

    public PlayerFactory() {

    }

    public Currency getDefaultCurrency() {
        return this.defaultCurrency;
    }

    public Player createPlayer(String firstName, String lastName, LocalDate dateOfBirth, Locale country, IPlayer.Position position, BigDecimal salary, Statistics statistics, Currency currency) throws Exception {
        if (statistics == null) {
            statistics = this.createStatistics(0, 0);
        }

        if (currency == null) {
            currency = this.defaultCurrency;
        }

        Player player = new Player(firstName, lastName, dateOfBirth, country, position, salary, statistics, currency);
        String validation = this.isPlayerValid(player);

        if (validation.isEmpty()) {
            return player;
        } else {
            throw new Exception(validation);
        }
    }

    public Player generateRandomPlayer(IPlayer.Position position) throws Exception {
        Player player = new Player();
        player.setFirstName(RandomStringUtils.randomAlphabetic(8));
        player.setLastName(RandomStringUtils.randomAlphabetic(8));

        LocalDate now = LocalDate.now();
        Random randomInt = new Random();
        int randomYearOfBirth = randomInt.nextInt(3) + 20;
        LocalDate dateOfBirth = LocalDate.of(now.getYear() - randomYearOfBirth, now.getMonth(), now.getDayOfMonth());
        player.setDateOfBirth(dateOfBirth);

        player.setCountry(Locale.CANADA_FRENCH);
        player.setPosition(position);
        
        int randomSalary = randomInt.nextInt(10000000 - 1000000) + 1000000;
        player.setSalary(new BigDecimal(randomSalary));
        player.setStatistics(this.generateRandomStatistics());
        player.setCurrency(defaultCurrency);

        String validation = this.isPlayerValid(player);

        if (validation.isEmpty()) {
            return player;
        } else {
            throw new Exception(validation);
        }
    }
    
    public Statistics generateRandomStatistics() throws Exception {
        Statistics statistics = new Statistics();
        
        Random randomInt = new Random();
        statistics.setGoalsScored(randomInt.nextInt(10));
        statistics.setBookingsNo(randomInt.nextInt(10));
        
        String validation = this.isStatisticsValid(statistics);
        if (validation.isEmpty()) {
            return statistics;
        } else {
            throw new Exception(validation);
        }
    }

    public String isPlayerValid(Player player) {
        String validation = "";

        if (player.getFirstName() == null || player.getFirstName().isEmpty() || player.getFirstName().matches(".*[0-9].*")) {
            validation += String.format("Player first name '%s' is not valid: Should not be empty or contain digits", player.getFirstName());
        }

        if (player.getLastName() == null || player.getLastName().isEmpty() || player.getLastName().matches(".*[0-9].*")) {
            validation += String.format("Player last name '%s' is not valid: Should not be empty or contain digits", player.getLastName());
        }

        if (player.getAge() < 19 || player.getAge() > 23) {
            validation += String.format("Player age is not valid: Should be between 20 and 23 but is %s", player.getAge());
        }

        if (player.getCountry() == null)
            validation += "Player's country cannot be null";

        if (player.getPosition() == null)
            validation += "Player's position cannot be null";

        if (player.getSalary() == null || player.getSalary().equals(BigDecimal.ZERO)) {
            validation += String.format("Player salary is not valid: Should not be empty but is %s", player.getSalary().toString());
        }

        String validateStatistics = this.isStatisticsValid(player.getStatistics());
        if (!validateStatistics.isEmpty())
            validation += validateStatistics;

        return validation;
    }

    public Statistics createStatistics(int goalsScored, int bookingsNo) throws Exception {
        Statistics statistics = new Statistics(goalsScored, bookingsNo);

        String validation = this.isStatisticsValid(statistics);
        if (validation.isEmpty())
            return statistics;
        else
            throw new Exception(validation);
    }

    public String isStatisticsValid(Statistics statistics) {
        String validation = "";

        if (statistics.getGoalsScored() < 0)
            validation += String.format("Statistics goalsScored '%s'is not valid: Should be numeric value equal or greater than zero", statistics.getGoalsScored());

        if (statistics.getBookingsNo() < 0)
            validation += String.format("Statistics bookings '%s'is not valid: Should be numeric value equal or greater than zero", statistics.getBookingsNo());

        return validation;
    }

}
