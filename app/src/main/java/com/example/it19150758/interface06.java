package com.example.it19150758;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class interface06 extends AppCompatActivity {

    com.google.firebase.database.FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    ListView datalist;
    List<Book> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface06);

        datalist = findViewById(R.id.datalist);
        list = new ArrayList<>();
        reference = firebaseDatabase.getInstance().getReference().child("user");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot ds: snapshot.getChildren())
                {
                    Book book = ds.getValue(Book.class);
                    list.add(book);
                }

                Booklistadapter booklistadapter = new Booklistadapter(interface06.this, list);
                datalist.setAdapter(booklistadapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}