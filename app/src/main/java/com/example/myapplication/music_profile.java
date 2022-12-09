package com.example.myapplication;

import static android.os.Process.killProcess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;

import com.example.myapplication.view.MainActivity;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;

import java.util.Timer;
import java.util.TimerTask;

public class music_profile extends AppCompatActivity {


    public static ViewPager viewPager;
    private FragmentManager fmgr;
    private radarFragment radarF;
    private musicFragment musicF;
    public static RadarChart radarchart;
    public static RadarData data;
    public static RadarDataSet set1 ;
    public static MediaPlayer player ;
    public Timer timer = MainActivity.timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_profile);


        viewPager = (ViewPager) findViewById(R.id.viewPager);
        SwipePagerAdapter swipePagerAdapter = new SwipePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(swipePagerAdapter);




    }

    @Override
    public void onBackPressed() {


    }


}