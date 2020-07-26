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

    public static HashMap<String, Integer> mExerciseImages = new HashMap<>();

    static {
        mExerciseImages.put("nature_exercise1_image", R.drawable.bigtree);
        mExerciseImages.put("nature_exercise2_image", R.drawable.bookmark);
    }

    public static HashMap<String, Integer> mExerciseStrings = new HashMap<>();

    static {
        mExerciseStrings.put("nature_exercise1_text", R.string.exercise1_center_text_string);
        mExerciseStrings.put("nature_exercise2_text", R.string.exercise2_center_text_string);
        mExerciseStrings.put("nature_exercise3_text", R.string.app_name);
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

        createExerciseMenu(menuCategory);

//        checkForNatureCompletedExercises();
//        mOnClickListeners();

    }


    private void createExerciseMenu(int menuCategory) {

        if(menuCategory == MainActivity.selfMenu) {
            createSelfMenu();
            checkForCompletedExercises(null, null);
            selfOnClickListeners();
        }

        if(menuCategory == MainActivity.othersMenu) {
            createOthersMenu();
            checkForCompletedExercises(null, null);
            othersOnClickListeners();
        }

        if(menuCategory == MainActivity.natureMenu) {
            createNatureMenu();
            checkForCompletedExercises(natureKeys, natureValues);
            natureOnClickListeners(mExerciseImages, mExerciseStrings);
        }

        if(menuCategory == MainActivity.societyMenu) {
            createSocietyMenu();
            checkForCompletedExercises(null, null);
            societyOnClickListeners();
        }

    }

    private void createSelfMenu() {

    }

    private void createOthersMenu() {

    }

    private void createSocietyMenu() {

    }

    private void createNatureMenu() {

    }



    private void checkForCompletedExercises(String[] exerciseKeys, int[] exerciseValues) {

        mSharedPreferences = getApplicationContext().getSharedPreferences(userNatureProgress, MODE_PRIVATE);

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

    private void selfOnClickListeners () {

    }

    private void othersOnClickListeners() {

    }

    private void natureOnClickListeners(final HashMap<String, Integer> exerciseImages, final HashMap<String,Integer> exerciseStrings) { //HashMap here?

        mStartExercise1 = findViewById(R.id.ExerciseMenuE1_ImageView);
        mStartExercise2 = findViewById(R.id.ExerciseMenuE2_ImageView);

        mStartExercise1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startExercise1 = new Intent(ExerciseMenuActivity.this, ExerciseActivity.class);
                startExercise1.putExtra(exerciseImageView, exerciseImages.get("nature_exercise1_image"));
                startExercise1.putExtra(exerciseTextView, exerciseStrings.get("nature_exercise1_text"));
                startExercise1.putExtra(exerciseNumber,1);
                startActivity(startExercise1);
            }
        });

        mStartExercise2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startExercise2 = new Intent(ExerciseMenuActivity.this, ExerciseActivity.class);
                startExercise2.putExtra(exerciseImageView, exerciseImages.get("nature_exercise2_image"));
                startExercise2.putExtra(exerciseTextView, exerciseStrings.get("nature_exercise2_text"));
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

    private void societyOnClickListeners() {

    }


}
