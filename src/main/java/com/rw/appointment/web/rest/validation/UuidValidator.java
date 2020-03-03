package com.rw.appointment.web.rest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UuidValidator implements ConstraintValidator<ValidUuid, String> {

    @Override
    public void initialize(ValidUuid validUuid) {
    }

    @Override
    public boolean isValid(String uuid, ConstraintValidatorContext cxt) {
        String regex = "[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[34][0-9a-fA-F]{3}-[89ab][0-9a-fA-F]{3}-[0-9a-fA-F]{12}";
        return uuid != null && !uuid.isEmpty() && uuid.matches(regex);
    }
}
