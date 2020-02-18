package com.bawei.bailang20200218.presenter;

import com.bawei.bailang20200218.base.BasePresenter;
import com.bawei.bailang20200218.bean.GsonBean;
import com.bawei.bailang20200218.contart.MyContart;
import com.bawei.bailang20200218.model.MyModel;

public class MyPresenter extends BasePresenter {
    public MyContart.IModel model;

    @Override
    protected void initData() {
        model = new MyModel();
    }

    @Override
    public void GsonModleInfo(int status, int page) {
        model.GsonModleInfo(status, page, new MyContart.IModel.Models() {
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
