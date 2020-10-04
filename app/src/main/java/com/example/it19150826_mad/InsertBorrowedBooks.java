package com.example.it19150826_mad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class InsertBorrowedBooks extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref;
    //TextView addNew, bDate, rDate, libraries;
    EditText bookTitle, bDate, rDate;
    Spinner libraries;
    Button submit;
    borrowedBooks book;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_borrowed_books);

        bookTitle = findViewById(R.id.bookTitle);
        //bDate = findViewById(R.id.);

       bDate = findViewById(R.id.editTextbDate);
       rDate = findViewById(R.id.editTextrDate);
       libraries = findViewById(R.id.libSpinner);
        submit = findViewById(R.id.submit);

        book = new borrowedBooks();

        ref = database.getInstance().getReference().child("borrowedbooks");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    id = (int) dataSnapshot.getChildrenCount();
                }else
                {
                    //
                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.i("Dtatascript",databaseError.toString());
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long time =System.currentTimeMillis();

                book.setId(String.valueOf(time));
                book.setTitle(bookTitle.getText().toString());
                book.setbDate(bDate.getText().toString());
                book.setrDate(rDate.getText().toString());
                book.setLib(libraries.getSelectedItem().toString());

                ref.child(String.valueOf(time)).setValue(book);
                ref.push();

                Toast.makeText(getApplicationContext() , "Data inserted successfully" , Toast.LENGTH_SHORT).show();
            }
        });


    }
}