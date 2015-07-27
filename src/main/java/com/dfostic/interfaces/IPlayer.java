package com.dfostic.interfaces;

import com.dfostic.beans.Player;
import com.dfostic.beans.Statistics;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Locale;

/**
 * @author dfostic
 */
public interface IPlayer {

    public enum Position {

        GOALKEEPER, DEFENDER, MIDFIELDER, FORWARD
    }

    public static String firstName = null;
    public static String lastName = null;
    public static LocalDate dateOfBirth = null;
    public static Locale country = null;
    public static Player.Position position = null;
    public static BigDecimal salary = null;
    public static Statistics statistics = null;
    public static Currency currency = null;

    public int getAge();

}
