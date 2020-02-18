package com.example.myapplication.contart;

import com.example.myapplication.bean.EnterBean;
import com.example.myapplication.bean.JsonBean;
import com.example.myapplication.bean.LoginBean;

public interface IContart {
    interface MyModel {
        void LoginModel(String phone, String pwd, Models models);

        void EnterModel(String phone, String pwd, Models models);

        void JsonModel(Models models);
    }

    interface MyView {
        void LoginGetInfo(LoginBean loginBean);

        void LoginError(Throwable throwable);

        void EnterGetInfo(EnterBean enterBean);

        void EnterError(Throwable throwable);

        void JsonGetInfo(JsonBean jsonBean);

        void JsonError(Throwable throwable);
    }

    interface MyPresenter {
        void LoginPresenter(String phone, String pwd);

        void EnterPresenter(String phone, String pwd);

        void JsonPrenseter();
    }

    interface Models {
        void LoginGetInfo(LoginBean loginBean);

        void LoginError(Throwable throwable);

        void EnterGetInfo(EnterBean enterBean);

        void EnterError(Throwable throwable);

        void JsonGetInfo(JsonBean jsonBean);

        void JsonError(Throwable throwable);


    }
}
