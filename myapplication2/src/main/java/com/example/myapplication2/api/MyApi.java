package com.example.myapplication2.api;

import com.example.myapplication2.bean.DlBean;
import com.example.myapplication2.bean.GsonBean;
import com.example.myapplication2.bean.ZcBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyApi {
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<ZcBean> register(@Field("phone") String phone, @Field("pwd") String pwd);

    @FormUrlEncoded
    @POST("small/user/v1/login")
    Observable<DlBean> login(@Field("phone") String phone, @Field("pwd") String pwd);

    @GET("small/order/verify/v1/findOrderListByStatus")
    Observable<GsonBean> gson(@Header("sessionId") String sessionId, @Header("userId") int userId,
                              @Query("status") int status, @Query("page") int page, @Query("count") int count);


}
