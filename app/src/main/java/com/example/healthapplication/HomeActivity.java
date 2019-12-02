package com.example.healthapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import maes.tech.intentanim.CustomIntent;

public class HomeActivity extends AppCompatActivity {
    Button btnPick;
    SQLClass instSQL;
    Intent getFileIntent;
    final int ACTION_GET_CONTENT = 10; //Request code of the action
    public Uri csvUri; //Used for getting csv file

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        instSQL = new SQLClass(this);
        (findViewById(R.id.off_menu)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home_to_menu= new Intent(HomeActivity.this,MenuActivity.class);
                HomeActivity.this.startActivity(home_to_menu);
                CustomIntent.customType(HomeActivity.this,   "right-to-left");
            }
        });
        btnPick = findViewById(R.id.button_pick);
        openFilePicker();

    }

    private void csvToDatabase() {
        try {
            InputStream csvIs = getContentResolver().openInputStream(csvUri);
            BufferedReader reader = new BufferedReader(new InputStreamReader(csvIs));
            String csvLine;
            instSQL.clearTable(); // If you wan to clear table every time you upload a new csv. MAYBE A POPUP QUESTION?
            boolean firstLine = true; // First line is column names, use this to discard it
            while ((csvLine = reader.readLine()) != null) {
                if (firstLine) {    //First line is column names, to discard it we use this.
                    firstLine = false;
                }
                else {
                    String[] row = csvLine.replace("\"" ,"").replace(",",".").split(";");
                    instSQL.insertData(row[0], Integer.parseInt(row[1]), Integer.parseInt(row[2]),Double.parseDouble(row[3]),Integer.parseInt(row[4]),Integer.parseInt(row[5]),Integer.parseInt(row[6]),Integer.parseInt(row[7]),Integer.parseInt(row[8]),Integer.parseInt(row[9]),Integer.parseInt(row[10]),Integer.parseInt(row[11]));

                }
            }
            instSQL.createSubTables(); // Creates monthly subtables.

        } catch (IOException e) {
        }
    }

    private void openFilePicker() {
        btnPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFileIntent = new Intent(Intent.ACTION_GET_CONTENT); // Opens file explorer.
                getFileIntent.setType("*/*");
                startActivityForResult(getFileIntent, 10);

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { //openFilePicker activity result
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTION_GET_CONTENT) { //File pick action code check
            if (resultCode == RESULT_OK) { //Check if file is selected
                csvUri = data.getData();
                Toast.makeText(HomeActivity.this, csvUri.toString(), Toast.LENGTH_LONG).show();
                csvToDatabase();
            }
        }

    }
}
