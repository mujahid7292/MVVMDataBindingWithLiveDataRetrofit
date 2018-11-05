package com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.LogInActivity.LogInRepository;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.Global.Common;
import com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.RestAPI.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInRepository {

    private MutableLiveData<String> mutableLiveDataResponse = new MutableLiveData<>();
    private static final String TAG = "LogIn";

    public LogInRepository() {

    }

    public MutableLiveData<String> getLogInCredentialsFromServer(String userName, String userPassword) {
        APIService apiService = Common.getAPIService();
        Call<String> response = apiService.sendUserLogInCredentials(userName,userPassword);
        response.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                mutableLiveDataResponse.setValue(response.body());
                Log.i(TAG,"Repository: " +response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
        return mutableLiveDataResponse;
    }
}
