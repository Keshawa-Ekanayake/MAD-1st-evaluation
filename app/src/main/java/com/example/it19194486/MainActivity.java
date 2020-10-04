package com.example.it19194486;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button add , edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.bttn1);
        edit = findViewById(R.id.bttn2);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, library02.class);
                startActivity(intent);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Library04.class);
                startActivity(intent);
            }
        });

        Button edit;

        TextView libh1 = findViewById(R.id.libh1);
        libh1.setText(R.string.header);

        TextView uname = findViewById(R.id.uname);
        uname.setText(R.string.uname);
    }
}