package com.programmers.cat_picture_search.feign.cat.client;

import com.programmers.cat_picture_search.feign.cat.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "catFeignClient", url = "${the-cat-api.url}", configuration = FeignConfig.class)
public interface CatFeignClient {


}

