package com.example.healthapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class StatisticsActivity extends AppCompatActivity  {
    LineChart stepChart, distanceChart;
    SQLClass instSQL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        instSQL = new SQLClass(this);
        stepChart=(LineChart) findViewById(R.id.stepChart);
        distanceChart=(LineChart) findViewById(R.id.distanceChart);

        ArrayList<ArrayList<Entry>> stepArrayList = new ArrayList<>();
        stepArrayList = instSQL.stepTable();

        LineDataSet stepDataSet=new LineDataSet(stepArrayList.get(0), "Step number");
        LineData stepDataCnvrtd = new LineData(stepDataSet); //Convert datasets to LineData

        LineDataSet distanceDataSet=new LineDataSet(stepArrayList.get(1), "Distance");
        LineData distanceDataCnvrtd = new LineData(distanceDataSet); //Convert datasets to LineData


        //For mutliple data in one graph
        /*List<ILineDataSet>dataSets = new ArrayList<ILineDataSet>(); // Combine data sets
        dataSets.add(stepDataSet);
        dataSets.add(distanceDataSet);
        LineData combinedData = new LineData(dataSets); //Convert datasets to LineData*/



        stepChart.setData(stepDataCnvrtd);
        stepChart.setTouchEnabled(true);
        stepChart.setDragEnabled(true);
        stepChart.setScaleEnabled(true);

        distanceChart.setData(distanceDataCnvrtd);
        distanceChart.setTouchEnabled(true);
        distanceChart.setDragEnabled(true);
        distanceChart.setScaleEnabled(true);


    }
}
