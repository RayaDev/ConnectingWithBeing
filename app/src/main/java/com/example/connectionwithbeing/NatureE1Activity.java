package com.example.connectionwithbeing;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.prush.typedtextview.TypedTextView;

public class NatureE1Activity extends AppCompatActivity {

    private ImageView mStartQuestion1;
    private ImageView mHomeButton;
    private TypedTextView mTypedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature_e1);

        //Set Actionbar color
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.nature_primary_dark)));

        mStartQuestion1 = findViewById(R.id.question1Image);
        mTypedTextView = findViewById(R.id.natureE1_TypedTextView);
        mHomeButton = findViewById(R.id.E1HomeButton);


        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent returnHome = new Intent(NatureE1Activity.this, MainActivity.class);
                startActivity(returnHome);

            }
        });

        String mExerciseString = getString(R.string.nature_e1_text);
        final int mIndex = mExerciseString.length() -1;
        final char mChar = '.';


        mTypedTextView.bringToFront();

        mTypedTextView.setOnCharacterTypedListener(new TypedTextView.OnCharacterTypedListener() {
            @Override
            public void onCharacterTyped(char character, int index) {
                if(index == mIndex) {

                    mStartQuestion1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            new AlertDialog.Builder(NatureE1Activity.this)
                                    .setTitle("Continue to reflections..")
                                    .setMessage("Have you completed the exercise?")

                                    // Specifying a listener allows you to take an action before dismissing the dialog.
                                    // The dialog is automatically dismissed when a dialog button is clicked.
                                    .setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent startQuestions = new Intent(NatureE1Activity.this, NatureEQ1Activity.class);
                                            startActivity(startQuestions);
                                        }
                                    })

                                    // A null listener allows the button to dismiss the dialog and take no further action.
                                    .setNegativeButton("Take more time", null)
                                    .setIcon(R.drawable.star)
                                    .show();


                        }
                    });

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            blink();
                        }
                    }, 1750);

                }

            }
        });
    }

    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        View v = (View) findViewById(R.id.natureE1_ImageView);
        String x = Integer.toString(v.getWidth());
        String y = Integer.toString(v.getHeight());

//        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
//        int width = metrics.widthPixels;
//        int height = metrics.heightPixels;

        //show ImageView width and height
        Log.i("ViewSize", x + ":" + y);
    }

    public void blink(){
        ImageView image = (ImageView)findViewById(R.id.question1Image);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.blink);
        image.startAnimation(animation1);
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
