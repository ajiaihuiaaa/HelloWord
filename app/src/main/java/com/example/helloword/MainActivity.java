package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloword.datastorage.DataStorageActivity;

public class MainActivity extends AppCompatActivity {
    private Button mBtnUi;
    private Button mBtnContorl;
    private Button mBtnData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


    }

}