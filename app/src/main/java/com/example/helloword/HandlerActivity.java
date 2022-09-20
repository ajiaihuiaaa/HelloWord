package com.example.helloword;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class HandlerActivity extends AppCompatActivity {
    private Handler mHandler;
    // 用法1：延迟一段时间处理runnable方法
    // 用法2: handler 传递message，thread进行处理


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
//        fun1();
        fun2();
    }

    private void fun1() {
        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(HandlerActivity.this, AlertDialogActivity.class);
                startActivity(intent);
            }
        }, 3000);
    }

    private void fun2() {
        mHandler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        Toast.makeText(HandlerActivity.this, "线程开始", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        new Thread() {
            @Override
            public void run() {
                super.run();
                Message message = new Message();
                message.what = 1;
                mHandler.sendMessage(message);
            }
        }.start();
    }
}