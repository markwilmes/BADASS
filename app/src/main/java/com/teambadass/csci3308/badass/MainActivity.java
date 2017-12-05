package com.teambadass.csci3308.badass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.teambadass.csci3308.badass.BluetoothActivityFinal.ChatMain;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Intent accountCreation = new Intent(this,AccountCreationPage.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        final EditText user = (EditText) findViewById(R.id.editText);
        final EditText pass = (EditText) findViewById(R.id.editText3);
        final Button button = findViewById(R.id.button1);
        final Button button1 = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String userString = user.getText().toString();
                final String passString = pass.getText().toString();
                Thread loginThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        login(userString,passString);
                    }
                });
                loginThread.start();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(accountCreation);
            }
        });
    }

    protected void login(String username, String password) {
        try {


            URL url;
            String response = "";

            try {
                url = new URL("http://192.168.30.204/queryDB");

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                conn.setRequestMethod("POST");

                JSONObject postParams = new JSONObject();
                postParams.put("username", username);
                postParams.put("password", password);

                System.out.println(postParams);

                OutputStreamWriter os = new OutputStreamWriter(conn.getOutputStream());
                os.write(postParams.toString());

                //os.flush();
                os.close();


                int responseCode = conn.getResponseCode();
                System.out.println(responseCode);
                if (responseCode == 200) {
                    String line;
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    while ((line = br.readLine()) != null) {
                        response += line;
                    }
                    if(response != null){
                        Intent bluetooth = new Intent(this,ChatMain.class);
                        startActivity(bluetooth);
                    }
                } else {
                    response = "";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
