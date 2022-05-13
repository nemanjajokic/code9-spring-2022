package com.code9.beershop.model.dto;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBeerDto {
	@NotEmpty(message = "Name must not be empty.")
	String name;
	@NotEmpty(message = "IngredientIds must not be empty.")
	List<Long> ingredientIds;
}
