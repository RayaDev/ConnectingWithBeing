package com.example.connectionwithbeing;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import model.Exercise;


public class IntroductionActivity extends AppCompatActivity {

    private LinearLayout mNextLinearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction_1);
        setTitle("Introduction");

        mNextLinearLayout = findViewById(R.id.IntroductionNext_LinearLayout);

//        Animation mBlink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
//        mNextLinearLayout.setAnimation(mBlink);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                playBlinkAnimation();
            }
        }, 2000);

        mNextLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntroSlide = new Intent(IntroductionActivity.this, IntroductionActivity2.class);
                startActivity(nextIntroSlide);
            }
        });

    }

    @Override
    public void onBackPressed() {
        SharedPreferences preferences =
                getApplicationContext().getSharedPreferences(Exercise.generalPreferencesKey, MODE_PRIVATE);
        boolean introCompleted = preferences.getBoolean(Exercise.introCompletedKey, false);
        if (introCompleted == true) {
            Intent startMainActivity = new Intent(IntroductionActivity.this, MainActivity.class);
            startActivity(startMainActivity);
        }
        else {

        }
    }

    private void playBlinkAnimation(){

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        mNextLinearLayout.startAnimation(animation1);

    }

}
