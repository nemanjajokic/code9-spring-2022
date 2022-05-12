package com.code9.beershop.service;

import org.springframework.stereotype.Service;
import com.code9.beershop.model.Order;
import com.code9.beershop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderBeerService {
	private final OrderRepository orderRepository;

	public Order submitOrder(final Order order) {
		return orderRepository.save(order);
	}

}
