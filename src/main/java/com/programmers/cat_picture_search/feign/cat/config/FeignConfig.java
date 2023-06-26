package com.programmers.cat_picture_search.feign.cat.config;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableFeignClients("com.programmers.cat_picture_search")
public class FeignConfig {

  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }

  @Bean
  public RequestInterceptor requestInterceptor(@Value("${the-cat-api.key}") String key) {
    return requestTemplate -> requestTemplate.header("x-api-key", key);
  }
}
