package com.example.connectionwithbeing;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;

import model.Exercise;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Declaring all Views
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private LinearLayout mHomeButtonBar;
    private ImageView mHomeButton, mToDoButton, mSelfImageView, mOthersImageView, mSocietyImageView, mNatureImageView;
    private TextView mSelfTextView, mOthersTextView, mSocietyTextView, mNatureTextView;

    //Shared Preferences for the number of exercises completed, and menu creation
    public SharedPreferences mSharedPreferences;

    //Keys
    public static final String selfProgress = "self_progress";
    public static final String othersProgress = "others_progress";
    public static final String natureProgress = "nature_progress";
    public static final String societyProgress= "society_progress";

    //Values
    public static int natureCompletedInt, othersCompletedInt, selfCompletedInt, societyCompletedInt;

    //Keys
    public static final String menuCategory = "menu_category";

    //Values, passed as extra for determining which menu to construct.
    public static final int selfMenu = 1;
    public static final int othersMenu = 2;
    public static final int natureMenu = 3;
    public static final int societyMenu = 4;


    //Used for back button nav
    boolean HARD_BACK_BUTTON_EXIT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//IMPLEMENTING ALL VIEWS
        mHomeButtonBar = findViewById(R.id.bottomHomeButtonBar); //Used for controlling the functionality of the bottom home button bar.
        mHomeButton = findViewById(R.id.homeHomeButton); //The actual button itself.
        mToDoButton = findViewById(R.id.homeToDoButton);

        mSelfImageView = findViewById(R.id.selfImageView);
        mOthersImageView = findViewById(R.id.othersImageView);
        mSocietyImageView = findViewById(R.id.societyImageView);
        mNatureImageView = findViewById(R.id.natureImageView);

        mSelfTextView = findViewById(R.id.selfCompletedTextView);
        mOthersTextView = findViewById(R.id.othersCompletedTextView);
        mNatureTextView = findViewById(R.id.natureCompletedTextView);
        mSocietyTextView = findViewById(R.id.societyCompletedTextView);


//**************************************************************************************************
//SETTING UP SHARED PREFERENCES

          mSharedPreferences = getApplicationContext().getSharedPreferences(Exercise.userActivityProgress, MODE_PRIVATE);
          setProgressStars();
          playProgressAnimation();
//**************************************************************************************************
// ACTION BAR AND NAVIGATION

        //Action bar settings.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Adds functionality back button
        getSupportActionBar().setTitle("Connection With..."); //Sets the title to be blank on create.

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mHomeButtonBar.setElevation(100);
        }
        //Navigation View Settings
        NavigationView navigationView = (NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this); // Activates the onNavItemSelected to make the items work.

        //Creates the actual menu functionality.
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close); //The toggle is the hamburger.
        mDrawerLayout.addDrawerListener(mToggle); // Listens to the toggle button, which is the hamburger for the nav menu?
        mToggle.syncState();
        mDrawerLayout.closeDrawers();

        setOnClickListeners();

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
            return;
        }

    }
    //End of onCreate()

    //On click methods for home menu items
    private void setOnClickListeners() {


        mSelfImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mOthersImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startOthersMenu = new Intent(MainActivity.this, ExerciseMenuActivity.class);
                startOthersMenu.putExtra(menuCategory, othersMenu);
                startActivity(startOthersMenu);
            }
        });

        mNatureImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startNatureMenu = new Intent(MainActivity.this, ExerciseMenuActivity.class);

                startNatureMenu.putExtra(menuCategory, natureMenu);
                //Pass the appropriate extras through the intent to build the menu layout.
                startActivity(startNatureMenu);
            }
        });

        mSocietyImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.home_button_toast,Toast.LENGTH_SHORT).show();
            }
        });

        mToDoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "To Do Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

//**************************************************************************************************
//Actionbar and navigation method implementations

    //  Creates the right hand menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_menu, menu);

        return true;
    }


    //  Method needed for the left hand nav menu as well as setting the item actions for the right hand.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(mToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        if(item.getItemId() == R.id.infoItem) {
            String version = "Current Version: " + BuildConfig.VERSION_NAME;
            Toast.makeText(this, version,Toast.LENGTH_SHORT ).show();

        }

        if(item.getItemId() == R.id.settingsItem) {
            Toast.makeText(this,"Settings go here in a group", Toast.LENGTH_SHORT).show();
        }

