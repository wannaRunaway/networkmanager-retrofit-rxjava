package com.example.moduleupload;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moduleupload.databinding.ActivityMainBinding;
import com.example.networkmanager_retrofitrxjava.InternetworkManager;
import com.example.networkmanager_retrofitrxjava.MyBanner;
import com.example.networkmanager_retrofitrxjava.MyObserver;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private List<MyBanner> list = new ArrayList<MyBanner>();
    private MainListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        activityMainBinding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainListAdapter(this, list);
        activityMainBinding.recyclerview.setAdapter(adapter);
        InternetworkManager.getRetrofitApi(this).getBannerList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<List<MyBanner>>() {
                    @Override
                    public void onSuccess(List<MyBanner> data) {
                        list.addAll(data);
                        for (int i = 0; i < 10; i++) {
                            list.add(new MyBanner());
                        }
                        adapter.notifyDataSetChanged();
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
