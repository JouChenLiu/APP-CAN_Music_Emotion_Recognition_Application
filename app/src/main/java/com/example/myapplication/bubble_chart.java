package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.androidplot.ui.DynamicTableModel;
import com.androidplot.ui.FixedTableModel;
import com.androidplot.ui.TableOrder;
import com.androidplot.util.PixelUtils;
import com.androidplot.xy.BoundaryMode;
import com.androidplot.xy.BubbleFormatter;
import com.androidplot.xy.BubbleRenderer;
import com.androidplot.xy.BubbleSeries;
import com.androidplot.xy.PanZoom;
import com.androidplot.xy.PointLabelFormatter;
import com.androidplot.xy.XYGraphWidget;
import com.androidplot.xy.XYPlot;

import java.util.Arrays;

public class bubble_chart extends AppCompatActivity {
    XYPlot myPlot;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bubble_chart);
        myPlot = findViewById(R.id.xyPlot);

        // 一天3次 一周21次 每個標籤 2 4 2 3 2 3 3 2
        BubbleSeries serieshappy = new BubbleSeries(
                Arrays.asList(new Number[]{5.5, 8.0}),
                Arrays.asList(new Number[]{1.0, 0.8}),
                Arrays.asList(new Number[]{1, 1}),
                "快樂"
        );

        BubbleSeries seriesdark = new BubbleSeries(
                Arrays.asList(new Number[]{3.0, 4.7}),
                Arrays.asList(new Number[]{0.7, 0.6}),
                Arrays.asList(new Number[]{3, 1}),
                "暗夜"
        );

        BubbleSeries seriesrelaxed = new BubbleSeries(
                Arrays.asList(new Number[]{-3.0, -6.5}),
                Arrays.asList(new Number[]{0.7, 0.85}),
                Arrays.asList(new Number[]{2, 3}),
                "放鬆"
        );

        BubbleSeries serieshugging = new BubbleSeries(
                Arrays.asList(new Number[]{-5.0, 2.0}),
                Arrays.asList(new Number[]{0.5, 0.9}),
                Arrays.asList(new Number[]{1, 2}),
                "擁抱"
        );

        BubbleSeries seriescomfort = new BubbleSeries(
                Arrays.asList(new Number[]{-7.0, 2.7}),
                Arrays.asList(new Number[]{0.6, 0.8}),
                Arrays.asList(new Number[]{1, 1}),
                "安慰"
        );

        BubbleSeries seriesshouting = new BubbleSeries(
                Arrays.asList(new Number[]{-2.5, -5.0}),
                Arrays.asList(new Number[]{0.8, 0.9}),
                Arrays.asList(new Number[]{3, 2}),
                "咆哮"
        );

        BubbleSeries seriescalming = new BubbleSeries(
                Arrays.asList(new Number[]{4.5}),
                Arrays.asList(new Number[]{0.9}),
                Arrays.asList(new Number[]{3}),
                "鎮定劑"
        );

        BubbleSeries seriesrandom = new BubbleSeries(
                Arrays.asList(new Number[]{6.5}),
                Arrays.asList(new Number[]{0.6}),
                Arrays.asList(new Number[]{1}),
                "漫遊"
        );

        myPlot.setDomainBoundaries(-9, 9, BoundaryMode.FIXED);
        myPlot.setRangeBoundaries(0.4, 1, BoundaryMode.FIXED);

        BubbleFormatter formatterhappy = new BubbleFormatter(Color.rgb(224, 228, 124), Color.rgb(224, 224, 224));
        BubbleFormatter formatterrelaxed = new BubbleFormatter(Color.rgb(176, 228, 124), Color.rgb(224, 224, 224));
        BubbleFormatter formatterdark = new BubbleFormatter(Color.rgb(116, 134, 172), Color.rgb(224, 224, 224));
        BubbleFormatter formattershouting = new BubbleFormatter(Color.rgb(228, 124, 134), Color.rgb(224, 224, 224));
        BubbleFormatter formattercomfort = new BubbleFormatter(Color.rgb(219, 162, 208), Color.rgb(224, 224, 224));
        BubbleFormatter formatterhugging = new BubbleFormatter(Color.rgb(228, 169, 124), Color.rgb(224, 224, 224));
        BubbleFormatter formattercalming = new BubbleFormatter(Color.rgb(124, 190, 228), Color.rgb(224, 224, 224));
        BubbleFormatter formatterrandom = new BubbleFormatter(Color.rgb(218, 222, 239), Color.rgb(224, 224, 224));

        PointLabelFormatter plf = new PointLabelFormatter();
        plf.getTextPaint().setTextSize(PixelUtils.spToPix(12));
        plf.getTextPaint().setColor(Color.rgb(72, 43, 129));
        formatterhappy.setPointLabelFormatter(plf);
        formatterrelaxed.setPointLabelFormatter(plf);
        formatterdark.setPointLabelFormatter(plf);
        formattershouting.setPointLabelFormatter(plf);
        formattercomfort.setPointLabelFormatter(plf);
        formatterhugging.setPointLabelFormatter(plf);
        formattercalming.setPointLabelFormatter(plf);
        formatterrandom.setPointLabelFormatter(plf);

        myPlot.addSeries(serieshappy, formatterhappy);
        myPlot.addSeries(seriesrelaxed, formatterrelaxed);
        myPlot.addSeries(seriesdark, formatterdark);
        myPlot.addSeries(seriesshouting, formattershouting);
        myPlot.addSeries(seriescomfort, formattercomfort);
        myPlot.addSeries(serieshugging, formatterhugging);
        myPlot.addSeries(seriescalming, formattercalming);
        myPlot.addSeries(seriesrandom, formatterrandom);

        myPlot.getDomainTitle().getLabelPaint().setTextSize(40f);
        myPlot.getRangeTitle().getLabelPaint().setTextSize(40f);

        myPlot.getLegend().setTableModel(new DynamicTableModel(4, 2, TableOrder.ROW_MAJOR));
        //myPlot.getLegend().setTableModel(new FixedTableModel(PixelUtils.dpToPix(10),
        //PixelUtils.dpToPix(80), TableOrder.COLUMN_MAJOR));
        PanZoom.attach(myPlot);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.showing){
            createNewContactDialog();
        }
        return true;
    }

    public void createNewContactDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.popup, null);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.show();
    }
}