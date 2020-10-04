package com.example.it19194486;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class library02 extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref;
    EditText libname , address , phone , medate , fine;
    BookLib bookLib;
    int maxid = 0;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library02);

        libname = findViewById(R.id.libname);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        medate = findViewById(R.id.medate);
        fine = findViewById(R.id.fine);
        submit = findViewById(R.id.submit);

        bookLib = new BookLib();

        ref = database.getInstance().getReference().child("library");

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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long time= System.currentTimeMillis();
                bookLib.setName(libname.getText().toString());
                bookLib.setAddress(address.getText().toString());
                bookLib.setPhone(phone.getText().toString());
                bookLib.setDate(medate.getText().toString());
                bookLib.setFine(fine.getText().toString());

                ref.child((Long.toString(time))).setValue(bookLib);
                ref.push();
            }
        });
    }
}