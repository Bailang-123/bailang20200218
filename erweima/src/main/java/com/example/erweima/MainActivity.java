package com.example.erweima;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.shengcheng_buttton)
    Button shengchengButtton;
    @BindView(R.id.shibie_buttton)
    Button shibieButtton;
    @BindView(R.id.sys_buttton)
    Button sysButtton;
    @BindView(R.id.image_name)
    ImageView imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        CodeUtils.init(this);
    }

    @OnClick({R.id.shengcheng_buttton, R.id.shibie_buttton, R.id.sys_buttton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shengcheng_buttton:
                String s = editName.getText().toString();
                Bitmap image = CodeUtils.createImage(s, 200, 200, null);
                imageName.setImageBitmap(image);
                break;
            case R.id.shibie_buttton:
                CodeUtils.analyzeByPhotos(this);
                break;
            case R.id.sys_buttton:
                CodeUtils.analyzeByCamera(this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        CodeUtils.onActivityResult(this, requestCode, resultCode, data, new CodeUtils.AnalyzeCallback() {
            @Override
            public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                Toast.makeText(MainActivity.this, "相册已打开"+result, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnalyzeFailed() {
                Toast.makeText(MainActivity.this, "相册打开失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
