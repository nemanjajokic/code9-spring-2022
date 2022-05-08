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
public class Order {

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

  private List<Beer> beers;

}
