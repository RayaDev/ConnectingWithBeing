package com.example.connectionwithbeing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class NatureMenuActivity extends AppCompatActivity {

    private LinearLayout mHomeButtonBar;
    private ImageView mHomeButton;

    private ImageView mStartExercise1;

    public static SharedPreferences mSharedPreferences;
    public static final String userNatureProgress = "nature_exercises_completed";

    public static final String natureE1 = "natureE1";
    public static final String natureE2 = "natureE2";
    public static final String natureE3 = "natureE3";
    public static final String natureE4 = "natureE4";
    public static final String natureE5 = "natureE5";
    public static final String natureE6 = "natureE6";

    public static int natureE1Completed = 0;

//    natureE2Completed, natureE3Completed,
//    natureE4Completed, natureE5Completed, natureE6Completed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature_menu);

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.nature_primary_dark)));

        mStartExercise1 = findViewById(R.id.natureMenuE1_ImageView);

        mHomeButtonBar = findViewById(R.id.natureBottomActionBar_Menu);
        mHomeButton = findViewById(R.id.natureHomeButton_Menu);

        checkForCompletedExercises();

        mStartExercise1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startExercise1 = new Intent(NatureMenuActivity.this, NatureE1Activity.class);
                startActivity(startExercise1);
            }
        });

        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent returnHome = new Intent(NatureMenuActivity.this, MainActivity.class);
                startActivity(returnHome);

            }
        });
    }

    public void checkForCompletedExercises() {


        mSharedPreferences = getApplicationContext().getSharedPreferences(userNatureProgress, MODE_PRIVATE);

        int lightUpStar = mSharedPreferences.getInt(natureE1, natureE1Completed);

        if(lightUpStar == 1) {
            ImageView mStar = findViewById(R.id.natureMenuE1Star_ImageView);
            mStar.setImageResource(R.drawable.star);
        }

    }
}
