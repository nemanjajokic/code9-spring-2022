package com.code9.beershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.code9.beershop.model.Beer;

public interface BeerRepository extends JpaRepository<Beer, Long> {
}