package com.example.wishtoread;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ADD extends AppCompatActivity {

    FirebaseDatabase FirebaseDatabase;
    DatabaseReference reff;
    EditText booktitle , author , pdate, category;
    int maxid = 0;
    TextView texttop;
    Button button, home1;
    wishToRead book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_d_d);

        TextView texttop = findViewById(R.id.texttop);
        texttop.setText(R.string.header1);
        booktitle = findViewById(R.id.titletxt);
        author = findViewById(R.id.authortxt);
        pdate = findViewById(R.id.pdatetxt);
        button = findViewById(R.id.submit);
        home1 = findViewById(R.id.home1);
        category = findViewById(R.id.categ);

        reff = FirebaseDatabase.getInstance().getReference().child("wishToRead");

        book = new wishToRead();
        //ref = database.getInstance().getReference().child("user");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    maxid = (int)dataSnapshot.getChildrenCount();

            }

        }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                long time =System.currentTimeMillis();

                book.setBookID(String.valueOf(time));
                book.setBookTitle(booktitle.getText().toString());
                book.setBookAuthor(author.getText().toString());
                book.setPdate(pdate.getText().toString());
                book.setCategory(category.getText().toString());

                //book.setBookTitle(booktitle.getText().toString());

                reff.child(String.valueOf(time)).setValue(book);
                reff.push();

                Toast.makeText(getApplicationContext() , "Data added successfully" , Toast.LENGTH_SHORT).show();




            }
        });
        /*home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent(ADD.this,);
            }
        });*/

    }

}