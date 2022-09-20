package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
// 好好观察一下 后台、关闭时会调用哪些方法
public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d("Lifecycle","----oncreate----");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle","----start----");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle","----onResume----");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle","----onPause----");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle","----onStop----");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle","----onRestart----");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle","----onDestroy----");
    }
}