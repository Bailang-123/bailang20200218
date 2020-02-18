package com.example.myapplication.api;

import com.example.myapplication.bean.EnterBean;
import com.example.myapplication.bean.JsonBean;
import com.example.myapplication.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<LoginBean> loginGet(@Field("phone") String phone , @Field("pwd") String pwd);
    @FormUrlEncoded
    @POST("small/user/v1/login")
    Observable<EnterBean> EnterGet(@Field("phone") String phone , @Field("pwd") String pwd);
    @GET("small/order/verify/v1/findShoppingCart")
    Observable<JsonBean> JsonGet(@Header("sessionId") String sessionId , @Header("userId") String userId);
}
