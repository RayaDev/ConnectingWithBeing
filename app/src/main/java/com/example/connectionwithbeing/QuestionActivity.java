package com.example.connectionwithbeing;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import model.Exercise;
import model.Question;

//AEQ for short hand notation.
 /*
 Self = 1
 Others = 2
 Nature = 3
 Society = 4
*/

public class QuestionActivity extends AppCompatActivity {

    private ImageView mToDoButton, mHomeButton;
    private LinearLayout mCompletedQuestions;
    private TextView mQuestions1, mQuestions2, mQuestions3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        // Sets the AEQ action bar to have the same color as AE action bar.
//        Make sure the actionbar versions are the same.
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.nature_primary_dark)));

        Bundle extras = getIntent().getExtras();
        final int exerciseNumber = (int) extras.get(ExerciseMenuActivity.exerciseNumberKey);
        final int exerciseType = (int) extras.get(ExerciseMenuActivity.exerciseCategoryKey);

        mHomeButton = findViewById(R.id.questionHomeButton);
        mToDoButton = findViewById(R.id.questionToDoButton);
        mCompletedQuestions = findViewById(R.id.questionCompleteReflections_LinearLayout);

        mQuestions1 = findViewById(R.id.questionActivity_Q1);
        mQuestions2 = findViewById(R.id.questionActivity_Q2);
        mQuestions3 = findViewById(R.id.questionActivity_Q3);


        setQuestions(exerciseNumber, exerciseType);
        setOnClickListeners(exerciseNumber, exerciseType);
        bottomNavButtonsListeners();

    }


    private void setOnClickListeners(int i, int j) {

        final int exerciseNumber = i;
        final int exerciseType = j;

        mCompletedQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(QuestionActivity.this)
                        .setTitle("Finish Reflecting..")
                        .setMessage("Have you thought about all the questions?")

                        .setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                //Exercise type and number are passed through the whole app along intents.. Maybe there's a better way to do this?

                                Log.i("Type", exerciseType +"");

                                int playAnimation = setSharedPreferences(exerciseNumber, exerciseType); //Changes exercise star color on topic menu.

                                //Returns to the home screen and activates an animation on the stars.
                                Intent returnHome = new Intent(QuestionActivity.this, MainActivity.class);
                                returnHome.putExtra("play_animation", playAnimation);
                                returnHome.putExtra("exercise_category", exerciseType);
                                startActivity(returnHome);
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton("Take more time", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mCompletedQuestions.clearAnimation();
                            }
                        })
                        .setIcon(R.drawable.guistar)
                        .show();
            }
        });


       //Starts the blink animation on the mirror image after 5 seconds.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation blinkAnimation =
                        AnimationUtils.loadAnimation(getApplicationContext(),
                                R.anim.blink);

                mCompletedQuestions.startAnimation(blinkAnimation);

            }
        }, 3000);



    }


    //Saves and sets the exercise progress star color to yellow on the exercise menu. Returns an int to trigger the play animation.
    //Would prefer this to not have duplicated code for each category.
    public int setSharedPreferences(int exerciseNumber, int exerciseType) {

        //Self
        SharedPreferences mSharedPreferences = getApplicationContext().getSharedPreferences(Exercise.userActivityProgress, MODE_PRIVATE);
        SharedPreferences.Editor mSharedPreferencesEditor = mSharedPreferences.edit();

        if (exerciseType == 1) {

            int selfE1Completed = mSharedPreferences.getInt(Exercise.selfE1CompletedKey, 0);
            int selfE2Completed = mSharedPreferences.getInt(Exercise.selfE2CompletedKey, 0);
            int selfE3Completed = mSharedPreferences.getInt(Exercise.selfE3CompletedKey, 0);
            int selfE4Completed = mSharedPreferences.getInt(Exercise.selfE4CompletedKey, 0);
            int selfE5Completed = mSharedPreferences.getInt(Exercise.selfE5CompletedKey, 0);
            int selfE6Completed = mSharedPreferences.getInt(Exercise.selfE6CompletedKey, 0);

            switch (exerciseNumber) {

                case 1:

                    if(selfE1Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.selfProgress, 0);
                        completedExerciseTotal++;
//                        Exercise.selfCompletedInt = completedExerciseTotal;
                        mSharedPreferencesEditor.putInt(Exercise.selfProgress, completedExerciseTotal);

                        mSharedPreferencesEditor.putInt(Exercise.selfE1CompletedKey, 1);  //Saves progress of the exercise, and allows the star color to be set.

                        mSharedPreferencesEditor.commit();

                       return 1; //Returns 1 to trigger the animation on the Main Activity.
                    }

                    else {

                        //Otherwise exercise is already completed, return home with out an animation, and make no changes to data.
                        return 0;
                    }


                case 2:
                    if(selfE2Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.selfProgress, 0);
                        completedExerciseTotal++;
//                        Exercise.selfCompletedInt = completedExerciseTotal;
                        mSharedPreferencesEditor.putInt(Exercise.selfProgress, completedExerciseTotal);

                        mSharedPreferencesEditor.putInt(Exercise.selfE2CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {


                        return 0;
                    }

                case 3:

                    if(selfE3Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.selfProgress, 0);
                        completedExerciseTotal++;
//                        Exercise.selfCompletedInt = completedExerciseTotal;
                        mSharedPreferencesEditor.putInt(Exercise.selfProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.selfE3CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {

                        return 0;
                    }

                case 4:

                    if(selfE4Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.selfProgress, 0);
                        completedExerciseTotal++;
//                        Exercise.selfCompletedInt = completedExerciseTotal;
                        mSharedPreferencesEditor.putInt(Exercise.selfProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.selfE4CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {

                        return 0;
                    }

                case 5:

                    if(selfE5Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.selfProgress, 0);
                        completedExerciseTotal++;
//                        Exercise.selfCompletedInt = completedExerciseTotal;
                        mSharedPreferencesEditor.putInt(Exercise.selfProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.selfE5CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {

                        return 0;
                    }

                case 6:

                    if(selfE6Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.selfProgress, 0);
                        completedExerciseTotal++;
//                        Exercise.selfCompletedInt = completedExerciseTotal;
                        mSharedPreferencesEditor.putInt(Exercise.selfProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.selfE6CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {

                        return 0;
                    }
            }
        }

        //Others
        if (exerciseType == 2) {

            int othersE1Completed = mSharedPreferences.getInt(Exercise.othersE1CompletedKey, 0);
            int othersE2Completed = mSharedPreferences.getInt(Exercise.othersE2CompletedKey, 0);
            int othersE3Completed = mSharedPreferences.getInt(Exercise.othersE3CompletedKey, 0);
            int othersE4Completed = mSharedPreferences.getInt(Exercise.othersE4CompletedKey, 0);
            int othersE5Completed = mSharedPreferences.getInt(Exercise.othersE5CompletedKey, 0);
            int othersE6Completed = mSharedPreferences.getInt(Exercise.othersE6CompletedKey, 0);


            switch (exerciseNumber) {

                case 1:
                    if(othersE1Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.othersProgress, 0);
                        completedExerciseTotal++;

                        mSharedPreferencesEditor.putInt(Exercise.othersProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.othersE1CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {


                        return 0;
                    }

                case 2:
                    if(othersE2Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.othersProgress, 0);
                        completedExerciseTotal++;

                        mSharedPreferencesEditor.putInt(Exercise.othersProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.othersE2CompletedKey, 1);
                        mSharedPreferencesEditor.commit();
                        return 1;
                    }

                    else {


                        return 0;
                    }

                case 3:
                    if(othersE3Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.othersProgress, 0);
                        completedExerciseTotal++;

                        mSharedPreferencesEditor.putInt(Exercise.othersProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.othersE3CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {


                        return 0;
                    }

                case 4:
                    if(othersE4Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.othersProgress, 0);
                        completedExerciseTotal++;

                        mSharedPreferencesEditor.putInt(Exercise.othersProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.othersE4CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {


                        return 0;
                    }

                case 5:
                    if(othersE5Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.othersProgress, 0);
                        completedExerciseTotal++;

                        mSharedPreferencesEditor.putInt(Exercise.othersProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.othersE5CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {


                        return 0;
                    }

                case 6:
                    if(othersE6Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.othersProgress, 0);
                        completedExerciseTotal++;

                        mSharedPreferencesEditor.putInt(Exercise.othersProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.othersE6CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {


                        return 0;
                    }

            }
        }

        //Nature
        if(exerciseType == 3) {

            int natureE1Completed = mSharedPreferences.getInt(Exercise.natureE1CompletedKey, 0);
            int natureE2Completed = mSharedPreferences.getInt(Exercise.natureE2CompletedKey, 0);
            int natureE3Completed = mSharedPreferences.getInt(Exercise.natureE3CompletedKey, 0);
            int natureE4Completed = mSharedPreferences.getInt(Exercise.natureE4CompletedKey, 0);
            int natureE5Completed = mSharedPreferences.getInt(Exercise.natureE5CompletedKey, 0);
            int natureE6Completed = mSharedPreferences.getInt(Exercise.natureE6CompletedKey, 0);

            switch (exerciseNumber) {

                case 1:
                    if(natureE1Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.natureProgress, 0);
                        completedExerciseTotal++;

                        mSharedPreferencesEditor.putInt(Exercise.natureProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.natureE1CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {


                        return 0;
                    }

                case 2:
                    if(natureE2Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.natureProgress, 0);
                        completedExerciseTotal++;

                        mSharedPreferencesEditor.putInt(Exercise.natureProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.natureE2CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {


                        return 0;
                    }

                case 3:
                    if(natureE3Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.natureProgress, 0);
                        completedExerciseTotal++;

                        mSharedPreferencesEditor.putInt(Exercise.natureProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.natureE3CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {


                        return 0;
                    }

                case 4:
                    if(natureE4Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.natureProgress, 0);
                        completedExerciseTotal++;

                        mSharedPreferencesEditor.putInt(Exercise.natureProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.natureE4CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {


                        return 0;
                    }

                case 5:
                    if(natureE5Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.natureProgress, 0);
                        completedExerciseTotal++;

                        mSharedPreferencesEditor.putInt(Exercise.natureProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.natureE5CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {


                        return 0;
                    }

                case 6:
                    if(natureE6Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.natureProgress, 0);
                        completedExerciseTotal++;

                        mSharedPreferencesEditor.putInt(Exercise.natureProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.natureE6CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {


                        return 0;
                    }

            }
        }

        //Society
        if (exerciseType == 4) {

            int societyE1Completed = mSharedPreferences.getInt(Exercise.natureE1CompletedKey, 0);
            int societyE2Completed = mSharedPreferences.getInt(Exercise.natureE2CompletedKey, 0);
            int societyE3Completed = mSharedPreferences.getInt(Exercise.natureE3CompletedKey, 0);
            int societyE4Completed = mSharedPreferences.getInt(Exercise.natureE4CompletedKey, 0);
            int societyE5Completed = mSharedPreferences.getInt(Exercise.natureE5CompletedKey, 0);
            int societyE6Completed = mSharedPreferences.getInt(Exercise.natureE6CompletedKey, 0);

            switch (exerciseNumber) {

                case 1:
                    if(societyE1Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.societyProgress, 0);
                        completedExerciseTotal++;

                        mSharedPreferencesEditor.putInt(Exercise.societyProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.societyE1CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {


                        return 0;
                    }

                case 2:
                    if(societyE2Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.societyProgress, 0);
                        completedExerciseTotal++;

                        mSharedPreferencesEditor.putInt(Exercise.societyProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.societyE1CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {


                        return 0;
                    }

                case 3:
                    if(societyE3Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.societyProgress, 0);
                        completedExerciseTotal++;

                        mSharedPreferencesEditor.putInt(Exercise.societyProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.societyE3CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {


                        return 0;
                    }

                case 4:
                    if(societyE4Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.societyProgress, 0);
                        completedExerciseTotal++;

                        mSharedPreferencesEditor.putInt(Exercise.societyProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.societyE4CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {


                        return 0;
                    }

                case 5:
                    if(societyE5Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.societyProgress, 0);
                        completedExerciseTotal++;

                        mSharedPreferencesEditor.putInt(Exercise.societyProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.societyE5CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {


                        return 0;
                    }


                case 6:
                    if(societyE6Completed == 0) {
                        int completedExerciseTotal = mSharedPreferences.getInt(Exercise.societyProgress, 0);
                        completedExerciseTotal++;

                        mSharedPreferencesEditor.putInt(Exercise.societyProgress, completedExerciseTotal);


                        mSharedPreferencesEditor.putInt(Exercise.societyE6CompletedKey, 1);
                        mSharedPreferencesEditor.commit();

                        return 1;
                    }

                    else {


                        return 0;
                    }

            }
        }
        return 0; //Default return for method.
    }

    //Set questions based on exercise category.
    private void setQuestions(int exerciseNumber, int exerciseType) {
        //For example type = nature (3), and number = 4, so it would be the natureE4 exercise question set.
        //Algorithm here?

        switch (exerciseType) {
            case 1:
                setSelfQuestions(exerciseNumber);
                break;

            case 2:
                setOthersQuestion(exerciseNumber);
                break;

            case 3:
                setNatureQuestions(exerciseNumber);
                break;

            case 4:
                setSocietyQuestions(exerciseNumber);
        }


    }

    private void setSelfQuestions(int exerciseNumber) {

        int[] questions;
        switch (exerciseNumber) {
            case 1:

                questions = Question.selfE1Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);

                break;

            case 2:

                questions = Question.selfE2Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);
                break;

            case 3:

                questions = Question.selfE3Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);
                break;

            case 4:

                questions = Question.selfE4Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);
                break;

            case 5:

                questions = Question.selfE5Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);
                break;

            case 6:

                questions = Question.selfE6Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);
                break;
        }

    }

    private void setOthersQuestion(int exerciseNumber) {

        int[] questions;
        switch (exerciseNumber) {
            case 1:

                questions = Question.othersE1Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);

                break;

            case 2:

                questions = Question.othersE2Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);
                break;

            case 3:

                questions = Question.othersE3Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);
                break;

            case 4:

                questions = Question.othersE4Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);
                break;

            case 5:

                questions = Question.othersE5Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);
                break;

            case 6:

                questions = Question.othersE6Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);
                break;
        }

    }

    private void setNatureQuestions(int exerciseNumber) {

        int[] questions;
        switch (exerciseNumber) {
            case 1:

                questions = Question.natureE1Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);

                break;

            case 2:

                questions = Question.natureE2Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);

                break;

            case 3:

                questions = Question.natureE3Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);
                break;

            case 4:

                questions = Question.natureE4Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);
                break;

            case 5:

                questions = Question.natureE5Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);
                break;

            case 6:

                questions = Question.natureE6Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);
                break;
        }

    }

    private void setSocietyQuestions(int exerciseNumber) {

        int[] questions;
        switch (exerciseNumber) {
            case 1:

                questions = Question.societyE1Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);

                break;

            case 2:

                questions = Question.societyE2Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);

                break;

            case 3:

                questions = Question.societyE3Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);

                break;

            case 4:

                questions = Question.societyE4Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);

                break;

            case 5:

                questions = Question.societyE5Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);

                break;

            case 6:

                questions = Question.societyE6Questions;
                mQuestions1.setText(questions[0]);
                mQuestions2.setText(questions[1]);
                mQuestions3.setText(questions[2]);

                break;
        }

    }

    private void bottomNavButtonsListeners() {
        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent returnHome = new Intent(QuestionActivity.this, MainActivity.class);
                startActivity(returnHome);

            }
        });

        mToDoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuestionActivity.this, "To Do Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //When back button on actionbar is pressed, returns to the previous activity which has not been destroyed.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(getApplicationContext(),"Back button clicked", Toast.LENGTH_SHORT).show();
                super.onBackPressed(); //This replicates the hard back button on the phone. Could just replace this with an Intent
                break;
        }
        return true;
    }
}
