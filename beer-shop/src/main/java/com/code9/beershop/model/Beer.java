package com.code9.beershop.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Beer {

  private Long id;

  private LocalDateTime createdAt;

  private String name;

  private List<Ingredient> ingredients;

}
