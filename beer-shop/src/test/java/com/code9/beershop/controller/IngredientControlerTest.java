package com.code9.beershop.controller;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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
import com.code9.beershop.service.IngredientService;

@WebMvcTest(IngredientControler.class)
class IngredientControlerTest {
	private AutoCloseable closeable;

	private MockMvc mockMvc;

	@MockBean
	private IngredientService ingredientService;

	private IngredientControler ingredientControler;

	@BeforeEach
	final void setup() {
		closeable = MockitoAnnotations.openMocks(this);
		ingredientControler = new IngredientControler(ingredientService);
		mockMvc = MockMvcBuilders.standaloneSetup(ingredientControler).build();
	}

	@AfterEach
	public void releaseMocks() throws Exception {
		closeable.close();
	}

	@Test()
	final void testGetAllIngredients() throws Exception {
		mockMvc.perform(get("/ingredients")).andExpect(status().isOk());
		verify(ingredientService).getAllIngredients();
	}

	@Test
	final void testStoreIngredients() throws Exception {
		mockMvc.perform(
			MockMvcRequestBuilders.post("/ingredients")
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
		verify(ingredientService).storeIngredients();
	}
}