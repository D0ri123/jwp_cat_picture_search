package com.programmers.cat_picture_search.image.controller;

import com.programmers.cat_picture_search.feign.cat.dto.CatImage;
import com.programmers.cat_picture_search.feign.cat.service.CatFeignService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ImageController {

  private final CatFeignService catFeignService;

  @GetMapping("/images")
  public List<CatImage> getImages(@RequestParam("limit") Long limit) {
    return catFeignService.getCatImages(limit);
  }



}
