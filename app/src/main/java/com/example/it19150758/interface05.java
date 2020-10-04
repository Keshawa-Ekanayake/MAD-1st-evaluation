package com.example.it19150758;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class interface05 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface05);

        TextView bname1 = findViewById(R.id.bname1);
        bname1.setText(R.string.bname1);

        TextView datebirth = findViewById(R.id.datebirth);
        datebirth.setText(R.string.datebirth);

        TextView baurthor1 = findViewById(R.id.baurthor1);
        baurthor1.setText(R.string.baurthor1);

        TextView bcategory1 = findViewById(R.id.bcategory1);
        bcategory1.setText(R.string.bcategory1);



    }
}