package com.code9.beershop.model.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Beer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private LocalDateTime createdAt;

	private String name;
	@ManyToMany(targetEntity = Ingredient.class)
	private List<Ingredient> ingredients;

	@PrePersist
	void createdAt() {
		this.createdAt = LocalDateTime.now();
	}

	public Beer(final String name, final List<Ingredient> ingredients) {
		this.name = name;
		this.ingredients = ingredients;
	}
}
