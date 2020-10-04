package com.example.wishtoread;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Update extends AppCompatActivity {

    com.google.firebase.database.FirebaseDatabase FirebaseDatabase;
    DatabaseReference reff;
    String bookTit, bookAt;
    TextView texttop, bookid;
    EditText title, author, pubDate, category;
    Button button, button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        TextView texttop = findViewById(R.id.texttop);
        texttop.setText(R.string.header1);
        button = findViewById(R.id.submit);
        title = findViewById(R.id.titletxt);
        author = findViewById(R.id.authortxt);
        pubDate = findViewById(R.id.pdatetxt);
        category = findViewById(R.id.catg);
        bookid = findViewById(R.id.bookId);
        button1 = findViewById(R.id.delete);

        final Intent intent = getIntent();
        bookTit = intent.getExtras().getString("BookTitle");
        bookAt = intent.getExtras().getString("BookAuthor");

        retrieve(bookTit,bookAt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateRecord();

            }

        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Update.this);
                builder.setTitle("delete");
                builder.setMessage("are you sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DeleteRecord();
                        Intent intent1 = new Intent(Update.this, Wishtoreadbook.class);
                        startActivity(intent1 );

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

    }

    private void retrieve(String bookTit, String bookAt) {

        reff = FirebaseDatabase.getInstance().getReference().child("wishToRead");
        Query query = reff.orderByChild(bookTit);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot datas: dataSnapshot.getChildren()){
                    wishToRead book = datas.getValue(wishToRead.class);
                    title.setText(book.getBookTitle());
                    author.setText(book.getBookAuthor());
                    pubDate.setText(book.getPdate());
                    category.setText(book.getCategory());
                    bookid.setText(book.getBookID());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Log.i("GetError",databaseError.getMessage());

            }
        });


    }

    private void UpdateRecord(){
        wishToRead update = new wishToRead();
        update.setBookID(bookid.getText().toString());
        update.setBookTitle(title.getText().toString());
        update.setBookAuthor(author.getText().toString());
        update.setPdate(pubDate.getText().toString());
        update.setCategory(category.getText().toString());

        reff = FirebaseDatabase.getInstance().getReference().child("wishToRead").child(bookid.getText().toString());
        reff.setValue(update);
        reff.push();
        

        Toast.makeText(getApplicationContext() , "Data updated successfully" , Toast.LENGTH_SHORT).show();
    }

    private void DeleteRecord(){
        reff = FirebaseDatabase.getInstance().getReference().child("wishToRead").child(bookid.getText().toString());
        reff.removeValue();
        title.setText("");
        author.setText("");
        pubDate.setText("");
        category.setText("");
        bookid.setText("");

    }
}