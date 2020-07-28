package com.example.connectionwithbeing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import model.Exercise;

public class ExerciseMenuActivity extends AppCompatActivity {

    //Views for the custom bottom navigation
    private LinearLayout mHomeButtonBar;
    private ImageView mHomeButton, mToDoButton;

    //Image Views for the UI Activity "Menu"
    private ImageView mStartExercise1, mStartExercise2;

    //Intent Extras for setting exercise UI Views
    public static final String exerciseImageView = "exercise_image";
    public static final String exerciseTextView = "exercise_text";
    public static final String exerciseNumber = "exercise_number";
    public static final String exerciseCategory = "exercise_category";
    public static int menuCategory;

//    //Values, passed as extra for determing which menu to construct. Notes from main activity
//    private static final int selfMenu = 1;
//    private static final int othersMenu = 2;
//    private static final int natureMenu = 3;
//    private static final int societyMenu = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_menu);

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.nature_primary_dark)));


        mHomeButtonBar = findViewById(R.id.ExerciseBottomActionBar_Menu);
        mHomeButton = findViewById(R.id.ExerciseHomeButton_Menu);
        mToDoButton = findViewById(R.id.ExerciseToDoButton_Menu);


        Bundle extras = getIntent().getExtras();

        menuCategory = extras.getInt("menu_category");

        setMenuDrawables(menuCategory);
        createExerciseMenu(menuCategory);

//        checkForNatureCompletedExercises();
//        mOnClickListeners();

    }

    private void createExerciseMenu(int menuCategory) {

        if(menuCategory == MainActivity.selfMenu) {

//            checkForCompletedExercises(null,null, null);
//            onClickListeners(null, null);
        }

        if(menuCategory == MainActivity.othersMenu) {

            setTitle(R.string.others_menu_title);

            Exercise mOthersExercise = new Exercise();

            checkForCompletedExercises(mOthersExercise.userOthersProgress,
                    mOthersExercise.getOthersKeys(), mOthersExercise.getOthersValues());

            onClickListeners(mOthersExercise.getOtherExerciseImages(), mOthersExercise.getOtherExerciseStrings());
        }

        if(menuCategory == MainActivity.natureMenu) {
            setTitle(R.string.nature_menu_title);

            Exercise mNatureExercise = new Exercise();

            checkForCompletedExercises(mNatureExercise.userNatureProgress,
                    mNatureExercise.getNatureKeys(), mNatureExercise.getNatureValues());

            onClickListeners(mNatureExercise.getNatureExerciseImages(), mNatureExercise.getNatureExerciseStrings());
        }

        if(menuCategory == MainActivity.societyMenu) {

//            checkForCompletedExercises(null,null, null);
//            onClickListeners(null, null);
        }


    }

    //Sets the images for the menu.
    private void setMenuDrawables(int menuCategory) {

    }

    private void checkForCompletedExercises(String exerciseCategory, String[] exerciseKeys, int[] exerciseValues) {

        //Sets color of stars for each exercise.
        SharedPreferences exerciseSharedPreferences = getApplicationContext().getSharedPreferences(exerciseCategory, MODE_PRIVATE); //Polymorph this

        //Order of these arrays is very important... must be maintained.
//        String[] natureKeys = {natureE1, natureE2, natureE3, natureE4, natureE5, natureE6};
//
//        int[] natureValues = {natureE1Completed, natureE2Completed, natureE3Completed,
//                natureE4Completed, natureE5Completed, natureE6Completed};

        int[] exerciseStarImageViews = {R.id.ExerciseMenuE1Star_ImageView, R.id.ExerciseMenuE2Star_ImageView, R.id.ExerciseMenuE3Star_ImageView,
                R.id.ExerciseMenuE4Star_ImageView, R.id.ExerciseMenuE5Star_ImageView, R.id.ExerciseMenuE6Star_ImageView};

        int i = 0;
        while(i < exerciseKeys.length) {
            int lightUpStar = exerciseSharedPreferences.getInt(exerciseKeys[i], exerciseValues[i]);

            if (lightUpStar == 1) {
                ImageView mStar = findViewById(exerciseStarImageViews[i]);
                mStar.setImageResource(R.drawable.star);
            }

            i++;
        }

    }


    private void onClickListeners(final HashMap<String, Integer> exerciseImages, final HashMap<String,Integer> exerciseStrings) { //HashMap here?

        mStartExercise1 = findViewById(R.id.ExerciseMenuE1_ImageView);
        mStartExercise2 = findViewById(R.id.ExerciseMenuE2_ImageView);

        mStartExercise1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startExercise1 = new Intent(ExerciseMenuActivity.this, ExerciseActivity.class);
                startExercise1.putExtra(exerciseImageView, exerciseImages.get("exercise1_image"));
                startExercise1.putExtra(exerciseTextView, exerciseStrings.get("exercise1_text"));
                startExercise1.putExtra(exerciseNumber,1);
                startExercise1.putExtra(exerciseCategory, menuCategory);
                startActivity(startExercise1);

            }
        });

        mStartExercise2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startExercise2 = new Intent(ExerciseMenuActivity.this, ExerciseActivity.class);
                startExercise2.putExtra(exerciseImageView, exerciseImages.get("exercise2_image"));
                startExercise2.putExtra(exerciseTextView, exerciseStrings.get("exercise2_text"));
                startExercise2.putExtra(exerciseNumber,2);
                startExercise2.putExtra(exerciseCategory, menuCategory);
                startActivity(startExercise2);

            }
        });

        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnHome = new Intent(ExerciseMenuActivity.this, MainActivity.class);
                startActivity(returnHome);
            }
        });

        mToDoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ExerciseMenuActivity.this, "To Do Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
