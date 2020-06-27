package com.rw.appointment.service.mapper;

import com.rw.appointment.domain.Address;
import com.rw.appointment.domain.TimeSlot;
import com.rw.appointment.domain.TimeSlotStatus;
import com.rw.appointment.domain.User;
import com.rw.appointment.repository.UserRepository;
import com.rw.appointment.service.dto.NewTimeSlotDto;
import com.rw.appointment.service.dto.TimeSlotDto;
import com.rw.appointment.service.util.DateTimeParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class TimeSlotsMapper {

    private static Logger logger = LoggerFactory.getLogger(TimeSlotsMapper.class);

    private UserRepository userRepository;

    public TimeSlotsMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public TimeSlot timeSlotDtoToTimeSlot(TimeSlotDto timeSlotDto) {
        logger.info("Mapping dto: {}", timeSlotDto);
        LocalDateTime timeSlotStart = null;
        LocalDateTime timeSlotEnd = null;
        if (timeSlotDto.getTimeSlotStart() != null) {
            timeSlotStart = DateTimeParser.stringToLocalDateTime(timeSlotDto.getTimeSlotStart());
        }
        if (timeSlotDto.getTimeSlotEnd() != null) {
            timeSlotEnd = DateTimeParser.stringToLocalDateTime(timeSlotDto.getTimeSlotEnd());
        }
        TimeSlotStatus timeSlotStatus = TimeSlotStatus.valueOf(timeSlotDto.getTimeSlotStatus().toUpperCase());
        //UUID contractorUuid = UUID.fromString(timeSlotDto.getContractor());
        User contractor = timeSlotDto.getContractor();
        User client = timeSlotDto.getClient();
        Address address = timeSlotDto.getAddress();
        String contractorComment = timeSlotDto.getContractorComment();
        String clientComment = timeSlotDto.getClientComment();

        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setTimeSlotStart(timeSlotStart);
        timeSlot.setTimeSlotEnd(timeSlotEnd);
        timeSlot.setTimeSlotStatus(timeSlotStatus);
        timeSlot.setContractor(contractor);
        timeSlot.setClient(client);
        timeSlot.setAddress(address);
        timeSlot.setContractorComment(contractorComment);
        timeSlot.setClientComment(clientComment);
        return timeSlot;
    }

    public TimeSlot newTimeSlotToTimeSlot(NewTimeSlotDto newTimeSlotDto) {
        LocalDateTime timeSlotStart = DateTimeParser.stringToLocalDateTime(newTimeSlotDto.getTimeSlotStart());
        LocalDateTime timeSlotEnd = DateTimeParser.stringToLocalDateTime(newTimeSlotDto.getTimeSlotEnd());
        TimeSlotStatus timeSlotStatus = TimeSlotStatus.valueOf(newTimeSlotDto.getTimeSlotStatus().toUpperCase());
        UUID contractorUuid = UUID.fromString(newTimeSlotDto.getContractor());
        User contractor = userRepository.findById(contractorUuid)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + newTimeSlotDto.getContractor()));
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setTimeSlotStart(timeSlotStart);
        timeSlot.setTimeSlotEnd(timeSlotEnd);
        timeSlot.setTimeSlotStatus(timeSlotStatus);
        timeSlot.setContractor(contractor);
        //contractor.ifPresent(timeSlot::setContractor);  //
        return timeSlot;
    }

    public TimeSlotDto timeSlotToTimeSlotDto(TimeSlot timeSlot) {
        return TimeSlotDto.TimeSlotDtoBuilder.aTimeSlotDto()
                .withId(timeSlot.getId())
                .withTimeSlotStart(timeSlot.getTimeSlotStart().toString())
                .withTimeSlotEnd(timeSlot.getTimeSlotEnd().toString())
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

    public Page<TimeSlotDto> timeSlotsToTimeSlotsDtoPage(Page<TimeSlot> timeSlots) {
        return timeSlots.map(this::timeSlotToTimeSlotDto);
    }
}
