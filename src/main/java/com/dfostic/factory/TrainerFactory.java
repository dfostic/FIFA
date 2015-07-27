package com.dfostic.factory;

import com.dfostic.beans.Team;
import com.dfostic.beans.Trainer;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import java.util.Random;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * @author dfostic
 */

@Component
public class TrainerFactory {

    public final int ageLimit = 40;
//    private final Currency defaultCurrency = Currency.getInstance("USD");
    private final Currency defaultCurrency = Currency.getInstance(Locale.US);

    public static final Trainer LaurentBlanc = new Trainer("Laurent", "Blanc", LocalDate.of(1965, Month.NOVEMBER, 19), null, new BigDecimal("6000000"), Currency.getInstance(Locale.FRANCE));
    public static final Trainer LuisEnrique = new Trainer("Luis", "Enrique", LocalDate.of(1970, Month.MAY, 8), null, new BigDecimal("3400000"), Currency.getInstance(Locale.US));
    public static final Trainer JoseMourinho = new Trainer("Jose", "Mourinho", LocalDate.of(1963, Month.JANUARY, 26), null, new BigDecimal("13200000"), Currency.getInstance(Locale.UK));
    public static final Trainer RafaelBenitez = new Trainer("Rafael", "Benitez", LocalDate.of(1960, Month.APRIL, 16), null, new BigDecimal("3500000"), Currency.getInstance(new Locale("es", "ES")));

    public TrainerFactory() {
    }

    public Trainer createTrainer(String firstName, String lastName, LocalDate dateOfBirth, ArrayList<Team> previousTeams, BigDecimal salary, Currency currency) throws Exception {

        if (previousTeams == null) {
            previousTeams = new ArrayList<Team>();
        }

        if (currency == null) {
            currency = defaultCurrency;
        }

        Trainer trainer = new Trainer(firstName, lastName, dateOfBirth, previousTeams, salary, currency);

        String validation = this.isTrainerValid(trainer);
        if (validation.isEmpty()) {
            return trainer;
        } else {
            throw new Exception(validation);
        }

    }
    
    
    public Trainer generateRandomTrainer() {
        Trainer trainer = new Trainer();
        trainer.setFirstName(RandomStringUtils.randomAlphabetic(8));
        trainer.setLastName(RandomStringUtils.randomAlphabetic(8));
        
        LocalDate now = LocalDate.now();
        Random randomInt = new Random();
        int randomYearOfBirth = randomInt.nextInt(100 - 40) + 40;
        LocalDate dateOfBirth = LocalDate.of(now.getYear() - randomYearOfBirth, now.getMonth(), now.getDayOfMonth());
        trainer.setDateOfBirth(dateOfBirth);
        
        int randomSalary = randomInt.nextInt(10000000 - 1000000) + 1000000;
        trainer.setSalary(new BigDecimal(randomSalary));
        trainer.setCurrency(defaultCurrency);
        
        return trainer;
    }

    /**
     * Returning string with invalid value message. Build in this way for future
     * validation, in case we wont to validate something else, and have
     * different error messages
     *
     * @param trainer
     * @return
     */
    private String isTrainerValid(Trainer trainer) {
        String validation = "";
        if (trainer.getFirstName() == null || trainer.getFirstName().isEmpty()) {
            validation += String.format("Trainer first name '%s' is not valid: Should not be empty", trainer.getFirstName());
        }

        if (trainer.getLastName() == null || trainer.getLastName().isEmpty()) {
            validation += String.format("Trainer last name '%s' is not valid: Should not be empty", trainer.getLastName());
        }

        if (trainer.getAge() < this.ageLimit) {
            validation += String.format("Trainer age '%s' is not valid: Minimum age is %s", trainer.getAge(), this.ageLimit);
        }

        if (trainer.getSalary() == null || trainer.getSalary() == BigDecimal.ZERO) {
            validation += String.format("Trainer salary '%s' is not valid: Should not be empty", trainer.getSalary());
        }

        return validation;
    }
}
