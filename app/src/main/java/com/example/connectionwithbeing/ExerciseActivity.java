package com.example.connectionwithbeing;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.prush.typedtextview.TypedTextView;

public class ExerciseActivity extends AppCompatActivity {

    private ImageView mStartQuestions;
    private ImageView mHomeButton, mExerciseImage, mToDoButton;
    private TypedTextView mTypedTextView;
    private TextView mPlaceHolderTextView;
    private TextView mQuoteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        //Set Actionbar color
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.nature_primary_dark)));

        //Get Intents all coming from the menu activity.
        Bundle extras = getIntent().getExtras();
        int exerciseImage = (int) extras.get(ExerciseMenuActivity.exerciseImageViewKey);
        int exerciseText = (int) extras.get(ExerciseMenuActivity.exerciseTextViewKey);
        int exerciseNumber = (int) extras.get(ExerciseMenuActivity.exerciseNumberKey);
        int exerciseType = (int) extras.get(ExerciseMenuActivity.exerciseCategoryKey);

        //Declare Views, and Set resources from extras.
        mQuoteTextView = findViewById(R.id.ExerciseActivityQuote_TextView);
        mQuoteTextView.setText(R.string.society_e6_quote);
        mExerciseImage = findViewById(R.id.ExerciseActivity_ImageView);
        mExerciseImage.setImageResource(exerciseImage);

        mTypedTextView = findViewById(R.id.ExerciseActivity_TypedTextView);
        mTypedTextView.setTypedText(exerciseText);

        mPlaceHolderTextView = findViewById(R.id.ExerciseActivity_TextView);
        mPlaceHolderTextView.setText(exerciseText);

        //Reflections Button
        mStartQuestions = findViewById(R.id.ExerciseStartQuestions_ImageView);
        mHomeButton = findViewById(R.id.ExerciseActivityHomeButton);
        mToDoButton = findViewById(R.id.ExerciseActivityToDoButton);

        onClickListeners(exerciseText, exerciseNumber, exerciseType);

    }

    private void onClickListeners(int exerciseText, final int exerciseNumber, final int exerciseType) {
        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent returnHome = new Intent(ExerciseActivity.this, MainActivity.class);
                startActivity(returnHome);

            }
        });

        mToDoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ExerciseActivity.this, "To Do Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        mStartQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(ExerciseActivity.this)
                        .setTitle("Continue to reflections..")
                        .setMessage("Have you completed the exercise?")

                        .setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                //Need intents here with extras for the questions!
                                Intent startQuestions = new Intent(ExerciseActivity.this, QuestionActivity.class);
                                startQuestions.putExtra(ExerciseMenuActivity.exerciseNumberKey, exerciseNumber);
                                startQuestions.putExtra(ExerciseMenuActivity.exerciseCategoryKey, exerciseType);
                                startActivity(startQuestions);
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton("Take more time", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mStartQuestions.clearAnimation();

                            }
                        })
                        .setIcon(R.drawable.star)
                        .show();

            }
        });

        String mExerciseString = getString(exerciseText);
        final int mIndex = mExerciseString.length() -1;

        mTypedTextView.bringToFront(); //Needed for formatting the typed text. Otherwise gets lost in the background text.

        mTypedTextView.setOnCharacterTypedListener(new TypedTextView.OnCharacterTypedListener() {
            @Override
            public void onCharacterTyped(char character, int index) {
                if(index == mIndex) {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            playBlinkAnimation();
                        }
                    }, 1750);

                }
            }
        });

    }

    private void playBlinkAnimation(){

        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.blink);
        mStartQuestions.startAnimation(animation1);
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

