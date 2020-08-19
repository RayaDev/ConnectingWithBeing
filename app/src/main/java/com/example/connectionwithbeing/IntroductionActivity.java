package com.example.connectionwithbeing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Button;

public class IntroductionActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private Button mSkipButton;
    private Button mNextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        mViewPager = (ViewPager)findViewById(R.id.IntroductionActivity_ViewPager);
        mSkipButton = (Button)findViewById(R.id.IntroductionActivity_SkipButton);
        mNextButton = (Button)findViewById(R.id.IntroductionActivity_NextButton);
    }
}
