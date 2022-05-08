package com.code9.beershop.service;

import com.code9.beershop.model.Beer;
import com.code9.beershop.model.Order;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class OrderBeerService {

  @Autowired
  private DesignBeerService designBeerService;

  private List<Order> orders = new ArrayList<>();

  public void submitOrder(final Order order) {
    order.setBeers(designBeerService.getAllBeers());
    orders.add(order);
    log.info(format("Order submitted: %s", order));
  }

}
