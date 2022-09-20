package com.example.helloword.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.helloword.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SharePregerenceActivity extends AppCompatActivity {
    private Button mBtnSave, mBtnShow;
    private EditText mEtName;
    private TextView mTvContent;
    private SharedPreferences mSharePreference;
    private SharedPreferences.Editor mEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_pregerence);
        mBtnSave = (Button) findViewById(R.id.btn_save);
        mBtnShow = (Button) findViewById(R.id.btn_show);
        mEtName = (EditText) findViewById(R.id.et_name);
        mTvContent = (TextView) findViewById(R.id.tv_content);
        mSharePreference = this.getSharedPreferences("data", MODE_PRIVATE);
        mEditor = mSharePreference.edit();

        // listener
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.putString("name", mEtName.getText().toString());
                mEditor.apply();
            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvContent.setText(mSharePreference.getString("name", ""));
            }
        });
    }
}