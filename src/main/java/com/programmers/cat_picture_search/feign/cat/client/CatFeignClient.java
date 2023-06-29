package com.programmers.cat_picture_search.feign.cat.client;

import com.programmers.cat_picture_search.feign.cat.config.FeignConfig;
import com.programmers.cat_picture_search.feign.cat.dto.CatImage;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "catFeignClient", url = "${the-cat-api.url}",
             configuration = FeignConfig.class)
public interface CatFeignClient {

  @GetMapping(value = "v1/images/search")
  List<CatImage> getImages(@RequestParam("limit") Long limit);

}

