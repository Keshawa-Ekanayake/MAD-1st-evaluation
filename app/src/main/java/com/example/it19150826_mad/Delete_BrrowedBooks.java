package com.example.it19150826_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Delete_BrrowedBooks extends AppCompatActivity {

    Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete__brrowed_books);

        delete = findViewById(R.id.deleteBtn2);

    }
}