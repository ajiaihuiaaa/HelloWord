package com.example.helloword.jump;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.helloword.R;

public class AActivity extends AppCompatActivity {
    private Button mBtnJump;
    private Button mBtnJump2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aactivity);
        Log.d("AActivity:", "----onCreate----");
        Log.d("AActivity", "taskid:" + getTaskId() + "   ,hash:" + hashCode());
        logTaskName();

        mBtnJump = (Button) findViewById(R.id.btn_jump);
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // activity跳转
                // 显式 1：
                Intent intent = new Intent(AActivity.this, BActivity.class);
                // 传入数据
                Bundle bundle = new Bundle();
                bundle.putString("name", "hello");
                bundle.putInt("num", 20);
                intent.putExtras(bundle);
                startActivity(intent);


                // 显式2:
//                Intent intent = new Intent();
//                intent.setClass(AActivity.this,BActivity.class);
//                startActivity(intent);

                // 显式3:
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this,"com.example.helloword.jump.BActivity");
//                startActivity(intent);

                // 显式4:
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this,"com.example.helloword.jump.BActivity"));
//                startActivity(intent);

                // 隐式 1：
                // 需要在manifest中的activity中添加action
//                Intent intent = new Intent();
//                intent.setAction("com.example.test.BActivity");
//                startActivity(intent);
            }
        });

        mBtnJump2 = (Button) findViewById(R.id.btn_jump_2);
        mBtnJump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this, AActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActivity:", "----onNewIntent----");
        Log.d("AActivity", "taskid:" + getTaskId() + "   ,hash:" + hashCode());
        logTaskName();
    }

    private void logTaskName() {
        try {
            ActivityInfo activityInfo = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("AActivity:", "task name:" + activityInfo.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}