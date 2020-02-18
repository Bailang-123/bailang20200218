package com.bawei.bailang20200218;


import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.bailang20200218.adapter.MyAdapter;
import com.bawei.bailang20200218.base.BaseFragment;
import com.bawei.bailang20200218.base.BasePresenter;
import com.bawei.bailang20200218.bean.GsonBean;
import com.bawei.bailang20200218.presenter.MyPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GsonFragment extends BaseFragment {
    @BindView(R.id.gson_recyclerview)
    RecyclerView gsonRecyclerview;
    @BindView(R.id.restart_layout)
    SmartRefreshLayout restartLayout;
    private int key = 1;
    private int status = 0;
    List<GsonBean.OrderListBean> list = new ArrayList<>();

    @Override
    protected BasePresenter getPresneter() {
        return new MyPresenter();
    }

    @Override
    protected void initData() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            status = bundle.getInt("key");
        }
        mpresenter.GsonModleInfo(status, key);
    }

    @Override
    protected void initView(View inflate) {
        restartLayout.setEnableLoadMore(true);
        restartLayout.setEnableRefresh(true);
        restartLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                list.clear();
                key=1;
                mpresenter.GsonModleInfo(status,key);
                refreshLayout.finishRefresh();
            }
        });
        restartLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                key++;
                mpresenter.GsonModleInfo(status,key);
                refreshLayout.finishLoadMore();
            }
        });
    }

    public static GsonFragment getInstance(int view) {
        GsonFragment gsonFragment = new GsonFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key", view);
        gsonFragment.setArguments(bundle);
        return gsonFragment;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_gson;
    }

    @Override
    public void GsonSccess(GsonBean gsonBean) {
        List<GsonBean.OrderListBean> orderList = gsonBean.getOrderList();
        list.addAll(orderList);
        gsonRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        MyAdapter myAdapter  = new MyAdapter(list);
        gsonRecyclerview.setAdapter(myAdapter);
    }

    @Override
    public void GsonError(Throwable throwable) {
        Log.e("throwable",throwable.getMessage());
    }
}
