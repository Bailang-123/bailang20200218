package com.example.erweima.base;

import com.example.erweima.contart.Contart;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends Contart.MyView> implements Contart.MyPresenter {
    private WeakReference<V> weakReference;
    public BasePresenter(){
        initData();
    }

    public void AttvhView(V view){
        weakReference = new WeakReference<>(view);
    }
    public void DreachView(){
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
