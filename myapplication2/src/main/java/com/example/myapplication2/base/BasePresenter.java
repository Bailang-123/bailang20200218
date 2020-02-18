package com.example.myapplication2.base;

import com.example.myapplication2.contart.MyContart;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends MyContart.IView> implements MyContart.IPresenter {
    private WeakReference<V> weakReference;
    public BasePresenter(){
        initData();
    }
    public void AttchView(V view){
        weakReference = new WeakReference<>(view);
    }
    public void DreView(){
        if (weakReference != null) {
            weakReference = null;
            weakReference.clear();
        }
    }
    public V getView(){
       return weakReference.get();
    }



    protected abstract void initData();
}
