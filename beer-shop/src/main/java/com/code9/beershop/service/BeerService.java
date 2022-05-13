package com.code9.beershop.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.code9.beershop.mapper.BeerMapper;
import com.code9.beershop.model.dto.CreateBeerDto;
import com.code9.beershop.model.dto.GetBeerDto;
import com.code9.beershop.model.entity.Beer;
import com.code9.beershop.model.entity.Ingredient;
import com.code9.beershop.repository.BeerRepository;
import com.code9.beershop.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BeerService {

	private final BeerRepository beerRepository;
	private final IngredientRepository ingredientRepository;

	public List<GetBeerDto> getAllBeers() {
		List<GetBeerDto>responseList=new ArrayList<>();
		List<Beer> beers= beerRepository.findAll();
		beers.forEach(b->responseList.add(BeerMapper.mapBeerToGetBeerDto(b)));
		return responseList;
	}

	public GetBeerDto getBeerById(final Long id) {
		Beer beer= beerRepository.getById(id);
		return BeerMapper.mapBeerToGetBeerDto(beer);
	}

	public GetBeerDto saveBeer(final CreateBeerDto createBeerDto) {
		List<Ingredient> ingredients = ingredientRepository.findByIdIn(createBeerDto.getIngredientIds());
		Beer beer=BeerMapper.mapCreateBeerDtoToBeer(createBeerDto, ingredients);
		Beer storedBeer= beerRepository.save(beer);
		return BeerMapper.mapBeerToGetBeerDto(storedBeer);
	}

}
