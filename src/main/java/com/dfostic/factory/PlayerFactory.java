package com.dfostic.factory;

import com.dfostic.beans.Player;
import com.dfostic.beans.Statistics;
import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;

/**
 *
 * @author DFostic1
 */
public class PlayerFactory {

    public Player getPlayer(String firstName, String lastName) {
        Player player = null;

        if (firstName.equals("Nicolas") && lastName.equals("Douchez")) {
            player = new Player(firstName, lastName, LocalDate.of(1980, Month.APRIL, 22), Locale.FRANCE, Player.Position.GOALKEEPER, 1440000, new Statistics());
        } else if (firstName.equals("Thiago") && lastName.equals("Silva")) {
            player = new Player(firstName, lastName, LocalDate.of(1984, Month.SEPTEMBER, 22), new Locale("pt_BR", "Brazil"), Player.Position.DEFENDER, 12000000, new Statistics(4, 1));
        } else if (firstName.equals("Benjamin") && lastName.equals("Stambouli")) {
            player = new Player(firstName, lastName, LocalDate.of(1990, Month.AUGUST, 13), Locale.FRANCE, Player.Position.MIDFIELDER, 1711667, new Statistics(5, 2));
        }

        return player;
    }

}
