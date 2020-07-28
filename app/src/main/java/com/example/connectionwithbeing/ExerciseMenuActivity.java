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

import java.util.HashMap;

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

    //HashMaps holding all drawable and String ids for exercises

    public static final HashMap<String, Integer> mNatureExerciseImages = new HashMap<>();

    static {
        mNatureExerciseImages.put("exercise1_image", R.drawable.bigtree);
        mNatureExerciseImages.put("exercise2_image", R.drawable.bookmark);
    }

    public static final HashMap<String, Integer> mNatureExerciseStrings = new HashMap<>();

    static {
        mNatureExerciseStrings.put("exercise1_text", R.string.exercise1_center_text_string);
        mNatureExerciseStrings.put("exercise2_text", R.string.exercise2_center_text_string);
        mNatureExerciseStrings.put("exercise3_text", R.string.app_name);
    }

    public static final HashMap<String, Integer> mOtherExerciseImages = new HashMap<>();

    static {
        mOtherExerciseImages.put("exercise1_image", R.drawable.cwblogotest);
        mOtherExerciseImages.put("exercise2_image", R.drawable.othershomepng);
    }

    public static final HashMap<String, Integer> mOtherExerciseStrings = new HashMap<>();

    static {
        mOtherExerciseStrings.put("exercise1_text", R.string.nature_e1_q3_text);
        mOtherExerciseStrings.put("exercise2_text", R.string.nature_e1_q1_text);
        mOtherExerciseStrings.put("exercise2_text", R.string.nature_e1_q3_text);
    }

    //Shared Preferences for the Exercise Menu. Controls yellow star on completion for each category.
    public static SharedPreferences mSharedPreferences;


    public static final String userNatureProgress = "nature_exercises_completed";

    //Keys
    public static final String natureE1 = "natureE1";
    public static final String natureE2 = "natureE2";
    public static final String natureE3 = "natureE3";
    public static final String natureE4 = "natureE4";
    public static final String natureE5 = "natureE5";
    public static final String natureE6 = "natureE6";

    //Values
    public static int natureE1Completed = 0;
    public static int natureE2Completed = 0;
    public static int natureE3Completed = 0;
    public static int natureE4Completed = 0;
    public static int natureE5Completed = 0;
    public static int natureE6Completed = 0;

    public static String[] natureKeys = {natureE1, natureE2, natureE3, natureE4, natureE5, natureE6};

    public static int[] natureValues = {natureE1Completed, natureE2Completed, natureE3Completed,
            natureE4Completed, natureE5Completed, natureE6Completed};


    public static final String userOthersProgress = "others_exercises_completed";

    public static final String othersE1 = "othersE1";
    public static final String othersE2 = "othersE2";
    public static final String othersE3 = "othersE3";
    public static final String othersE4 = "othersE4";
    public static final String othersE5 = "othersE5";
    public static final String othersE6 = "othersE6";

    public static int othersE1Completed = 0;
    public static int othersE2Completed = 0;
    public static int othersE3Completed = 0;
    public static int othersE4Completed = 0;
    public static int othersE5Completed = 0;
    public static int othersE6Completed = 0;

    public static final String[] othersKeys = {othersE1, othersE2, othersE3, othersE4, othersE5, othersE6};
    public static final int[] othersValues = {othersE1Completed, othersE2Completed,
            othersE3Completed, othersE4Completed, othersE5Completed, othersE6Completed};


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

        int menuCategory = extras.getInt("menu_category");

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

            checkForCompletedExercises(userOthersProgress,othersKeys, othersValues);
            onClickListeners(mOtherExerciseImages, mOtherExerciseStrings);
        }

        if(menuCategory == MainActivity.natureMenu) {

            checkForCompletedExercises(userNatureProgress, natureKeys, natureValues);
            onClickListeners(mNatureExerciseImages, mNatureExerciseStrings);
        }

        if(menuCategory == MainActivity.societyMenu) {

//            checkForCompletedExercises(null,null, null);
//            onClickListeners(null, null);
        }

        //I can never get these switch statements to work for some reason..
//        switch (menuCategory){
//            case 1:
//                //            checkForCompletedExercises(null,null, null);
////            onClickListeners(null, null);
//
//            case 2:
//                checkForCompletedExercises(userOthersProgress,othersKeys, othersValues);
//                onClickListeners(mOtherExerciseImages, mOtherExerciseStrings);
//
//            case 3:
//                checkForCompletedExercises(userNatureProgress, natureKeys, natureValues);
//                onClickListeners(mNatureExerciseImages, mNatureExerciseStrings);
//
//            case 4:
//                //            checkForCompletedExercises(null,null, null);
////            onClickListeners(null, null);
//
//        }

    }

    //Sets the images for the menu.
    private void setMenuDrawables(int menuCategory) {

    }



    private void checkForCompletedExercises(String exerciseCategory, String[] exerciseKeys, int[] exerciseValues) {

        mSharedPreferences = getApplicationContext().getSharedPreferences(exerciseCategory, MODE_PRIVATE); //Polymorph this

        //Order of these arrays is very important... must be maintained.
//        String[] natureKeys = {natureE1, natureE2, natureE3, natureE4, natureE5, natureE6};
//
//        int[] natureValues = {natureE1Completed, natureE2Completed, natureE3Completed,
//                natureE4Completed, natureE5Completed, natureE6Completed};

        int[] exerciseStarImageViews = {R.id.ExerciseMenuE1Star_ImageView, R.id.ExerciseMenuE2Star_ImageView, R.id.ExerciseMenuE3Star_ImageView,
                R.id.ExerciseMenuE4Star_ImageView, R.id.ExerciseMenuE5Star_ImageView, R.id.ExerciseMenuE6Star_ImageView};

        int i = 0;
        while(i < exerciseKeys.length) {
            int lightUpStar = mSharedPreferences.getInt(exerciseKeys[i], exerciseValues[i]);

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

            }
        });
    }

}
