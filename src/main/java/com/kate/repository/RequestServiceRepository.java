package com.kate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kate.domain.RequestService;
import com.kate.domain.RequestServiceId;

/**
 * Spring Data JPA repository for the Service entity.
 */
@SuppressWarnings("unused")
public interface RequestServiceRepository extends JpaRepository<RequestService,RequestServiceId> {

}
