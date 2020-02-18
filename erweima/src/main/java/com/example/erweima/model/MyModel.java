package com.example.erweima.model;

import com.example.erweima.api.ApiServicer;
import com.example.erweima.bean.JsonBean;
import com.example.erweima.contart.Contart;
import com.example.erweima.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyModel implements Contart.MyModels {
    @Override
    public void ModelInfo(String phone, String pwd, Contart.Models models) {
        NetUtils.getInstance().apiServicer.loginGet(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonBean jsonBean) {
                        models.NameInfo(jsonBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        models.ErrorInfo(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
