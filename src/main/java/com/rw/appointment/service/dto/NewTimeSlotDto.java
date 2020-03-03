package com.rw.appointment.service.dto;

import com.rw.appointment.web.rest.validation.ValidUuid;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewTimeSlotDto {

    @NotNull(message = "Pole timeSlotStart nie może być puste")
    @Size(min=19, max = 19, message = "Zła długość pola timeSlotStart")
    private String timeSlotStart;

    @NotNull(message = "Pole timeSlotLength nie może być puste")
    @Digits(integer=3, fraction=0, message = "Zła wartość pola timeSlotLength")
    private long timeSlotLength;

    @NotNull(message = "Pole timeSlotLength nie może być puste")
    @Size(min=6, max = 12, message = "Zła długość pola timeSlotStatus")
    private String timeSlotStatus;

    @NotNull(message = "Pole contractor nie może być puste")
    @ValidUuid(message = "Nieprawidłowa wartość pola contractor")
    private String contractor;

    public String getTimeSlotStart() {
        return timeSlotStart;
    }

    public NewTimeSlotDto setTimeSlotStart(String timeSlotStart) {
        this.timeSlotStart = timeSlotStart;
        return this;
    }

    public long getTimeSlotLength() {
        return timeSlotLength;
    }

    public NewTimeSlotDto setTimeSlotLength(long timeSlotLength) {
        this.timeSlotLength = timeSlotLength;
        return this;
    }

    public String getTimeSlotStatus() {
        return timeSlotStatus;
    }

    public NewTimeSlotDto setTimeSlotStatus(String timeSlotStatus) {
        this.timeSlotStatus = timeSlotStatus;
        return this;
    }

    public String getContractor() {
        return contractor;
    }

    public NewTimeSlotDto setContractor(String contractor) {
        this.contractor = contractor;
        return this;
    }

    @Override
    public String toString() {
        return "NewTimeSlotDto{" +
                "timeSlotStart='" + timeSlotStart + '\'' +
                ", timeSlotLength=" + timeSlotLength +
                ", timeSlotStatus='" + timeSlotStatus + '\'' +
                ", contractor=" + contractor +
                '}';
    }
}
