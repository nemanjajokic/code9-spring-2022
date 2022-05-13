package com.code9.beershop.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import com.code9.beershop.repository.BeerRepository;
import com.code9.beershop.repository.IngredientRepository;

class BeerServiceTest {

	@Mock
	private BeerRepository beerRepository;
	@Mock
	private IngredientRepository ingredientRepository;

	private BeerService beerService;

	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
		beerService = new BeerService(beerRepository,ingredientRepository);
	}


}