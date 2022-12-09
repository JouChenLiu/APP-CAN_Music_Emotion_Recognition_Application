package com.example.myapplication.view;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.Random;

public class heart_lake extends AppCompatActivity implements View.OnClickListener {
    private ImageView pause;
    private MediaPlayer mPlayer;
    ImageButton switch_bt;
    int soundIndex;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heart_lake);
        initPlayer();   //進入頁面加載音樂
        initView();
    }

    private void initPlayer() {
        //initializing media player
        mPlayer = new MediaPlayer();

        /*
        mPlayer = MediaPlayer.create(this, R.raw.happy_home);
        mPlayer = MediaPlayer.create(this, R.raw.dance_for_two);
        mPlayer = MediaPlayer.create(this, R.raw.candlelight);
        mPlayer = MediaPlayer.create(this, R.raw.love_story_theme);
        mPlayer = MediaPlayer.create(this, R.raw.cartoons);
        mPlayer = MediaPlayer.create(this, R.raw.discovery);
        mPlayer = MediaPlayer.create(this, R.raw.bright_future);
        */

        //get random sound index
        soundIndex = getRandomSoundIndex();

        //make media player
        mPlayer = MediaPlayer.create(heart_lake.this, soundIndex);

        switch_bt = findViewById(R.id.switchsong);
        switch_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Random r = new Random(arr.length);

                //get random sound index
                soundIndex = getRandomSoundIndex();

                mPlayer.reset();
                mPlayer = MediaPlayer.create(heart_lake.this, soundIndex);
                mPlayer.start();    //開始播放音樂

                pause.setBackgroundResource(R.drawable.pause_circle_w1);
                isPause = true;

                Toast.makeText(getApplicationContext(),"隨機換歌",Toast.LENGTH_SHORT).show();
            }
        });

        mPlayer.setLooping(true);   //設定是否循環播放
        mPlayer.start();    //開始播放音樂
        mPlayer.pause();    //暫停播放音樂
    }

    private  void initView() {
        pause = findViewById(R.id.pause);
        pause.setOnClickListener(this);
    }

    private boolean isPause = false;

    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.pause) {
            if (!isPause) {
                pause.setBackgroundResource(R.drawable.pause_circle_w1);
                mPlayer.start();    //繼續播放音樂
                isPause = true;
            } else {
                pause.setBackgroundResource(R.drawable.play_circle_w);
                mPlayer.pause();    //暫停播放音樂
                isPause = false;
            }
        }
    }

    protected void onDestroy() {    //銷毀
        super.onDestroy();
        mPlayer.stop(); //停止播放音樂
    }

    public int getRandomSoundIndex(){
        int [] songs = {R.raw.m1, R.raw.m2, R.raw.m3, R.raw.m4, R.raw.m5, R.raw.m6, R.raw.m7, R.raw.m8, R.raw.m9, R.raw.m10};

        Random random = new Random();
        soundIndex = random.nextInt(songs.length);

        return songs[soundIndex];
    }

}