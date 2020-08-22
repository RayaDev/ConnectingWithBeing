package com.example.connectionwithbeing;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
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
//        mToDoButton = findViewById(R.id.ExerciseToDoButton_Menu);

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

            checkForCompletedExercises(Exercise.selfKeys, menuCategory);

            setOnClickListeners(Exercise.selfExerciseImages, Exercise.selfExerciseStrings);
        }

        if(menuCategory == Exercise.othersMenu) {

            checkForCompletedExercises(Exercise.othersKeys, menuCategory);

            setOnClickListeners(Exercise.otherExerciseImages, Exercise.otherExerciseStrings);
        }

        if(menuCategory == Exercise.natureMenu) {


            checkForCompletedExercises(Exercise.natureKeys, menuCategory);

            setOnClickListeners(Exercise.natureExerciseImages, Exercise.natureExerciseStrings);
        }

        if(menuCategory == Exercise.societyMenu) {


            checkForCompletedExercises(Exercise.societyKeys, menuCategory);

            setOnClickListeners(Exercise.societyExerciseImages, Exercise.societyExerciseStrings);

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
            mScrollView.setBackgroundColor(getResources().getColor(R.color.self_primary));
            changeActionBarColor(R.color.self_primary_dark);
            mHomeButtonBar.setBackgroundColor(getResources().getColor(R.color.self_primary_dark));

        }

        //Others Menu
        if(menuCategory == 2) {

            for (ImageView exercise: exerciseImageArray)
            {
                exercise.setImageResource(R.drawable.othersexercisemenuimage);
            }

            setTitle(R.string.others_menu_title);
            mScrollView.setBackgroundColor(getResources().getColor(R.color.others_primary));
            changeActionBarColor(R.color.others_primary_dark);
            mHomeButtonBar.setBackgroundColor(getResources().getColor(R.color.others_primary_dark));
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

        //Society Menu
        if(menuCategory == 4){
            for (ImageView exercise: exerciseImageArray)
            {
                exercise.setImageResource(R.drawable.societyexercisemenuimage);

            }

            setTitle(R.string.society_menu_title);
            mScrollView.setBackgroundColor(getResources().getColor(R.color.society_primary));
            changeActionBarColor(R.color.society_primary_dark);
            mHomeButtonBar.setBackgroundColor(getResources().getColor(R.color.society_primary_dark));
        }

        //Society Menu
    }

    private void checkForCompletedExercises(String[] exerciseKeys, int menuCategory) {

        //Sets color of stars for each exercise.
        SharedPreferences exerciseSharedPreferences = getApplicationContext().getSharedPreferences(Exercise.userActivityProgress, MODE_PRIVATE);

        int[] exerciseStarImageViews = {R.id.ExerciseMenuE1Star_ImageView, R.id.ExerciseMenuE2Star_ImageView, R.id.ExerciseMenuE3Star_ImageView,
                R.id.ExerciseMenuE4Star_ImageView, R.id.ExerciseMenuE5Star_ImageView, R.id.ExerciseMenuE6Star_ImageView};

        int i = 0;
//        int completedCount = 0;
        while(i < exerciseKeys.length) {
            int lightUpStar = exerciseSharedPreferences.getInt(exerciseKeys[i], 0);


            if (lightUpStar == 1) {
                ImageView mStar = findViewById(exerciseStarImageViews[i]);
                mStar.setImageResource(R.drawable.guistar);
//                completedCount++;
            }

            i++;
        }

//        SharedPreferences mSharedPreferences = getApplicationContext().getSharedPreferences(Exercise.userActivityProgress, MODE_PRIVATE);
//        SharedPreferences.Editor mSharedPreferencesEditor = mSharedPreferences.edit();
//
//        switch (menuCategory) {
//            case 1:
//               mSharedPreferencesEditor.putInt(Exercise.selfProgress, completedCount);
//               mSharedPreferencesEditor.commit();
//               break;
//
//            case 2:
//                mSharedPreferencesEditor.putInt(Exercise.othersProgress, completedCount);
//                mSharedPreferencesEditor.commit();
//                break;
//
//            case 3:
//                mSharedPreferencesEditor.putInt(Exercise.natureProgress, completedCount);
//                mSharedPreferencesEditor.commit();
//                break;
//
//            case 4:
//                mSharedPreferencesEditor.putInt(Exercise.societyProgress, completedCount);
//                mSharedPreferencesEditor.commit();
//                break;
//
//        }

    }

    private void setOnClickListeners(final HashMap<String, Integer> exerciseImages, final HashMap<String,Integer> exerciseStrings) { //HashMap here?

        mStartExercise1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle exerciseExtras = new Bundle();
                exerciseExtras.putInt(exerciseImageViewKey, exerciseImages.get(Exercise.exercise1ImageKey));
                exerciseExtras.putInt(exerciseTextViewKey, exerciseStrings.get(Exercise.exercise1StringKey));
                exerciseExtras.putInt(exerciseNumberKey,1);
                exerciseExtras.putInt(exerciseCategoryKey, menuCategory);

                Intent startExercise1 = new Intent(ExerciseMenuActivity.this, QuoteActivity.class);
                startExercise1.putExtras(exerciseExtras);
                startActivity(startExercise1);

            }
        });

        mStartExercise1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClickTest();
