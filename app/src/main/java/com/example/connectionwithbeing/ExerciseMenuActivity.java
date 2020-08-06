package com.example.connectionwithbeing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

import model.Exercise;

 /*
 Self = 1
 Others = 2
 Nature = 3
 Society = 4
*/

public class ExerciseMenuActivity extends AppCompatActivity {

    //Views for the custom bottom navigation
    private LinearLayout mHomeButtonBar;
    private ImageView mHomeButton, mToDoButton;

    //Image Views for the UI Activity "Menu"
    private ImageView mStartExercise1, mStartExercise2, mStartExercise3, mStartExercise4, mStartExercise5, mStartExercise6;
    private ScrollView mScrollView;

    //Intent Extras for setting exercise UI Views
    public static final String exerciseImageViewKey = "exercise_image";
    public static final String exerciseTextViewKey = "exercise_text";
    public static final String exerciseNumberKey = "exercise_number";
    public static final String exerciseCategoryKey = "exercise_category";
    public static final String exerciseTitleKey = "exercise_title";
    public static int menuCategory;


//    //Values, passed as extra for determing which menu to construct. Notes from main activity ***
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

        mScrollView = findViewById(R.id.ExerciseScrollView);

        mStartExercise1 = findViewById(R.id.ExerciseMenuE1_ImageView);
        mStartExercise2 = findViewById(R.id.ExerciseMenuE2_ImageView);
        mStartExercise3 = findViewById(R.id.ExerciseMenuE3_ImageView);
        mStartExercise4 = findViewById(R.id.ExerciseMenuE4_ImageView);
        mStartExercise5 = findViewById(R.id.ExerciseMenuE5_ImageView);
        mStartExercise6 = findViewById(R.id.ExerciseMenuE6_ImageView);

        //Using and ArrayList of objects here to set the image resource for each exercise button.
        ArrayList<ImageView> mExerciseImageArray = new ArrayList<>();
        mExerciseImageArray.add(mStartExercise1);
        mExerciseImageArray.add(mStartExercise2);
        mExerciseImageArray.add(mStartExercise3);
        mExerciseImageArray.add(mStartExercise4);
        mExerciseImageArray.add(mStartExercise5);
        mExerciseImageArray.add(mStartExercise6);


        Bundle extras = getIntent().getExtras();

        //Coming from the mainActivity.
        //Original intent that keeps track of which category the user is currently in.
        menuCategory = extras.getInt("menu_category");

