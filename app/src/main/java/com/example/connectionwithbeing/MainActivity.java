package com.example.connectionwithbeing;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //Declaring all Views
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private LinearLayout mHomeButtonBar;
    private ImageView mHomeButton, mSelfImageView, mOthersImageView, mSocietyImageView, mNatureImageView;
    private TextView mSelfTextView, mOthersTextView, mSocietyTextView, mNatureTextView;

    //Shared Preferences
    public SharedPreferences mSharedPreferences;
    public static final String userActivityProgress = "Exercises Completed";

    public static final String RTProgress = "RTProgress";
    public static final String RBProgress = "RBProgress";
    public static final String LTPrgoress = "LTProgress";
    public static final String LBProgress = "LBProgress";

    public int RTeCC, RBeCC, LTeCC, LBeCC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//IMPLEMENTING ALL VIEWS
        mHomeButtonBar = findViewById(R.id.bottomHomeButtonBar); //Used for controlling the functionality of the bottom home button.
        mHomeButton = findViewById(R.id.bottomHomeButton); //The actual button itself.

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

//        mSharedPreferences = getSharedPreferences()

//**************************************************************************************************
// ACTION BAR AND NAVIGATION

        //Action bar settings.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Adds functionality back button
        getSupportActionBar().setElevation(0); //Removes shadow on action bar
        getSupportActionBar().setTitle("Connection With..."); //Sets the title to be blank on create.

        //Navigation View Settings
        NavigationView navigationView = (NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this); // Activates the onNavItemSelected to make the items work.

        //Creates the actual menu functionality.
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.open, R.string.close); //The toggle is the hamburger.
        mDrawerLayout.addDrawerListener(mToggle); // Listens to the toggle button, which is the hamburger for the nav menu?
        mToggle.syncState();
        mDrawerLayout.closeDrawers();

//**************************************************************************************************
//VARIOUS MAIN ACTIVITY FUNCTIONALITY

        //Provides the functionality for the bottom home button.
        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, R.string.home_button_toast,Toast.LENGTH_SHORT).show();

            }
        });

    }

//**************************************************************************************************
//ACTION BAR AND NAVIGATION METHOD IMPLEMENTATIONS

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

        return super.onOptionsItemSelected(item);
    }


    //    Makes items clickable and perform actions for nav menu.

    //    Sets a unique action bar color for each exercise.
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();


        if(id == R.id.home) {


            mDrawerLayout.closeDrawers();
        }

        if(id == R.id.first_fragment_menu){


            mDrawerLayout.closeDrawers();
        }

        if(id == R.id.second_fragment_menu) {

            mDrawerLayout.closeDrawers();
        }

        return true;
    }

//**************************************************************************************************
//VARIOUS MAIN ACTIVITY METHODS

    public void changeActionBarColor(int color) {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(color)));
    }

//**************************************************************************************************

}
