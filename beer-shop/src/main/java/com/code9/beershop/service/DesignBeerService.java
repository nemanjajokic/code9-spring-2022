package com.code9.beershop.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.code9.beershop.model.Beer;
import com.code9.beershop.model.Ingredient;
import com.code9.beershop.repository.BeerRepository;
import com.code9.beershop.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DesignBeerService {

	private final BeerRepository beerRepository;
	private final IngredientRepository ingredientRepository;

	public List<Beer> getAllBeers() {
		return beerRepository.findAll();
	}

	public Beer getBeerById(final Long id) {
		return beerRepository.getById(id);
	}

	public Beer saveBeer(final Beer beer) {
		List<Ingredient> ingredients = beer.getIngredients();
		ingredientRepository.saveAll(ingredients);
		return beerRepository.save(beer);
	}

}
