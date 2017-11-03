package com.teambadass.csci3308.badass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.PipedOutputStream;
import java.text.Normalizer;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    protected void sendData(Normalizer.Form form){
        PipedOutputStream stream = new PipedOutputStream();
    }
}
