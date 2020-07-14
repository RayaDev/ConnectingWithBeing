package com.example.connectionwithbeing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class NatureMenuActivity extends AppCompatActivity {

    private LinearLayout mHomeButtonBar;
    private ImageView mHomeButton;

    private ImageView mStartExercise1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature_menu);

        mStartExercise1 = findViewById(R.id.selfImageView1);

        mHomeButtonBar = findViewById(R.id.bottomNatureHomeButtonBar);
        mHomeButton = findViewById(R.id.bottomNatureHomeButton);


        mStartExercise1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startExercise1 = new Intent(NatureMenuActivity.this, NatureE1Activity.class);
                startActivity(startExercise1);
            }
        });

        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent returnHome = new Intent(NatureMenuActivity.this, MainActivity.class);
                startActivity(returnHome);

            }
        });
    }

    //When back button on actionbar is pressed, returns to the previous activity which has not been destroyed.
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                Toast.makeText(getApplicationContext(),"Back button clicked", Toast.LENGTH_SHORT).show();
//                super.onBackPressed(); //This replicates the hard back button on the phone. Could just replace this with an Intent
//                break;
//        }
//        return true;
//    }
}
