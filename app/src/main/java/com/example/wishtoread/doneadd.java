package com.example.wishtoread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class doneadd extends AppCompatActivity {

    TextView texttop;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doneadd);

        TextView texttop = findViewById(R.id.texttop);
        texttop.setText(R.string.header1);
        button = findViewById(R.id.button3);
    }
}