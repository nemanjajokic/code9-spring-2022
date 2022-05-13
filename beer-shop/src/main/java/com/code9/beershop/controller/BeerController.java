package com.code9.beershop.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.code9.beershop.exception.NotFoundException;
import com.code9.beershop.model.dto.CreateBeerDto;
import com.code9.beershop.model.dto.GetBeerDto;
import com.code9.beershop.model.entity.Beer;
import com.code9.beershop.service.BeerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/beers")
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "http://localhost:4200")
public class BeerController {
	private final BeerService beerService;

	@GetMapping
	public List<GetBeerDto> getAllBeers() {
		return beerService.getAllBeers();
	}

	@GetMapping("/{id}")
	public GetBeerDto getBeerById(@NotEmpty @PathVariable("id") final Long id) {
		try {
			return beerService.getBeerById(id);
		} catch (NotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Design not found", ex);
		}
	}

	@PostMapping
	public GetBeerDto saveBeer(@Valid @RequestBody final CreateBeerDto beerDto) {
		return beerService.saveBeer(beerDto);
	}

}
