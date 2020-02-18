package com.bawei.bailang20200218.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.bailang20200218.contart.MyContart;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements MyContart.IView {
    public P mpresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layoutId() != 0) {
            setContentView(layoutId());
            ButterKnife.bind(this);
            initView();
            mpresenter = getPresenter();
            startPresenter();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mpresenter != null) {
            mpresenter.DreatyView();
            mpresenter = null;
        }
    }

    protected abstract void startPresenter();

    protected abstract P getPresenter();

    protected abstract void initView();

    protected abstract int layoutId();
}
