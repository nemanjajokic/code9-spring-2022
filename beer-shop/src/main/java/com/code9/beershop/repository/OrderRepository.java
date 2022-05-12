package com.code9.beershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.code9.beershop.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
