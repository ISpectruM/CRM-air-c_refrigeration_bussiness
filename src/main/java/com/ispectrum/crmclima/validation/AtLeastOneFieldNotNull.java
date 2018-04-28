package com.ispectrum.crmclima.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AtLeastOneFieldNotNulValidator.class)
public @interface AtLeastOneFieldNotNull {
    String message() default "{com.xxx.constraints.checkatleastnotnull}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] fieldNames();
}
