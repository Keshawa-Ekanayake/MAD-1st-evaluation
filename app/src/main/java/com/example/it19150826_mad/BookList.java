package com.example.it19150826_mad;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.ListIterator;

public class BookList extends ArrayAdapter {
    private Activity content;
    List<borrowedBooks> list;

    public BookList (@NonNull Activity Content, List<borrowedBooks> list){
        super(Content, R.layout.showdata,list);
        this.content = Content;
        this.list = list;
    }

    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = content.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.showdata, null, true);
        TextView bookTitle = listItemView.findViewById(R.id.SingleBookTitle);
        TextView bDate = listItemView.findViewById(R.id.singleBookBdate);
        TextView rDate = listItemView.findViewById(R.id.singleBookRdate);
        TextView lib = listItemView.findViewById(R.id.singleBookLib);

        borrowedBooks read = list.get(position);
        bookTitle.setText(read.getTitle());
        bDate.setText(read.getbDate());
        rDate.setText(read.getrDate());
        lib.setText(read.getLib());

        return listItemView;
    }
}
