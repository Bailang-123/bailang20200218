package com.example.myapplication2.contart;

import com.example.myapplication2.bean.GsonBean;

public interface GsonContart {
    interface IView{
        void GsonSccess(GsonBean gsonBean);
        void GsonError(Throwable throwable);
    }
    public interface IModle{
        void GsonModelInfo(int status,int page,GsonModel gsonModel);
        interface GsonModel{
            void GsonSccess(GsonBean gsonBean);
            void GsonError(Throwable throwable);
        }
    }
    interface IPresenter{
        void GsonPresenter(int status,int page);
    }
}
