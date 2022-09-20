package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.helloword.databinding.ActivityBindBinding;

public class BindActivity extends AppCompatActivity {
    private ActivityBindBinding binding;
    private boolean pressedBtn1 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBindBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pressedBtn1 == false){
                    pressedBtn1 = true;
                }else{
                    pressedBtn1 = false;

                }
            }
        });

    }
}