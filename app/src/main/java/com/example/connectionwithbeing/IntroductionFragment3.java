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

    private ImageView mIntroHomeIcon, mIntroBookmarkIcon, mIntroShuffleIcon, mIntroInfoIcon;
    private TextView mIntroIconText, mIntroIconTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_introduction_fragment3, container, false);

        mIntroHomeIcon = view.findViewById(R.id.UIIntroHomeHomeButton);
        mIntroBookmarkIcon = view.findViewById(R.id.UIIntroHomeBookmarkButton);
        mIntroShuffleIcon = view.findViewById(R.id.UIIntroHomeShuffleButton);
        mIntroInfoIcon = view.findViewById(R.id.UIIntroInfoButton);
        mIntroIconText = view.findViewById(R.id.UIIntroIconText_TextView2);
        mIntroIconTitle= view.findViewById(R.id.UIIntroIconInfoTitle_TextView2);

        setOnclickListeners();

        return view;
    }

    private void setOnclickListeners() {

        mIntroHomeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(), "Menu Item Clicked", Toast.LENGTH_SHORT).show();
                mIntroIconTitle.setText(R.string.ui_home_icon_title);
                mIntroIconText.setText(R.string.ui_home_icon);
            }
        });

        mIntroBookmarkIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntroIconTitle.setText(R.string.ui_bookmark_icon_title);
                mIntroIconText.setText(R.string.ui_bookmark_icon);
            }
        });

        mIntroShuffleIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntroIconTitle.setText(R.string.ui_shuffle_icon_title);
                mIntroIconText.setText(R.string.ui_shuffle_icon);
            }
        });

        mIntroInfoIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntroIconTitle.setText(R.string.ui_info_icon_title);
                mIntroIconText.setText(R.string.ui_info_icon);
            }
        });

    }

}
