package com.example.it19150758;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class interface06 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface06);

        TextView upcommingbooks = findViewById(R.id.upcommingbooks);
        upcommingbooks.setText(R.string.upcommingbooks);

        TextView coloum1 = findViewById(R.id.coloum1);
        coloum1.setText(R.string.table1);

        TextView coloum2 = findViewById(R.id.coloum2);
        coloum2.setText(R.string.table2);

        TextView coloum3 = findViewById(R.id.coloum3);
        coloum3.setText(R.string.table3);
    }
}