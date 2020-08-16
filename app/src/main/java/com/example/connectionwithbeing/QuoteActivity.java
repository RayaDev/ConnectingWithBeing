package com.example.connectionwithbeing;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuoteActivity extends AppCompatActivity {
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
        mProgressBar = (ProgressBar) findViewById(R.id.pBar);
        mTextView = (TextView) findViewById(R.id.tView);
        mButton = findViewById(R.id.btnShow);

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

    public void stopThread()
    {
        exitThread = true;
    }

    public void startExercise() {
        Intent exerciseIntent = getIntent();
        Bundle exerciseExtras = exerciseIntent.getExtras();

        Intent startExercise = new Intent(QuoteActivity.this, ExerciseActivity.class);
        startExercise.putExtras(exerciseExtras);
        startActivity(startExercise);
    }
}
