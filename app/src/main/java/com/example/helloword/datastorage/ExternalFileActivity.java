package com.example.helloword.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.helloword.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExternalFileActivity extends AppCompatActivity {
    private Button mBtnSave, mBtnShow;
    private EditText mEtName;
    private TextView mTvContent;
    private final String mFileName = "test.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);
        mBtnSave = (Button) findViewById(R.id.btn_save);
        mBtnShow = (Button) findViewById(R.id.btn_show);
        mEtName = (EditText) findViewById(R.id.et_name);
        mTvContent = (TextView) findViewById(R.id.tv_content);

        // listener
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // trim:去除前后空格
                saveFile(mEtName.getText().toString().trim());
            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvContent.setText(readFile());
            }
        });
    }

    private void saveFile(String content) {
        FileOutputStream fileOutputStream = null;
        try {
            // 创建文件夹
            File dir = new File(this.getExternalFilesDir(null).getAbsolutePath(), "skypan");
            if (!dir.exists()) {
                dir.mkdir();
            }
            File file = new File(dir, mFileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String readFile() {
        FileInputStream fileInputStream = null;
        try {
            File file = new File(this.getExternalFilesDir(null).getAbsolutePath() +
                    File.separator + "skypan", mFileName);
            fileInputStream = new FileInputStream(file);
            byte[] buff = new byte[1024];
            StringBuilder stringBuilder = new StringBuilder();
            int len = 0;
            // fileInputStream.read(buff): 以1024的长度的buff进去读数据，存多少数据，len就是多少
            // 如果存的数是0，那么不满足条件，跳出while
            while ((len = fileInputStream.read(buff)) > 0) {
                stringBuilder.append(new String(buff, 0, len));
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}