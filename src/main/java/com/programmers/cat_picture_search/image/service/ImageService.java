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

  //랜덤으로 50개 뽑아들고옴
  public List<ImageDto> get50Images() {
    List<Image> randomImg50 = imageRepositoryImpl.get50();

    return randomImg50.stream()
        .map(ImageDto::new)
        .collect(Collectors.toList());
  }
}
