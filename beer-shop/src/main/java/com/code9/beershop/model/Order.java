package com.code9.beershop.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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
	@ManyToMany(targetEntity = Beer.class)
	private List<Beer> beers;

}
