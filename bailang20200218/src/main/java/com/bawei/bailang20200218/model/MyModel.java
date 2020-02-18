package com.bawei.bailang20200218.model;

import com.bawei.bailang20200218.bean.GsonBean;
import com.bawei.bailang20200218.contart.MyContart;
import com.bawei.bailang20200218.util.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyModel implements MyContart.IModel {
    @Override
    public void GsonModleInfo(int status, int page, Models models) {
        NetUtils.getInstance().getMyApi().gson("15819883412421217", 1217, status, page, 5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GsonBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GsonBean gsonBean) {
                        models.GsonSccess(gsonBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        models.GsonError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
