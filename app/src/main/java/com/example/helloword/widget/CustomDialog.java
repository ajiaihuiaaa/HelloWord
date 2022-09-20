package com.example.helloword.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.helloword.R;

public class CustomDialog extends Dialog implements View.OnClickListener {
    private TextView mTvTile, mTvMessage, mTvCancel, mTvConfirm;
    private IOnCancelListener cancelListener;
    private IOnConfirmListener confirmListener;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCancelText(String cancel) {
        this.cancel = cancel;
    }

    public void setConfirmText(String confirm) {
        this.confirm = confirm;
    }

    public void setOnCancelClickListener(IOnCancelListener iOnCancelListener){
        this.cancelListener = iOnCancelListener;
    }

    public void setOnConfirmClickListener(IOnConfirmListener iOnConfirmListener){
        this.confirmListener = iOnConfirmListener;
    }

    private String title, message, cancel, confirm;


    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);

        // 设置dialog的宽度
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int) (size.x * 0.8);
        getWindow().setAttributes(p);

        mTvTile = (TextView) findViewById(R.id.tv_title);
        mTvMessage = (TextView) findViewById(R.id.tv_message);
        mTvCancel = (TextView) findViewById(R.id.tv_cancel);
        mTvConfirm = (TextView) findViewById(R.id.tv_confirm);
        if (!TextUtils.isEmpty(title)) {
            mTvTile.setText(title);
        }
        if (!TextUtils.isEmpty(message)) {
            mTvMessage.setText(message);
        }
        if (!TextUtils.isEmpty(cancel)) {
            mTvCancel.setText(cancel);
        }
        if (!TextUtils.isEmpty(confirm)) {
            mTvConfirm.setText(confirm);
        }
        mTvCancel.setOnClickListener(this);
        mTvConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                if (cancelListener != null) {
                    cancelListener.onCancel(this);
                }
                this.dismiss();
                break;
            case R.id.tv_confirm:
                if (confirmListener != null) {
                    confirmListener.OnConfirm(this);
                }
                this.dismiss();
                break;
        }
    }

    public interface IOnCancelListener {
        void onCancel(CustomDialog customDialog);
    }

    public interface IOnConfirmListener {
        void OnConfirm(CustomDialog customDialog);
    }

}
