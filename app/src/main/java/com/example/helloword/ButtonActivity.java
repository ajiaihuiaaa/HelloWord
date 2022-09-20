package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    private Button mBtn3;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        //实现点击事件
        mBtn3 = (Button) findViewById(R.id.button03);
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this,"点击了3",Toast.LENGTH_SHORT).show();
            }
        });
        //textView也可以实现点击事件
        textView = (TextView) findViewById(R.id.textview08);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this,"点击了textView",Toast.LENGTH_SHORT).show();
            }
        });
    }
//这里用了另外一种方法实现点击事件
    public void showToast(View view){
        Toast.makeText(this,"点击了4",Toast.LENGTH_SHORT).show();
    }
}