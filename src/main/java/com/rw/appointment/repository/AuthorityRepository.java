package com.rw.appointment.repository;

import com.rw.appointment.domain.Authority;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorityRepository extends PagingAndSortingRepository<Authority, String> {
}
