package com.example.connectionwithbeing;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import android.app.Fragment;


public class FirstFragment extends Fragment {


    private View view;
    private ImageView mImageView;
    private TextView mTextView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.exercise1_fragment, container, false);



        return view;
    }
}
