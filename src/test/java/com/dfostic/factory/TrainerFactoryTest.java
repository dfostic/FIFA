package com.dfostic.factory;

import com.dfostic.beans.Team;
import com.dfostic.beans.Trainer;
import com.dfostic.config.FifaConfig;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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
public class TrainerFactoryTest {
    
    private static LocalDate validDateOfBirth;
    
    private static final String validFN = "firstName";
    private static final String validLN = "lastName";
    private static final BigDecimal validSalary = new BigDecimal("1000000");
    private static final Currency validCurrency = Currency.getInstance(Locale.CANADA);
    private static final ArrayList<Team> validTeams = new ArrayList<Team>();
    
    @BeforeClass
    public static void setUpClass() {
        LocalDate now = LocalDate.now();
        validDateOfBirth = LocalDate.of(now.getYear() - 41, now.getMonth(), now.getDayOfMonth());
    }
    
    @Autowired
    private TrainerFactory trainerFactory;
    
    @Autowired
    private Trainer LaurentBlanc;
    
    @Autowired
    private Trainer LuisEnrique;
    
    @Autowired
    private Trainer JoseMourinho;
    
    @Autowired
    private Trainer RafaelBenitez;
    
    @Test
    public void trainerFactoryNotNull() {
        assertNotNull(trainerFactory);
    }
    
    @Test
    public void autowiredLaurentBlancNotNull() {
        assertNotNull(LaurentBlanc);
    }
    
    @Test
    public void autowiredLaurentBlancInfo() {
        assertEquals(LaurentBlanc.getFirstName(), "Laurent");
        assertEquals(LaurentBlanc.getLastName(), "Blanc");
    }
    
    @Test
    public void autowiredLuisEnriqueNotNull() {
        assertNotNull(LuisEnrique);
    }
    
    @Test
    public void autowiredLuisEnriqueInfo() {
        assertEquals(LuisEnrique.getFirstName(), "Luis");
        assertEquals(LuisEnrique.getLastName(), "Enrique");
    }
    
    @Test
    public void autowiredJoseMourinhoNotNull() {
        assertNotNull(JoseMourinho);
    }
    
    @Test
    public void autowiredJoseMourinhoInfo() {
        assertEquals(JoseMourinho.getFirstName(), "Jose");
        assertEquals(JoseMourinho.getLastName(), "Mourinho");
    }
    
    @Test
    public void autowiredRafaelBenitezNotNull() {
        assertNotNull(RafaelBenitez);
    }
    
    @Test
    public void autowiredRafaelBenitezInfo() {
        assertEquals(RafaelBenitez.getFirstName(), "Rafael");
        assertEquals(RafaelBenitez.getLastName(), "Benitez");
    }
    
    @Test
    public void createValidTrainer() throws Exception {
        Trainer trainer = trainerFactory.createTrainer(validFN, validLN, validDateOfBirth, validTeams, validSalary, validCurrency);
        assertNotNull(trainer);
    }
    
    @Test
    public void createInvalidFirstNameEmpty() {
        String message = null;
        String expected = String.format("Trainer first name '%s' is not valid: Should not be empty", "");
        
        try {
            Trainer trainer = trainerFactory.createTrainer("", validLN, validDateOfBirth, validTeams, validSalary, validCurrency);
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        
        assertEquals(message, expected);
    }
    
    @Test
    public void createInvalidFirstNameNull() {
        String message = null;
        String expected = String.format("Trainer first name '%s' is not valid: Should not be empty", null);
        
        try {
            Trainer trainer = trainerFactory.createTrainer(null, validLN, validDateOfBirth, validTeams, validSalary, validCurrency);
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        
        assertEquals(message, expected);
    }
    
    @Test
    public void createInvalidLastNameEmpty() {
        String message = null;
        String expected = String.format("Trainer last name '%s' is not valid: Should not be empty", "");
        
        try {
            Trainer trainer = trainerFactory.createTrainer(validFN, "", validDateOfBirth, validTeams, validSalary, validCurrency);
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        
        assertEquals(message, expected);
    }
    
    @Test
    public void createInvalidLastNameNull() {
        String message = null;
        String expected = String.format("Trainer last name '%s' is not valid: Should not be empty", null);
        
        try {
            Trainer trainer = trainerFactory.createTrainer(validFN, null, validDateOfBirth, validTeams, validSalary, validCurrency);
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        
        assertEquals(message, expected);
    }
    
    @Test
    public void createInvalidAge() {
        LocalDate now = LocalDate.now();
        int wrongAge = 39;
        LocalDate invalidDateOfBirth = LocalDate.of(now.getYear() - wrongAge, now.getMonth(), now.getDayOfMonth());
        
        String message = null;
        String expected = String.format("Trainer age '%s' is not valid: Minimum age is %s", wrongAge, 40);
        
        try {
            Trainer trainer = trainerFactory.createTrainer(validFN, validLN, invalidDateOfBirth, validTeams, validSalary, validCurrency);
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        
        assertEquals(message, expected);
        
    }
    
    @Test
    public void createSalaryNull() {
        String message = null;
        String expected = String.format("Trainer salary '%s' is not valid: Should not be empty", null);
        
        try {
            Trainer trainer = trainerFactory.createTrainer(validFN, validLN, validDateOfBirth, validTeams, null, validCurrency);
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        
        assertEquals(message, expected);
    }
    
    @Test
    public void createSalaryZero() {
        String message = null;
        String expected = String.format("Trainer salary '%s' is not valid: Should not be empty", BigDecimal.ZERO);
        
        try {
            Trainer trainer = trainerFactory.createTrainer(validFN, validLN, validDateOfBirth, validTeams, BigDecimal.ZERO, validCurrency);
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        
        assertEquals(message, expected);
    }
    
    @Test
    public void generateRandomTrainer() {
        Exception exception = null;
        
        try {
            Trainer trainer = trainerFactory.generateRandomTrainer();
        } catch (Exception ex) {
            exception = ex;
        }
        
        assertNull(exception);
    }
}
