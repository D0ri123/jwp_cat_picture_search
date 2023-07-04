package com.programmers.cat_picture_search.image.controller;

import com.programmers.cat_picture_search.feign.cat.dto.CatImage;
import com.programmers.cat_picture_search.feign.cat.service.CatFeignService;
import com.programmers.cat_picture_search.global.response.DataResponse;
import com.programmers.cat_picture_search.image.dto.response.ImageDto;
import com.programmers.cat_picture_search.image.service.ImageService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ImageController {

  private final CatFeignService catFeignService;
  private final ImageService imageService;

  //TODO: Feign controller 를 생성하여, 이 메서드를 넣기 & Feign 패키지 위치 모두 변경
  @GetMapping("/images")
  public List<CatImage> getImages(@RequestParam("limit") Long limit) {
    return catFeignService.getCatImages(limit);
  }

  @GetMapping("/cats/random/50")
  public ResponseEntity<DataResponse<List<ImageDto>>> getRandom50() {
    List<ImageDto> images = imageService.get50Images();
    return new ResponseEntity<>(DataResponse.of(HttpStatus.OK, "고양이 이미지 랜덤 조회 성공", images), HttpStatus.OK);
  }

  @GetMapping("/cats/search")
  public ResponseEntity<DataResponse<List<ImageDto>>> getKeywordImages(@RequestParam("keyword") String keyword) {
    List<ImageDto> sameKeywordImages = imageService.getSameKeywordImages(keyword);
    return new ResponseEntity<>(
        DataResponse.of(HttpStatus.OK, "키워드에 해당하는 고양이 이미지 조회 성공", sameKeywordImages), HttpStatus.OK);
  }

}
