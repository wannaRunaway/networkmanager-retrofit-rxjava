package com.example.networkmanager_retrofitrxjava;

import com.example.networkmanager_retrofitrxjava.ResponseModel;
import com.example.networkmanager_retrofitrxjava.Utils;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public abstract class MyObserver<T> implements Observer<ResponseModel<T>> {
    @Override
    public void onSubscribe(@NonNull Disposable d) {
        Utils.log("myobserver onSubscribe");
    }

    @Override
    public void onNext(@NonNull ResponseModel<T> tResponseModel) {
        onSuccess(tResponseModel.getData());
    }

    @Override
    public void onError(@NonNull Throwable e) {
        onError();
        Utils.log("myobserver onError");
    }

    @Override
    public void onComplete() {
        Utils.log("myobserver onComplete");
    }

    public abstract void onSuccess(T data);

    public abstract void onFail(int code, String message);

    public abstract void onError();

    public abstract void onClearToken();
}
