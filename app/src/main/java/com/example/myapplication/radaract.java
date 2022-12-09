package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class radaract  extends AppCompatActivity {
    public musicFragment musicf;
    public static RadarChart radarchart;
    public static RadarData data ;
    public static RadarDataSet set1 ;
    public static RadarDataSet set0 ;
    public Button emotion;
    public static int songnumber = musicFragment.songnumber;
    public static String[] labels = new String[6];
    public static View v;
    public static ImageView next = musicFragment.next;
    public static ImageView last = musicFragment.last;
    public static int resume = musicFragment.resume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radaract);

        musicFragment.resume = 1;


        emotion = (Button)findViewById(R.id.emotion);
        emotion.setText(songfile.melody[musicFragment.songnumber]);

        List<Integer> colorlist = new ArrayList<>();

        radarchart = (RadarChart)findViewById(R.id.radarchart);

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


    }
    public static List<RadarEntry> number0(){

        ArrayList<RadarEntry> dataVals = new ArrayList<RadarEntry>();
        dataVals.add(new RadarEntry((float) songfile.joy[musicFragment.songnumber]));
        dataVals.add(new RadarEntry((float) songfile.sad[musicFragment.songnumber]));
        dataVals.add(new RadarEntry((float) songfile.distaste[musicFragment.songnumber]));
        dataVals.add(new RadarEntry((float) songfile.hopeless[musicFragment.songnumber]));
        dataVals.add(new RadarEntry((float) songfile.warmth[musicFragment.songnumber]));
        dataVals.add(new RadarEntry((float) songfile.excited[musicFragment.songnumber]));

        return dataVals;

    }

    public void resume(){
        if(resume == 0){
            this.recreate();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("re", "yes"+musicFragment.resume);
        if(musicFragment.resume == 0){
            this.recreate();
            Log.e("recreate", "yes");
        }
    }


}
