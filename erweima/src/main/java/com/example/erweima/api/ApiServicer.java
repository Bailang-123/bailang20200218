package com.example.erweima.api;

import com.example.erweima.bean.JsonBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServicer {
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<JsonBean> loginGet(@Field("phone") String phone , @Field("pwd") String pwd);
}
