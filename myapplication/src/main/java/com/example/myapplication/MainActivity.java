package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.EncryptUtils;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.EnterBean;
import com.example.myapplication.bean.JsonBean;
import com.example.myapplication.bean.LoginBean;
import com.example.myapplication.presenter.IPresenter;

import java.time.temporal.TemporalUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.edit_pwd)
    EditText editPwd;
    @BindView(R.id.denglu_button)
    Button dengluButton;
    @BindView(R.id.zhuce_button)
    Button zhuceButton;
    private Intent intent1;

    @Override
    protected void startPresenter() {

    }

    @Override
    protected BasePresenter getPresenter() {
        return new IPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void LoginGetInfo(LoginBean loginBean) {
        Toast.makeText(this, ""+loginBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoginError(Throwable throwable) {
        Log.e("login",throwable.getMessage());
    }

    @Override
    public void EnterGetInfo(EnterBean enterBean) {
       if(enterBean.getStatus().equals("0000")){
           String headPic = enterBean.getResult().getHeadPic();
           Log.e("hand",headPic);
           Intent intent=new Intent(this, ShoppingActivity.class);
           intent.putExtra("pic",headPic);
           startActivity(intent);
       }else{
           Toast.makeText(this, enterBean.getMessage(), Toast.LENGTH_SHORT).show();
       }
    }

    @Override
    public void EnterError(Throwable throwable) {
        Log.e("login",throwable.getMessage());
    }

    @Override
    public void JsonGetInfo(JsonBean jsonBean) {

    }

    @Override
    public void JsonError(Throwable throwable) {

    }

    @OnClick({R.id.denglu_button, R.id.zhuce_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.denglu_button:
                String phone = editPhone.getText().toString();
                if (TextUtils.isEmpty(phone)){
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String pwd = editPwd.getText().toString();
                if (TextUtils.isEmpty(pwd)){
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String s = EncryptUtils.encryptMD5ToString(pwd);
                mpresenter.EnterPresenter(phone,s);
                break;
            case R.id.zhuce_button:
                String phone1 = editPhone.getText().toString();
                if (TextUtils.isEmpty(phone1)){
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String pwd1 = editPwd.getText().toString();
                if (TextUtils.isEmpty(pwd1)){
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String s1 = EncryptUtils.encryptMD5ToString(pwd1);
                mpresenter.LoginPresenter(phone1,s1);
                break;

        }
    }
}
