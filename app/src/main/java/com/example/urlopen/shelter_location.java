package com.example.urlopen;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;

public class shelter_location extends AppCompatActivity implements OnMapReadyCallback {

    private final int FINE_PERMISSION_CODE = 1;
    GoogleMap myMap;
    Location currentLocation;
    FusedLocationProviderClient fusedClient;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_location);
        searchView=findViewById(R.id.search);

        fusedClient = LocationServices.getFusedLocationProviderClient(this);
        getlocation();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                String location = searchView.getQuery().toString();
                List<Address> addressList = null;
                if(location!=null){

                    Geocoder geocoder = new Geocoder(shelter_location.this);

                    try {
                        addressList=geocoder.getFromLocationName(location,1);
                    }catch (IOException e){
                        e.printStackTrace();
                    }

                    Address address = addressList.get(0);
                    LatLng latLng = new LatLng(address.getLatitude(),address.getLongitude());
                    myMap.addMarker(new MarkerOptions().position(latLng).title(location));
                    myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));

                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    private void getlocation() {

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},FINE_PERMISSION_CODE);
            return;
        }
        Task<Location> task = fusedClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!=null){
                    currentLocation = location;

                    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                    mapFragment.getMapAsync(shelter_location.this);
                }
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        myMap= googleMap;
        LatLng myLocation = new LatLng(currentLocation.getLatitude(),currentLocation.getLongitude());
        LatLng mugaipara = new LatLng(24.574675113693694, 88.70673366529904);
        LatLng pariladanga = new LatLng(24.61845910398018, 88.6300945824893);
        LatLng dighapatia = new LatLng(24.441062393708556, 89.01891993830786);
        LatLng halsha = new LatLng(24.38761926769123, 89.08812568063571);
        LatLng sthapondighi = new LatLng(24.585958637992977, 89.13838323831159);
        LatLng chanua = new LatLng(22.972479401273347, 91.46463487870757);
        LatLng minjirtola = new LatLng(22.004182611198697, 91.92476184194473);
        LatLng laximpur = new LatLng(25.12311083088474, 91.53512308336744);
        LatLng feniCollege = new LatLng(22.95273805755325, 91.48821314877523);
        LatLng Bogdadia = new LatLng(22.949104485269523, 91.4661653472279);
        LatLng shibpur = new LatLng(22.974183250523865, 91.50837276035256);

        myMap.addMarker(new MarkerOptions().position(shibpur).title("Shibpur Shelter"));
        myMap.addMarker(new MarkerOptions().position(Bogdadia).title("Bogdadia High School and Flood Shelter"));
        myMap.addMarker(new MarkerOptions().position(feniCollege).title("Feni South East Degree College"));
        myMap.addMarker(new MarkerOptions().position(myLocation).title("Current Location"));
        myMap.addMarker(new MarkerOptions().position(laximpur).title("Laxipur Union Complex"));
        myMap.addMarker(new MarkerOptions().position(minjirtola).title("Minjirtola Dakhil Madrasa"));
        myMap.addMarker(new MarkerOptions().position(chanua).title("Chonua High School"));
        myMap.addMarker(new MarkerOptions().position(sthapondighi).title("Sthapondighi High School"));
        myMap.addMarker(new MarkerOptions().position(mugaipara).title("Mugaipara High School"));
        myMap.addMarker(new MarkerOptions().position(pariladanga).title("Pariladanga Primary School and Flood shelter"));
        myMap.addMarker(new MarkerOptions().position(dighapatia).title("Dighapatia PN High School"));
        myMap.addMarker(new MarkerOptions().position(halsha).title("Halsha High School and Flood Center"));

        myMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myLocation,10));
        myMap.getUiSettings().setZoomControlsEnabled(true);
        myMap.getUiSettings().setCompassEnabled(true);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == FINE_PERMISSION_CODE){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                getlocation();
            }else{
                Toast.makeText(this, "Location permission is denied,please allow the permission", Toast.LENGTH_SHORT).show();
            }
        }
    }
}