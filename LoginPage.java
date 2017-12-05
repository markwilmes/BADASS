/*
*  Defines LoginPage class with the following attributes:
*  Forms for reading in username and password, button, clicklistener for button press
*  Login passes username and password to server/database via JSON
*
*/

package com.teambadass.csci3308.badass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        EditText user = (EditText)findViewById(R.id.editText2); //username
        EditText pass = (EditText)findViewById(R.id.editText3); //password
        final String userString = user.getText().toString(); //store username
        final String passString = pass.getText().toString(); //store password
        final Button button = findViewById(R.id.button1); //button
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                login(userString,passString);
            }
        });
        final Button button2 = findViewById(R.id.button2); //clicked button
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), AccountCreationPage.class);
                startActivity(intent);
            }
        });

    }

    protected void login(String username,String password){
        Intent intent = new Intent(this, MainActivity.class);
        try {
            URL url = new URL("http://10.0.0.77/queryDB"); //communication with database

            JSONObject postParams = new JSONObject(); //JSON object sends username and password
            postParams.put("username",username);
            postParams.put("password",password);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //URL connection
            conn.setReadTimeout(15000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            String cookie = conn.getResponseMessage();
            if(cookie != null){
                startActivity(intent);
            }
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }
}
