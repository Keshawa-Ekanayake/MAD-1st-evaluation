package com.example.it19150826_mad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class show_BorrowedBooks extends AppCompatActivity {

    com.google.firebase.database.FirebaseDatabase FirebaseDatabase;
    DatabaseReference ref;

    ListView Datalist;
    List<borrowedBooks> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__borrowed_books);

        Datalist = findViewById(R.id.bookListView);
        list = new ArrayList<>();


        ref = FirebaseDatabase.getInstance().getReference().child("borrowedbooks");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();

                for (DataSnapshot ds:dataSnapshot.getChildren()){

                    borrowedBooks borrowedBooks = ds.getValue(borrowedBooks.class);
                    list.add(borrowedBooks);

                }

                BookList adapter = new BookList(show_BorrowedBooks.this, list);
                Datalist.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}