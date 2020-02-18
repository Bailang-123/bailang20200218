package com.example.myapplication2.base;

import com.example.myapplication2.contart.GsonContart;

import java.lang.ref.WeakReference;

public abstract class BasePresenters<V extends GsonContart.IView> implements GsonContart.IPresenter {
    private WeakReference<V> weakReference;

    public BasePresenters() {
        initData();
    }

    public void AttchView(V view) {
        weakReference = new WeakReference<>(view);
    }

    public void DreView() {
        if (weakReference != null) {
            weakReference = null;
            weakReference.clear();
        }
    }

    public V getView() {
        return weakReference.get();
    }


    protected abstract void initData();
}
