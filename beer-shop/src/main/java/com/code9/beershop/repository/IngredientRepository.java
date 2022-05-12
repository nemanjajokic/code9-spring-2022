package com.code9.beershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.code9.beershop.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {
}
