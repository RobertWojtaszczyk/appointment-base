package com.rw.appointment.web.rest;

import com.rw.appointment.service.TimeSlotService;
import com.rw.appointment.service.dto.NewTimeSlotDto;
import com.rw.appointment.service.dto.TimeSlotDto;
import com.rw.appointment.web.rest.validation.ValidUuid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api")
@Validated // @PathVariable Validation + ClientWebConfigJava
@CrossOrigin( origins = "*" ) //@CrossOrigin(origins = "http://localhost:4200", allowedHeadres="*")  //     @CrossOrigin( origins = "*" )
public class TimeSlotController {

    private TimeSlotService timeSlotService;
    private static Logger logger = LoggerFactory.getLogger(TimeSlotController.class);

    public TimeSlotController(TimeSlotService timeSlotService) {
        this.timeSlotService = timeSlotService;
    }

    @GetMapping(value = "/timeSlots/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TimeSlotDto findById(@PathVariable(value = "id") @ValidUuid String uuid) throws InterruptedException {
        logger.info("Looking for TimeSlot id: {}", uuid);
        TimeUnit.SECONDS.sleep(1); // simulate delay
        return timeSlotService.findOne(uuid);
    }

    @GetMapping(value = "/timeSlots", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<TimeSlotDto> findTimeSlots(@RequestParam(required = false) String date,
                                           @RequestParam(required = false, defaultValue = "0") Integer page) {
       // if (date == null) {
       //     logger.info("Looking for all TimeSlots");
       //     return timeSlotService.findAll();
       // } else {
            logger.info("Looking for TimeSlots by date {} and page {}", date, page);

            return timeSlotService.findAllByDate(date, page != null ? page : 0);
        //}
    }

    @GetMapping(value = "/timeSlots/date/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<TimeSlotDto> findAllTimeSlotsByDate(@PathVariable(value = "date") String date,
                                                    @RequestParam(required = false) Integer page) {
        logger.info("Looking for TimeSlots by date {}", date);
        return timeSlotService.findAllByDate(date, page != null ? page : 0);
    }

    @PostMapping(value = "/timeSlots", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TimeSlotDto createTimeSlots(@RequestBody @Valid NewTimeSlotDto newTimeSlotDto) {
        logger.info("Creating new TimeSlot: {}", newTimeSlotDto);
        return timeSlotService.createNewTimeSlot(newTimeSlotDto);
    }

    @PatchMapping(value = "/timeSlots/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TimeSlotDto updateTimeSlots(@PathVariable(value = "id") @ValidUuid String uuid, @RequestBody @Valid TimeSlotDto timeSlotDto) {
        logger.info("Updating TimeSlot {} with new data: {}", uuid, timeSlotDto);
        return timeSlotService.updateTimeSlot(uuid, timeSlotDto);
    }

    @DeleteMapping(value = "/timeSlots/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TimeSlotDto deleteTimeSlot(@PathVariable(value = "id") @ValidUuid String uuid) {
        logger.info("Deleting TimeSlot id: {}", uuid);
        return timeSlotService.deleteTimeSlot(uuid);
    }
}