        setMenuDrawables(menuCategory, mExerciseImageArray);
        createExerciseMenu(menuCategory);
        bottomNavButtonsListeners();


    }

    //Creates the actual exercises to be displayed to the user on the following screen.
    private void createExerciseMenu(int menuCategory) {

        if(menuCategory == Exercise.selfMenu) {

            Exercise mSelfExercise = new Exercise();

            checkForCompletedExercises(mSelfExercise.userSelfProgress,
                    mSelfExercise.getSelfKeys(), mSelfExercise.getSelfValues());

            onClickListeners(mSelfExercise.getSelfExerciseImages(), mSelfExercise.getSelfExerciseStrings());
        }

        if(menuCategory == Exercise.othersMenu) {

            Exercise mOthersExercise = new Exercise();

            checkForCompletedExercises(mOthersExercise.userOthersProgress,
                    mOthersExercise.getOthersKeys(), mOthersExercise.getOthersValues());

            onClickListeners(mOthersExercise.getOtherExerciseImages(), mOthersExercise.getOtherExerciseStrings());
        }

        if(menuCategory == Exercise.natureMenu) {

            Exercise mNatureExercise = new Exercise();

            checkForCompletedExercises(mNatureExercise.userNatureProgress,
                    mNatureExercise.getNatureKeys(), mNatureExercise.getNatureValues());

            onClickListeners(mNatureExercise.getNatureExerciseImages(), mNatureExercise.getNatureExerciseStrings());
        }

        if(menuCategory == Exercise.societyMenu) {
            Exercise mSocietyExercise = new Exercise();

            checkForCompletedExercises(mSocietyExercise.userSocietyProgress,
                    mSocietyExercise.getSocietyKeys(), mSocietyExercise.getSocietyValues());

            onClickListeners(mSocietyExercise.getSocietyExerciseImages(), mSocietyExercise.getSocietyExerciseStrings());

        }
    }

    //Sets the images for the exercises
    private void setMenuDrawables(int menuCategory, ArrayList<ImageView> exerciseImageArray) {
        //Create references for all views

        //Self Menu
        if(menuCategory == 1) {

            for (ImageView exercise: exerciseImageArray)
            {
                exercise.setImageResource(R.drawable.selfexercisemenuimage);
            }

            setTitle(R.string.self_menu_title);
            mScrollView.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
            changeActionBarColor(R.color.design_default_color_primary_dark);
            mHomeButtonBar.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary_dark));

        }

        //Others Menu
        if(menuCategory == 2) {

            for (ImageView exercise: exerciseImageArray)
            {
                exercise.setImageResource(R.drawable.othersexercisemenuimage);
            }

            setTitle(R.string.others_menu_title);
            mScrollView.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary_variant));
            changeActionBarColor(R.color.design_default_color_secondary_variant);
            mHomeButtonBar.setBackgroundColor(getResources().getColor(R.color.design_default_color_secondary_variant));
        }

        //Nature Menu
        if(menuCategory == 3) {

            for (ImageView exercise: exerciseImageArray)
            {
                exercise.setImageResource(R.drawable.natureexercisemenuimage);

            }

            setTitle(R.string.nature_menu_title);
            mScrollView.setBackgroundColor(getResources().getColor(R.color.nature_primary));
            changeActionBarColor(R.color.nature_primary_dark);
            mHomeButtonBar.setBackgroundColor(getResources().getColor(R.color.nature_primary_dark));

        }

        if(menuCategory == 4){
            for (ImageView exercise: exerciseImageArray)
            {
                exercise.setImageResource(R.drawable.societyexercisemenuimage);

            }

            setTitle(R.string.society_menu_title);
            mScrollView.setBackgroundColor(getResources().getColor(R.color.myBlack));
            changeActionBarColor(R.color.design_default_color_error);
            mHomeButtonBar.setBackgroundColor(getResources().getColor(R.color.design_default_color_error));
        }

        //Society Menu
    }

    private void checkForCompletedExercises(String exerciseCategory, String[] exerciseKeys, int[] exerciseValues) {

        //Sets color of stars for each exercise.
        SharedPreferences exerciseSharedPreferences = getApplicationContext().getSharedPreferences(exerciseCategory, MODE_PRIVATE);

        int[] exerciseStarImageViews = {R.id.ExerciseMenuE1Star_ImageView, R.id.ExerciseMenuE2Star_ImageView, R.id.ExerciseMenuE3Star_ImageView,
                R.id.ExerciseMenuE4Star_ImageView, R.id.ExerciseMenuE5Star_ImageView, R.id.ExerciseMenuE6Star_ImageView};

        int i = 0;
        while(i < exerciseKeys.length) {
            int lightUpStar = exerciseSharedPreferences.getInt(exerciseKeys[i], exerciseValues[i]);

            if (lightUpStar == 1) {
                ImageView mStar = findViewById(exerciseStarImageViews[i]);
                mStar.setImageResource(R.drawable.guistar);
            }

            i++;
        }

    }

    private void onClickListeners(final HashMap<String, Integer> exerciseImages, final HashMap<String,Integer> exerciseStrings) { //HashMap here?

        mStartExercise1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startExercise1 = new Intent(ExerciseMenuActivity.this, ExerciseActivity.class);
                startExercise1.putExtra(exerciseImageViewKey, exerciseImages.get(Exercise.exercise1ImageKey)); //This intent as a hashmap of exercise images as its value.
                startExercise1.putExtra(exerciseTextViewKey, exerciseStrings.get(Exercise.exercise1StringKey));
                startExercise1.putExtra(exerciseNumberKey,1); //Eventually passed to the QuestionActivity
                startExercise1.putExtra(exerciseCategoryKey, menuCategory);
                startActivity(startExercise1);

            }
        });

        mStartExercise2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startExercise2 = new Intent(ExerciseMenuActivity.this, ExerciseActivity.class);
                startExercise2.putExtra(exerciseImageViewKey, exerciseImages.get(Exercise.exercise2ImageKey));
                startExercise2.putExtra(exerciseTextViewKey, exerciseStrings.get(Exercise.exercise2StringKey));
                startExercise2.putExtra(exerciseNumberKey,2);
                startExercise2.putExtra(exerciseCategoryKey, menuCategory);
                startActivity(startExercise2);

            }
        });

        mStartExercise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startExercise3 = new Intent(ExerciseMenuActivity.this, ExerciseActivity.class);
                startExercise3.putExtra(exerciseImageViewKey, exerciseImages.get(Exercise.exercise3ImageKey));
                startExercise3.putExtra(exerciseTextViewKey, exerciseStrings.get(Exercise.exercise3StringKey));
                startExercise3.putExtra(exerciseNumberKey,3);
                startExercise3.putExtra(exerciseCategoryKey, menuCategory);
                startActivity(startExercise3);

            }
        });

        mStartExercise4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startExercise4 = new Intent(ExerciseMenuActivity.this, ExerciseActivity.class);
                startExercise4.putExtra(exerciseImageViewKey, exerciseImages.get(Exercise.exercise4ImageKey));
                startExercise4.putExtra(exerciseTextViewKey, exerciseStrings.get(Exercise.exercise4StringKey));
                startExercise4.putExtra(exerciseNumberKey,4);
                startExercise4.putExtra(exerciseCategoryKey, menuCategory);
                startActivity(startExercise4);

            }
        });

        mStartExercise5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startExercise5 = new Intent(ExerciseMenuActivity.this, ExerciseActivity.class);
                startExercise5.putExtra(exerciseImageViewKey, exerciseImages.get(Exercise.exercise5ImageKey));
                startExercise5.putExtra(exerciseTextViewKey, exerciseStrings.get(Exercise.exercise5StringKey));
                startExercise5.putExtra(exerciseNumberKey,5);
                startExercise5.putExtra(exerciseCategoryKey, menuCategory);
                startActivity(startExercise5);

            }
        });

        mStartExercise6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startExercise6 = new Intent(ExerciseMenuActivity.this, ExerciseActivity.class);
                startExercise6.putExtra(exerciseImageViewKey, exerciseImages.get(Exercise.exercise6ImageKey));
                startExercise6.putExtra(exerciseTextViewKey, exerciseStrings.get(Exercise.exercise6StringKey));
                startExercise6.putExtra(exerciseNumberKey,6);
                startExercise6.putExtra(exerciseCategoryKey, menuCategory);
                startActivity(startExercise6);

            }
        });

    }

    public void changeActionBarColor(int color) {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(color)));
    }

    private void bottomNavButtonsListeners() {
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
