package com.programmers.cat_picture_search.global.exception;

/**
 * 도메인 관련 예외 정의 클래스
 */
public class BusinessException extends RuntimeException{

  private ErrorCode errorCode;

  public BusinessException(String message, ErrorCode errorCode) {
    super(message);
    this.errorCode = errorCode;
  }

  public BusinessException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }

  public ErrorCode getErrorCode() {
    return errorCode;
  }

}
