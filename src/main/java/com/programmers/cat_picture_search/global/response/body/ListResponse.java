package com.programmers.cat_picture_search.global.response.body;

import java.util.List;
import lombok.Getter;

@Getter
public class ListResponse <T> extends CommonResponse {
  public List<T> dataList;

}
