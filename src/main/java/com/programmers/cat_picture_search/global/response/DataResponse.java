package com.programmers.cat_picture_search.global.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * api 호출 시, 성공 응답 형식
 */
@Getter
public class DataResponse<T> extends DefaultResponse {

  private final T data;

  private DataResponse(HttpStatus status, String message, T data) {
    super(status.value(), message);
    this.data = data;
  }

  public static <T> DataResponse<T> of(HttpStatus status, String message, T data) {
    return new DataResponse<>(status, message, data);
  }


}
