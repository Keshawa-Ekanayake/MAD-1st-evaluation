package com.example.wishtoread;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BookLsitAdapter extends ArrayAdapter {

    private Activity mContext;
    List<wishToRead> list;

    public BookLsitAdapter(@NonNull Activity mContext, List<wishToRead> list) {
        super(mContext,R.layout.booksingle,list);
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.booksingle , null, true);
        TextView BookName = listItemView.findViewById(R.id.SingleBookName);
        TextView BookAuthor = listItemView.findViewById(R.id.singleBookAuthor);
        TextView BookPublish = listItemView.findViewById(R.id.singleBookPdate);
        TextView BookCate = listItemView.findViewById(R.id.singleBookCate);

        wishToRead read = list.get(position);
        BookName.setText(read.getBookTitle());
        BookAuthor.setText(read.getBookAuthor());
        BookPublish.setText(read.getPdate());
        BookCate.setText(read.getCategory());

        return listItemView;
    }
}
