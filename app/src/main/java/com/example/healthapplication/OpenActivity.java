package com.example.healthapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import maes.tech.intentanim.CustomIntent;

public class OpenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);

        ((CardView)findViewById(R.id.user1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open_to_main= new Intent(OpenActivity.this,HomeActivity.class);
                OpenActivity.this.startActivity(open_to_main);
                CustomIntent.customType(OpenActivity.this,"bottom-to-up");
            }
        });
    }
}
