package com.example.connectionwithbeing;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import android.app.Fragment;


public class Exercise2Fragment extends Fragment {

    private View mFragmentView;
    private Button mButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mFragmentView = inflater.inflate(R.layout.exercise2_fragment, container, false);


        return mFragmentView;
    }
}
