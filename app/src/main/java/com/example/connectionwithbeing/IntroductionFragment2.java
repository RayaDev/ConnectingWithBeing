package com.example.connectionwithbeing;


import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class IntroductionFragment2 extends Fragment {


    public IntroductionFragment2() {
        // Required empty public constructor
    }

    private LinearLayout mIntroExerciseIcon, mIntroMenuIcon;
    private TextView mIntroIconText, mIntroIconTitle;
    private ScrollView mScrollView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_introduction_fragment2, container, false);

        mIntroMenuIcon = view.findViewById(R.id.UIIntroExerciseMenuIcon_LinearLayout);
        mIntroExerciseIcon = view.findViewById(R.id.UIIntroExerciseIcon_LinearLayout);
        mIntroIconText = view.findViewById(R.id.UIIntroIconText_TextView);
        mIntroIconTitle= view.findViewById(R.id.UIIntroIconInfoTitle_TextView);

        mScrollView = view.findViewById(R.id.Fragment2ScrollView);



        setOnclickListeners();

        return view;

    }

    private void setOnclickListeners() {

        mIntroMenuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mIntroIconTitle.setText(R.string.ui_menu_icon_title);
                mIntroIconText.setText(R.string.ui_menu_icon);
//                mScrollView.fullScroll(View.FOCUS_DOWN);
            }
        });

        mIntroExerciseIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntroIconTitle.setText(R.string.ui_exercise_icon_title);
                mIntroIconText.setText(R.string.ui_exercise_icon);
//                mScrollView.fullScroll(View.FOCUS_DOWN);
            }
        });

    }

}
