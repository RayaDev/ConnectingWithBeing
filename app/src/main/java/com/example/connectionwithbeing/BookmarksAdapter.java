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


// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class BookmarksAdapter extends RecyclerView.Adapter<BookmarksAdapter.ViewHolder> {

    public BookmarksAdapter() {

    }

    private List<NatureE1Activity> mBookmarkedActivity;

    public BookmarksAdapter(List<NatureE1Activity> bookmarkedActivity) {

        mBookmarkedActivity = bookmarkedActivity;
    }


    //Generated Methods

    // Usually involves inflating a layout from XML and returning the holder
    @NonNull
    @Override
    public BookmarksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context); //What does LayoutInflater actually do?
        View contactView = inflater.inflate(R.layout.bookmark_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // Get the data model based on position
        NatureE1Activity mExercise = mBookmarkedActivity.get(position);

        // Set item views based on your views and data model
        ImageView mExerciseImage = holder.mImageView;
        mExerciseImage.setImageResource(R.drawable.bigtree);

        TextView mExerciseText = holder.mTextView;
        mExerciseText.setText(R.string.exercise1_center_text_string);

        Button mButton = holder.mButton;
        mButton.setText("Success!");
    }

    @Override
    public int getItemCount() {
        return mBookmarkedActivity.size();
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
        public ViewHolder (View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            mImageView = itemView.findViewById(R.id.exerciseImage_Bookmark);
            mTextView = itemView.findViewById(R.id.exerciseName_Bookmark);
            mButton = itemView.findViewById(R.id.exerciseRemove_Button);

        }
    }
}
