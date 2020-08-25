package com.example.connectionwithbeing;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class IntroductionFragment3 extends Fragment {


    public IntroductionFragment3() {
        // Required empty public constructor
    }

    private ImageView mIntroHomeIcon, mIntroBookmarkIcon, mIntroShuffleIcon;
    private TextView mIntroIconText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_introduction_fragment3, container, false);

        mIntroHomeIcon = view.findViewById(R.id.UIIntroHomeHomeButton);
        mIntroBookmarkIcon = view.findViewById(R.id.UIIntroHomeBookmarkButton);
        mIntroShuffleIcon = view.findViewById(R.id.UIIntroHomeShuffleButton);
        mIntroIconText = view.findViewById(R.id.UIIntroIconText_TextView2);

        setOnclickListeners();

        return view;
    }

    private void setOnclickListeners() {

        mIntroHomeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(), "Menu Item Clicked", Toast.LENGTH_SHORT).show();
                mIntroIconText.setText(R.string.ui_home_icon);
            }
        });

        mIntroBookmarkIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntroIconText.setText(R.string.ui_bookmark_icon);
            }
        });

        mIntroShuffleIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntroIconText.setText(R.string.ui_shuffle_icon);
            }
        });

    }

}
