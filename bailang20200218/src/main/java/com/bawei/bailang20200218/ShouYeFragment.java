package com.bawei.bailang20200218;


import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.bailang20200218.adapter.ShouyeAdapter;
import com.bawei.bailang20200218.base.BaseFragment;
import com.bawei.bailang20200218.base.BasePresenter;
import com.bawei.bailang20200218.bean.GsonBean;
import com.bawei.bailang20200218.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShouYeFragment extends BaseFragment {


    @BindView(R.id.shouye_recuclerview)
    RecyclerView shouyeRecuclerview;
    List<GsonBean.OrderListBean> listBeans = new ArrayList<>();
    private int key = 1;
    private int status = 0;

    @Override
    protected BasePresenter getPresneter() {
        return new MyPresenter();
    }

    @Override
    protected void initData() {
        mpresenter.GsonModleInfo(status,key);
    }

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_shou_ye;
    }

    @Override
    public void GsonSccess(GsonBean gsonBean) {
        List<GsonBean.OrderListBean> orderList = gsonBean.getOrderList();
        listBeans.addAll(orderList);
        shouyeRecuclerview.setLayoutManager(new GridLayoutManager(getContext(),2));
        ShouyeAdapter shouyeAdapter = new ShouyeAdapter(listBeans);
        shouyeRecuclerview.setAdapter(shouyeAdapter);
    }

    @Override
    public void GsonError(Throwable throwable) {
        Log.e("throwable",throwable.getMessage());
    }
}
