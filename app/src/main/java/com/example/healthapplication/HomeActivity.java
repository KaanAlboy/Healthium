package com.example.healthapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import maes.tech.intentanim.CustomIntent;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        (findViewById(R.id.off_menu)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home_to_menu= new Intent(HomeActivity.this,MenuActivity.class);
                HomeActivity.this.startActivity(home_to_menu);
                CustomIntent.customType(HomeActivity.this,   "right-to-left");
            }
        });

    }
}
