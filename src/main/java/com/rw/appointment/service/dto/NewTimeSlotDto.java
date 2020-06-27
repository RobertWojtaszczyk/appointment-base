package com.rw.appointment.service.dto;

import com.rw.appointment.web.rest.validation.ValidUuid;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewTimeSlotDto {

    @NotNull(message = "Pole timeSlotStart nie może być puste")
    @Size(min=16, max = 19, message = "Zła długość pola timeSlotStart")
    private String timeSlotStart;

    @NotNull(message = "Pole timeSlotLength nie może być puste")
    @Size(min=16, max = 19, message = "Zła długość pola timeSlotStart")
    private String timeSlotEnd;

    @NotNull(message = "Pole timeSlotStatus nie może być puste")
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

    public String getTimeSlotEnd() {
        return timeSlotEnd;
    }

    public NewTimeSlotDto setTimeSlotEnd(String timeSlotEnd) {
        this.timeSlotEnd = timeSlotEnd;
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
                ", timeSlotEnd=" + timeSlotEnd +
                ", timeSlotStatus='" + timeSlotStatus + '\'' +
                ", contractor=" + contractor +
                '}';
    }
}
