package com.code9.beershop.mapper;

import com.code9.beershop.model.dto.CreateOrderDto;
import com.code9.beershop.model.entity.Beer;
import com.code9.beershop.model.entity.Order;

public class OrderMapper {

	public static Order mapCreateOrderDtoToOrder(CreateOrderDto createOrderDto, Beer beer) {
		return new Order(createOrderDto.getName(), createOrderDto.getStreet(), createOrderDto.getCity(), createOrderDto.getState(), createOrderDto.getZip(),
			createOrderDto.getCreditCardNumber(), createOrderDto.getCreditCardExpiration(), createOrderDto.getCreditCardSecurityCode(), beer);
	}
}
