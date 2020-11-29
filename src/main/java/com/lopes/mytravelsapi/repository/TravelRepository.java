package com.lopes.mytravelsapi.repository;

import com.lopes.mytravelsapi.repository.model.Travel;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * The interface Travel repository.
 */
public interface TravelRepository extends PagingAndSortingRepository<Travel, Long> {
}