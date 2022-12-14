package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloword.datastorage.DataStorageActivity;

public class MainActivity extends AppCompatActivity {
    private Button mBtnUi;
    private Button mBtnContorl;
    private Button mBtnData;
    private Button mBtnAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 申请读取存储权限
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        mBtnUi = (Button) findViewById(R.id.btn_ui);
        mBtnUi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UiActivity.class);
                startActivity(intent);
            }
        });

        mBtnContorl = (Button) findViewById(R.id.btn_control);
        mBtnContorl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ControlActivity.class);
                startActivity(intent);
            }
        });

        mBtnData = (Button) findViewById(R.id.btn_data);
        mBtnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DataStorageActivity.class);
                startActivity(intent);
            }
        });

        mBtnAnimation = (Button) findViewById(R.id.btn_animation);
        mBtnAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ObjectAnimationMainActivity.class);
                startActivity(intent);
            }
        });


    }

}