package com.programmers.cat_picture_search.image.entity;

import static jakarta.persistence.FetchType.*;

import com.programmers.cat_picture_search.breed.entity.Breed;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Image {

  @Id
  private Long id;

  private String url;

  /**
   * 이미지 너비
   */
  private Long width;

  /**
   * 이미지 높이
   */
  private Long height;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "breed_id")
  private Breed breed;
}
