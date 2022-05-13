package com.code9.beershop.service;

import org.springframework.stereotype.Service;
import com.code9.beershop.mapper.OrderMapper;
import com.code9.beershop.model.dto.CreateOrderDto;
import com.code9.beershop.model.entity.Beer;
import com.code9.beershop.model.entity.Order;
import com.code9.beershop.repository.BeerRepository;
import com.code9.beershop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderBeerService {
	private final OrderRepository orderRepository;
	private final BeerRepository beerRepository;

	public Order submitOrder(final CreateOrderDto createOrderDto) {
		Beer beer = beerRepository.getById(createOrderDto.getBeerId());
		Order order = OrderMapper.mapCreateOrderDtoToOrder(createOrderDto, beer);
		return orderRepository.save(order);
	}

}
