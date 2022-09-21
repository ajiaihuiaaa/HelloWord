package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ObjectAnimationMainActivity extends AppCompatActivity {
    private TextView mTv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animation_main);
        mTv1 = (TextView) findViewById(R.id.tv_animation);
        /*
        // 简单
//        mTv1.animate().translationYBy(500).setDuration(2000).start();
*/
/*
// 监听动画处于什么状态
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.setDuration(4000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // valueAnimator实际的值
                Log.d("animation:", animation.getAnimatedValue() + "");
                // 动画的进度0-1
                Log.d("animation:", animation.getAnimatedFraction() + "");
            }
        });
        valueAnimator.start();
        */

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mTv1,"translationY",0,500,200,300);
        objectAnimator.setDuration(4000);
        objectAnimator.start();
    }
}