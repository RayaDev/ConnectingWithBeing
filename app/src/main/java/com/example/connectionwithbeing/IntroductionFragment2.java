package com.example.connectionwithbeing;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class IntroductionFragment2 extends Fragment {


    public IntroductionFragment2() {
        // Required empty public constructor
    }

    private LinearLayout mIntroLinearLayout, mIntroExerciseMenu, mIntroExerciseIcon, mIntroNext2Button, mFirstIntroIcon;
    private TextView mIntroIconTextView;



    private int clickCount = 2;

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
        mIntroIconTextView = view.findViewById(R.id.IntroIconText_TextView);
        mIntroNext2Button = view.findViewById(R.id.IntroductionNext2_LinearLayout);
        mIntroExerciseMenu = view.findViewById(introImages[0]);
        mIntroIconTextView.setText(introText[0]);
        mIntroExerciseIcon = view.findViewById(introImages[1]);


        Animation animation1 =
                AnimationUtils.loadAnimation(getContext(),
                        R.anim.blink);

       mFirstIntroIcon = view.findViewById(R.id.UIIntroExerciseMenuIcon_LinearLayout);
       mFirstIntroIcon.setAnimation(animation1);

        mIntroNext2Button.setVisibility(View.INVISIBLE);

        mIntroLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageText();
                clickCount++;
            }
        });


        return view;

    }


    private void setImageText() {

        Animation animation1 =
                AnimationUtils.loadAnimation(getContext(),
                        R.anim.blink);

        mFirstIntroIcon.clearAnimation();

        switch (clickCount) {
            case 1:
                mIntroExerciseMenu.setVisibility(View.VISIBLE);
                mIntroExerciseIcon.setVisibility(View.INVISIBLE);
                mIntroExerciseMenu.setAnimation(animation1);
                mIntroIconTextView.setText(introText[0]);
                break;


            case 2:
                mIntroExerciseMenu.setVisibility(View.GONE);
                mIntroExerciseIcon.setVisibility(View.VISIBLE);
                mIntroExerciseIcon.setAnimation(animation1);
                mIntroIconTextView.setText(introText[1]);
                break;

            case 3:
                mIntroExerciseMenu.setVisibility(View.INVISIBLE);
                mIntroExerciseIcon.setVisibility(View.INVISIBLE);
                mIntroExerciseIcon.clearAnimation();
                mIntroExerciseMenu.clearAnimation();
                mIntroLinearLayout.setBackgroundResource(introImages[2]);
                mIntroIconTextView.setText(introText[2]);
                mIntroLinearLayout.setAnimation(animation1);
                break;

            case 4:
                mIntroExerciseMenu.setVisibility(View.INVISIBLE);
                mIntroExerciseIcon.setVisibility(View.INVISIBLE);
                mIntroLinearLayout.setBackgroundResource(introImages[3]);
                mIntroIconTextView.setText(introText[3]);
                mIntroLinearLayout.setAnimation(animation1);
                break;

            case 5:
                mIntroExerciseMenu.setVisibility(View.INVISIBLE);
                mIntroExerciseIcon.setVisibility(View.INVISIBLE);
                mIntroLinearLayout.setBackgroundResource(introImages[4]);
                mIntroIconTextView.setText(introText[4]);
                mIntroLinearLayout.setAnimation(animation1);
                break;

            case 6:
                mIntroExerciseMenu.setVisibility(View.INVISIBLE);
                mIntroExerciseIcon.setVisibility(View.INVISIBLE);
                mIntroLinearLayout.setBackgroundResource(introImages[5]);
                mIntroIconTextView.setText(introText[5]);
                mIntroLinearLayout.setAnimation(animation1);
                break;

            case 7:

                mIntroLinearLayout.clearAnimation();
                mIntroNext2Button.setVisibility(View.VISIBLE);


                break;
        }

    }
}
