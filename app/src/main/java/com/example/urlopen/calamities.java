package com.example.urlopen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class calamities extends AppCompatActivity {

    Button cyclone,flood,earthquake;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calamities);

        cyclone = (Button)findViewById(R.id.cyclone);
        earthquake=(Button)findViewById(R.id.earthquake);
        flood=(Button)findViewById(R.id.flood);

        cyclone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(calamities.this, cyclone_steps.class);
                startActivity(myintent);
            }
        });

        flood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(calamities.this, Floods_steps.class);
                startActivity(myintent);
            }
        });

        earthquake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(calamities.this, earthquake_steps.class);
                startActivity(myintent);
            }
        });

    }
}