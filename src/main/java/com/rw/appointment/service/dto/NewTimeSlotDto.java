package com.rw.appointment.service.dto;

public class NewTimeSlotDto {

    private String timeSlotStart;
    private long timeSlotLength;
    private String timeSlotStatus;

    public NewTimeSlotDto() {
    }

    public NewTimeSlotDto(String timeSlotStart, int timeSlotLength, String timeSlotStatus) {
        this.timeSlotStart = timeSlotStart;
        this.timeSlotLength = timeSlotLength;
        this.timeSlotStatus = timeSlotStatus;
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

    @Override
    public String toString() {
        return "NewTimeSlotDto{" +
                "timeSlotStart='" + timeSlotStart + '\'' +
                ", timeSlotLength='" + timeSlotLength + '\'' +
                ", timeSlotStatus='" + timeSlotStatus + '\'' +
                '}';
    }
}
