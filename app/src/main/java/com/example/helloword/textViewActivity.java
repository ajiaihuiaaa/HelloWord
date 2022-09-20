package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class textViewActivity extends AppCompatActivity {
    // 右击新建一个activity时，需要在androidMainfest中添加这个activity，一般系统会自动添加
    private TextView mTv4,mTv5,mTv6,mTv7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
//        添加中划线
        mTv4 = (TextView) findViewById(R.id.textView04);
        mTv4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);   // 中划线
        mTv4.getPaint().setAntiAlias(true); // 去除中划线的锯齿
//        添加下划线
        mTv5 = (TextView) findViewById(R.id.textView05);
        mTv5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
//        添加下划线的第二种方法 html
        mTv6 = (TextView) findViewById(R.id.textView06);
        mTv6.setText(Html.fromHtml("<u>text view</u>"));
//跑马灯
        mTv7 = (TextView) findViewById(R.id.textView07);
        mTv7.setSelected(true);

    }
}