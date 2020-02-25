package com.rw.appointment.service.dto;

import com.rw.appointment.domain.User;

import java.util.UUID;

public class NewTimeSlotDto {

    private String timeSlotStart;
    private long timeSlotLength;
    private String timeSlotStatus;
    private UUID contractor;

    public NewTimeSlotDto() {
    }

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

    public UUID getContractor() {
        return contractor;
    }

    public NewTimeSlotDto setContractor(UUID contractor) {
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
