package com.programmers.cat_picture_search.feign.cat.service;

import com.programmers.cat_picture_search.feign.cat.client.CatFeignClient;
import com.programmers.cat_picture_search.feign.cat.dto.CatImage;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatFeignService {

  private final CatFeignClient catFeignClient;

  public List<CatImage> getCatImages(Long limit) {
    return catFeignClient.getImages(limit);
  }

}
