package com.example.connectionwithbeing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import model.Exercise;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        ImageView welcomeScreenImage = findViewById(R.id.WelcomeActivity_ImageView);
        Animation rotateAnimation =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.rotate);

        welcomeScreenImage.startAnimation(rotateAnimation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences preferences =
                        getApplicationContext().getSharedPreferences(Exercise.generalPreferencesKey, MODE_PRIVATE);

                if (!preferences.getBoolean(Exercise.introCompletedKey, false)) {
                    // Start the onboarding Activity
                    Intent introductionActivity = new Intent(WelcomeActivity.this, IntroductionActivity.class);
                    startActivity(introductionActivity);

                    // Close the main Activity
                    finish();

                }
                else {

                    Intent i = new Intent(WelcomeActivity.this, MainActivity.class);

                    startActivity(i);
                    // close this activity
                    finish();
                }
            }
        }, 3000); // wait for 5 seconds
    }
}
