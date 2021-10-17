package com.example.moduleupload;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.networkmanager_retrofitrxjava.InternetworkManager;
import com.example.networkmanager_retrofitrxjava.MyBanner;
import com.example.networkmanager_retrofitrxjava.MyObserver;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InternetworkManager.getRetrofitApi(this).getBannerList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<List<MyBanner>>() {
                    @Override
                    public void onSuccess(List<MyBanner> data) {

                    }

                    @Override
                    public void onFail(int code, String message) {

                    }

                    @Override
                    public void onError() {

                    }

                    @Override
                    public void onClearToken() {

                    }
                });
    }
}
