package com.example.it19150826_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView header, reader, name;
    Button add, show, edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        header = findViewById(R.id.headerView);
        reader = findViewById(R.id.headerView);
        name = findViewById(R.id.nameView);

        add = findViewById(R.id.Add);
        show = findViewById(R.id.Show);
        edit = findViewById(R.id.Edit);


    }
}