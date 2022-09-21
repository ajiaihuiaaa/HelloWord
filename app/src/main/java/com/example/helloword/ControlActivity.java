package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloword.broadcast.BroadActivity;
import com.example.helloword.broadcast.BroadActivity2;
import com.example.helloword.jump.AActivity;
import com.example.helloword.fragment.*;

public class ControlActivity extends AppCompatActivity {
    private Button mBtnAlert;
    private Button mBtnBind;
    private Button mBtnSpinner;
    private Button mBtnProgressBar;
    private Button mBtnCustomDialog;
    private Button mBtnPopupwindow;
    private Button mBtnLifeCycle;
    private Button mBtnJumpA;
    private Button mBtnFragment;
    private Button mBtnEvent;
    private Button mBtnHandler;
    private Button mBtnBroad;
    private Button mBtnBroad2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        mBtnAlert = (Button) findViewById(R.id.btn_alert_dialog1);
        mBtnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AlertDialogActivity.class);
                startActivity(intent);
            }
        });
        mBtnBind = (Button) findViewById(R.id.btn_bind_fun);
        mBtnBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ControlActivity.this, BindActivity.class);
                startActivity(intent);
            }
        });

        mBtnSpinner = (Button) findViewById(R.id.btn_spinner);
        mBtnSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ControlActivity.this, SpinnerActivity.class);
                startActivity(intent);
            }
        });

        mBtnProgressBar = (Button) findViewById(R.id.btn_progress_bar);
        mBtnProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ControlActivity.this, ProgressBarActivity.class);
                startActivity(intent);
            }
        });

        mBtnCustomDialog = (Button) findViewById(R.id.btn_custom_dialog);
        mBtnCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ControlActivity.this, CustomDialogActivity.class);
                startActivity(intent);
            }
        });

        mBtnPopupwindow = (Button) findViewById(R.id.btn_popupwindow);
        mBtnPopupwindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ControlActivity.this, PopupwindowActivity.class);
                startActivity(intent);
            }
        });

        mBtnLifeCycle = (Button) findViewById(R.id.btn_life_cycle);
        mBtnLifeCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ControlActivity.this, LifeCycleActivity.class);
                startActivity(intent);
            }
        });

        mBtnJumpA = (Button) findViewById(R.id.btn_jump);
        mBtnJumpA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ControlActivity.this, AActivity.class);
                startActivity(intent);
            }
        });

        mBtnFragment = (Button) findViewById(R.id.btn_fragment);
        mBtnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ControlActivity.this, ContainerActivity.class);
                startActivity(intent);
            }
        });

        mBtnEvent = (Button) findViewById(R.id.btn_event);
        mBtnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ControlActivity.this, EventActivity.class);
                startActivity(intent);
            }
        });

        mBtnHandler = (Button) findViewById(R.id.btn_handler);
        mBtnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ControlActivity.this, HandlerActivity.class);
                startActivity(intent);
            }
        });

        mBtnBroad = (Button) findViewById(R.id.btn_broadcast);
        mBtnBroad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ControlActivity.this, BroadActivity.class);
                startActivity(intent);
            }
        });

        mBtnBroad2 = (Button) findViewById(R.id.btn_broadcast2);
        mBtnBroad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ControlActivity.this, BroadActivity2.class);
                startActivity(intent);
            }
        });
    }
}