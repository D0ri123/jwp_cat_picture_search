package com.programmers.cat_picture_search.image.dto.response;

import com.programmers.cat_picture_search.image.entity.Image;
import lombok.Getter;

@Getter
public class ImageInfoDto {

  /**
   * 고양이 품종 이름.
   */
  private final String name;

  /**
   * 고양이 사진 Id.
   */
  private final String id;

  /**
   * 고양이 사진 url.
   */
  private final String url;

  /**
   * 고양이 사진 width.
   */
  private final Long width;

  /**
   * 고양이 사진 height.
   */
  private final Long height;

  /**
   * 고양이 성격.
   */
  private final String temperament;

  /**
   * 고양이 출신지.
   */
  private final String origin;

  public ImageInfoDto(Image image) {
    this.name = image.getBreed().getName();
    this.id = image.getId();
    this.url = image.getUrl();
    this.width = image.getWidth();
    this.height = image.getHeight();
    this.temperament = image.getBreed().getTemperament();
    this.origin = image.getBreed().getOrigin();
  }
}

