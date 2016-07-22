package com.bjshenpu.perfectcommonbaseframework.retrofit;

import com.bjshenpu.perfectcommonbaseframework.model.LoginEntity;
import com.bjshenpu.perfectcommonbaseframework.model.UpDateInfoEntity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;


public interface ApiStores {


    //baseUrl
    String API_SERVER_URL = HttpConfig.BASE_HOST_URL;



    @FormUrlEncoded
    @POST("servlet/AppCheckVersionController")
    Observable<LoginEntity> login(@Field("clientType") String clientType, @Field("version") String version);


    //获取更新信息
    @FormUrlEncoded
    @POST("servlet/AppCheckVersionController")
    Observable<UpDateInfoEntity> getApkInfo(@Field("clientType") String clientType, @Field("version") String version);


}
