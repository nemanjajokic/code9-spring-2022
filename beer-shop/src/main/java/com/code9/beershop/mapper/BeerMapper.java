package com.code9.beershop.mapper;

import java.util.ArrayList;
import java.util.List;
import com.code9.beershop.model.dto.CreateBeerDto;
import com.code9.beershop.model.dto.GetBeerDto;
import com.code9.beershop.model.entity.Beer;
import com.code9.beershop.model.entity.Ingredient;

public class BeerMapper {

	public static Beer mapCreateBeerDtoToBeer(CreateBeerDto createBeerDto, List<Ingredient> ingredients) {
		return new Beer(createBeerDto.getName(), ingredients);
	}

	public static List<Ingredient> mapIngredients(List<String> ingredients) {
		List<Ingredient> resultList = new ArrayList<>();
		ingredients.forEach(i -> {
			resultList.add(new Ingredient(i));
		});
		return resultList;
	}

	public static GetBeerDto mapBeerToGetBeerDto(final Beer beer) {
		return new GetBeerDto(beer.getId(),beer.getCreatedAt(), beer.getName(), beer.getIngredients());
	}
}
