package com.code9.beershop.controller;

import com.code9.beershop.model.Order;
import com.code9.beershop.service.OrderBeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/orders")
public class OrderBeerController {

  @Autowired
  private OrderBeerService orderBeerService;

  @PostMapping
  public void orderBeer(@RequestBody final Order order) {
    orderBeerService.submitOrder(order);
  }

}
