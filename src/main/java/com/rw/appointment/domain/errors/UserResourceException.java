package com.rw.appointment.domain.errors;

public class UserResourceException extends RuntimeException {
    public UserResourceException(String message) {
        super(message);
    }
}

