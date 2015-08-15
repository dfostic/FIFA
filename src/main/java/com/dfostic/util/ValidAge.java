package com.dfostic.util;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author dfostic
 */

@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = AgeValidator.class)
@Documented
public @interface ValidAge {
    
    String message() default "This is custom made age validator. Please set age limits for validation";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

	int min() default 0;

	int max() default Integer.MAX_VALUE;

	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {

		ValidAge[] value();
	}
    
}
