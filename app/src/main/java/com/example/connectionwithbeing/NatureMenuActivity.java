package com.example.connectionwithbeing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class NatureMenuActivity extends AppCompatActivity {

    //Views for the custom bottom navigation
    private LinearLayout mHomeButtonBar;
    private ImageView mHomeButton;

    //Image Views for the UI Activity "Menu"
    private ImageView mStartExercise1, mStartExercise2;

    //Intent Extras for setting exercise UI Views
    public static final String exerciseImageView = "exercise_image";
    public static final String exerciseTextView = "exercise_text";


    //Shared Preferences for the Activity. User progress
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
        mStartExercise2 = findViewById(R.id.natureMenuE2_ImageView);

        mHomeButtonBar = findViewById(R.id.natureBottomActionBar_Menu);
        mHomeButton = findViewById(R.id.natureHomeButton_Menu);

        checkForCompletedExercises();
        mOnClickListeners();

    }

    public void mOnClickListeners() {

        mStartExercise1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startExercise1 = new Intent(NatureMenuActivity.this, NatureE1Activity.class);
                startExercise1.putExtra(exerciseImageView, R.drawable.bigtree);
                startExercise1.putExtra(exerciseTextView, R.string.exercise1_center_text_string);
                startActivity(startExercise1);
            }
        });

        mStartExercise2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startExercise2 = new Intent(NatureMenuActivity.this, NatureE1Activity.class);
                startExercise2.putExtra(exerciseImageView, R.drawable.naturemenuicon);
                startExercise2.putExtra(exerciseTextView, R.string.exercise2_center_text_string);
                startActivity(startExercise2);

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

//    //Switch statement for starting activities.
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.natureMenuE1_ImageView:
//                Intent startExercise1 = new Intent(NatureMenuActivity.this, NatureE1Activity.class);
//                startExercise1.putExtra(exerciseImageView, R.drawable.bigtree);
//                startExercise1.putExtra(exerciseTextView, R.string.exercise1_center_text_string);
//                startActivity(startExercise1);
//
//            case R.id.natureMenuE2_ImageView:
//                Intent startExercise2 = new Intent(NatureMenuActivity.this, NatureE1Activity.class);
//                startExercise2.putExtra(exerciseImageView, R.drawable.naturemenuicon);
//                startExercise2.putExtra(exerciseTextView, R.string.exercise2_center_text_string);
//                startActivity(startExercise2);
//
//            case R.id.natureHomeButton_Menu:
//                Intent returnHome = new Intent(NatureMenuActivity.this, MainActivity.class);
//                startActivity(returnHome);
//        }
//
//    }
}
