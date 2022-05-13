package com.code9.beershop.model.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.code9.beershop.model.entity.Beer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="beer_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private LocalDateTime placedAt = LocalDateTime.now();

	private String name;

	private String street;

	private String city;

	private String state;

	private String zip;

	private String creditCardNumber;

	private String creditCardExpiration;

	private String creditCardSecurityCode;
	@ManyToOne(targetEntity = Beer.class)
	private Beer beer;

	public Order(final String name, final String street, final String city, final String state, final String zip, final String creditCardNumber,
		final String creditCardExpiration,
		final String creditCardSecurityCode, final Beer beer) {
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.creditCardNumber = creditCardNumber;
		this.creditCardExpiration = creditCardExpiration;
		this.creditCardSecurityCode = creditCardSecurityCode;
		this.beer = beer;
	}
}
