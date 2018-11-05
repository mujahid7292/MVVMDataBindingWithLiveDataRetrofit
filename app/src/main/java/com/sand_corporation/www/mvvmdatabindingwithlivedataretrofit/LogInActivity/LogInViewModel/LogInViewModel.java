package com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.LogInActivity.LogInViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.LogInActivity.LogInRepository.LogInRepository;

public class LogInViewModel extends ViewModel {

    public ObservableField<String> userName = new ObservableField<>("");
    public ObservableField<String> userPassword = new ObservableField<>("");
    private MutableLiveData<String> mutableLiveDataRsponse = new MutableLiveData<>();
    private LogInRepository mRepository;
    private static final String TAG = "LogIn";

    public LogInViewModel() {
        mRepository = new LogInRepository();
        mutableLiveDataRsponse = mRepository.getLogInCredentialsFromServer(userName.get(),userPassword.get());
    }

    public MutableLiveData<String> getMutableLiveDataRsponse() {
        return mutableLiveDataRsponse;
    }

    public void sendLogInCredentialsToServer(){
        mutableLiveDataRsponse = mRepository.getLogInCredentialsFromServer(userName.get(),userPassword.get());
    }
}
