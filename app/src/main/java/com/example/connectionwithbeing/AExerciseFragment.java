package com.example.connectionwithbeing;


import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.sarnava.textwriter.TextWriter;


public class AExerciseFragment extends Fragment {


    private View view;
    private ImageView mImageView;
    private Button mButton;
    private TextWriter textWriter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.exercise1_fragment, container, false);
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.red)));

        mImageView = view.findViewById(R.id.exercise1_footerImage_ImageView);
        mButton = view.findViewById(R.id.exercise1_questionsButton);

        textWriter = view.findViewById(R.id.exercise1_TextWriter);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AExerciseOneQuestions.class);
                startActivity(intent);
            }
        });



        return view;
    }
}
