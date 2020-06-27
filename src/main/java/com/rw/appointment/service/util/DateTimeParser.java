package com.rw.appointment.service.util;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeParser {

    public static LocalDateTime stringToLocalDateTime(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"); // uuuu-MM-dd'T'HH:mm
        return LocalDateTime.parse(dateTime, formatter);
    }

    public static LocalDate stringToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        return LocalDate.parse(date, formatter);
    }

    public static long durationToInt(Duration duration) {
        return duration.toMinutes();
    }
}
