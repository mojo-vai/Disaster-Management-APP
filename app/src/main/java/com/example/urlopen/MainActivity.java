package com.example.urlopen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button calamity,emergency,shelter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calamity= (Button) findViewById(R.id.calamities);
        emergency=(Button)findViewById(R.id.emergency);
        shelter=(Button) findViewById(R.id.shelter);

        calamity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, calamities.class);
                startActivity(myIntent);
            }
        });

        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, emergency_contacts.class);
                startActivity(myintent);
            }
        });

        shelter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, shelter_location.class);
                startActivity(myIntent);
            }
        });

    }

}