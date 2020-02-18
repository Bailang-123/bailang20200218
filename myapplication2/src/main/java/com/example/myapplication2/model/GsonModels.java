package com.example.myapplication2.model;

import com.example.myapplication2.bean.GsonBean;
import com.example.myapplication2.contart.GsonContart;
import com.example.myapplication2.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GsonModels implements GsonContart.IModle {

    @Override
    public void GsonModelInfo(int status, int page, GsonModel gsonModel) {
        NetUtils.getInstance().getapi().gson("15819494584831217",1217,status,page,5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GsonBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GsonBean gsonBean) {
                        gsonModel.GsonSccess(gsonBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        gsonModel.GsonError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
