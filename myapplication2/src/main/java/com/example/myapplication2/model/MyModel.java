package com.example.myapplication2.model;

import com.example.myapplication2.bean.DlBean;
import com.example.myapplication2.bean.ZcBean;
import com.example.myapplication2.contart.MyContart;
import com.example.myapplication2.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyModel implements MyContart.IModel {
    @Override
    public void RightModelInfo(String phone, String pwd, RightMoel rightMoel) {
        NetUtils.getInstance().getapi().register(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZcBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZcBean zcBean) {
                        rightMoel.RightSccess(zcBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        rightMoel.RightError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void LoginModelInfo(String phone, String pwd, LoginMoel loginMoel) {
        NetUtils.getInstance().getapi().login(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DlBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DlBean dlBean) {
                        loginMoel.LoginSccess(dlBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loginMoel.LoginError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
