package com.code9.beershop.model.dto;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateBeerDto {
	@NotBlank
	@NotNull
	String name;
	@NotEmpty
	List<Long> ingredientIds;
}
