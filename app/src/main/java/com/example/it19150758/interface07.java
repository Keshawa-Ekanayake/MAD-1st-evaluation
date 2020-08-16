package com.example.it19150758;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class interface07 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface07);

        TextView textdelete = findViewById(R.id.textdelete);
        textdelete.setText(R.string.delete_update);

    }
}