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
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * Created by markw on 11/3/2017.
 */

public class AccountCreationPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent intent = new Intent(this,MainActivity.class);
        setContentView(R.layout.activity_create_account);
        final EditText user = (EditText)findViewById(R.id.email);
        final EditText pass = (EditText)findViewById(R.id.password);
        Button button = (Button)findViewById(R.id.email_sign_in_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String userString = user.getText().toString();
                final String passString = pass.getText().toString();
                Thread accountThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //submitAccount(userString,passString);
                        startActivity(intent);
                    }
                });
                accountThread.start();

            }
        });
    }

    public void submitAccount(String username, String password){
        try {
            URL url = new URL("http://10.233.8.59/insertData");

            JSONObject params = new JSONObject();
            params.put("username",username);
            params.put("password",password);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

            writer.write(params.toString());

            //writer.flush();
            writer.close();

        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }
}
