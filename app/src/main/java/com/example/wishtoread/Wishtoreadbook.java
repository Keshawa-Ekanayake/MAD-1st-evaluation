package com.example.wishtoread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Wishtoreadbook extends AppCompatActivity {
    com.google.firebase.database.FirebaseDatabase FirebaseDatabase;
    DatabaseReference reff;
    Button button, button2;
    TextView text;
    TextView add;

    ListView Datalist;
    List<wishToRead> list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishtoreadbook);


        TextView texttop = findViewById(R.id.texttop);
        texttop.setText(R.string.header1);

        text = findViewById(R.id.textView4);
        add = findViewById(R.id.add);
        text = findViewById(R.id.bktitle);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opencheck();
            }
        });
        button2 = (Button) findViewById(R.id.button2);
        Datalist = findViewById(R.id.dataList);
        list = new ArrayList<>();

        reff = FirebaseDatabase.getInstance().getReference().child("wishToRead");


        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot data:dataSnapshot.getChildren()){

                    wishToRead wishToRead = data.getValue(wishToRead.class);
                    list.add(wishToRead);
                }
               BookLsitAdapter adapter = new BookLsitAdapter(Wishtoreadbook.this,list);
                Datalist.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }

        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wishtoreadbook.this, ADD.class);
                startActivity(intent);

            }
        });



    }

    public void opencheck() {
        Intent intent = new Intent(this, Check.class);
        startActivity(intent);
    }


}