package com.rw.appointment.domain.errors;

public class TimeSlotResourceException extends RuntimeException {
    public TimeSlotResourceException(String message) {
        super(message);
    }
}
