package com.example.it19150758;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView textlogin = findViewById(R.id.textlogin);
        textlogin.setText(R.string.login);

        TextView textusername = findViewById(R.id.textusername);
        textusername.setText(R.string.username);

        TextView textpassword = findViewById(R.id.textpassword);
        textpassword.setText(R.string.password);
    }
}