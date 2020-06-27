package com.rw.appointment.repository;

import com.rw.appointment.domain.TimeSlot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.UUID;

public interface TimeSlotRepository extends PagingAndSortingRepository<TimeSlot, UUID> {

    @Query("select ts from TimeSlot ts where ts.timeSlotStart between :date and :ceilDate")
    Page<TimeSlot> findAllByDate(@Param("date") LocalDateTime date, @Param("ceilDate") LocalDateTime ceilDate, Pageable page);

}
