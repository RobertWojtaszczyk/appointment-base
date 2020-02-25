package com.rw.appointment.repository;

import com.rw.appointment.domain.Address;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {
}
