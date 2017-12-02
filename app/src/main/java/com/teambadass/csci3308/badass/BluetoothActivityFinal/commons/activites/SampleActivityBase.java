package com.teambadass.csci3308.badass.BluetoothActivityFinal.commons.activites;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.teambadass.csci3308.badass.BluetoothActivityFinal.commons.logger.LogWrapper;

/**
 * Created by adam on 11/30/2017.
 */

public class SampleActivityBase extends FragmentActivity{
    public static final String TAG = "SampleActivityBase";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected  void onStart() {
        super.onStart();
        initializeLogging();
    }

    /** Set up targets to receive log data */
    public void initializeLogging() {
        // Using Log, front-end to the logging chain, emulates android.util.log method signatures.
        // Wraps Android's native log framework
        LogWrapper logWrapper = new LogWrapper();
        com.teambadass.csci3308.badass.BluetoothActivityFinal.commons.logger.Log.setLogNode(logWrapper);

        android.util.Log.i(TAG, "Ready");
    }
}
