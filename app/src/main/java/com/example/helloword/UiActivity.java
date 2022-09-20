package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.helloword.listview.ListViewActivity;
import com.example.helloword.gridview.GridViewActivity;
import com.example.helloword.recycleview.RecycleViewActivity;

public class UiActivity extends AppCompatActivity {
    // 在layout中画了一个button，所以在这里需要定义一个button对应它
    // 在设置背景颜色时发现无法设置，需要在values中的themes中修改默认的主题，改成
    // parent="Theme.MaterialComponents.DayNight.NoActionBar.Bridge"
    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEdit;
    private Button mBtnRadioButton;
    private Button mBtnRadioBox;
    private Button mBtnImageview;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnRecycleView;
    private Button mBtnWebView;
    private Button mBtnToast;
    private Button mBtnAlert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        // findViewById返回的是一个view，需要通过强行转换成Button
        mBtnTextView = (Button) findViewById(R.id.btn_textview);
        mBtnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 从这里跳转到textView演示界面
                Intent intent = new Intent(UiActivity.this,textViewActivity.class);
                startActivity(intent);
            }
        });
        mBtnButton = (Button) findViewById(R.id.button);
        mBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 从这里跳转到button演示界面
                Intent intent = new Intent(UiActivity.this,ButtonActivity.class);
                startActivity(intent);
            }
        });
        mBtnEdit = (Button) findViewById(R.id.editText);
        mBtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UiActivity.this,EditTextActivity.class);
                startActivity(intent);
            }
        });

        mBtnRadioButton = (Button) findViewById(R.id.button_radio_button);
        mBtnRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UiActivity.this,RadioButtonActivity.class);
                startActivity(intent);
            }
        });

        mBtnRadioBox = (Button) findViewById(R.id.button_check_box);
        mBtnRadioBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UiActivity.this,CheckBoxActivity.class);
                startActivity(intent);
            }
        });

        mBtnImageview = (Button) findViewById(R.id.button_image_view);
        mBtnImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UiActivity.this,ImageviewActivity.class);
                startActivity(intent);
            }
        });

        mBtnListView = (Button) findViewById(R.id.button_list_view);
        mBtnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UiActivity.this,ListViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnGridView = (Button) findViewById(R.id.button_grid_view);
        mBtnGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UiActivity.this,GridViewActivity.class);
                startActivity(intent);
            }
        });
        mBtnRecycleView = (Button) this.findViewById(R.id.button_recycle_view);
        mBtnRecycleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UiActivity.this, RecycleViewActivity.class);
                startActivity(intent);
            }
        });
        mBtnWebView = (Button) findViewById(R.id.btn_webview);
        mBtnWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UiActivity.this,WebViewActivity.class);
                startActivity(intent);
            }
        });
        mBtnToast = (Button) findViewById(R.id.btn_toast);
        mBtnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UiActivity.this,ToastActivity.class);
                startActivity(intent);
            }
        });

        mBtnAlert = (Button) findViewById(R.id.btn_alert_dialog);
        mBtnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AlertDialogActivity.class);
                startActivity(intent);
            }
        });
    }
}