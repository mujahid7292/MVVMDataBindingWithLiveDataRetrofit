package com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.MainActivity.MainViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.MainActivity.MainRepository.MainRepository;

public class MainViewModel extends ViewModel {

    public MutableLiveData<String> mutableLiveData;
    public ObservableField<String> observableData = new ObservableField<>();
    private MainRepository mRepository;

    public MainViewModel() {
        mRepository = new MainRepository();
        observableData.set("From ObservableField");
        mutableLiveData = mRepository.getMutableLiveData();
    }

    public MutableLiveData<String> getMutableLiveData() {
        return mutableLiveData;
    }

    public void processUserLogInTheServer(String userName, String userPassword){
        mRepository.processUserLogInTheServer(userName,userPassword);
    }
}
