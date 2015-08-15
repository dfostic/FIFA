package com.dfostic.util;

import java.time.LocalDate;
import java.time.Period;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author DFostic1
 */
public class AgeValidator implements ConstraintValidator<ValidAge, LocalDate> {

    private int minAge;
    private int maxAge;

    public void initialize(ValidAge constraintAnnotation) {
        this.minAge = constraintAnnotation.min();
        this.maxAge = constraintAnnotation.max();
    }

    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        LocalDate now = LocalDate.now();
        Period period = Period.between(value, now);
        int age = period.getYears();

        if (age < minAge || age > maxAge)
            return false;
        else
            return true;
    }

}
