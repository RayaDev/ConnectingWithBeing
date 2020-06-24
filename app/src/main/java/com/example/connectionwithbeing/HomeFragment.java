package com.example.connectionwithbeing;


import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import android.app.Fragment;


public class HomeFragment extends Fragment {

    View fragmentView;
    Button homeButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       fragmentView = inflater.inflate(R.layout.fragment_home, container, false);

        homeButton = (Button) fragmentView.findViewById(R.id.homeFragment_Button);

        // perform setOnClickListener on first Button
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // display a message by using a Toast
                Toast.makeText(getActivity(), "Home Fragment", Toast.LENGTH_LONG).show();
            }
        });


       return fragmentView;
    }

}
