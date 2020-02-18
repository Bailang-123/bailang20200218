package com.bawei.bailang20200218;


import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.bailang20200218.base.BaseFragment;
import com.bawei.bailang20200218.base.BasePresenter;
import com.bawei.bailang20200218.bean.GsonBean;
import com.bawei.bailang20200218.presenter.MyPresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment {


    @BindView(R.id.tavlayout_my)
    TabLayout tavlayoutMy;
    @BindView(R.id.my_viewpager)
    ViewPager myViewpager;
    List<Fragment> list_fragment = new ArrayList<>();
    List<String> list_str = new ArrayList<>();
    @Override
    protected BasePresenter getPresneter() {
        return new MyPresenter();
    }

    @Override
    protected void initData() {
        GsonFragment gsonFragment0  = GsonFragment.getInstance(0);
        GsonFragment gsonFragment1  = GsonFragment.getInstance(1);
        GsonFragment gsonFragment2  = GsonFragment.getInstance(2);
        GsonFragment gsonFragment3  = GsonFragment.getInstance(3);
        GsonFragment gsonFragment9  = GsonFragment.getInstance(9);
        list_fragment.add(gsonFragment0);
        list_fragment.add(gsonFragment1);
        list_fragment.add(gsonFragment2);
        list_fragment.add(gsonFragment3);
        list_fragment.add(gsonFragment9);
        list_str.add("全部订单");
        list_str.add("待发货");
        list_str.add("待收货");
        list_str.add("待评价");
        list_str.add("已完成");

        myViewpager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list_fragment.get(position);
            }

            @Override
            public int getCount() {
                return list_fragment.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list_str.get(position);
            }
        });

        tavlayoutMy.setupWithViewPager(myViewpager);
    }

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_my;
    }

    @Override
    public void GsonSccess(GsonBean gsonBean) {

    }

    @Override
    public void GsonError(Throwable throwable) {

    }
}
