package com.programmers.cat_picture_search.global.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 응답 관련 에러 코드.
 */
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

  // Common
  INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "C001", "입력값이 유효하지 않습니다."),
  METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "C002", "요청 메서드가 유효하지 않습니다."),
  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C003", "서버 에러"),
  INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST, "C004", "입력값이 유효하지 않습니다."),
  HANDLE_ACCESS_DENIED(HttpStatus.FORBIDDEN, "C005", "접근이 거부되었습니다.");

  //도메인에 따른 에러코드 추가 예정

  private final String code;
  private final String message;
  private final HttpStatus status;

  public int getStatus() {
    return this.status.value();
  }

  ErrorCode(final HttpStatus status, final String code, final String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }
}
