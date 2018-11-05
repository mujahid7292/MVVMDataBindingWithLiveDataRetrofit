package com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.Global;

import com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.RestAPI.APIService;
import com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.RestAPI.RetrofitClient;

public class Common {
    public static final String BASE_URL = "http://192.168.0.52/api/";

    public static APIService getAPIService(){
        return RetrofitClient.getRetrofit(BASE_URL).create(APIService.class);
    }

}
