package com.bawei.bailang20200218.base;

import com.bawei.bailang20200218.contart.MyContart;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends MyContart.IView> implements MyContart.IPresenter {
    private WeakReference<V> weakReference;
    public BasePresenter(){
        initData();
    }

    public void AttchView(V view){
        weakReference = new WeakReference<>(view);
    }
    public void DreatyView(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }
    public V getView(){
        return weakReference.get();
    }

    protected abstract void initData();
}
