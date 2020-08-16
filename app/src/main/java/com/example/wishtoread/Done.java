package com.example.wishtoread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Done extends AppCompatActivity {

    TextView text;
    Button button;
    TextView add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);


        TextView texttop = findViewById(R.id.texttop);
        texttop.setText(R.string.header1);

        text = findViewById(R.id.textView4);
        button = findViewById(R.id.button);
        add = findViewById(R.id.add);
        text = findViewById(R.id.textView);
    }
}