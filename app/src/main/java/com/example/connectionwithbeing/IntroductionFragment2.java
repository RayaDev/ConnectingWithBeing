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

import java.util.HashMap;


public class IntroductionFragment2 extends Fragment {


    public IntroductionFragment2() {
        // Required empty public constructor
    }

    private LinearLayout mIntroLinearLayout, mIntroExerciseMenu, mIntroExerciseIcon;

    private int[] introImages = {R.id.UIIntroExerciseMenuIcon_LinearLayout, R.id.UIIntroExerciseIcon_LinearLayout,
            R.drawable.guihome, R.drawable.guibookmark, R.drawable.shuffleiconimage, R.drawable.guiinfoitemimage};

    int[] introText = {R.string.ui_menu_icon, R.string.ui_exercise_icon, R.string.ui_home_icon, R.string.ui_bookmark_icon,
            R.string.ui_shuffle_icon, R.string.ui_info_icon};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_introduction_fragment2, container, false);


        mIntroLinearLayout = view.findViewById(R.id.IntroIconPlaceHolder_LinearLayout);
        mIntroExerciseMenu = view.findViewById(introImages[1]);
        mIntroExerciseIcon = view.findViewById(introImages[2]);


        setOnclickListeners();

        return view;

    }

    private void setOnclickListeners() {


//        mIntroExerciseMenu.setVisibility(View.GONE);
//        mIntroExerciseIcon.setVisibility(View.GONE);
        mIntroLinearLayout.setBackgroundResource(introImages[5]);

    }
}
