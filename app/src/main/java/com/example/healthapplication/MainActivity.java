package com.example.healthapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.content.Intent;
import androidx.cardview.widget.CardView;

import maes.tech.intentanim.CustomIntent;

public class MainActivity extends AppCompatActivity {
    private static int open_time=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {
                    Intent start_to_open=new Intent(MainActivity.this,OpenActivity.class);
                    startActivity(start_to_open);
                    CustomIntent.customType(MainActivity.this,"fadein-to-fadeout");
                    finish();
                }
            },open_time);


    }
}
