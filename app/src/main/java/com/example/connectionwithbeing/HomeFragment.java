package com.example.connectionwithbeing;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class HomeFragment extends Fragment implements View.OnClickListener {
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

        mRTimageView.setOnClickListener(this);
        mRBimageView.setOnClickListener(this);
        mLTimageView.setOnClickListener(this);
        mLBimageView.setOnClickListener(this);

        mRTtextView = mFragmentView.findViewById(R.id.RT_text);
        mRBtextView = mFragmentView.findViewById(R.id.RB_text);
        mLTtextView = mFragmentView.findViewById(R.id.LT_text);
        mLBtextView = mFragmentView.findViewById(R.id.LB_text);

        RTeCC = 0;
        RBeCC = 0;
        LTeCC = 0;
        LBeCC = 0;

       return mFragmentView;
    }


    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.RT_image:
                RTeCC += 1;
                mRTtextView.setText("Completed Exercises: " + RTeCC+"/5");
                break;

            case R.id.RB_image:
                RBeCC += 1;
                mRBtextView.setText("Completed Exercises: " + RBeCC+"/5");
                break;

            case R.id.LT_image:
                LTeCC += 1;
                mLTtextView.setText("Completed Exercises: " + LTeCC+"/5");
                break;

            case R.id.LB_image:
                LBeCC += 1;
                mLBtextView.setText("Completed Exercises: " + LBeCC+"/5");
                break;
        }
    }
}
