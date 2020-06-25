package com.example.connectionwithbeing;


import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import android.app.Fragment;

import androidx.annotation.RequiresApi;


public class AExerciseFragment extends Fragment {


    private View view;
    private ImageView mImageView;
    private TextView mTextView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.exercise1_fragment, container, false);
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.red)));

        mImageView = view.findViewById(R.id.exercise1_footerImage_ImageView);

        mImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent questionIntent = new Intent(getActivity(), AExerciseOneQuestions.class);
                startActivity(questionIntent);
            }
        });



        return view;
    }
}
