package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.helloword.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {
    private Button mBtnCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        mBtnCustomDialog = (Button) findViewById(R.id.btn_custom);
        mBtnCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this, R.style.CustomDialog);
                customDialog.setTitle("提示");
                customDialog.setMessage("确认删除？");
                customDialog.setCancelText("取消");
                customDialog.setOnCancelClickListener(new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog customDialog) {
                        Toast.makeText(CustomDialogActivity.this,"取消",Toast.LENGTH_SHORT).show();
                    }
                });
                customDialog.setConfirmText("确认");
                customDialog.setOnConfirmClickListener(new CustomDialog.IOnConfirmListener() {
                    @Override
                    public void OnConfirm(CustomDialog customDialog) {
                        Toast.makeText(CustomDialogActivity.this,"确认",Toast.LENGTH_SHORT).show();
                    }
                });
                customDialog.show();
            }
        });
    }
}