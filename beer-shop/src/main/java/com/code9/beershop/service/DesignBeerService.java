package com.code9.beershop.service;

import com.code9.beershop.exception.NotFoundException;
import com.code9.beershop.model.Beer;
import com.code9.beershop.model.Ingredient;
import com.code9.beershop.model.IngredientType;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class DesignBeerService {

  private List<Beer> beers = List.of(
      Beer.builder()
          .id(101L)
          .createdAt(LocalDateTime.now())
          .name("Caiman")
          .ingredients(List.of(Ingredient.builder()
              .id("AYE")
              .name("Ale yeast")
              .type(IngredientType.YEAST)
              .build()))
          .build(),
      Beer.builder()
          .id(102L)
          .createdAt(LocalDateTime.now())
          .name("Salto")
          .ingredients(List.of(Ingredient.builder()
              .id("LYE")
              .name("Lager yeast")
              .type(IngredientType.YEAST)
              .build()))
          .build()
  );

  public List<Beer> getAllBeers() {
    return getBeers();
  }

  public Beer getBeerById(final Long id) {
    return getBeer(id);
  }

  public Beer saveBeer(final Beer beer) {
    return addBeer(beer);
  }

  private Beer getBeer(final Long id) {
    return beers.stream()
        .filter(beer -> id.equals(beer.getId()))
        .findAny()
        .orElseThrow(() -> new NotFoundException(format("Design for id: %s not found", id)));
  }

  private List<Beer> getBeers() {
    return beers;
  }

  private Beer addBeer(final Beer beer) {
    beers.add(beer);
    return beer;
  }

}
