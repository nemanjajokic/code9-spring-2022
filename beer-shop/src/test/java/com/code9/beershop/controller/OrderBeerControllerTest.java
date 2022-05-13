package com.code9.beershop.controller;

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
import com.code9.beershop.model.dto.CreateOrderDto;
import com.code9.beershop.service.OrderBeerService;
import com.code9.beershop.utils.TestUtil;

@WebMvcTest(OrderBeerController.class)
class OrderBeerControllerTest {
	private AutoCloseable closeable;

	private MockMvc mockMvc;

	@MockBean
	private OrderBeerService orderBeerService;

	private OrderBeerController orderBeerController;

	@BeforeEach
	final void setup() {
		closeable = MockitoAnnotations.openMocks(this);
		orderBeerController = new OrderBeerController(orderBeerService);
		mockMvc = MockMvcBuilders.standaloneSetup(orderBeerController).build();
	}

	@AfterEach
	public void releaseMocks() throws Exception {
		closeable.close();
	}

	@Test
	final void testSubmitOrder() throws Exception {
		String testName = "";
		CreateOrderDto createOrderDto = new CreateOrderDto(testName, "test street", "test city", "test state", "test zip", "test", "test", "test", 1L);
		mockMvc.perform(
			MockMvcRequestBuilders.post("/orders")
				.content(TestUtil.asJsonString(createOrderDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());
		testName = "test name";
		createOrderDto.setName(testName);
		mockMvc.perform(
			MockMvcRequestBuilders.post("/orders")
				.content(TestUtil.asJsonString(createOrderDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
	}
}