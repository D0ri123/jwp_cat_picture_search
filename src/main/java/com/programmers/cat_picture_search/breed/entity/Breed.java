package com.programmers.cat_picture_search.breed.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Breed {

  @Id
  private String id;

  private String name;
  private String temperament;
  private String origin;

  @Builder
  public Breed(String id, String name, String temperament, String origin) {
    this.id = id;
    this.name = name;
    this.temperament = temperament;
    this.origin = origin;
  }

}
