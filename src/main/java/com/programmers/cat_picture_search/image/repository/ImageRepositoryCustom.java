package com.programmers.cat_picture_search.image.repository;

import com.programmers.cat_picture_search.image.entity.Image;
import java.util.List;

public interface ImageRepositoryCustom {
  List<Image> get50();

  List<Image> getKeywordImages(String keyword);

  Image getImageInfo(String id);
}
