package com.bawei.bailang20200218.contart;

import com.bawei.bailang20200218.bean.GsonBean;

public interface MyContart {
    interface IModel {
        void GsonModleInfo(int status, int page, Models models);

        interface Models {
            void GsonSccess(GsonBean gsonBean);

            void GsonError(Throwable throwable);
        }
    }

    interface IView {
        void GsonSccess(GsonBean gsonBean);

        void GsonError(Throwable throwable);
    }

    interface IPresenter {
        void GsonModleInfo(int status, int page);
    }
}
