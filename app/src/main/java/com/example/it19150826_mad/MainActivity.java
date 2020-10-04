package com.example.it19150826_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView header, reader, name;
    Button add, show, edit , addbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.borrowed_books_main);

        header = findViewById(R.id.headerView);
        reader = findViewById(R.id.headerView);
        name = findViewById(R.id.nameView);

        add = findViewById(R.id.addbutton);
        show = findViewById(R.id.Show);
        edit = findViewById(R.id.Edit);

        addbutton = (Button) findViewById(R.id.addbutton);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addnewbook();
            }

            private void addnewbook() {
                Intent intent = new Intent(MainActivity.this , InsertBorrowedBooks.class);
                startActivity(intent);
            }
        });

        show = (Button) findViewById(R.id.Show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, show_BorrowedBooks.class);
                startActivity(intent);
            }
        });

        edit = (Button) findViewById(R.id.Edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check();
            }
        });
    }

    public void check(){
        Intent intent = new Intent(this, SearchBorrowedBooks.class);
        startActivity(intent);
    }
}