package com.example.healthapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.widget.ImageView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);

        ((ImageView)findViewById(R.id.home_icon)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sport_to_home= new Intent(SportActivity.this,MainActivity.class);
                SportActivity.this.startActivity(sport_to_home);
            }
        });
    }
}
