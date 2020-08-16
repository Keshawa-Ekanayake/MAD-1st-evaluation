package com.example.wishtoread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Check extends AppCompatActivity {

    TextView text1;
    TextView text;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        TextView texttop = findViewById(R.id.texttop);
        texttop.setText(R.string.header1);
        button = findViewById(R.id.button3);
        button = findViewById(R.id.button4);
       // text1 = findViewById(R.id.editTextTextPersonName);
        //text1 = findViewById(R.id.editTextTextPersonName2);
    }
}