//        if(item.getItemId() == android.R.id.home) {
//            finish();
//        }

        return super.onOptionsItemSelected(item);
    }


    // Makes items clickable and perform actions for nav menu.
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();


        if(id == R.id.home) {

            mDrawerLayout.closeDrawers();
            Toast.makeText(MainActivity.this, "Home item clicked", Toast.LENGTH_SHORT).show();
        }

        if(id == R.id.introduction_item){


            mDrawerLayout.closeDrawers();
            Toast.makeText(MainActivity.this, "Introduction item clicked", Toast.LENGTH_SHORT).show();
        }

        if(id == R.id.credits_item) {

            mDrawerLayout.closeDrawers();
            Toast.makeText(MainActivity.this, "Credits item clicked", Toast.LENGTH_SHORT).show();
        }

        if(id == R.id.about_item) {
            mDrawerLayout.closeDrawers();
            Toast.makeText(MainActivity.this, "About item clicked",Toast.LENGTH_SHORT).show();
        }

        if(id == R.id.contacts_item) {
            mDrawerLayout.closeDrawers();
            Toast.makeText(MainActivity.this, "Contacts item clicked",Toast.LENGTH_SHORT).show();
        }

        return true;
    }

//**************************************************************************************************
//Various main activity methods for Shared preferences

    public void changeActionBarColor(int color) {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(color)));
    }

    public void playProgressAnimation() {
        Intent playAnimation = getIntent();
        int i = playAnimation.getIntExtra("play_animation",0);
        int j = playAnimation.getIntExtra("exercise_category",0);

        HashMap<Integer, Integer> stars = new HashMap<>();
        stars.put(selfMenu, R.id.selfStar);
        stars.put(othersMenu, R.id.othersStar);
        stars.put(natureMenu, R.id.natureStar);
        stars.put(societyMenu, R.id.societyStar);


        if(i == 1) {
            //Rotates the stars
            ImageView natureStarImage = findViewById(stars.get(j));
            Animation rotateAnimation =
                    AnimationUtils.loadAnimation(getApplicationContext(),
                            R.anim.rotate);

            natureStarImage.startAnimation(rotateAnimation);

            //Plays bell sound
            final MediaPlayer mMediaPlayer = MediaPlayer.create(this, R.raw.finishbells);

            int MAX_VOLUME = 100;
            int soundVolume = 50;

            final float volume = (float) (1 - (Math.log(MAX_VOLUME - soundVolume) / Math.log(MAX_VOLUME)));
            mMediaPlayer.setVolume(volume, volume);
            mMediaPlayer.start();
        }

    }

    public void setProgressStars() {

        //Need this for all categories.
        int stars = mSharedPreferences.getInt(natureProgress, natureCompletedInt);
        String progressStars = "X "+ stars+"/6";
        mNatureTextView = findViewById(R.id.natureCompletedTextView);
        mNatureTextView.setText(progressStars);

        stars = mSharedPreferences.getInt(othersProgress, othersCompletedInt);
        progressStars = "X "+ stars+"/6";
        mOthersTextView = findViewById(R.id.othersCompletedTextView);
        mOthersTextView.setText(progressStars);

        stars = mSharedPreferences.getInt(selfProgress, selfCompletedInt);
        progressStars = "X "+ stars+"/6";
        mSelfTextView = findViewById(R.id.selfCompletedTextView);
        mSelfTextView.setText(progressStars);

        stars = mSharedPreferences.getInt(societyProgress, societyCompletedInt);
        progressStars = "X "+ stars+"/6";
        mSocietyTextView = findViewById(R.id.societyCompletedTextView);
        mSocietyTextView.setText(progressStars);

    }

    //Exits the app if the back button is pressed from the home screen.
    @Override
    public void onBackPressed()
    {

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Exit")
                .setMessage("Close the App?")

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        moveTaskToBack(true);
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setIcon(R.drawable.star)
                .show();
    }


//**************************************************************************************************

}
