package com.example.erweima.base;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.erweima.contart.Contart;

public abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity implements Contart.MyView {
    public P mpresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(layoutId()!=0){
            setContentView(layoutId());
            initView();
            mpresenter = getpresenter();
            mpresenter.AttvhView(this);
            startPresenter();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mpresenter != null) {
            mpresenter.DreachView();
        }
    }

    protected abstract void startPresenter();

    protected abstract void initView();

    protected abstract P getpresenter();

    protected abstract int layoutId();
}
