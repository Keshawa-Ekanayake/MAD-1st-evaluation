package com.example.it19150758;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Booklistadapter extends ArrayAdapter {

    private Activity mContext;
    List<Book> list;
    public Booklistadapter(@NonNull Activity mContext, List<Book> list) {
        super(mContext,R.layout.retrievedata,list);
        this.mContext = mContext;
        this.list = list;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.retrievedata , null, true);
        TextView BookName = listItemView.findViewById(R.id.SingleBookName);
        TextView BookAuthor = listItemView.findViewById(R.id.singleBookAuthor);
        TextView BookPublish = listItemView.findViewById(R.id.singleBookPdate);
        TextView BookCate = listItemView.findViewById(R.id.singleBookCate);
        Book read = list.get(position);
        BookName.setText(read.getName());
        BookAuthor.setText(read.getCategory());
        BookPublish.setText(read.getAuthor());
        BookCate.setText(read.getPublishdate());
        return listItemView;
    }
}
