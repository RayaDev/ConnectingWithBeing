package com.example.connectionwithbeing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class AExerciseOneQuestions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise1_questions_activitiy);
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
