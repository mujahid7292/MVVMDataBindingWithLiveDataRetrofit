package com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.MainActivity.MainRepository;

import android.arch.lifecycle.MutableLiveData;

public class MainRepository {
    public MutableLiveData<String> mutableLiveData;

    public MainRepository() {
        mutableLiveData = new MutableLiveData<>();
    }

    public void processUserLogInTheServer(String userName, String userPassword){
        if (userName.equals("Mujahid") && userPassword.equals("123456")){
            mutableLiveData.setValue("Login Successful");
        }else {
            mutableLiveData.setValue("Login Failed");
        }
    }

    public MutableLiveData<String> getMutableLiveData() {
        return mutableLiveData;
    }
}
