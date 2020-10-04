package com.example.it19150826_mad;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SearchBorrowedBooks extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference ref;
    EditText title;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__borrowed_books);

        ref = FirebaseDatabase.getInstance().getReference("borrowedbooks");
        title = (EditText) findViewById(R.id.searchView);
        searchButton = findViewById(R.id.searchBtn);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchBorrowedBooks.this, Delete_BrrowedBooks.class);
                intent.putExtra("title", title.getText().toString());

                startActivity(intent);
            }
        });


    }
}