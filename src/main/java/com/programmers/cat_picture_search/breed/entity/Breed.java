package com.programmers.cat_picture_search.breed.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Breed {

  @Id
  private Long id;

  private String name;
  private String temperament;
  private String origin;

}
