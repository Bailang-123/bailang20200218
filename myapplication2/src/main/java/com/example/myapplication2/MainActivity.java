package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.myapplication2.base.BaseActivity;
import com.example.myapplication2.base.BasePresenter;
import com.example.myapplication2.bean.DlBean;
import com.example.myapplication2.bean.ZcBean;
import com.example.myapplication2.presenter.MyPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.phone_edit)
    EditText phoneEdit;
    @BindView(R.id.pwd_edit)
    EditText pwdEdit;
    @BindView(R.id.dl_button)
    Button dlButton;
    @BindView(R.id.zc_button)
    Button zcButton;

    @Override
    protected void startPresenter() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter getPresenter() {
        return new MyPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void RightSccess(ZcBean zcBean) {
        Toast.makeText(this, zcBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void RightError(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoginSccess(DlBean dlBean) {
        Toast.makeText(this, dlBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoginError(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }


    @OnClick({R.id.dl_button, R.id.zc_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dl_button:
                String phone = phoneEdit.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }
                String pwd = phoneEdit.getText().toString().trim();
                if (TextUtils.isEmpty(pwd)) {
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }
                String substring = pwd.substring(0, 6);
                presenters.LoginPresenterInfo(phone, substring);
                break;
            case R.id.zc_button:
                String phone1 = phoneEdit.getText().toString().trim();
                if (TextUtils.isEmpty(phone1)) {
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }
                String pwd1 = phoneEdit.getText().toString().trim();
                if (TextUtils.isEmpty(pwd1)) {
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }
                String substring1 = pwd1.substring(0, 6);
                presenters.LoginPresenterInfo(phone1, substring1);
                break;
        }
    }
}
