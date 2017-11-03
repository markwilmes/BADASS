package com.teambadass.csci3308.badass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
    }

    protected void sendData(String username,String password){
        try {
            URL url = new URL("http://BADASSIPADDRESS/queryDB");

            JSONObject postParams = new JSONObject();
            postParams.put("username",username);
            postParams.put("password",password);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }
}
