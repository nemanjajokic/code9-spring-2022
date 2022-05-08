package com.code9.beershop.controller;

import com.code9.beershop.exception.NotFoundException;
import com.code9.beershop.model.Beer;
import com.code9.beershop.service.DesignBeerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v1/design")
public class DesignBeerController {

  // http://localhost:8080/swagger-ui.html

  @Autowired
  private DesignBeerService designBeerService;

  @GetMapping
  public List<Beer> getAllBeers() {
    return designBeerService.getAllBeers();
  }

  @GetMapping("/{id}")
  public Beer getBeerById(@PathVariable("id") final Long id) {
    try {
      return designBeerService.getBeerById(id);
    } catch (NotFoundException ex) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Design not found", ex);
    }
  }

  @PostMapping
  public Beer saveBeer(@RequestBody final Beer beer) {
    return designBeerService.saveBeer(beer);
  }

}