//                Toast.makeText(ExerciseMenuActivity.this, "Long clicked exercise 1", Toast.LENGTH_SHORT).show();
                return true;

            }
        });

        mStartExercise2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle exerciseExtras = new Bundle();
                exerciseExtras.putInt(exerciseImageViewKey, exerciseImages.get(Exercise.exercise2ImageKey));
                exerciseExtras.putInt(exerciseTextViewKey, exerciseStrings.get(Exercise.exercise2StringKey));
                exerciseExtras.putInt(exerciseNumberKey,2);
                exerciseExtras.putInt(exerciseCategoryKey, menuCategory);

                Intent startExercise2 = new Intent(ExerciseMenuActivity.this, QuoteActivity.class);
                startExercise2.putExtras(exerciseExtras);
                startActivity(startExercise2);

            }
        });

        mStartExercise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle exerciseExtras = new Bundle();
                exerciseExtras.putInt(exerciseImageViewKey, exerciseImages.get(Exercise.exercise3ImageKey));
                exerciseExtras.putInt(exerciseTextViewKey, exerciseStrings.get(Exercise.exercise3StringKey));
                exerciseExtras.putInt(exerciseNumberKey,3);
                exerciseExtras.putInt(exerciseCategoryKey, menuCategory);

                Intent startExercise3 = new Intent(ExerciseMenuActivity.this, QuoteActivity.class);
                startExercise3.putExtras(exerciseExtras);
                startActivity(startExercise3);

            }
        });

        mStartExercise4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle exerciseExtras = new Bundle();
                exerciseExtras.putInt(exerciseImageViewKey, exerciseImages.get(Exercise.exercise4ImageKey));
                exerciseExtras.putInt(exerciseTextViewKey, exerciseStrings.get(Exercise.exercise4StringKey));
                exerciseExtras.putInt(exerciseNumberKey,4);
                exerciseExtras.putInt(exerciseCategoryKey, menuCategory);

                Intent startExercise4 = new Intent(ExerciseMenuActivity.this, QuoteActivity.class);
                startExercise4.putExtras(exerciseExtras);
                startActivity(startExercise4);

            }
        });

        mStartExercise5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle exerciseExtras = new Bundle();
                exerciseExtras.putInt(exerciseImageViewKey, exerciseImages.get(Exercise.exercise5ImageKey));
                exerciseExtras.putInt(exerciseTextViewKey, exerciseStrings.get(Exercise.exercise5StringKey));
                exerciseExtras.putInt(exerciseNumberKey,5);
                exerciseExtras.putInt(exerciseCategoryKey, menuCategory);

                Intent startExercise5 = new Intent(ExerciseMenuActivity.this, QuoteActivity.class);
                startExercise5.putExtras(exerciseExtras);
                startActivity(startExercise5);

            }
        });

        mStartExercise6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle exerciseExtras = new Bundle();
                exerciseExtras.putInt(exerciseImageViewKey, exerciseImages.get(Exercise.exercise6ImageKey));
                exerciseExtras.putInt(exerciseTextViewKey, exerciseStrings.get(Exercise.exercise6StringKey));
                exerciseExtras.putInt(exerciseNumberKey,6);
                exerciseExtras.putInt(exerciseCategoryKey, menuCategory);

                Intent startExercise6 = new Intent(ExerciseMenuActivity.this, QuoteActivity.class);
                startExercise6.putExtras(exerciseExtras);
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

    }

    private void longClickTest() {
        final SharedPreferences mSharedPreferences = getApplicationContext().getSharedPreferences(Exercise.userActivityProgress, MODE_PRIVATE);
        final SharedPreferences.Editor mSharedPreferencesEditor = mSharedPreferences.edit();

        AlertDialog.Builder builder = new AlertDialog.Builder(ExerciseMenuActivity.this);
        builder.setTitle("Reset this exercise.");
        builder.setMessage("Do you want to reset your progress star for the exercise?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        int exerciseCategory = menuCategory;
                        int exerciseNumber = 1;

                        switch (exerciseCategory) {
                            //Self
                            case 1:
                                switch (exerciseNumber) {
                                    case 1:
                                        int completed = mSharedPreferences.getInt(Exercise.selfE1CompletedKey,0);

                                        if(completed == 1) {
                                            mSharedPreferencesEditor.putInt(Exercise.selfE1CompletedKey, 0);
                                            int stars = mSharedPreferences.getInt(Exercise.selfProgress, 0);
                                            mSharedPreferencesEditor.putInt(Exercise.selfProgress, stars - 1);
                                            mSharedPreferencesEditor.commit();
                                            ImageView mStar = findViewById(R.id.ExerciseMenuE1Star_ImageView);
                                            mStar.setImageResource(R.drawable.guigreystar);
                                        }
                                        else {
                                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                                        }
                                }

                        }

                    }
                });
            }
        });
        builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });
        builder.setIcon(R.drawable.guistar);
        builder.show();// A null listener allows the button to dismiss the dialog and take no further action.


    }
}
