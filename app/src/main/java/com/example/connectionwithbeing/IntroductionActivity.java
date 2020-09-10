package com.example.connectionwithbeing;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
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
        } else {

        }
    }

}
