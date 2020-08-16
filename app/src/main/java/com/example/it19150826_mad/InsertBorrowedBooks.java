package com.example.it19150826_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class InsertBorrowedBooks extends AppCompatActivity {

    TextView addNew, bDate, rDate, libraries;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_borrowed_books);

        addNew = findViewById(R.id.AddNew);
        bDate = findViewById(R.id.bDate);
        rDate = findViewById(R.id.rDate);
        libraries = findViewById(R.id.library);

        submit = findViewById(R.id.submit);

    }
}