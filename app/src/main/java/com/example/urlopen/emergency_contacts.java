package com.example.urlopen;

import static com.example.urlopen.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.QuickContactBadge;

public class emergency_contacts extends AppCompatActivity {

    QuickContactBadge police,ambulance,fire_service,disaster_manage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_emergency_contacts);
        police = (QuickContactBadge) findViewById(id.poll);
        police.assignContactFromPhone("999",true);
        ambulance = (QuickContactBadge) findViewById(id.amblance);
        ambulance.assignContactFromPhone("999",true);
        fire_service=(QuickContactBadge) findViewById(id.fire);
        fire_service.assignContactFromPhone("102",true);
        disaster_manage= (QuickContactBadge) findViewById(id.disaster);
        disaster_manage.assignContactFromPhone("1090",true);
    }
}