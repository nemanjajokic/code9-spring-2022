package com.code9.beershop.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.code9.beershop.model.entity.Ingredient;
import com.code9.beershop.service.IngredientService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class IngredientControler {
	private final IngredientService ingredientService;

	@GetMapping
	public List<Ingredient> getAllIngredients() {
		return ingredientService.getAllIngredients();
	}

	@PostMapping
	public void storeIngrediants() {
		ingredientService.storeIngredients();
	}
}
