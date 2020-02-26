package com.rw.appointment.controller.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UuidValidator.class)
public @interface ValidUuid {
    String message() default "{com.rw.UUID.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}