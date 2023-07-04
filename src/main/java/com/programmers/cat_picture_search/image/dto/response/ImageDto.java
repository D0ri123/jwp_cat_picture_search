package com.programmers.cat_picture_search.image.dto.response;

import com.programmers.cat_picture_search.image.entity.Image;
import lombok.Getter;

@Getter
public class ImageDto {
  private final String id;
  private final String url;
  private final String name;

  public ImageDto(Image image) {
    this.id = image.getId();
    this.url = image.getUrl();
    //breed 정보 없으면 '품종 정보 없음' 으로 나타나야 함
    this.name = image.getBreed() != null ? image.getBreed().getName() : "품종 정보 없음";
  }

}
