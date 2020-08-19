package com.example.connectionwithbeing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import model.Exercise;

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

        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter (getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0 : return new IntroductionFragment1();
                    case 1 : return new IntroductionFragment2();
                    case 2 : return new IntroductionFragment3();
                    default: return null;
                }
            }

            @Override
            public int getCount() {
                return 3;
            }
        };

        mViewPager.setAdapter(adapter);

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if(position == 2){
                    mSkipButton.setVisibility(View.GONE);
                    mNextButton.setText("Done");
                } else {
                    mSkipButton.setVisibility(View.VISIBLE);
                    mNextButton.setText("Next");
                }
            }
        });
    }

    private void finishOnboarding() {
        // Get the shared preferences
        SharedPreferences preferences =
                getApplicationContext().getSharedPreferences(Exercise.generalPreferencesString, MODE_PRIVATE);

        // Set onboarding_complete to true
        preferences.edit()
                .putBoolean("onboarding_complete",true).apply();

        // Launch the main Activity, called MainActivity
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);

        // Close the OnboardingActivity
        finish();
    }
}
