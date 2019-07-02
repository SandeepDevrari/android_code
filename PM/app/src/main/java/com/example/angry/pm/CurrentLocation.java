package com.example.angry.pm;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationServices;

public class CurrentLocation extends AppCompatActivity implements ConnectionCallbacks,OnConnectionFailedListener {

    private Button bt1;
    private TextView t1;
    private Location cloc;
    private GoogleApiClient gac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_location);
        bt1 = (Button) findViewById(R.id.map);
        t1 = (TextView) findViewById(R.id.LongiLati);
        FusedLocationProviderApi fla = LocationServices.FusedLocationApi;
        gac = new GoogleApiClient.Builder(this).addApi(LocationServices.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
        if(gac!=null)
        {
            cloc = fla.getLastLocation(gac);
        }
    }

    @Override
    public void onConnected(Bundle arg0) {
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {

    }
    @Override
    public void onConnectionSuspended(int arg0) {
        gac.connect();
    }
}
