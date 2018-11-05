package com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.LogInActivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.LogInActivity.LogInPresenter.LogInPresenter;
import com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.LogInActivity.LogInViewModel.LogInViewModel;
import com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.R;
import com.sand_corporation.www.mvvmdatabindingwithlivedataretrofit.databinding.ActivityLogInBinding;

public class LogInActivity extends AppCompatActivity {

    private ActivityLogInBinding mLogInBinding;
    private LogInViewModel mViewModel;
    private static final String TAG = "LogIn";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLogInBinding = DataBindingUtil.setContentView(this,R.layout.activity_log_in);
        mViewModel = ViewModelProviders.of(this).get(LogInViewModel.class);
        mLogInBinding.setLogInViewModel(mViewModel);
        mLogInBinding.setLifecycleOwner(this);

        mViewModel.getMutableLiveDataRsponse().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.i(TAG,"Activity: " + s );
                Toast.makeText(LogInActivity.this, "" + s, Toast.LENGTH_LONG).show();
            }
        });

        mLogInBinding.setLogInPresenter(new LogInPresenter() {
            @Override
            public void sendLogInCredentials() {
                mViewModel.sendLogInCredentialsToServer();
            }
        });
    }
}
