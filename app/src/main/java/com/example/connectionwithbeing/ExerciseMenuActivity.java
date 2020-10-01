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

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

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
    private LinearLayout mStartExercise1, mStartExercise2, mStartExercise3, mStartExercise4, mStartExercise5,
            mStartExercise6, mStartExercise7, mStartExercise8;
    private ImageView mStartExercise1Image, mStartExercise2Image, mStartExercise3Image,
            mStartExercise4Image, mStartExercise5Image, mStartExercise6Image;
    private ScrollView mScrollView;

    //Intent Extras for setting exercise UI Views
    public static final String exerciseImageViewKey = "exercise_image";
    public static final String exerciseTextViewKey = "exercise_text";
    public static final String exerciseNumberKey = "exercise_number";
    public static final String exerciseCategoryKey = "exercise_category";
    public static final String exerciseTitleKey = "exercise_title";
    public static int menuCategory;

    private InterstitialAd mInterstitialAd;


//    //Values, passed as extra for determing which menu to construct. Notes from main activity ***
//    private static final int selfMenu = 1;
//    private static final int othersMenu = 2;
//    private static final int natureMenu = 3;
//    private static final int societyMenu = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_menu);

        loadTheAds();

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.nature_primary_dark)));


        mHomeButtonBar = findViewById(R.id.ExerciseBottomActionBar_Menu);
        mHomeButton = findViewById(R.id.ExerciseHomeButton_Menu);
//        mToDoButton = findViewById(R.id.ExerciseToDoButton_Menu);

        mScrollView = findViewById(R.id.ExerciseScrollView);

        mStartExercise1 = findViewById(R.id.ExerciseMenuE1_LinearLayout);
        mStartExercise2 = findViewById(R.id.ExerciseMenuE2_LinearLayout);
        mStartExercise3 = findViewById(R.id.ExerciseMenuE3_LinearLayout);
        mStartExercise4 = findViewById(R.id.ExerciseMenuE4_LinearLayout);
        mStartExercise5 = findViewById(R.id.ExerciseMenuE5_LinearLayout);
        mStartExercise6 = findViewById(R.id.ExerciseMenuE6_LinearLayout);
        mStartExercise7 = findViewById(R.id.ExerciseMenuE7_LinearLayout);
        mStartExercise8 = findViewById(R.id.ExerciseMenuE8_LinearLayout);

        mStartExercise1Image = findViewById(R.id.ExerciseMenuE1_ImageView);
        mStartExercise2Image = findViewById(R.id.ExerciseMenuE2_ImageView);
        mStartExercise3Image = findViewById(R.id.ExerciseMenuE3_ImageView);
        mStartExercise4Image = findViewById(R.id.ExerciseMenuE4_ImageView);
        mStartExercise5Image = findViewById(R.id.ExerciseMenuE5_ImageView);
        mStartExercise6Image = findViewById(R.id.ExerciseMenuE6_ImageView);

        //Using and ArrayList of objects here to set the image resource for each exercise button.
        ArrayList<ImageView> mExerciseImageArray = new ArrayList<>();
        mExerciseImageArray.add(mStartExercise1Image);
        mExerciseImageArray.add(mStartExercise2Image);
        mExerciseImageArray.add(mStartExercise3Image);
        mExerciseImageArray.add(mStartExercise4Image);
        mExerciseImageArray.add(mStartExercise5Image);
        mExerciseImageArray.add(mStartExercise6Image);


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

            checkForCompletedExercises(Exercise.selfKeys);

            setOnClickListeners(Exercise.selfExerciseImages, Exercise.selfExerciseStrings);
        }

        if(menuCategory == Exercise.othersMenu) {

            checkForCompletedExercises(Exercise.othersKeys);

            setOnClickListeners(Exercise.otherExerciseImages, Exercise.otherExerciseStrings);
        }

        if(menuCategory == Exercise.natureMenu) {


            checkForCompletedExercises(Exercise.natureKeys);

            setOnClickListeners(Exercise.natureExerciseImages, Exercise.natureExerciseStrings);
        }

        if(menuCategory == Exercise.societyMenu) {


            checkForCompletedExercises(Exercise.societyKeys);

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

    private void checkForCompletedExercises(String[] exerciseKeys) {

        //Sets color of stars for each exercise.
        SharedPreferences exerciseSharedPreferences = getApplicationContext().getSharedPreferences(Exercise.userActivityProgress, MODE_PRIVATE);

        int[] exerciseStarImageViews = {R.id.ExerciseMenuE1Star_ImageView, R.id.ExerciseMenuE2Star_ImageView, R.id.ExerciseMenuE3Star_ImageView,
                R.id.ExerciseMenuE4Star_ImageView, R.id.ExerciseMenuE5Star_ImageView, R.id.ExerciseMenuE6Star_ImageView};

        int i = 0;
        while(i < exerciseKeys.length) {
            int lightUpStar = exerciseSharedPreferences.getInt(exerciseKeys[i], 0);

            if (lightUpStar == 1) {
                ImageView mStar = findViewById(exerciseStarImageViews[i]);
                mStar.setImageResource(R.drawable.guistar);
            }

            i++;
        }

    }

    private void setOnClickListeners(final HashMap<String, Integer> exerciseImages, final HashMap<String,Integer> exerciseStrings) {

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

                startInterstitialAd(startExercise1);

//                startActivity(startExercise1);

            }
        });

        mStartExercise1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startUndoStarsDialog(menuCategory, 1);
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

                startInterstitialAd(startExercise2);
