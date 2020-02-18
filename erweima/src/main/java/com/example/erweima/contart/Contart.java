package com.example.erweima.contart;

import com.example.erweima.bean.JsonBean;

public interface Contart {
    interface MyModels{
        void ModelInfo(String phone,String pwd,Models models);
    }
    interface MyView{
        void NameInfo(JsonBean jsonBean);
        void ErrorInfo(Throwable throwable);
    }
    interface MyPresenter{
        void PresenterInfo(String phone,String pwd);
    }
    interface Models {
        void NameInfo(JsonBean jsonBean);
        void ErrorInfo(Throwable throwable);
    }
}
