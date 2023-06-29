package com.programmers.cat_picture_search.feign.cat.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class CatImage {

  /**
   * 이미지의 String 아이디.
   */
  private String id;

  /**
   * 이미지 너비.
   */
  private Long width;

  /**
   * 이미지 높이.
   */
  private Long height;

  /**
   * 이미지 url.
   */
  private String url;

  private List<BreedDto> breeds;

  @Getter
  public static class BreedDto {
    private String id;
    private String name;
    private String temperament;
    private String origin;
  }

}
