package com.example.connectionwithbeing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookmarksAdapter extends RecyclerView.Adapter<BookmarksAdapter.ViewHolder> {

//    public BookmarksAdapter() {
//
//    } Empty default constructor

    private List<NatureE1Activity> mBookmarkedActivity;

    public BookmarksAdapter(List<NatureE1Activity> bookmarkedActivity) {

        mBookmarkedActivity = bookmarkedActivity;
    }


    //Generated Methods
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context); //What does LayoutInflater actually do?
        View contactView = inflater.inflate(R.layout.bookmark_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    //Custom created ViewHolder class
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public ImageView mImageView;
        public TextView mTextView;
        public Button mButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            mImageView = itemView.findViewById(R.id.exerciseImage_Bookmark);
            mTextView = itemView.findViewById(R.id.exerciseName_Bookmark);
            mButton = itemView.findViewById(R.id.exerciseRemove_Button);

        }
    }
}
