package com.example.helloword.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloword.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnSharedPreference, mBtnInternalFile, mBtnExternalFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        mBtnSharedPreference = (Button) findViewById(R.id.btn_sharedpreferences);
        mBtnSharedPreference.setOnClickListener(this);
        mBtnInternalFile = (Button) findViewById(R.id.btn_file);
        mBtnInternalFile.setOnClickListener(this);
        mBtnExternalFile = (Button) findViewById(R.id.btn_external_file);
        mBtnExternalFile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_sharedpreferences:
                intent = new Intent(DataStorageActivity.this, SharePregerenceActivity.class);
                break;
            case R.id.btn_file:
                intent = new Intent(DataStorageActivity.this, InternalFileActivity.class);
                break;
            case R.id.btn_external_file:
                intent = new Intent(DataStorageActivity.this, ExternalFileActivity.class);
                break;
        }
        startActivity(intent);
    }
}