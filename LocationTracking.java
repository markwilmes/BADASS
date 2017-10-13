package com.example.jasmine.badass;

/**
 * Created by jasmine on 10/13/17.
 * gets last known location of user and implements location updating
 * currently only gets location and doesn't update
 */

import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.Manifest;

public class LocationTracking {

    LocationProvider provider = new LocationProvider();

    Location get_location() {
        boolean gps_enabled = false;
        boolean network_enabled = false;

        Location finalLoc = null;
        Location net_loc = null, gps_loc = null;

        Context mCtx = null;

        AppCompatActivity activity = new AppCompatActivity();


        if (activity.checkSelfPermission
                (Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                &&
                activity.checkSelfPermission
                        (Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            activity.requestPermissions(new String[]{
                    android.Manifest.permission.ACCESS_COARSE_LOCATION,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
            }, 1);

        } else {
            LocationManager lm = (LocationManager) mCtx
                    .getSystemService(Context.LOCATION_SERVICE);

            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (gps_enabled) {
                gps_loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            }
            if (network_enabled) {
            }
            net_loc = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if (gps_loc != null && net_loc != null)

            {
                if (gps_loc.getAccuracy() > net_loc.getAccuracy())
                    finalLoc = net_loc;
                else
                    finalLoc = gps_loc;

            } else

            {

                if (gps_loc != null) {
                    finalLoc = gps_loc;
                } else if (net_loc != null) {
                    finalLoc = net_loc;
                }
            }

        }
        if (finalLoc != null)

        {
            return finalLoc;
        } else {
            return null;
        }
    }



}
