package com.example.connectionwithbeing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

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

                Intent i = new Intent(WelcomeActivity.this, MainActivity.class);

                startActivity(i);
                // close this activity
                finish();
            }
        }, 3000); // wait for 5 seconds
    }
}
