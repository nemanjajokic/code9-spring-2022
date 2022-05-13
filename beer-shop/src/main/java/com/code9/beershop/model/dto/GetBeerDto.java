package com.code9.beershop.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import com.code9.beershop.model.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBeerDto {
	private Long id;
	private LocalDateTime createdAt;
	private String name;
	private List<Ingredient> ingredients;
}
