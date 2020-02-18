package com.bawei.bailang20200218.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bawei.bailang20200218.contart.MyContart;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements MyContart.IView {
    public P mpresenter;
    public Unbinder butterKnife;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getContext(), layoutId(), null);
        butterKnife = ButterKnife.bind(this,inflate);
        initView(inflate);
        mpresenter = getPresneter();
        mpresenter.AttchView(this);
        return inflate;
    }

    protected abstract P getPresneter();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    protected abstract void initView(View inflate);

    protected abstract int layoutId();
}
