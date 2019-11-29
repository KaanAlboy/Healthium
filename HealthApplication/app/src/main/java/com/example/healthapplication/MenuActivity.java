package com.example.healthapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import maes.tech.intentanim.CustomIntent;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ((CardView)findViewById(R.id.statisticsCard)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_to_statistics= new Intent(MenuActivity.this,StatisticsActivity.class);
                MenuActivity.this.startActivity(menu_to_statistics);
            }
        });

        ((CardView)findViewById(R.id.nutritionCard)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_to_nutrition= new Intent(MenuActivity.this,NutritionActivity.class);
                MenuActivity.this.startActivity(menu_to_nutrition);
            }
        });

        ((CardView)findViewById(R.id.sportCard)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_to_sport= new Intent(MenuActivity.this,SportActivity.class);
                startActivity(menu_to_sport);
                CustomIntent.customType(MenuActivity.this,   "bottom-to-up");
            }
        });

        ((CardView)findViewById(R.id.goalsCard)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_to_goals= new Intent(MenuActivity.this,GoalsActivity.class);
                MenuActivity.this.startActivity(menu_to_goals);
            }
        });
    }
}
