package com.rw.appointment.service;

import com.rw.appointment.domain.TimeSlot;
import com.rw.appointment.domain.errors.TimeSlotResourceException;
import com.rw.appointment.repository.TimeSlotRepository;
import com.rw.appointment.service.dto.NewTimeSlotDto;
import com.rw.appointment.service.dto.TimeSlotDto;
import com.rw.appointment.service.mapper.TimeSlotsMapper;
import com.rw.appointment.service.util.DateTimeParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
public class TimeSlotService {
    public static final int PAGE_SIZE = 5;
    private static Logger logger = LoggerFactory.getLogger(TimeSlotService.class);

    private TimeSlotRepository timeSlotRepository;
    private TimeSlotsMapper timeSlotsMapper;

    public TimeSlotService(TimeSlotRepository timeSlotRepository, TimeSlotsMapper timeSlotsMapper) {
        this.timeSlotRepository = timeSlotRepository;
        this.timeSlotsMapper = timeSlotsMapper;
    }

    public TimeSlotDto createNewTimeSlot(NewTimeSlotDto newTimeSlotDto) {
        logger.info("Creating new TimeSlot: {}", newTimeSlotDto);
        return timeSlotsMapper.timeSlotToTimeSlotDto(timeSlotRepository.save(timeSlotsMapper.newTimeSlotToTimeSlot(newTimeSlotDto)));
    }

    public List<TimeSlotDto> findAll() {
        return timeSlotsMapper.timeSlotsToTimeSlotsDto(timeSlotRepository.findAll());
    }

    public Page<TimeSlotDto> findAllByDate(String date, int page) {
        // TODO validate page
        LocalDate startDate = DateTimeParser.stringToLocalDate(date);
        int pageNumber = Math.max(page, 0);
        return timeSlotsMapper
                .timeSlotsToTimeSlotsDtoPage(timeSlotRepository
                        .findAllByDate(startDate.atStartOfDay(), startDate.atTime(23, 59, 59), PageRequest.of(pageNumber, PAGE_SIZE)));
    }

    public TimeSlotDto findOne(String id) {
        UUID uuid = UUID.fromString(id);
        return timeSlotRepository.findById(uuid)
                .map(timeSlotsMapper::timeSlotToTimeSlotDto)
                .orElseThrow(()-> new TimeSlotResourceException("TimeSlot not found: " + uuid));
    }

    public TimeSlot findById(String id) {
        UUID uuid = UUID.fromString(id);
        return timeSlotRepository.findById(uuid)
                .orElseThrow(()-> new TimeSlotResourceException("TimeSlot not found: " + uuid));
    }

    public TimeSlotDto updateTimeSlot(String uuid, TimeSlotDto timeSlotDto) {
        TimeSlot timeSlot = findById(uuid);
        return timeSlotsMapper.timeSlotToTimeSlotDto(updateTimeSlot(timeSlot, timeSlotsMapper.timeSlotDtoToTimeSlot(timeSlotDto)));
    }

    private TimeSlot updateTimeSlot(TimeSlot timeSlot, TimeSlot update) {
        logger.info("Original timeSlot: {}", timeSlot);
        logger.info("Update: {}", update);

        if (update.getTimeSlotStart() != null) {
            timeSlot.setTimeSlotStart(update.getTimeSlotStart());
        }
        if (update.getTimeSlotEnd() != null) {
            timeSlot.setTimeSlotEnd(update.getTimeSlotEnd());
        }
        if (update.getTimeSlotStatus() != null) {
            timeSlot.setTimeSlotStatus(update.getTimeSlotStatus());
        }
        if (update.getContractor() != null) {
            timeSlot.setContractor(update.getContractor());
        }
        if (update.getClient() != null) {
            timeSlot.setClient(update.getClient());
        }
        if (update.getAddress() != null) {
            timeSlot.setAddress(update.getAddress());
        }
        if (update.getContractorComment() != null) {
            timeSlot.setContractorComment(update.getContractorComment());
        }
        if (update.getClientComment() != null) {
            timeSlot.setClientComment(update.getClientComment());
        }
        logger.info("Updated timeSlot: {}", timeSlot);
        return timeSlotRepository.save(timeSlot);
    }

    public TimeSlotDto deleteTimeSlot(String uuid) {
        TimeSlot timeSlot = findById(uuid);
        TimeSlotDto timeSlotDto = TimeSlotDto.TimeSlotDtoBuilder.aTimeSlotDto()
                .withTimeSlotStatus("DELETED")
                .build();
        return timeSlotsMapper.timeSlotToTimeSlotDto(updateTimeSlot(timeSlot, timeSlotsMapper.timeSlotDtoToTimeSlot(timeSlotDto)));
    }


}
