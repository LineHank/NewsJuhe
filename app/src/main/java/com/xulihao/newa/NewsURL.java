package com.xulihao.newa;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zz on 2016/10/14.
 */
public interface NewsURL {
    @GET("index")
    Call<NewsBean> getString(@Query("type") String type, @Query("key") String key);
}
