package com.rw.appointment.web.rest;

import com.rw.appointment.service.TimeSlotService;
import com.rw.appointment.service.dto.NewTimeSlotDto;
import com.rw.appointment.service.dto.TimeSlotDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TimeSlotController {

    private TimeSlotService timeSlotService;

    @Autowired
    public TimeSlotController(TimeSlotService timeSlotService) {
        this.timeSlotService = timeSlotService;
    }

    @PostMapping(value = "/timeSlots", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TimeSlotDto createTimeSlots(@RequestBody @Valid NewTimeSlotDto newTimeSlotDto) {
        return timeSlotService.createNewTimeSlot(newTimeSlotDto);
    }

    @GetMapping(value = "/timeSlots", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TimeSlotDto> findAllTimeSlots() {
        return timeSlotService.findAll();
    }

}