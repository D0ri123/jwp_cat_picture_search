package com.programmers.cat_picture_search.global.response.service;

import com.programmers.cat_picture_search.global.response.body.CommonResponse;
import com.programmers.cat_picture_search.global.response.body.ListResponse;
import com.programmers.cat_picture_search.global.response.body.SingleResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

  public<T> SingleResponse<T> getSingleResponse(T data) {
    SingleResponse singleResponse = new SingleResponse();
    singleResponse.data = data;
    setSuccessResponse(singleResponse);

    return singleResponse;
  }

  public<T> ListResponse<T> getListResponse(List<T> dataList) {
    ListResponse listResponse = new ListResponse();
    listResponse.dataList = dataList;
    setSuccessResponse(listResponse);

    return listResponse;
  }

  void setSuccessResponse(CommonResponse commonResponse) {
    commonResponse.code = 0;
    commonResponse.success = true;
    commonResponse.message = "SUCCESS";
  }

}
