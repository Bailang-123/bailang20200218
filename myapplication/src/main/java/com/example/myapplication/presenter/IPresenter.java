package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.EnterBean;
import com.example.myapplication.bean.JsonBean;
import com.example.myapplication.bean.LoginBean;
import com.example.myapplication.contart.IContart;
import com.example.myapplication.model.IModel;

public class IPresenter extends BasePresenter {

    private IContart.MyModel model;

    @Override
    protected void initData() {
        model = new IModel();
    }

    @Override
    public void LoginPresenter(String phone, String pwd) {
        model.LoginModel(phone, pwd, new IContart.Models() {
            @Override
            public void LoginGetInfo(LoginBean loginBean) {
                getView().LoginGetInfo(loginBean);
            }

            @Override
            public void LoginError(Throwable throwable) {
                getView().LoginError(throwable);
            }

            @Override
            public void EnterGetInfo(EnterBean enterBean) {
                getView().EnterGetInfo(enterBean);
            }

            @Override
            public void EnterError(Throwable throwable) {
                getView().EnterError(throwable);
            }

            @Override
            public void JsonGetInfo(JsonBean jsonBean) {
                getView().JsonGetInfo(jsonBean);
            }

            @Override
            public void JsonError(Throwable throwable) {
                getView().JsonError(throwable);
            }
        });
    }

    @Override
    public void EnterPresenter(String phone, String pwd) {
        model.EnterModel(phone, pwd, new IContart.Models() {
            @Override
            public void LoginGetInfo(LoginBean loginBean) {
                getView().LoginGetInfo(loginBean);
            }

            @Override
            public void LoginError(Throwable throwable) {
                getView().LoginError(throwable);
            }

            @Override
            public void EnterGetInfo(EnterBean enterBean) {
                getView().EnterGetInfo(enterBean);
            }

            @Override
            public void EnterError(Throwable throwable) {
                getView().EnterError(throwable);
            }

            @Override
            public void JsonGetInfo(JsonBean jsonBean) {
                getView().JsonGetInfo(jsonBean);
            }

            @Override
            public void JsonError(Throwable throwable) {
                getView().JsonError(throwable);
            }
        });
    }

    @Override
    public void JsonPrenseter() {
        model.JsonModel(new IContart.Models() {
            @Override
            public void LoginGetInfo(LoginBean loginBean) {
                getView().LoginGetInfo(loginBean);
            }

            @Override
            public void LoginError(Throwable throwable) {
                getView().LoginError(throwable);
            }

            @Override
            public void EnterGetInfo(EnterBean enterBean) {
                getView().EnterGetInfo(enterBean);
            }

            @Override
            public void EnterError(Throwable throwable) {
                getView().EnterError(throwable);
            }

            @Override
            public void JsonGetInfo(JsonBean jsonBean) {
                getView().JsonGetInfo(jsonBean);
            }

            @Override
            public void JsonError(Throwable throwable) {
                getView().JsonError(throwable);
            }
        });
    }
}
