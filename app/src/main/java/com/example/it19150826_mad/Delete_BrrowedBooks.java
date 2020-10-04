package com.example.it19150826_mad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Delete_BrrowedBooks extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference ref;
    Button delete, update, cancel;
    EditText title, bDate, rDate, lib, id;
    String bookName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete__brrowed_books);

        delete = findViewById(R.id.deleteBtn);
        update = findViewById(R.id.updateBtn);
        cancel = findViewById(R.id.cancelBtn);
        title = findViewById(R.id.titleText);
        bDate = findViewById(R.id.bDateText);
        rDate = findViewById(R.id.rDateText);
        lib = findViewById(R.id.libText);
        id = findViewById(R.id.idText);

        Intent intent = getIntent();
        bookName = intent.getExtras().getString("title");

        dataRetrieve();

         update.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 updateRecords(id.getText().toString());
             }
         });

         delete.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 deleteRecords(id.getText().toString());
                 Intent intent = new Intent(Delete_BrrowedBooks.this, MainActivity.class);
                 startActivity(intent);
             }
         });

         cancel.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(Delete_BrrowedBooks.this, MainActivity.class);
                 startActivity(intent);
             }
         });


        /*delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Delete_BrrowedBooks.this, MainActivity.class);
                startActivity(intent);
            }
        });*/

    }

    private void dataRetrieve(){
        ref = FirebaseDatabase.getInstance().getReference().child("borrowedbooks");
        Query query = ref.orderByChild(bookName);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){

                    borrowedBooks Book = ds.getValue(borrowedBooks.class);
                    id.setText(Book.getId());
                    title.setText(Book.getTitle());
                    bDate.setText(Book.getbDate());
                    rDate.setText(Book.getrDate());
                    lib.setText(Book.getLib());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.i("GetError",databaseError.getMessage());
            }
        });
    }

    public void updateRecords(String BookID){

        borrowedBooks update = new borrowedBooks();
        update.setId(BookID);
        update.setTitle(title.getText().toString());
        update.setLib(lib.getText().toString());
        update.setrDate(rDate.getText().toString());
        update.setbDate(bDate.getText().toString());

        ref = FirebaseDatabase.getInstance().getReference().child("borrowedbooks").child(BookID);
        ref.setValue(update);
        ref.push();

        Toast.makeText(getApplicationContext() , "Data updated successfully" , Toast.LENGTH_SHORT).show();

    }

    private void deleteRecords(String BookID){
        ref = FirebaseDatabase.getInstance().getReference().child("borrowedbooks").child(BookID);
        ref.removeValue();

        Toast.makeText(getApplicationContext() , "Data deleted successfully" , Toast.LENGTH_SHORT).show();

    }
}