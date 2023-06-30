package com.programmers.cat_picture_search.global.response.body;

import lombok.Getter;

@Getter
public class SingleResponse <T> extends CommonResponse {

  public T data;

}
