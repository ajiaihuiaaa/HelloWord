package com.example.helloword.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloword.R;

public class RecycleViewActivity extends AppCompatActivity {
    private Button mBtnLinear, mBtnHor, mBtnGrid,mBtnPu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        mBtnLinear = (Button) findViewById(R.id.btn_linear);
        mBtnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleViewActivity.this, LinearRecycleViewActivity.class);
                startActivity(intent);
            }
        });
        mBtnHor = (Button) findViewById(R.id.btn_hor);
        mBtnHor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleViewActivity.this, HorRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        mBtnGrid = (Button) findViewById(R.id.btn_grid);
        mBtnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleViewActivity.this, GridRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        mBtnPu = (Button) findViewById(R.id.rv_pu);
        mBtnPu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleViewActivity.this,PuRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}