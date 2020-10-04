package com.example.it19150758;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class interface01 extends AppCompatActivity {

    private Button btninsert;
    private Button btnsearch;
    private Button btnsearchall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface01);

        btninsert = (Button) findViewById(R.id.addbookbutton);
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openinterface2();
            }

            private void openinterface2() {
                Intent intent = new Intent(interface01.this , interface02.class);
                startActivity(intent);
            }
        });

        btnsearch = (Button) findViewById(R.id.btnsearch);
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openinterface3();
            }

            private void openinterface3() {
                Intent intent = new Intent(interface01.this , DATARETRIEVING.class);
                startActivity(intent);
            }
        });

        btnsearchall = (Button) findViewById(R.id.btnsearchall);
        btnsearchall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openshowalldetails();
            }

            private void openshowalldetails() {
                Intent intent = new Intent(interface01.this, interface06.class);
                startActivity(intent);
            }
        });






    }


}