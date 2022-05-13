package com.code9.beershop.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.code9.beershop.model.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {

	public List<Ingredient> findByIdIn(List<Long> ids);
}
