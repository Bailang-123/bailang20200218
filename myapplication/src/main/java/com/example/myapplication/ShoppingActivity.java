package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.myapplication.adapter.MyAdapter;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.EnterBean;
import com.example.myapplication.bean.JsonBean;
import com.example.myapplication.bean.LoginBean;
import com.example.myapplication.presenter.IPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShoppingActivity extends BaseActivity {


    @BindView(R.id.image_view01)
    ImageView imageView01;
    @BindView(R.id.json_listview)
    ExpandableListView jsonListview;
    @BindView(R.id.ch)
    CheckBox ch;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.bt)
    Button bt;
    @BindView(R.id.smart)
    SmartRefreshLayout smartRefreshLayout;
    int page = 0;
    List<JsonBean.ResultBean> list = new ArrayList<>();

    @Override
    protected void startPresenter() {
        mpresenter.JsonPrenseter();
        Intent intent = getIntent();
        String pic = intent.getStringExtra("pic");
        Glide.with(imageView01)
                .load(pic)
                .into(imageView01);
    }

    @Override
    protected BasePresenter getPresenter() {
        return new IPresenter();
    }

    @Override
    protected void initView() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingActivity.this, Main2Activity.class);
                startActivity(intent);

            }
        });
        smartRefreshLayout.finishLoadMore(true);
        smartRefreshLayout.finishRefresh(true);
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page=1;
                list.clear();
                mpresenter.JsonPrenseter();
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                mpresenter.JsonPrenseter();
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_shopping;
    }

    @Override
    public void LoginGetInfo(LoginBean loginBean) {

    }

    @Override
    public void LoginError(Throwable throwable) {

    }

    @Override
    public void EnterGetInfo(EnterBean enterBean) {

    }

    @Override
    public void EnterError(Throwable throwable) {

    }

    @Override
    public void JsonGetInfo(JsonBean jsonBean) {
        list.addAll(jsonBean.getResult());
        MyAdapter myAdapter = new MyAdapter(list);
        jsonListview.setAdapter(myAdapter);
        myAdapter.setOnClickLisnner(new MyAdapter.OnClickLisnner() {
            @Override
            public void onClick() {
                price.setText("￥" + myAdapter.getSumprice());
                bt.setText("去结算:(" + myAdapter.numbean() + ")");
                ch.setChecked(myAdapter.getAllCheck());
            }
        });

        for (int i = 0; i < list.size(); i++) {
            jsonListview.expandGroup(i);
        }
        ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myAdapter != null) {
                    boolean allCheck = myAdapter.getAllCheck();
                    allCheck = !allCheck;
                    myAdapter.getChangeAllCheck(allCheck);
                    price.setText("￥" + myAdapter.getSumprice());
                    bt.setText("去结算:(" + myAdapter.numbean() + ")");
                }
            }
        });

    }

    @Override
    public void JsonError(Throwable throwable) {

    }

}
