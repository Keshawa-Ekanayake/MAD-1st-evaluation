package com.example.it19150758;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DATARETRIEVING extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    EditText bookname , bookdate , bookauthor , bookcategory , searchbook;
    TextView id;
    Button search , update , delete;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_a_t_a_r_e_t_r_i_e_v_i_n_g);



        id= findViewById(R.id.bookid);

        bookname = findViewById(R.id.bookname);
        bookdate = findViewById(R.id.bookdate);
        bookauthor = findViewById(R.id.bookauthor);
        bookcategory = findViewById(R.id.bookcategory);
        searchbook = findViewById(R.id.searchbook);

        search = (Button) findViewById(R.id.Search);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);

       search.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               retrievedata(searchbook.getText().toString());
           }
       });

       update.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               upatedata(id.getText().toString());
           }
       });

       delete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               deletedata(id.getText().toString());
           }
       });

    }
    private void retrievedata(String searchtag)
    {
        reference = FirebaseDatabase.getInstance().getReference().child("user");
        Query query = reference.orderByChild(searchtag);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Book book = postSnapshot.getValue(Book.class);

                    id.setText(book.getId());
                    bookname.setText(book.getName());
                    bookdate.setText(book.getPublishdate());
                    bookauthor.setText(book.getAuthor());
                    bookcategory.setText(book.getCategory());

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void upatedata(String ID)
    {

        Book update = new Book();
        update.setId(ID);
        update.setName(bookname.getText().toString());
        update.setPublishdate(bookdate.getText().toString());
        update.setAuthor(bookauthor.getText().toString());
        update.setCategory(bookcategory.getText().toString());

        reference = FirebaseDatabase.getInstance().getReference().child("user").child(ID);
        reference.setValue(update);
        reference.push();

    }

    private void deletedata(String ID)
    {
        reference = FirebaseDatabase.getInstance().getReference().child("user").child(ID);
        reference.removeValue();
    }


}