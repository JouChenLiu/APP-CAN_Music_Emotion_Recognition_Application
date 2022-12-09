package com.example.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.myapplication.blindbox;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class fallingoff8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fallingoff8);

        FloatingActionButton back_bt = findViewById(R.id.back_bt);
        back_bt.setOnClickListener(new View.OnClickListener() { //點擊後執行返回上一頁的指令
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(fallingoff8.this, usermood_third.class);
                startActivity(intent);
            }
        });


    }
}