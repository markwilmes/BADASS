package com.teambadass.csci3308.badass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.io.PipedOutputStream;
import java.text.Normalizer;

public class LoginActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);
    }

    protected void sendData(Normalizer.Form form){
        PipedOutputStream stream = new PipedOutputStream();
    }

    public void onClick(View view){
        Intent intent = new Intent(this, AccountCreationPage.class);
        startActivity(intent);
    }
}
