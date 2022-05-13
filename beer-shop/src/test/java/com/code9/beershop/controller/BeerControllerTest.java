package com.code9.beershop.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.LocalDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.code9.beershop.exception.NotFoundException;
import com.code9.beershop.model.dto.CreateBeerDto;
import com.code9.beershop.model.dto.GetBeerDto;
import com.code9.beershop.model.entity.Ingredient;
import com.code9.beershop.service.BeerService;
import com.code9.beershop.utils.TestUtil;

@WebMvcTest(BeerController.class)
class BeerControllerTest {
	private AutoCloseable closeable;

	private MockMvc mockMvc;

	@MockBean
	private BeerService beerService;

	private BeerController beerController;

	@BeforeEach
	final void setup() {
		closeable = MockitoAnnotations.openMocks(this);
		beerController = new BeerController(beerService);
		mockMvc = MockMvcBuilders.standaloneSetup(beerController).build();
	}

	@AfterEach
	public void releaseMocks() throws Exception {
		closeable.close();
	}

	@Test()
	final void testGetAllBeers() throws Exception {
		mockMvc.perform(get("/beers")).andExpect(status().isOk());
		verify(beerService).getAllBeers();
	}

	@Test()
	final void testGetBeerById() throws Exception {
		when(beerService.getBeerById(2L)).thenThrow(new NotFoundException("Not found"));
		mockMvc.perform(get("/beers/{id}", 2L)).andExpect(status().isNotFound());

		when(beerService.getBeerById(4L)).thenReturn(new GetBeerDto(1L, LocalDateTime.now(), "Tets beer", Arrays.asList(new Ingredient())));
		mockMvc.perform(get("/beers/{id}", 4L)).andExpect(status().isOk());
		verify(beerService).getBeerById(4L);
	}

	@Test
	final void testSaveBeeer() throws Exception {
		CreateBeerDto createBeerDto = new CreateBeerDto(null, Arrays.asList(1L, 2L, 3L));
		mockMvc.perform(
			MockMvcRequestBuilders.post("/beers")
				.content(TestUtil.asJsonString(createBeerDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());

		createBeerDto = new CreateBeerDto("Test beer", Arrays.asList(1L, 2L, 3L));
		mockMvc.perform(
			MockMvcRequestBuilders.post("/beers")
				.content(TestUtil.asJsonString(createBeerDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
	}
}