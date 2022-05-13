package com.code9.beershop.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import com.code9.beershop.model.entity.Ingredient;
import com.code9.beershop.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IngredientService {

	private final IngredientRepository ingredientRepository;

	public List<Ingredient> getAllIngredients() {
		return ingredientRepository.findAll();
	}

	public void storeIngredients() {
		List<Ingredient> dummyIngredients = Arrays.asList(new Ingredient("Rye"), new Ingredient("Oat"),
			new Ingredient("Wheat"), new Ingredient("Agnus Hops"), new Ingredient("Beata Hops"),
			new Ingredient("Brewers Gold Hops"), new Ingredient("Ale yeast"),
			new Ingredient("Lager yeast"), new Ingredient("Distilled water"),
			new Ingredient("Tap water"), new Ingredient("Grapefruit"),
			new Ingredient("Lime"), new Ingredient("Orange"));
		ingredientRepository.saveAll(dummyIngredients);
	}

}
