package com.rw.appointment.repository;

import com.rw.appointment.domain.TimeSlot;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TimeSlotRepository extends PagingAndSortingRepository<TimeSlot, Long> {
}
