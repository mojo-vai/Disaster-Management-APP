package com.example.urlopen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Floods_steps extends AppCompatActivity {

    Button emergency1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floods_steps);
        emergency1=(Button) findViewById(R.id.emergency1);
        emergency1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Floods_steps.this, emergency_contacts.class);
                startActivity(myIntent);
            }
        });
    }
}