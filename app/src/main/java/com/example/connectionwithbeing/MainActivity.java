package com.example.connectionwithbeing;

import android.app.Fragment;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private LinearLayout mLinearLayout;
    private ImageView mImageView;

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
        setContentView(R.layout.activity_nav_drawer);

        mLinearLayout = findViewById(R.id.bottomHomeButtonBar); //Used for controlling the functionality of the bottom home button.
        mImageView = findViewById(R.id.bottomHomeButton); //The actual button itself.

//        mSharedPreferences = getSharedPreferences()

        //Action bar settings.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Adds functionality back button
        getSupportActionBar().setElevation(0); //Removes shadow on action bar
        getSupportActionBar().setTitle(""); //Sets the title to be blank on create.

        //Navigation View Settings
        NavigationView navigationView = (NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this); // Activates the onNavItemSelected to make the items work.

        //Creates the actuall menu functionality.
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.open, R.string.close); //The toggle is the hamburger.

        mDrawerLayout.addDrawerListener(mToggle); // Listens to the toggle button, which is the hamburger for the nav menu?
        mToggle.syncState();

        mDrawerLayout.closeDrawers();

        //Starts the Home Fragment
        final FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.add(R.id.frameLayout, new HomeFragment());
        mFragmentTransaction.commit();


        //Provides the functionality for the bottom home button.
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction home = getSupportFragmentManager().beginTransaction();
                home.add(R.id.frameLayout, new HomeFragment());
                home.commit();

                changeActionBarColor(R.color.homeScreenActionbarColor);
                mLinearLayout.setBackgroundColor(getResources().getColor(R.color.homeScreenActionbarColor));

            }
        });

    }

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
            String version = "Current Game Version: " + BuildConfig.VERSION_NAME;
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

//            loadFragment(new HomeFragment());

            changeActionBarColor(R.color.homeScreenActionbarColor);
            mLinearLayout.setBackgroundColor(getResources().getColor(R.color.homeScreenActionbarColor));

            mDrawerLayout.closeDrawers();
        }

        if(id == R.id.first_fragment_menu){

//            loadFragment(new Exercise1Fragment());

            changeActionBarColor(R.color.AE1_actionBarBackgroundColor);

            mLinearLayout.setBackgroundColor(getResources().getColor(R.color.AE1_actionBarBackgroundColor));

            mDrawerLayout.closeDrawers();
        }

        if(id == R.id.second_fragment_menu) {

//            loadFragment(new Exercise2Fragment());

            changeActionBarColor(R.color.AE2_actionBarBackgroundColor);
            mLinearLayout.setBackgroundColor(getResources().getColor(R.color.AE2_actionBarBackgroundColor));

            mDrawerLayout.closeDrawers();
        }

        return true;
    }


    private void loadFragment(Fragment fragment) {

    }

    public void changeActionBarColor(int color) {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(color)));
    }

}
