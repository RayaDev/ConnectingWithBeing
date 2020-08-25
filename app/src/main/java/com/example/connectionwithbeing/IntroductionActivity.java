package com.example.connectionwithbeing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import model.Exercise;

public class IntroductionActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private Button mSkipButton;
    private LinearLayout mNextButton;
    private View mNextButton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        mViewPager = (ViewPager) findViewById(R.id.IntroductionActivity_ViewPager);
//        mSkipButton = (Button) findViewById(R.id.IntroductionActivity_SkipButton);
        mNextButton = findViewById(R.id.IntroductionNext_LinearLayout);

        instructionToastMessage();


        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
//                        mNextButton = findViewById(R.id.IntroductionNext_LinearLayout);
                        return new IntroductionFragment1();
                    case 1:
//                        mNextButton = (LinearLayout) findViewById(R.id.ExerciseMenuE1_LinearLayout);

                        return new IntroductionFragment2();
                    case 2:
                        mNextButton = (LinearLayout) findViewById(R.id.selfLinearLayout);
                        return new IntroductionFragment3();
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return 3;
            }
        };

        mViewPager.setAdapter(adapter);

//        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
//            @Override
//            public void onPageSelected(int position) {
//                if (position == 2) {
//                    mSkipButton.setVisibility(View.GONE);
//                    mNextButton.setText("Done");
//                } else {
//                    mSkipButton.setVisibility(View.VISIBLE);
//                    mNextButton.setText("Next");
//                }
//            }
//        });

//        mSkipButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finishIntroduction();
//            }
//        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mViewPager.getCurrentItem() == 2) { // The last screen
                    finishIntroduction();
                } else {
                    mViewPager.setCurrentItem(
                            mViewPager.getCurrentItem() + 1,
                            true
                    );
                }
            }
        });
    }

    private void finishIntroduction() {
        // Get the shared preferences
        SharedPreferences preferences =
                getApplicationContext().getSharedPreferences(Exercise.generalPreferencesKey, MODE_PRIVATE);

        // Set introduction_complete to true
        preferences.edit().putBoolean(Exercise.introCompletedKey, true).apply();

        // Launch the main Activity, called MainActivity
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);

        // Close the IntroductionActivity
        finish();
    }

    @Override
    public void onBackPressed() {
        SharedPreferences preferences =
                getApplicationContext().getSharedPreferences(Exercise.generalPreferencesKey, MODE_PRIVATE);
        boolean introCompleted = preferences.getBoolean(Exercise.introCompletedKey, false);
        if (introCompleted == true) {
            Intent startMainActivity = new Intent(IntroductionActivity.this, MainActivity.class);
            startActivity(startMainActivity);
        } else {

        }
    }

    private void instructionToastMessage() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(IntroductionActivity.this, "Scroll down for more info", Toast.LENGTH_LONG).show();
                Toast.makeText(IntroductionActivity.this, "Click next arrow or swipe to continue", Toast.LENGTH_LONG).show();

            }
        }, 2500);

    }
}
