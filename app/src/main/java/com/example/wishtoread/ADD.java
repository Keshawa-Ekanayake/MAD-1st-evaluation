package com.example.wishtoread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ADD extends AppCompatActivity {

    TextView texttop;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_d_d);

        TextView texttop = findViewById(R.id.texttop);
        texttop.setText(R.string.header1);
        button = findViewById(R.id.button3);
    }
}