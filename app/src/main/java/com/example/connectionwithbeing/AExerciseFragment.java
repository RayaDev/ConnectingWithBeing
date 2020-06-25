package com.example.connectionwithbeing;


import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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
//        String text = getString(R.string.exercise1_centerText).toUpperCase();
//        text = "LILI IS CLEANING!!!";
//        Log.i("String", text);

        textWriter
                .setWidth(1) //Sets how thick the letters are.
                .setDelay(0) //Sets how fast the letters are draw. 0 is the default and fastest?
                .setColor(Color.BLACK)
                .setConfig(TextWriter.Configuration.INTERMEDIATE)
                .setSizeFactor(30f)
                .setLetterSpacing(10f)
                .setText("NATURE") //Must be in upper case to work.
                .setListener(new TextWriter.Listener() {
                    @Override
                    public void WritingFinished() {

                        //do stuff after animation is finished
                    }
                })
                .startAnimation();


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

//1. Nature is center

/*
Go in nature by yourself with no predetermined route (or very minimal one) or length of time.
What was the most exciting thing that happened during that walk?
 Were you thinking a lot? Or not at all? What was in your head?

 GO IN NATURE BY YOURSELF WITH NO PREDETERMINED ROUTE (OR VERY MINIMAL ONE) OR LENGTH OF TIME.
WHAT WAS THE MOST EXCITING THING THAT HAPPENED DURING THAT WALK?
 WERE YOU THINKING A LOT? OR NOT AT ALL? WHAT WAS IN YOUR HEAD?
 */