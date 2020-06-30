package com.example.connectionwithbeing;


import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;


public class HomeFragment extends Fragment{
    /*

    Short Hand Key
    *************************
    eCC = Exercise Completed Count
    RT = Right Top
    RB = Right Bottom
    LT = Left Top
    LB = Left Bottom

     */

    private View mFragmentView;

    private ImageView mRTimageView, mRBimageView, mLTimageView, mLBimageView;
    private TextView mRTtextView, mRBtextView, mLTtextView, mLBtextView;
    public int RTeCC, RBeCC, LTeCC, LBeCC;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       mFragmentView = inflater.inflate(R.layout.ahome_fragment, container, false);

        mRTimageView = mFragmentView.findViewById(R.id.RT_image);
        mRBimageView = mFragmentView.findViewById(R.id.RB_image);
        mLTimageView = mFragmentView.findViewById(R.id.LT_image);
        mLBimageView = mFragmentView.findViewById(R.id.LB_image);

        mRTtextView = mFragmentView.findViewById(R.id.RT_text);
        mRBtextView = mFragmentView.findViewById(R.id.RB_text);
        mLTtextView = mFragmentView.findViewById(R.id.LT_text);
        mLBtextView = mFragmentView.findViewById(R.id.LB_text);

        RTeCC = 0;
        RBeCC = 0;
        LTeCC = 0;
        LBeCC = 0;

        mRTimageView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                updateRTtextView();
                Toast.makeText(getContext(), "RTClicked", Toast.LENGTH_SHORT).show();
            }
        });

        mRBimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateRBtextView();

            }
        });

        mLTimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateLTtextView();

            }
        });

        mLBimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateLBtextView();

            }
        });


       return mFragmentView;
    }

    private void updateRTtextView() {

        mRTtextView.setText(Integer.toString(RTeCC));


    }

    private void updateRBtextView() {

        mRTtextView.setText(Integer.toString(RBeCC));

    }

    private void updateLTtextView() {

        mRTtextView.setText(Integer.toString(LTeCC));

    }

    private  void updateLBtextView() {

        mRTtextView.setText(Integer.toString(LBeCC));

    }


}
