package com.rw.appointment.service.mapper;

import com.rw.appointment.domain.TimeSlot;
import com.rw.appointment.domain.TimeSlotStatus;
import com.rw.appointment.domain.User;
import com.rw.appointment.repository.UserRepository;
import com.rw.appointment.service.dto.NewTimeSlotDto;
import com.rw.appointment.service.dto.TimeSlotDto;
import com.rw.appointment.service.util.DateTimeParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class TimeSlotsMapper {

    private UserRepository userRepository;

    @Autowired
    public TimeSlotsMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public TimeSlot newTimeSlotToTimeSlot(NewTimeSlotDto newTimeSlotDto) {
        LocalDateTime localDateTime = DateTimeParser.stringToLocalDateTime(newTimeSlotDto.getTimeSlotStart());
        TimeSlotStatus timeSlotStatus = TimeSlotStatus.valueOf(newTimeSlotDto.getTimeSlotStatus().toUpperCase());
        Duration timeSlotLength = Duration.ofMinutes(newTimeSlotDto.getTimeSlotLength());
        User contractor = userRepository.findById(newTimeSlotDto.getContractor()).orElseThrow(() -> new IllegalArgumentException("User not found: " + newTimeSlotDto.getContractor()));
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setTimeSlotStart(localDateTime);
        timeSlot.setTimeSlotStatus(timeSlotStatus);
        timeSlot.setTimeSlotLength(timeSlotLength);
        timeSlot.setContractor(contractor);
        //contractor.ifPresent(timeSlot::setContractor);  //
        return timeSlot;
    }

    public TimeSlotDto timeSlotToTimeSlotDto(TimeSlot timeSlot) {
        return TimeSlotDto.TimeSlotDtoBuilder.aTimeSlotDto()
                .withId(timeSlot.getId())
                .withTimeSlotStart(timeSlot.getTimeSlotStart().toString())
                .withTimeSlotEnd(timeSlot.getTimeSlotStart().plusSeconds(timeSlot.getTimeSlotLength().getSeconds()).toString())
                .withTimeSlotStatus(timeSlot.getTimeSlotStatus().toString())
                .withContractor(timeSlot.getContractor())
                .withClient(timeSlot.getClient())
                .withAddress(timeSlot.getAddress())
                .withContractorComment(timeSlot.getContractorComment())
                .withClientComment(timeSlot.getClientComment())
                .withCreatedDate(LocalDateTime.ofInstant(Instant.ofEpochMilli(timeSlot.getCreatedDate()), TimeZone.getDefault().toZoneId()).toString())
                .withModifiedDate(LocalDateTime.ofInstant(Instant.ofEpochMilli(timeSlot.getModifiedDate()), TimeZone.getDefault().toZoneId()).toString())
                .build();
    }

    public List<TimeSlotDto> timeSlotsToTimeSlotsDto(Iterable<TimeSlot> timeSlots) {
        return StreamSupport.stream(timeSlots.spliterator(), false)
                .map(this::timeSlotToTimeSlotDto)
                .collect(Collectors.toList());
    }
}
