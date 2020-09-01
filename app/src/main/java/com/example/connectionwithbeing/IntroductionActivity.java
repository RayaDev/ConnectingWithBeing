package com.example.connectionwithbeing;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
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

//        instructionToastMessage();


        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:

                        return new IntroductionFragment1();

                    case 1:

                        return new IntroductionFragment2();
                    case 2:

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

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if (position == 1) {
//                    mNextButton = findViewById(R.id.IntroductionNext_LinearLayout);
                    mNextButton.setVisibility(View.INVISIBLE);
                } else {
//                    mNextButton = findViewById(R.id.IntroductionNext_LinearLayout);
                    mNextButton.setVisibility(View.VISIBLE);
                }
            }
        });

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
                    new AlertDialog.Builder(IntroductionActivity.this)
                            .setTitle("Introduction Completed!")
                            .setMessage("Continue to the main menu?")

                            .setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    finishIntroduction();
                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setIcon(R.drawable.guistar)
                            .show();
                }
                else {
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
