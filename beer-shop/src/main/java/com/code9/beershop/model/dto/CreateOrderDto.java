package com.code9.beershop.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDto {
	@NotEmpty(message = "Name must not be empty.")
	private String name;
	@NotEmpty(message = "Street must not be empty.")
	private String street;
	@NotEmpty(message = "City must not be empty.")
	private String city;
	@NotEmpty(message = "State must not be empty.")
	private String state;
	@NotEmpty(message = "Zip must not be empty.")
	private String zip;
	@NotEmpty(message = "Credit card number must not be empty.")
	private String creditCardNumber;
	@NotEmpty(message = "Credit card expiration must not be empty.")
	private String creditCardExpiration;
	@NotEmpty(message = "Credit card security code must not be empty.")
	private String creditCardSecurityCode;
	@NotNull(message = "Beer id must not be null.")
	private Long beerId;
}
