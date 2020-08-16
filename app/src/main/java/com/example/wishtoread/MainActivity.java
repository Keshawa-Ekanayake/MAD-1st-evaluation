package com.example.wishtoread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    TextView text;
    TextView add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView texttop = findViewById(R.id.texttop);
        texttop.setText(R.string.header1);

        text = findViewById(R.id.textView4);
        add = findViewById(R.id.add);
        text = findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opencheck();
            }
        });

    }

    public void opencheck() {
        Intent intent = new Intent(this, Check.class);
        startActivity(intent);
    }


}