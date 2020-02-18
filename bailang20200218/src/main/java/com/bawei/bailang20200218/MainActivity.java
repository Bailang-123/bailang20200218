package com.bawei.bailang20200218;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.bailang20200218.base.BaseActivity;
import com.bawei.bailang20200218.base.BasePresenter;
import com.bawei.bailang20200218.bean.GsonBean;
import com.bawei.bailang20200218.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.shouye_view)
    ViewPager shouyeView;
    @BindView(R.id.shouye_radiobutton)
    RadioButton shouyeRadiobutton;
    @BindView(R.id.my_radiobutton)
    RadioButton myRadiobutton;
    @BindView(R.id.shouye_radio)
    RadioGroup shouyeRadio;
    List<Fragment> list = new ArrayList<>();
    @Override
    protected void startPresenter() {


    }

    @Override
    protected BasePresenter getPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initView() {
        ShouYeFragment shouYeFragment = new ShouYeFragment();
        MyFragment myFragment = new MyFragment();
        list.add(shouYeFragment);
        list.add(myFragment);
        shouyeView.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

        });
        shouyeView.setCurrentItem(0);
        shouyeRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.shouye_radiobutton:
                        shouyeView.setCurrentItem(0);
                        break;
                    case R.id.my_radiobutton:
                        shouyeView.setCurrentItem(1);
                        break;

                }
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void GsonSccess(GsonBean gsonBean) {

    }

    @Override
    public void GsonError(Throwable throwable) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
