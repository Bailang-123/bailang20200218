package com.example.myapplication2.presenter;

import com.example.myapplication2.base.BasePresenter;
import com.example.myapplication2.bean.DlBean;
import com.example.myapplication2.bean.ZcBean;
import com.example.myapplication2.contart.MyContart;
import com.example.myapplication2.model.MyModel;

public class MyPresenter extends BasePresenter {
    private MyContart.IModel model;
    @Override
    protected void initData() {
        model = new MyModel();
    }

    @Override
    public void RightPresenterInfo(String phone, String pwd) {
        model.RightModelInfo(phone, pwd, new MyContart.IModel.RightMoel() {
            @Override
            public void RightSccess(ZcBean zcBean) {
                getView().RightSccess(zcBean);
            }

            @Override
            public void RightError(Throwable throwable) {
                getView().RightError(throwable);
            }
        });
    }

    @Override
    public void LoginPresenterInfo(String phone, String pwd) {
        model.LoginModelInfo(phone, pwd, new MyContart.IModel.LoginMoel() {
            @Override
            public void LoginSccess(DlBean dlBean) {
                getView().LoginSccess(dlBean);
            }

            @Override
            public void LoginError(Throwable throwable) {
                getView().LoginError(throwable);
            }
        });
    }
}
