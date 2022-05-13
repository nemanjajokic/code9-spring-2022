package com.code9.beershop.model.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateOrderDto {
	@NotEmpty
	private String name;
	@NotEmpty
	private String street;
	@NotEmpty
	private String city;
	@NotEmpty
	private String state;
	@NotEmpty
	private String zip;
	@NotEmpty
	private String creditCardNumber;
	@NotEmpty
	private String creditCardExpiration;
	@NotEmpty
	private String creditCardSecurityCode;
	@NotNull
	private Long beerId;
}
