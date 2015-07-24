package com.dfostic.factory;

import com.dfostic.beans.Trainer;
import java.time.LocalDate;
import java.time.Month;
import java.util.Currency;
import java.util.Locale;

/**
 * @author DFostic1
 */
public class TrainerFactory {

    public Trainer createTrainer() {
        Trainer trainer = new Trainer();
        trainer.setFirstName("Laurent");
        trainer.setLastName("Blanc");
        trainer.setPreviousTeams(null);
        trainer.setSalary(6000000);
        trainer.setCurrency(Currency.getInstance("EUR"));

        return trainer;
    }

    public Trainer getTrainer(String clubName) {
        Trainer trainer = null;

        if (clubName.equals("PSG")) {
            trainer = new Trainer("Laurent", "Blanc", LocalDate.of(1965, Month.NOVEMBER, 19), null, 6000000, Currency.getInstance(Locale.FRANCE));
        } else if (clubName.equals("FCB")) {
            trainer = new Trainer("Luis", "Enrique", LocalDate.of(1970, Month.MAY, 8), null, 3400000, Currency.getInstance(Locale.US));
        } else if (clubName.equals("Chelsea")) {
            trainer = new Trainer("Jose", "Mourinho", LocalDate.of(1963, Month.JANUARY, 26), null, 13200000, Currency.getInstance(Locale.ENGLISH));
        } else if (clubName.equals("Los Blancos")) {
            trainer = new Trainer("Rafael", "Benitez", LocalDate.of(1960, Month.APRIL, 16), null, 3500000, Currency.getInstance(Locale.FRENCH));
        } else {
            trainer = new Trainer();
        }        

        return trainer;
    }

}
