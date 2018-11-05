package com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.MainActivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.MainActivity.MainPresenter.MainPresenter;
import com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.MainActivity.MainViewModel.MainViewModel;
import com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.R;
import com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    ActivityMainBinding mainBinding;
    MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainBinding.setMainViewModel(mViewModel);
        mainBinding.setLifecycleOwner(this);

        mViewModel.getMutableLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.i(TAG,"Observer: " + s);
                mViewModel.observableData.set(s);
            }
        });

        mainBinding.setMainPresenter(new MainPresenter() {
            @Override
            public void getData() {
                mViewModel.processUserLogInTheServer("Mujahid","123456");
            }
        });
    }
}
