package com.example.connectionwithbeing;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuoteActivity extends AppCompatActivity {
    private ProgressBar mProgressBar;
    private int i = 0;
    private TextView mTextView;
    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);
        mProgressBar = (ProgressBar) findViewById(R.id.pBar);
        mTextView = (TextView) findViewById(R.id.tView);

        Thread progressThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < 100) {
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

                startExercise();
            }
        });

        progressThread.start();
//        try {
//            progressThread.join();
//            startExercise();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }


    public void startExercise() {
        Intent exerciseIntent = getIntent();
        Bundle exerciseExtras = exerciseIntent.getExtras();

        Intent startExercise = new Intent(QuoteActivity.this, ExerciseActivity.class);
        startExercise.putExtras(exerciseExtras);
        startActivity(startExercise);
    }
}
