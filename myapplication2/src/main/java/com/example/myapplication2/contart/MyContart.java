package com.example.myapplication2.contart;

import com.example.myapplication2.bean.DlBean;
import com.example.myapplication2.bean.ZcBean;

public interface MyContart {
    interface IModel {
        void RightModelInfo(String phone, String pwd, RightMoel rightMoel);

        interface RightMoel {
            void RightSccess(ZcBean zcBean);

            void RightError(Throwable throwable);
        }

        void LoginModelInfo(String phone, String pwd, LoginMoel loginMoel);

        interface LoginMoel {
            void LoginSccess(DlBean dlBean);

            void LoginError(Throwable throwable);
        }
    }

    interface IView {
        void RightSccess(ZcBean zcBean);

        void RightError(Throwable throwable);

        void LoginSccess(DlBean dlBean);

        void LoginError(Throwable throwable);
    }

    interface IPresenter {
        void RightPresenterInfo(String phone, String pwd);

        void LoginPresenterInfo(String phone, String pwd);
    }
}
