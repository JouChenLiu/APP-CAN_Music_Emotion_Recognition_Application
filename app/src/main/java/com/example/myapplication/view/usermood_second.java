package com.example.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//設seekbar
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;
//https://ocean2002n.pixnet.net/blog/post/86982956-%5Bandroid%5D-seekbar-%E7%AF%84%E4%BE%8B
//http://denimpanell.blogspot.com/2018/01/android-studio-seekbar.html
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import com.example.myapplication.secondmood.second_mood;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.sql.Array;
import java.util.Arrays;

public class usermood_second extends AppCompatActivity {
    SeekBar seekbar;
    SeekBar seekbar2;
    SeekBar seekbar3;
    SeekBar seekbar4;
    TextView seektext1;
    TextView seektext2;
    TextView seektext3;
    TextView seektext4;
    DatabaseReference usermood;
    second_mood sc=new second_mood();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usermood_second);
        seekbar = (SeekBar) findViewById(R.id.seekBar1);
        seekbar.setMax(5);//設定SeekBar最大值
        seekbar.setProgress(0);
        seekbar.setOnSeekBarChangeListener(sbLis);
        seekbar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekbar2.setMax(5);//設定SeekBar最大值
        seekbar2.setProgress(0);
        seekbar2.setOnSeekBarChangeListener(sbLis2);
        seekbar3 = (SeekBar) findViewById(R.id.seekBar3);
        seekbar3.setMax(5);//設定SeekBar最大值
        seekbar3.setProgress(0);
        seekbar3.setOnSeekBarChangeListener(sbLis3);
        seekbar4 = (SeekBar) findViewById(R.id.seekBar4);
        seekbar4.setMax(5);//設定SeekBar最大值
        seekbar4.setProgress(0);
        seekbar4.setOnSeekBarChangeListener(sbLis4);
        seektext1 = (TextView) findViewById(R.id.seekText1);
        seektext2 = (TextView) findViewById(R.id.seekText2);
        seektext3 = (TextView) findViewById(R.id.seekText3);
        seektext4 = (TextView) findViewById(R.id.seekText4);
        usermood=FirebaseDatabase.getInstance().getReference().child("user_mood");
        Button mix_button = findViewById(R.id.mix_Button);
        mix_button.setOnClickListener(new View.OnClickListener() { //點擊後執行跳頁的指令
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(usermood_second.this, usermood_third.class);
                startActivity(intent);
                insertUserMood();
            }
        });
    }
    private void insertUserMood(){
        String mood=seektext1.getText().toString();
        String mood2=seektext2.getText().toString();
        String mood3=seektext3.getText().toString();
        String mood4=seektext4.getText().toString();
        String tag1="null";
        String date="11/05";
        String grade1="null";


        sc.setHappy(mood);
        sc.setRelax(mood2);
        sc.setAngry(mood3);
        sc.setSad(mood4);
        sc.setTag(tag1);
        sc.setDate(date);
        sc.setGrade(grade1);

//        second_mood user= new second_mood(mood,mood2,mood3,mood4,tag1,song_url);
        usermood.push().setValue(sc);
        Toast.makeText(usermood_second.this,"Mood Inserted",Toast.LENGTH_SHORT).show();
    }
    private OnSeekBarChangeListener sbLis=new OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            seektext1.setText(String.valueOf(seekbar.getProgress()));
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };
    private OnSeekBarChangeListener sbLis2=new OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            seektext2.setText(String.valueOf(seekbar2.getProgress()));
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };
    private OnSeekBarChangeListener sbLis3=new OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            seektext3.setText(String.valueOf(seekbar3.getProgress()));
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };
    private OnSeekBarChangeListener sbLis4=new OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            seektext4.setText(String.valueOf(seekbar4.getProgress()));
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };
}