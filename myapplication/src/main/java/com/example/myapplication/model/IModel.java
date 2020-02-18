package com.example.myapplication.model;

import com.example.myapplication.bean.EnterBean;
import com.example.myapplication.bean.JsonBean;
import com.example.myapplication.bean.LoginBean;
import com.example.myapplication.contart.IContart;
import com.example.myapplication.util.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class IModel implements IContart.MyModel {
    @Override
    public void LoginModel(String phone, String pwd, IContart.Models models) {
        NetUtils.getInstance().api().loginGet(phone, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        models.LoginGetInfo(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        models.LoginError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void EnterModel(String phone, String pwd, IContart.Models models) {
        NetUtils.getInstance().api().EnterGet(phone, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EnterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(EnterBean enterBean) {
                        models.EnterGetInfo(enterBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        models.EnterError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void JsonModel(IContart.Models models) {
        NetUtils.getInstance().api().JsonGet("157879052151613041","13041")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonBean jsonBean) {
                        models.JsonGetInfo(jsonBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        models.JsonError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
