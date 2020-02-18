package com.example.myapplication2.presenter;

import com.example.myapplication2.base.BasePresenters;
import com.example.myapplication2.bean.GsonBean;
import com.example.myapplication2.contart.GsonContart;
import com.example.myapplication2.model.GsonModels;

public class MyPresenters extends BasePresenters {
    private GsonContart.IModle modle;
    @Override
    protected void initData() {
        modle = new GsonModels();
    }

    @Override
    public void GsonPresenter(int status, int page) {
        modle.GsonModelInfo(status, page, new GsonContart.IModle.GsonModel() {
            @Override
            public void GsonSccess(GsonBean gsonBean) {
                getView().GsonSccess(gsonBean);
            }

            @Override
            public void GsonError(Throwable throwable) {
                getView().GsonError(throwable);
            }
        });
    }
}
