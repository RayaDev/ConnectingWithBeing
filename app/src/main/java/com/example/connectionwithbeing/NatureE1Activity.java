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
import androidx.recyclerview.widget.RecyclerView;

import com.prush.typedtextview.TypedTextView;

import java.util.ArrayList;

public class NatureE1Activity extends AppCompatActivity {

    private ImageView mStartNatureReflections;
    private ImageView mHomeButton, mExerciseImage;
    private TypedTextView mTypedTextView;
    private TextView mPlaceHolderTextView;

    //For passing into the Bookmarks Adapter
    private ArrayList<NatureE1Activity> mBookmarkedActitiestList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature_e1);

        //Set Actionbar color
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.nature_primary_dark)));

        //Get Intents
        Bundle extras = getIntent().getExtras();
        int exerciseImage = (int) extras.get(NatureMenuActivity.exerciseImageView);
        int exerciseText = (int) extras.get(NatureMenuActivity.exerciseTextView);
        int exerciseNumber = (int) extras.get(NatureMenuActivity.exerciseNumber);

        //Declare Views, and Set resources from extras.
        mExerciseImage = findViewById(R.id.natureE1_ImageView);
        mExerciseImage.setImageResource(exerciseImage);

        mTypedTextView = findViewById(R.id.natureE1_TypedTextView);
        mTypedTextView.setTypedText(exerciseText);

        mPlaceHolderTextView = findViewById(R.id.natureE1_TextView);
        mPlaceHolderTextView.setText(exerciseText);

        //Reflections Button
        mStartNatureReflections = findViewById(R.id.startNatureReflections_ImageView);
        mHomeButton = findViewById(R.id.natureHomeButton_E1);

        setupBookmarksAdapter();
        mOnClickListeners(exerciseText, exerciseNumber);

    }

    private void setupBookmarksAdapter() {
        RecyclerView mRecyclerView = findViewById(R.id.bookmark_RecyclerView);

        //Initialize the Exercise List
      //  mBookmarkedActitiestList = NatureE1Activity.buildBookmarkList();
    }

    private void buildBookmarkList() {

    }

    private void mOnClickListeners(int exerciseText, final int exerciseNumber) {
        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent returnHome = new Intent(NatureE1Activity.this, MainActivity.class);
                startActivity(returnHome);

            }
        });

        mStartNatureReflections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(NatureE1Activity.this)
                        .setTitle("Continue to reflections..")
                        .setMessage("Have you completed the exercise?")

                        .setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                //Need intents here with extras for the questions!
                                Intent startQuestions = new Intent(NatureE1Activity.this, NatureEQ1Activity.class);
                                startQuestions.putExtra(NatureMenuActivity.exerciseNumber, exerciseNumber);
                                startActivity(startQuestions);
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton("Take more time", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mStartNatureReflections.clearAnimation();

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
        mStartNatureReflections.startAnimation(animation1);
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

