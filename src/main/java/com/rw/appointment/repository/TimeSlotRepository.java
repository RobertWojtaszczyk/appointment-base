package com.rw.appointment.repository;

import com.rw.appointment.domain.TimeSlot;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface TimeSlotRepository extends PagingAndSortingRepository<TimeSlot, UUID> {
}
