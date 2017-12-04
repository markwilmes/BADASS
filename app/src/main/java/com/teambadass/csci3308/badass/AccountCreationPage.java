package com.teambadass.csci3308.badass;

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

/*
 * Created by markw on 11/3/2017.
 */

public class AccountCreationPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        EditText user = (EditText)findViewById(R.id.email);
        EditText pass = (EditText)findViewById(R.id.password);
        final String userString = user.getText().toString();
        final String passString = pass.getText().toString();
        final Button button = findViewById(R.id.email_sign_in_button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //submitAccount(userString,passString);
            }
        });
    }

    /*public void submitAccount(String username, String password){
        try {
            URL url = new URL("http://10.0.0.77/insertData");

            JSONObject params = new JSONObject();
            params.put("username",username);
            params.put("password",password);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000 *//* milliseconds *//*);
            conn.setConnectTimeout(15000 *//* milliseconds *//*);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }*/
}
