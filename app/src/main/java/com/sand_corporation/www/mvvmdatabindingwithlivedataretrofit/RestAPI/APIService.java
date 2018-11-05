package com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.RestAPI;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @FormUrlEncoded
    @POST("user_log_in")
    Call<String> sendUserLogInCredentials(
            @Field("userName")String userName,
            @Field("userPassword") String userPassword
    );
}
