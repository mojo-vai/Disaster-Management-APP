package com.example.urlopen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cyclone_steps extends AppCompatActivity {

    Button emergency;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cyclone_steps);
        emergency=(Button) findViewById(R.id.emergency2);
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(cyclone_steps.this, emergency_contacts.class);
                startActivity(myIntent);
            }
        });
    }
}