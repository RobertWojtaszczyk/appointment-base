package com.rw.appointment.service;

import com.rw.appointment.domain.TimeSlot;
import com.rw.appointment.repository.TimeSlotRepository;
import com.rw.appointment.service.dto.NewTimeSlotDto;
import com.rw.appointment.service.dto.TimeSlotDto;
import com.rw.appointment.service.mapper.TimeSlotsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimeSlotService {

    private TimeSlotRepository timeSlotRepository;
    private TimeSlotsMapper timeSlotsMapper;

    @Autowired
    public TimeSlotService(TimeSlotRepository timeSlotRepository, TimeSlotsMapper timeSlotsMapper) {
        this.timeSlotRepository = timeSlotRepository;
        this.timeSlotsMapper = timeSlotsMapper;
    }

    public TimeSlotDto createNewTimeSlot(NewTimeSlotDto newTimeSlotDto) {
        return timeSlotsMapper.timeSlotToTimeSlotDto(timeSlotRepository.save(timeSlotsMapper.newTimeSlotToTimeSlot(newTimeSlotDto)));
    }

    public List<TimeSlotDto> findAll() {
        return timeSlotsMapper.timeSlotsToTimeSlotsDto(timeSlotRepository.findAll());
    }
}
