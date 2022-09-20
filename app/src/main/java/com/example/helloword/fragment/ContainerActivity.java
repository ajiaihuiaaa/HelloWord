package com.example.helloword.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.helloword.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick {
    private AFragment aFragment;
    private BFragment bFragment;
    private Button mBtnChange;
    private TextView mTvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        mTvMessage = (TextView) findViewById(R.id.tv_text);
//        aFragment = new AFragment();
        aFragment = AFragment.newInstance("new I am aFragment");
        bFragment = new BFragment();
        // "a" 是打的tag
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, aFragment, "a").commitAllowingStateLoss();
        mBtnChange = (Button) findViewById(R.id.btn_change);
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).commitAllowingStateLoss();
            }
        });
    }

    public void setText(String str){
        mTvMessage.setText(str);
    }

    @Override
    public void onClick(String str) {
        mTvMessage.setText(str);
    }
}