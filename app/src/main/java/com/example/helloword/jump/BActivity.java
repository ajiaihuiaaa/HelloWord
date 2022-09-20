package com.example.helloword.jump;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.helloword.R;

public class BActivity extends AppCompatActivity {
    private TextView mTvDisplay;
    private Button mBtnJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bactivity);
        Log.d("BActivity", "----onCreate----");
        Log.d("BActivity", "taskid:" + getTaskId() + "   ,hash:" + hashCode());
        logTaskName();
        mTvDisplay = (TextView) findViewById(R.id.tv_display);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        int num = bundle.getInt("num");
        mTvDisplay.setText(name + num);
        mBtnJump = (Button) findViewById(R.id.btn_jump_3);
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BActivity.this, AActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("BActivity:", "----onNewIntent----");
        Log.d("Bctivity", "taskid:" + getTaskId() + "   ,hash:" + hashCode());
        logTaskName();
    }

    private void logTaskName() {
        try {
            ActivityInfo activityInfo = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("BActivity", "task name:" + activityInfo.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}