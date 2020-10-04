package com.example.it19150758;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class interface02 extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref;
    EditText bookname , bookdate , bookauthor , bookcategory;
    Book book;
    int maxid = 0;
    Button btnupcomming;
    String mystring = "Data Entered Successfully";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface02);

        bookname = findViewById(R.id.bookname);
        bookdate = findViewById(R.id.bookdate);
        bookauthor = findViewById(R.id.bookauthor);
        bookcategory = findViewById(R.id.bookcategory);
        btnupcomming = findViewById(R.id.btnupcomming);



        book = new Book();

        ref = database.getInstance().getReference().child("user");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    maxid = (int) dataSnapshot.getChildrenCount();
                }else {
                    //
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnupcomming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long time= System.currentTimeMillis();
                book.setId(Long.toString(time));
                book.setName(bookname.getText().toString());
                book.setPublishdate(bookdate.getText().toString());
                book.setAuthor(bookauthor.getText().toString());
                book.setCategory(bookcategory.getText().toString());

                ref.child((Long.toString(time))).setValue(book);
                ref.push();

                Toast.makeText(getApplicationContext(), mystring,Toast.LENGTH_SHORT).show();
            }
        });




    }
}