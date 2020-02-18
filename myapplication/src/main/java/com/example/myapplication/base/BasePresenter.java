package com.example.myapplication.base;

import com.example.myapplication.contart.IContart;

import java.lang.ref.WeakReference;

public abstract class BasePresenter <V extends IContart.MyView> implements IContart.MyPresenter {
    private WeakReference<V> weakReference;

    public BasePresenter() {
        initData();
    }

    protected abstract void initData();

    public void onAttchView(V view) {
        weakReference = new WeakReference<>(view);
    }

    public void onDreAttchView() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    public V getView() {
        return weakReference.get();
    }
}
