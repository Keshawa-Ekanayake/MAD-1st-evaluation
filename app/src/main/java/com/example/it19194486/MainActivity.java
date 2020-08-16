package com.example.it19194486;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView libh1 = findViewById(R.id.libh1);
        libh1.setText(R.string.header);

        TextView uname = findViewById(R.id.uname);
        uname.setText(R.string.uname);
    }
}