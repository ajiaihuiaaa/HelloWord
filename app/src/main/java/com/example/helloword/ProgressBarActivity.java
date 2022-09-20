package com.example.helloword;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.os.Handler;
import android.widget.Toast;

public class ProgressBarActivity extends AppCompatActivity {
    private ProgressBar mPb3;
    private ProgressBar mPb4;
    private Button mBtnProgress;
    private Button mBtnpd1;
    private Button mBtnpd2;
    int a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        //
        mPb3 = (ProgressBar) findViewById(R.id.pb3);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (a < 100) {
                    a++;
                    try {
                        Thread.sleep(200); // sleep time
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mPb3.setProgress(a);
                }
            }
        }).start();
//
        mPb4 = (ProgressBar) findViewById(R.id.pb4);
        mBtnProgress = (Button) findViewById(R.id.btn_progress);
        mBtnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);
            }
        });

        //
        mBtnpd1 = (Button) findViewById(R.id.btn_progress_dialog1);
        mBtnpd2 = (Button) findViewById(R.id.btn_progress_dialog2);
        mBtnpd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = ProgressDialog.show(ProgressBarActivity.this,
                        "tip", "progressing");
                progressDialog.show();
                progressDialog.setCancelable(false);
            }
        });

        mBtnpd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressBarActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("tip");
                progressDialog.setMessage("progressing");
                progressDialog.show();
                progressDialog.setProgress(20);
                progressDialog.setMax(100);
                // 升级版本后没有按钮了
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        progressDialog.cancel();
                    }
                });
            }
        });


    }


    // 这里用了个handler
    // 首先调用handler.sendEmptyMessage(0)，然后会启用handleMessage，会启用handler.postDelayed(runnable, 500)
    // 然后会调用runnable，runnable里又会调用handler.sendEmptyMessage(0)，所以这里有一个循环。
    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (mPb4.getProgress() < 100) {
                handler.postDelayed(runnable, 500);
            } else {
                Toast.makeText(ProgressBarActivity.this, "complete", Toast.LENGTH_SHORT).show();
            }
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mPb4.setProgress(mPb4.getProgress() + 5);
            handler.sendEmptyMessage(0);
        }
    };
}

