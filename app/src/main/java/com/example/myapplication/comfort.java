package com.example.myapplication;

import static com.google.firebase.database.Query.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapplication.view.MainActivity;
import com.example.myapplication.view.usermood_second;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class comfort extends AppCompatActivity{

    FloatingActionButton fab, fab1, fab2;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;

    boolean isOpen = false;

    String[] songs = {
            "https://media.giphy.com/media/oToaV4NYuCnWzSgruR/giphy.mp4", "https://media.giphy.com/media/IFHciwv8MkiPCr2XsQ/giphy.mp4", "https://media.giphy.com/media/iLbXsLTzXuHK1K1SJZ/giphy.mp4", "https://media.giphy.com/media/eM81Dypc193FjCAixF/giphy.mp4", "https://media.giphy.com/media/Vb3SdlyYGJeKqvH32l/giphy.mp4", "https://media.giphy.com/media/mc7reGWBeI25zD63UI/giphy.mp4", "https://media.giphy.com/media/Fs7LUZC7a6d5vnizzA/giphy.mp4"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comfort);

        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        final ViewPager2 viewPager2 = findViewById(R.id.viewPager2);

        List<VideoItem> videoItems = new ArrayList<>();

        int min = 1;
        //曲目數加一
        int max = 8;
        Set<Integer> set = new HashSet<Integer>();
        int[] array = new int[3];
        for (; true;) {
            // 調用Math.random()方法
            int num = (int) (Math.random() * (max - min)) + min;

            // 將不同的數存入HashSet中
            set.add(num);
            // 如果存入的數小於指定生成的個數，則調用遞歸再生成剩餘個數的隨機數，如此循環，直到達到指定大小
            if (set.size() >= 3) {
                break;
            }
        }
        int i = 0;
        for (int a : set) {
            array[i] = a;
            i++;
        }

        //Videos
        VideoItem video01 = new VideoItem();
        video01.url = songs[array[0]];
        //video01.title = "Don't stop!";
        videoItems.add(video01);

        VideoItem video02 = new VideoItem();
        video02.url = songs[array[1]];
        //video02.title = "you are the light of yourself";
        videoItems.add(video02);

        VideoItem video03 = new VideoItem();
        video03.url = songs[array[2]];
        //video03.title = "I have your back";
        videoItems.add(video03);

        //Adapter
        viewPager2.setAdapter(new VideoAdapter(videoItems));


        fab = (FloatingActionButton) findViewById(R.id.edit_fab);
        fab1 = (FloatingActionButton) findViewById(R.id.aspect_ratio_fab);
        fab2 = (FloatingActionButton) findViewById(R.id.crop_fab);

        final MediaPlayer mp = MediaPlayer.create(comfort.this, R.raw.acousticbreeze);
        mp.setLooping(true);

        //animations
        fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close);

        rotateForward = AnimationUtils.loadAnimation(this, R.anim.rotate_forward);
        rotateBackward = AnimationUtils.loadAnimation(this, R.anim.rotate_backward);

        Button button_start = findViewById(R.id.button);
        button_start.setOnClickListener(new View.OnClickListener() { //點擊後執行跳頁的指令
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(comfort.this, MainActivity.class);
                startActivity(intent);
                mp.stop();

            }
        });


        //Set the click listener on the MAIN FAB
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
            }
        });

        mp.start();
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(comfort.this, "music clicked", Toast.LENGTH_SHORT).show();
                if(mp.isPlaying()) {
                    mp.pause();
                    fab1.setImageDrawable(getResources().getDrawable(R.drawable.ic_nomusic));
                }else {
                    mp.start();
                    fab1.setImageDrawable(getResources().getDrawable(R.drawable.ic_music));
                }

            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String Body = "Download this APP";
                String Sub = "http://play.google.com/store/apps/details?="+BuildConfig.APPLICATION_ID+"\n\n";
                intent.putExtra(Intent.EXTRA_TEXT, Body);
                intent.putExtra(Intent.EXTRA_TEXT, Sub);
                startActivity(Intent.createChooser(intent, "Share Via"));
                //Toast.makeText(MainActivity.this, "Camera clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void animateFab() {
        if (isOpen) {
            fab.startAnimation(rotateForward);
            fab1.startAnimation(fabClose);
            fab2.startAnimation(fabClose);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isOpen=false;
        }
        else {
            fab.startAnimation(rotateBackward);
            fab1.startAnimation(fabOpen);
            fab2.startAnimation(fabOpen);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isOpen=true;
        }
    }
}
