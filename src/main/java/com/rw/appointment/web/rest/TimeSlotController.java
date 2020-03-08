package com.rw.appointment.web.rest;

import com.rw.appointment.service.TimeSlotService;
import com.rw.appointment.service.dto.NewTimeSlotDto;
import com.rw.appointment.service.dto.TimeSlotDto;
import com.rw.appointment.web.rest.validation.ValidUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated // @PathVariable Validation + ClientWebConfigJava
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
public class TimeSlotController {

    private TimeSlotService timeSlotService;

    @Autowired
    public TimeSlotController(TimeSlotService timeSlotService) {
        this.timeSlotService = timeSlotService;
    }

    @GetMapping(value = "/timeSlots/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TimeSlotDto findById(@PathVariable(value = "id") @ValidUuid String uuid) {
        return timeSlotService.findOne(uuid);
    }

    @GetMapping(value = "/timeSlots", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TimeSlotDto> findAllTimeSlots() {
        return timeSlotService.findAll();
    }

    @PostMapping(value = "/timeSlots", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TimeSlotDto createTimeSlots(@RequestBody @Valid NewTimeSlotDto newTimeSlotDto) {
        return timeSlotService.createNewTimeSlot(newTimeSlotDto);
    }

}