//                startActivity(startExercise2);

            }
        });

        mStartExercise2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startUndoStarsDialog(menuCategory, 2);
                return true;

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

                startInterstitialAd(startExercise3);
//                startActivity(startExercise3);

            }
        });

        mStartExercise3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startUndoStarsDialog(menuCategory, 3);
                return true;

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

                startInterstitialAd(startExercise4);
//                startActivity(startExercise4);

            }
        });

        mStartExercise4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startUndoStarsDialog(menuCategory, 4);
                return true;

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

                startInterstitialAd(startExercise5);
//                startActivity(startExercise5);

            }
        });

        mStartExercise5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startUndoStarsDialog(menuCategory, 5);
                return true;

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

                startInterstitialAd(startExercise6);

//                startActivity(startExercise6);

            }
        });

        mStartExercise6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startUndoStarsDialog(menuCategory, 6);
//                Toast.makeText(ExerciseMenuActivity.this, "Long clicked exercise 1", Toast.LENGTH_SHORT).show();
                return true;

            }
        });

        mStartExercise7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ExerciseMenuActivity.this, "Work In Progress! \nMore Exercises To Come!",Toast.LENGTH_LONG).show();
            }
        });

        mStartExercise8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ExerciseMenuActivity.this, "Work In Progress! \nMore Exercises To Come!",Toast.LENGTH_LONG).show();
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

    private void startUndoStarsDialog(final int menuCategory, final int exerciseNumber) {

        AlertDialog.Builder builder = new AlertDialog.Builder(ExerciseMenuActivity.this);
        builder.setTitle("Reset this exercise.");
        builder.setMessage("Do you want to reset your progress star for the exercise?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                new Handler().post(new Runnable() {
                    @Override
                    public void run() {

                        undoStars(menuCategory, exerciseNumber);

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

    private void undoStars(int exerciseCategory, int exerciseNumber) {

        final SharedPreferences mSharedPreferences = getApplicationContext().getSharedPreferences(Exercise.userActivityProgress, MODE_PRIVATE);
        final SharedPreferences.Editor mSharedPreferencesEditor = mSharedPreferences.edit();

        switch (exerciseCategory) {
            //Self
            case 1:
                switch (exerciseNumber) {
                    case 1:
                        int completed = mSharedPreferences.getInt(Exercise.selfE1CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.selfE1CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE1Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 2:
                        completed = mSharedPreferences.getInt(Exercise.selfE2CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.selfE2CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE2Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 3:
                        completed = mSharedPreferences.getInt(Exercise.selfE3CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.selfE3CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE3Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 4:
                        completed = mSharedPreferences.getInt(Exercise.selfE4CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.selfE4CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE4Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 5:
                        completed = mSharedPreferences.getInt(Exercise.selfE5CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.selfE5CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE5Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 6:
                        completed = mSharedPreferences.getInt(Exercise.selfE6CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.selfE6CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE6Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;
                }
                break;

            //Others
            case 2:
                switch (exerciseNumber) {
                    case 1:
                        int completed = mSharedPreferences.getInt(Exercise.othersE1CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.othersE1CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE1Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 2:
                        completed = mSharedPreferences.getInt(Exercise.othersE2CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.othersE2CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE2Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 3:
                        completed = mSharedPreferences.getInt(Exercise.othersE3CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.othersE3CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE3Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 4:
                        completed = mSharedPreferences.getInt(Exercise.othersE4CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.othersE4CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE4Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 5:
                        completed = mSharedPreferences.getInt(Exercise.othersE5CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.othersE5CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE5Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 6:
                        completed = mSharedPreferences.getInt(Exercise.othersE6CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.othersE6CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE6Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;
                }
                break;

            //Nature
            case 3:
                switch (exerciseNumber) {
                    case 1:
                        int completed = mSharedPreferences.getInt(Exercise.natureE1CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.natureE1CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE1Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 2:
                        completed = mSharedPreferences.getInt(Exercise.natureE2CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.natureE2CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE2Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 3:
                        completed = mSharedPreferences.getInt(Exercise.natureE3CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.natureE3CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE3Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 4:
                        completed = mSharedPreferences.getInt(Exercise.natureE4CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.natureE4CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE4Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 5:
                        completed = mSharedPreferences.getInt(Exercise.natureE5CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.natureE5CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE5Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 6:
                        completed = mSharedPreferences.getInt(Exercise.natureE6CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.natureE6CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE6Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;
                }
                break;

            //Society
            case 4:
                switch (exerciseNumber) {
                    case 1:
                        int completed = mSharedPreferences.getInt(Exercise.societyE1CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.societyE1CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE1Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 2:
                        completed = mSharedPreferences.getInt(Exercise.societyE2CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.societyE2CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE2Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 3:
                        completed = mSharedPreferences.getInt(Exercise.societyE3CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.societyE3CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE3Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 4:
                        completed = mSharedPreferences.getInt(Exercise.societyE4CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.societyE4CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE4Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 5:
                        completed = mSharedPreferences.getInt(Exercise.societyE5CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.societyE5CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE5Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;

                    case 6:
                        completed = mSharedPreferences.getInt(Exercise.societyE6CompletedKey,0);

                        if(completed == 1) {
                            mSharedPreferencesEditor.putInt(Exercise.societyE6CompletedKey, 0);
                            mSharedPreferencesEditor.commit();

                            ImageView mStar = findViewById(R.id.ExerciseMenuE6Star_ImageView);
                            mStar.setImageResource(R.drawable.guigreystar);
                            Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ExerciseMenuActivity.this, "Cannot reset an uncompleted exercise", Toast.LENGTH_SHORT).show();

                        }
                        break;
                }
                break;

        }

//        Toast.makeText(ExerciseMenuActivity.this, "Exercise Reset", Toast.LENGTH_SHORT).show();
    }

    private void loadTheAds() {
        mInterstitialAd = new InterstitialAd(ExerciseMenuActivity.this);
//        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712"); //Test Ad
        mInterstitialAd.setAdUnitId("ca-app-pub-8727538144612368/8398234778"); //Live Exercise Ad
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    private void startInterstitialAd(final Intent exerciseIntent) {
        if (mInterstitialAd.isLoaded()) {

            mInterstitialAd.show();
            mInterstitialAd.setAdListener(new AdListener() {

                @Override
                public void onAdClosed() {
                    // Step 2.1: Load another ad

//                    mInterstitialAd = new InterstitialAd(ExerciseMenuActivity.this);
//                    mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
//                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    loadTheAds();

                    // Step 2.2: Start the new activity
                    startActivity(exerciseIntent);

                }
            });
        }
        else {
            startActivity(exerciseIntent);
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }

    }
}
