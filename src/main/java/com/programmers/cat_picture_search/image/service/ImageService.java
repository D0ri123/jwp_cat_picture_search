package com.programmers.cat_picture_search.image.service;

import com.programmers.cat_picture_search.image.dto.response.ImageDto;
import com.programmers.cat_picture_search.image.entity.Image;
import com.programmers.cat_picture_search.image.repository.ImageRepositoryImpl;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {

  private final ImageRepositoryImpl imageRepositoryImpl;

  //랜덤 이미지 50개 목록 조회
  public List<ImageDto> get50Images() {
    List<Image> randomImg50 = imageRepositoryImpl.get50();

    return randomImg50.stream()
        .map(ImageDto::new)
        .collect(Collectors.toList());
  }

  //품종 검색으로 이미지 목록 조회
  public List<ImageDto> getSameKeywordImages(String keyword) {
    List<Image> keywordImages = imageRepositoryImpl.getKeywordImages(keyword);

    return keywordImages.stream()
        .map(ImageDto::new)
        .collect(Collectors.toList());
  }
}
