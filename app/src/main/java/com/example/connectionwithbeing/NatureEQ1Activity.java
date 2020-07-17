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
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

//AEQ for short hand notation.

public class NatureEQ1Activity extends AppCompatActivity {

    private ImageView mHomeButton, mCompletedQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature_eq1);


        mHomeButton = findViewById(R.id.natureHomeButton_EQ1);
        mCompletedQuestions = findViewById(R.id.natureQ1Completed_ImageView);

//        Sets the AEQ action bar to have the same color as AE action bar.
//        Make sure the actionbar versions are the same.
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.nature_primary_dark)));

       mCompletedQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(NatureEQ1Activity.this)
                        .setTitle("Finish Reflecting..")
                        .setMessage("Have you thought about all the questions?")

                        .setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                //Increments the number of nature exercises completed on the home menu.
                                SharedPreferences mSharedPreferences = getApplicationContext().getSharedPreferences(MainActivity.userActivityProgress, MODE_PRIVATE);
                                SharedPreferences.Editor mSharedPreferencesEditor = mSharedPreferences.edit();

                                MainActivity.natureCompletedInt = mSharedPreferences.getInt(MainActivity.natureProgress, MainActivity.natureCompletedInt);

                                MainActivity.natureCompletedInt += 1;

                                mSharedPreferencesEditor.putInt(MainActivity.natureProgress, MainActivity.natureCompletedInt);

                                mSharedPreferencesEditor.commit();

                                //Saves and sets the exercise progress star color to yellow on the nature menu.
                                SharedPreferences mSharedPreferences2 = getApplicationContext().getSharedPreferences(NatureMenuActivity.userNatureProgress, MODE_PRIVATE);
                                SharedPreferences.Editor mSharedPreferencesEditor2 = mSharedPreferences2.edit();

                                NatureMenuActivity.natureE1Completed = 1;

                                mSharedPreferencesEditor2.putInt(NatureMenuActivity.natureE1, NatureMenuActivity.natureE1Completed);

                                mSharedPreferencesEditor2.commit();

                                //Returns to the home screen and activates an animation on the stars.
                                Intent returnHome = new Intent(NatureEQ1Activity.this, MainActivity.class);

                                returnHome.putExtra("play_animation",1);

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
                        .setIcon(R.drawable.star)
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


        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent returnHome = new Intent(NatureEQ1Activity.this, MainActivity.class);
                startActivity(returnHome);

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
