package com.dfostic.interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

/**
 * @author dfostic
 */
public interface ITrainer {

    public static String firstName = null;
    public static String lastName = null;
    public static LocalDate dateOfBirth = null;
    public static BigDecimal salary = null;
    public static Currency currency = null;

    public int getAge();

}
