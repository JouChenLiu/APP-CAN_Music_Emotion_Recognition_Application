package com.example.myapplication.view;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.myapplication.R;
import com.example.myapplication.grade_music;
import com.example.myapplication.music_profile;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Timer;
import java.util.TimerTask;

public class fallingoff1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fallingoff1);

        Timer timer = MainActivity.timer;
        FloatingActionButton back_bt = findViewById(R.id.back_bt);
        back_bt.setOnClickListener(new View.OnClickListener() { //點擊後執行返回上一頁的指令
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(fallingoff1.this, usermood_third.class);
                startActivity(intent);
            }
        });

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent();
                intent.setClass(fallingoff1.this, music_profile.class);
                startActivity(intent);
            }
        });
        t.start();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("簽收單","簽收單", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        Intent intent = new Intent(fallingoff1.this, grade_music.class);
        PendingIntent pendingintent = PendingIntent.getActivity(this,0,intent,0);

        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(fallingoff1.this,"簽收單");
                builder.setContentTitle("心情簽收單");
                builder.setContentText("記得簽收你的心情狀態喔!");
                builder.setSmallIcon(R.drawable.ic_baseline_insert_comment_24);
                builder.setAutoCancel(true);
                builder.setContentIntent(pendingintent);
                NotificationManagerCompat managerCompat =  NotificationManagerCompat.from(fallingoff1.this);
                managerCompat.notify(1, builder.build());
            }
        };
        timer.schedule(task,6000);
    }
}
