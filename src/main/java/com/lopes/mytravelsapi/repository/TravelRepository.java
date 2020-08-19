package com.lopes.mytravelsapi.repository;

import com.lopes.mytravelsapi.repository.model.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRepository extends JpaRepository<Travel, Long> {
}
