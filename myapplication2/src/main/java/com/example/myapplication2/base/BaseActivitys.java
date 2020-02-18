package com.example.myapplication2.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.contart.GsonContart;

import butterknife.ButterKnife;

public abstract class BaseActivitys<P extends BasePresenters> extends AppCompatActivity implements GsonContart.IView {
    public P presenters;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layoutId() != 0) {
            setContentView(layoutId());
            ButterKnife.bind(this);
            initView();

            presenters = getPresenter();
            presenters.AttchView(this);
            startPresenter();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenters != null) {
            presenters = null;
            presenters.DreView();
        }
    }

    protected abstract void startPresenter();

    protected abstract void initView();

    protected abstract P getPresenter();

    protected abstract int layoutId();
}
