package com.dfostic.factory;

import com.dfostic.interfaces.IPlayer;
import com.dfostic.beans.Player;
import com.dfostic.beans.Statistics;
import com.dfostic.config.FifaConfig;
import com.dfostic.util.Position;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Locale;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author dfostic
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FifaConfig.class)
public class PlayerFactoryTest {

    private static LocalDate validDateOfBirth;
    private static final BigDecimal validSalary = new BigDecimal("1000000");
    private static final Position validPosition = Position.DEFENDER;
    private static final Statistics validStats = new Statistics(5, 5);
    private static final Currency validCurrency = Currency.getInstance(Locale.CANADA);

    @BeforeClass
    public static void setUpClass() {
        LocalDate now = LocalDate.now();
        validDateOfBirth = LocalDate.of(now.getYear() - 21, now.getMonth(), now.getDayOfMonth());
    }

    @Autowired
    private PlayerFactory playerFactory;

    @Autowired
    private Player NicolasDouchez;

    @Autowired
    private Player ThiagoSilva;

    @Autowired
    private Player BenjaminStambouli;

    @Test
    public void playerFactoryNotNull() {
        assertNotNull(playerFactory);
    }

    @Test
    public void autowiredNicolasDouchezNotNull() {
        assertNotNull(NicolasDouchez);
    }

    @Test
    public void autowiredNicolasDouchezInfo() {
        assertEquals(NicolasDouchez.getFirstName(), "Nicolas");
        assertEquals(NicolasDouchez.getLastName(), "Douchez");
    }

    @Test
    public void autowiredThiagoSilvaNotNull() {
        assertNotNull(ThiagoSilva);
    }

    @Test
    public void autowiredThiagoSilvaInfo() {
        assertEquals(ThiagoSilva.getFirstName(), "Thiago");
        assertEquals(ThiagoSilva.getLastName(), "Silva");
    }

    @Test
    public void autowiredBenjaminStambouliNotNull() {
        assertNotNull(BenjaminStambouli);
    }

    @Test
    public void autowiredBenjaminStambouliInfo() {
        assertEquals(BenjaminStambouli.getFirstName(), "Benjamin");
        assertEquals(BenjaminStambouli.getLastName(), "Stambouli");
    }

    @Test
    public void createValidPlayer() throws Exception {
        Player player = playerFactory.createPlayer("First", "Last", validDateOfBirth, Locale.ENGLISH, validPosition, validSalary, validStats, validCurrency);
        assertNotNull(player);
    }

    @Test
    public void createInvalidFisrtName() {
        String invalidFirst = "Willi5am";
        String message = null;
        String expected = String.format("Player first name '%s' is not valid: Should not be empty or contain digits", invalidFirst);

        try {
            Player player = playerFactory.createPlayer(invalidFirst, "Last", validDateOfBirth, Locale.ENGLISH, validPosition, validSalary, validStats, validCurrency);
        } catch (Exception ex) {
            message = ex.getMessage();
        }

        assertEquals(message, expected);
    }

    @Test
    public void createInvalidLastName() {
        String invalidLast = "Shake5speare";
        String message = null;
        String expected = String.format("Player last name '%s' is not valid: Should not be empty or contain digits", invalidLast);

        try {
            Player player = playerFactory.createPlayer("First", invalidLast, validDateOfBirth, Locale.ENGLISH, validPosition, validSalary, validStats, validCurrency);
        } catch (Exception ex) {
            message = ex.getMessage();
        }

        assertEquals(message, expected);
    }

    @Test
    public void createPlayerInvalidAge() throws Exception {
        LocalDate now = LocalDate.now();
        int wrongAge = 25;
        LocalDate dateOfBirth = LocalDate.of(now.getYear() - wrongAge, now.getMonth(), now.getDayOfMonth());

        String message = null;
        String expected = String.format("Player age is not valid: Should be between 20 and 23 but is %s", wrongAge);

        try {
            Player player = playerFactory.createPlayer("First", "Last", dateOfBirth, Locale.CANADA, validPosition, validSalary, validStats, validCurrency);
        } catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals(message, expected);
    }

    @Test
    public void CreatePlayerNullCountry() {
        Locale country = null;
        String message = null;

        try {
            Player player = playerFactory.createPlayer("First", "Last", validDateOfBirth, country, validPosition, validSalary, validStats, validCurrency);
        } catch (Exception ex) {
            message = ex.getMessage();
        }

        assertEquals(message, "Player's country cannot be null");

    }

    @Test
    public void CreatePlayerNullPosition() {
        Position position = null;
        String message = null;

        try {
            Player player = playerFactory.createPlayer("First", "Last", validDateOfBirth, Locale.CANADA, position, validSalary, validStats, validCurrency);
        } catch (Exception ex) {
            message = ex.getMessage();
        }

        assertEquals(message, "Player's position cannot be null");

    }

    @Test
    public void CreatePlayerEmptySalary() {
        BigDecimal salary = BigDecimal.ZERO;
        String message = null;
        String expected = String.format("Player salary is not valid: Should not be empty but is %s", salary);

        try {
            Player player = playerFactory.createPlayer("First", "Last", validDateOfBirth, Locale.CANADA, validPosition, salary, validStats, validCurrency);
        } catch (Exception ex) {
            message = ex.getMessage();
        }

        assertEquals(message, expected);

    }

    @Test
    public void CreatePlayerNegativeGoalsNo() {
        Statistics statistics = new Statistics(-1, 0);
        String message = null;
        String expected = String.format("Statistics goalsScored '%s'is not valid: Should be numeric value equal or greater than zero", statistics.getGoals());

        try {
            Player player = playerFactory.createPlayer("First", "Last", validDateOfBirth, Locale.CANADA, validPosition, validSalary, statistics, validCurrency);
        } catch (Exception ex) {
            message = ex.getMessage();
        }

        assertEquals(message, expected);

    }

    @Test
    public void CreatePlayerNegativeBookings() {
        Statistics statistics = new Statistics(0, -1);
        String message = null;
        String expected = String.format("Statistics bookings '%s'is not valid: Should be numeric value equal or greater than zero", statistics.getBookings());

        try {
            Player player = playerFactory.createPlayer("First", "Last", validDateOfBirth, Locale.CANADA, validPosition, validSalary, statistics, validCurrency);
        } catch (Exception ex) {
            message = ex.getMessage();
        }

        assertEquals(message, expected);

    }

    @Test
    public void createPlayerDefaultValues() throws Exception {
        Player player = playerFactory.createPlayer("First", "Last", validDateOfBirth, Locale.ENGLISH, validPosition, validSalary, null, null);

        assertNotNull(player);

    }

}
