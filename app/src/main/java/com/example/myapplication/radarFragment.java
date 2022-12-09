package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.example.myapplication.view.fallingoff3;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class radarFragment extends Fragment {

    public musicFragment musicf;
    public static RadarChart radarchart;
    public static RadarData data ;
    public static RadarDataSet set1 ;
    public static RadarDataSet set0 ;
    public Button emotion;
    public static int songnumber = musicFragment.songnumber;

    public static String[] labels = new String[6];



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_radar, container, false);

        emotion = (Button) v.findViewById(R.id.emotion);

        musicf = new musicFragment();


        List<Integer> colorlist = new ArrayList<>();

        radarchart = (RadarChart)v.findViewById(R.id.radarchart);

        set0 = new RadarDataSet( number0(),"");
        set0.setColor(Color.YELLOW);
        set0.setDrawFilled(true);
        set0.setDrawHighlightCircleEnabled(false);
        set0.setFillColor(Color.YELLOW);






        data = new RadarData();
        data.setValueTextColor(Color.WHITE);
        labels = new String[]{"Joy\n喜悅", "Sadness\n悲傷", "distaste\n厭惡", "hopeless\n絕望", "Warmth\n溫暖", "excited\n興奮"};
        data.addDataSet(set0);


        XAxis xAxis = radarchart.getXAxis();
        YAxis yAxis = radarchart.getYAxis();
        xAxis.setLabelCount(6, true);

        xAxis.setTextSize(15f);
        yAxis.setTextSize(15f);
        yAxis.setStartAtZero(true);
        yAxis.setDrawLabels(true);
        yAxis.setAxisMaximum(1);
        yAxis.setAxisMinimum(0);
        xAxis.setAxisMaximum(5);
        xAxis.setAxisMinimum(0);
        xAxis.setDrawLabels(true);

        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        xAxis.setAxisLineColor(R.color.white);
        xAxis.setAxisLineWidth(10f);
        radarchart.getDescription().setTextColor(Color.WHITE);
        radarchart.getXAxis().setTextColor(Color.WHITE);
        radarchart.getLegend().setTextColor(Color.WHITE);
        radarchart.getYAxis().setTextColor(Color.WHITE);
        radarchart.setRotationEnabled(false);
        radarchart.setTouchEnabled(true);

        radarchart.setData(data);


        return v;
    }

    public static List<RadarEntry> number0(){

        ArrayList<RadarEntry> dataVals = new ArrayList<RadarEntry>();
        dataVals.add(new RadarEntry((float) songfile.joy[songnumber]));
        dataVals.add(new RadarEntry((float) songfile.sad[songnumber]));
        dataVals.add(new RadarEntry((float) songfile.distaste[songnumber]));
        dataVals.add(new RadarEntry((float) songfile.hopeless[songnumber]));
        dataVals.add(new RadarEntry((float) songfile.warmth[songnumber]));
        dataVals.add(new RadarEntry((float) songfile.excited[songnumber]));

        return dataVals;


    }






    @Override
    public void onPause() {
        super.onPause();
        Log.e("radar",""+songfile.warmth[songnumber]);
        Log.e("radar",""+songfile.warmth[1]);
        Log.e("radar",""+songnumber);

    }




}