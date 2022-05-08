package com.code9.beershop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ingredient {

  private String id;

  private String name;

  private IngredientType type;

}
