package com.example.wishtoread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

public class Check extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    private ListView listData;
    EditText check1, check2;
    TextView text1;
    TextView text;
    Button button;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        reference = FirebaseDatabase.getInstance().getReference("wishToRead");

        TextView texttop = findViewById(R.id.texttop);
        texttop.setText(R.string.header1);
        button = findViewById(R.id.search);
        check1 = (EditText) findViewById(R.id.checkt);
        check2 = (EditText) findViewById(R.id.checka);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Check.this,Update.class);
                intent.putExtra("BookTitle",check1.getText().toString());
                intent.putExtra("BookAuthor",check2.getText().toString());


                startActivity(intent);

            }
        });
    }

}