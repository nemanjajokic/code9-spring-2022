package com.code9.beershop.controller;

import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.code9.beershop.model.Order;
import com.code9.beershop.service.OrderBeerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Validated
public class OrderBeerController {

	private final OrderBeerService orderBeerService;

	@PostMapping
	public void orderBeer(@Valid @RequestBody final Order order) {
		orderBeerService.submitOrder(order);
	}

}
