package com.programmers.cat_picture_search.global.response;

import lombok.Getter;

@Getter
public abstract class DefaultResponse {

  /**
   * 응답 코드
   */
  protected int code;

  /**
   * 응답 메시지
   */
  protected String message;

  protected DefaultResponse(int code, String message) {
    this.code = code;
    this.message = message;
  }

}
