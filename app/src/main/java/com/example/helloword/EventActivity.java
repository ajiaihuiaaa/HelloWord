package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.helloword.widget.MyButton;

public class EventActivity extends AppCompatActivity {
    private MyButton mBtnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnClick = (MyButton) findViewById(R.id.btn_click);
        // 为了证明是先调用的监听方法，再调用的回调函数
        mBtnClick.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener","-----onTouch-----");
                        break;
                }
                return false;
            }
        });
        mBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Listener","-----onClick-----");
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("Activity:","------onEvent------");
                break;
        }
        return false;    // true:这是最后一步，后面就不调用了；  false：后面的可以继续执行
    }
}