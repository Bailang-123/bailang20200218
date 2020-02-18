package com.bawei.bailang20200218.api;

import com.bawei.bailang20200218.bean.GsonBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface MyApi {
    @GET("small/order/verify/v1/findOrderListByStatus")
    Observable<GsonBean> gson (@Header("sessionId") String sessionId, @Header("userId")int userId,
                               @Query("status") int status, @Query("page") int page, @Query("count") int count);
}
