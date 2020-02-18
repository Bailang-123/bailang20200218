package com.example.erweima.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.erweima.contart.Contart;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements Contart.MyView {
    public P mpresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(layoutId(), container, false);
        mpresenter = getPresnter();
        if (mpresenter != null) {
            mpresenter.AttvhView(this);
        }
        initView(inflate);
        return inflate;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mpresenter != null) {
            mpresenter.DreachView();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    protected abstract void initView(View inflate);

    protected abstract P getPresnter();

    protected abstract int layoutId();
}
