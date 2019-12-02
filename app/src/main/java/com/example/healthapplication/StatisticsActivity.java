package com.example.healthapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class StatisticsActivity extends AppCompatActivity  {
    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        barChart=(BarChart) findViewById(R.id.stepChart);


        ArrayList<BarEntry> stepList=new ArrayList<>();
        stepList.add(new BarEntry(7000f,0));
        stepList.add(new BarEntry(5000f,1));
        stepList.add(new BarEntry(2000f,2));
        stepList.add(new BarEntry(3000f,3));
        stepList.add(new BarEntry(4000f,4));
        stepList.add(new BarEntry(9000f,5));

        BarDataSet barDataSet=new BarDataSet(stepList,"asd");

        BarData chartData=new BarData(barDataSet);
        barChart.setData(chartData);
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);


    }
}
