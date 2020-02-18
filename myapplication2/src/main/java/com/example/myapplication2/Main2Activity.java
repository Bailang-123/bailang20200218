package com.example.myapplication2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication2.base.BaseActivitys;
import com.example.myapplication2.base.BasePresenters;
import com.example.myapplication2.bean.GsonBean;
import com.example.myapplication2.presenter.MyPresenters;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends BaseActivitys {


    @BindView(R.id.tablayout_view)
    TabLayout tablayoutView;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    List<Fragment> arrayList = new ArrayList<>();
    List<String> stringList = new ArrayList<>();

    @Override
    protected void startPresenter() {

    }

    @Override
    protected void initView() {
        BlankFragment blankFragment0 = BlankFragment.getInstance(0);
        BlankFragment blankFragment1 = BlankFragment.getInstance(1);
        BlankFragment blankFragment2 = BlankFragment.getInstance(2);
        BlankFragment blankFragment3 = BlankFragment.getInstance(3);
        BlankFragment blankFragment9 = BlankFragment.getInstance(9);
        arrayList.add(blankFragment0);
        arrayList.add(blankFragment1);
        arrayList.add(blankFragment2);
        arrayList.add(blankFragment3);
        arrayList.add(blankFragment9);
        stringList.add("全部订单");
        stringList.add("待支付");
        stringList.add("待发货");
        stringList.add("待收货");
        stringList.add("已完成");

        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return arrayList.get(position);
            }

            @Override
            public int getCount() {
                return arrayList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return stringList.get(position);
            }
        });

        tablayoutView.setupWithViewPager(viewPager);

    }

    @Override
    protected BasePresenters getPresenter() {
        return new MyPresenters();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main2;
    }

    @Override
    public void GsonSccess(GsonBean gsonBean) {

    }

    @Override
    public void GsonError(Throwable throwable) {

    }

}
