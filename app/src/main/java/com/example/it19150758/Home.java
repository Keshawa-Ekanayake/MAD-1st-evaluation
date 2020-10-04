package com.example.it19150758;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Home extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn = (Button)findViewById(R.id.btnupcomming); //navigating for another page(interface 01)
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openinterface1();
            }

            private void openinterface1() {
                Intent intent = new Intent(Home.this, interface01.class);
                startActivity(intent);
            }
        });

    }
}


