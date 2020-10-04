package com.example.it19194486;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Library04 extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    EditText libname , address , phone , date , fine , searchlib;
    TextView id;
    Button search , update , delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library04);

        id= findViewById(R.id.bookid);

        libname = findViewById(R.id.libname);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        date = findViewById(R.id.date);
        fine = findViewById(R.id.fine);

        searchlib = findViewById(R.id.searchlib);

        search = (Button) findViewById(R.id.Search);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrievedata(searchlib.getText().toString());
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
        reference = FirebaseDatabase.getInstance().getReference().child("library");
        Query query = reference.orderByChild(searchtag);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    BookLib bookLib = postSnapshot.getValue(BookLib.class);

                    libname.setText(bookLib.getName());
                    address.setText(bookLib.getAddress());
                    phone.setText(bookLib.getPhone());
                    date.setText(bookLib.getDate());
                    fine.setText(bookLib.getFine());
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void upatedata(String ID)
    {
        BookLib update = new BookLib();
        update.setName(libname.getText().toString());
        update.setAddress(address.getText().toString());
        update.setPhone(phone.getText().toString());
        update.setDate(date.getText().toString());
        update.setFine(fine.getText().toString());

        reference = FirebaseDatabase.getInstance().getReference().child("library").child(ID);
        reference.setValue(update);
        reference.push();
    }

    private void deletedata(String ID)
    {
        reference = FirebaseDatabase.getInstance().getReference().child("library").child(ID);
        reference.removeValue();
    }
}