package com.example.it19150826_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Edit_borrowedBooks extends AppCompatActivity {

    Button save, cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_borrowed_books);

        save = findViewById(R.id.saveBtn);
        cancel = findViewById(R.id.cancelBtn);

    }
}