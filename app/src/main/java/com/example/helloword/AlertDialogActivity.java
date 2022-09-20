package com.example.helloword;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity {
    private Button mBtnAlert1, mBtnAlert2, mBtnAlert3, mBtnAlert4, mBtnAlert5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        mBtnAlert1 = (Button) findViewById(R.id.btn_alert1);
        mBtnAlert2 = (Button) findViewById(R.id.btn_alert2);
        mBtnAlert3 = (Button) findViewById(R.id.btn_alert3);
        mBtnAlert4 = (Button) findViewById(R.id.btn_alert4);
        mBtnAlert5 = (Button) findViewById(R.id.btn_alert5);
        OnClick onClick = new OnClick();
        mBtnAlert1.setOnClickListener(onClick);
        mBtnAlert2.setOnClickListener(onClick);
        mBtnAlert3.setOnClickListener(onClick);
        mBtnAlert4.setOnClickListener(onClick);
        mBtnAlert5.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_alert1:
                    // default
                    // 这里用到了链式，也可以分开写
                    AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder.setTitle("please answer").setMessage("how about the lesson")
                            .setIcon(R.drawable.eye)
                            .setPositiveButton("good", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(AlertDialogActivity.this, "thanks", Toast.LENGTH_SHORT).show();
                                }
                            }).setNeutralButton("neutral", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(AlertDialogActivity.this, "thanks also", Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("bad", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(AlertDialogActivity.this, "sorry", Toast.LENGTH_SHORT).show();
                        }
                    }).show();
                    break;
                case R.id.btn_alert2:
                    final String[] array2 = new String[]{"male", "female"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder2.setTitle("select gender").setItems(array2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(AlertDialogActivity.this, array2[which], Toast.LENGTH_SHORT).show();
                        }
                    }).show();
                    break;
                case R.id.btn_alert3:
                    final String[] array3 = new String[]{"male", "female"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder3.setSingleChoiceItems(array3, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(AlertDialogActivity.this, array3[which], Toast.LENGTH_SHORT).show();
                            dialog.dismiss();     // after selection,close the dialog
                        }
                    })
                            .setCancelable(false)        // click other interface,the dialog will not close
                            .show();
                    break;
                case R.id.btn_alert4:
                    final String[] array4 = new String[]{"sing", "dance", "film"};
                    boolean[] isSelected = new boolean[]{false, false, false};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder4.setTitle("select your interests")
                            .setMultiChoiceItems(array4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                    Toast.makeText(AlertDialogActivity.this, array4[which] + ":" + isChecked, Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String s = "";
                                    for (int i = 0; i < isSelected.length; i++) {
                                        if (isSelected[i]) {
                                            s = s + array4[i] + ",";
                                        }
                                    }
                                    Toast.makeText(AlertDialogActivity.this, s, Toast.LENGTH_SHORT).show();
                                }
                            })
                            .show();
                    break;
                case R.id.btn_alert5:
                    // display the custom interface
                    View view = LayoutInflater.from(AlertDialogActivity.this).inflate(R.layout.layout_alert_dialog, null);
                    EditText userName = (EditText) view.findViewById(R.id.et_user_name);
                    EditText password = (EditText) view.findViewById(R.id.et_password);
                    Button mBtnLogin = (Button) view.findViewById(R.id.btn_login);
                    mBtnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String strUserName = userName.getText().toString();
                            String strPassword = password.getText().toString();
                            String strPrint = strUserName + "+" + strPassword;
                            Toast.makeText(AlertDialogActivity.this, strPrint, Toast.LENGTH_SHORT).show();
                        }
                    });
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder5.setTitle("please login")
                            .setView(view)
                            .show();
                    break;
            }
        }
    }
}