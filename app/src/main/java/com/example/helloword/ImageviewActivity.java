package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageviewActivity extends AppCompatActivity {
    private ImageView mIv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);
//        加载网络图片
//        使用的是Glide
//        需要在build.gradle中的dependencies中添加内容就可以使用了
        mIv4 = (ImageView) findViewById(R.id.iv_4);
        Glide.with(this).load("https://csdnimg.cn/pubfooter/images/job-QR.png").into(mIv4);
    }
}