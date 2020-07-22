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
    private ImageView mHomeButton, mToDoButton;

    //Image Views for the UI Activity "Menu"
    private ImageView mStartExercise1, mStartExercise2;

    //Intent Extras for setting exercise UI Views
    public static final String exerciseImageView = "exercise_image";
    public static final String exerciseTextView = "exercise_text";
    public static final String exerciseNumber = "exercise_number";


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
    public static int natureE2Completed = 0;
    public static int natureE3Completed = 0;
    public static int natureE4Completed = 0;
    public static int natureE5Completed = 0;
    public static int natureE6Completed = 0;


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
        mToDoButton = findViewById(R.id.natureToDoButton_Menu);

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
                startExercise1.putExtra(exerciseNumber,1);
                startActivity(startExercise1);
            }
        });

        mStartExercise2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startExercise2 = new Intent(NatureMenuActivity.this, NatureE1Activity.class);
                startExercise2.putExtra(exerciseImageView, R.drawable.naturemenuicon);
                startExercise2.putExtra(exerciseTextView, R.string.exercise2_center_text_string);
                startExercise2.putExtra(exerciseNumber,2);
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

        mToDoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void checkForCompletedExercises() {

        mSharedPreferences = getApplicationContext().getSharedPreferences(userNatureProgress, MODE_PRIVATE);

        //Order of these arrays is very important... must be maintained.
        String[] natureKeys = {natureE1, natureE2, natureE3, natureE4, natureE5, natureE6};

        int[] natureValues = {natureE1Completed, natureE2Completed, natureE3Completed,
                natureE4Completed, natureE5Completed, natureE6Completed};

        int[] natureImageViews = {R.id.natureMenuE1Star_ImageView, R.id.natureMenuE2Star_ImageView, R.id.natureMenuE3Star_ImageView,
        R.id.natureMenuE4Star_ImageView, R.id.natureMenuE5Star_ImageView, R.id.natureMenuE6Star_ImageView};

        int i = 0;
        while(i < natureKeys.length) {
            int lightUpStar = mSharedPreferences.getInt(natureKeys[i], natureValues[i]);

            if (lightUpStar == 1) {
                ImageView mStar = findViewById(natureImageViews[i]);
                mStar.setImageResource(R.drawable.star);
            }

            i++;
        }

    }

}
