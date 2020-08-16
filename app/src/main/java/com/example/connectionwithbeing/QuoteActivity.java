package com.example.connectionwithbeing;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class QuoteActivity extends AppCompatActivity {

    private ConstraintLayout mConstraintLayout;
    private ProgressBar mProgressBar;
    private int i = 0;
    private TextView mTextView;
    private Handler mHandler = new Handler();
    private Button mButton;
    private boolean exitThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        mConstraintLayout = findViewById(R.id.QuoteActivity_ParentLayout);
        mProgressBar = (ProgressBar) findViewById(R.id.QuoteActivity_ProgressBar);
        mTextView = (TextView) findViewById(R.id.QuoteActivity_TextView);
        mButton = findViewById(R.id.QuoteActivity_Button);

        setQuoteActivityViews();

        final Thread progressThread = new Thread(new Runnable() {
            @Override
            public void run() {
                exitThread = false;
                while (i < 100 && exitThread == false) {
                    i += 1;
                    // Update the progress bar and display the current value in text view
                    mHandler.post(new Runnable() {
                        public void run() {
                            mProgressBar.setProgress(i);
                            mTextView.setText(i + "/" + mProgressBar.getMax());
                        }
                    });
                    try {
                        // Sleep for 100 milliseconds to show the progress slowly.
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if(exitThread == false) {
                    startExercise();
                }

                else {
                    finish();
                }

                finish();
            }
        });

        progressThread.start();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopThread();
                startExercise();
                finish();
            }
        });

    }

    private void stopThread()
    {
        exitThread = true;
    }

    private void setQuoteActivityViews() {

        Intent exerciseIntent = getIntent();
        Bundle exerciseExtras = exerciseIntent.getExtras();
        int category = exerciseExtras.getInt(ExerciseMenuActivity.exerciseCategoryKey);

        setActivityColors(category);


    }

    private void setActivityColors(int category) {

        switch (category) {
            case 1:
                mConstraintLayout.setBackgroundColor(getResources().getColor(R.color.self_primary));
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.self_primary_dark)));
                break;

                case 2:
                mConstraintLayout.setBackgroundColor(getResources().getColor(R.color.others_primary));
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.others_primary_dark)));
                break;

                case 3:
                mConstraintLayout.setBackgroundColor(getResources().getColor(R.color.nature_primary));
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.nature_primary_dark)));
                break;

                case 4:
                mConstraintLayout.setBackgroundColor(getResources().getColor(R.color.society_primary));
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.society_primary_dark)));
                break;



        }
    }

    private void startExercise() {
        Intent exerciseIntent = getIntent();
        Bundle exerciseExtras = exerciseIntent.getExtras();

        Intent startExercise = new Intent(QuoteActivity.this, ExerciseActivity.class);
        startExercise.putExtras(exerciseExtras);
        startActivity(startExercise);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(getApplicationContext(),"Back button clicked", Toast.LENGTH_SHORT).show();
                stopThread();
                finish();
                super.onBackPressed(); //This replicates the hard back button on the phone. Could just replace this with an Intent
                break;
        }

        return true;
    }

    public void onBackPressed()
    {
        stopThread();
        super.onBackPressed();
        finish();
    }
}
