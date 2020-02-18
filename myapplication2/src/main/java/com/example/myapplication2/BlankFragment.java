package com.example.myapplication2;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.myapplication2.adapter.MyAdapter;
import com.example.myapplication2.base.BaseFragment;
import com.example.myapplication2.base.BasePresenters;
import com.example.myapplication2.bean.GsonBean;
import com.example.myapplication2.presenter.MyPresenters;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends BaseFragment {


    @BindView(R.id.refrsh_layout)
    SmartRefreshLayout refrshLayout;
    @BindView(R.id.recyvler_View)
    RecyclerView recyvlerView;
    List<GsonBean.OrderListBean> listBeans = new ArrayList<>();
    private  int key = 0;
    private  int page = 1;

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        if(arguments!=null){
            key = arguments.getInt("key");
        }
        mpresenter.GsonPresenter(key,page);
    }

    public static BlankFragment getInstance(int view) {
        BlankFragment blankFragment = new BlankFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key",view);
        blankFragment.setArguments(bundle);
        return blankFragment;
    }
    @Override
    protected void initView(View inflate) {
        refrshLayout.setEnableRefresh(true);
        refrshLayout.setEnableLoadMore(true);
        refrshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                listBeans.clear();
                page = 1;
                mpresenter.GsonPresenter(key,page);
                refreshLayout.finishRefresh();
            }
        });
        refrshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                mpresenter.GsonPresenter(key,page);
                refreshLayout.finishLoadMore();
            }
        });
    }

    @Override
    protected BasePresenters getPresenter() {
        return new MyPresenters();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_blank;
    }

    @Override
    public void GsonSccess(GsonBean gsonBean) {
        List<GsonBean.OrderListBean> orderList = gsonBean.getOrderList();
        listBeans.addAll(orderList);
        recyvlerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MyAdapter myAdapter = new MyAdapter(listBeans);
        recyvlerView.setAdapter(myAdapter);

    }

    @Override
    public void GsonError(Throwable throwable) {

    }
}
