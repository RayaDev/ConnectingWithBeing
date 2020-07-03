package com.example.connectionwithbeing;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import android.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.open, R.string.close);


//       Listens to the toggle button, which is the hamburger for the nav menu?
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
//        Adds functionality back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navView);


//        Activates the onNavItemSelected to make the items work.
        navigationView.setNavigationItemSelectedListener(this);

        loadFragment(new HomeFragment());
        mDrawerLayout.closeDrawers();


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
            Toast.makeText(this, "Home item clicked", Toast.LENGTH_SHORT).show();
            loadFragment(new HomeFragment());
            changeActionBarColor(R.color.colorPrimary);
            mDrawerLayout.closeDrawers();
        }
        if(id == R.id.first_fragment_menu){
//            Toast.makeText(this, "First Fragment Clicked", Toast.LENGTH_SHORT).show();
            loadFragment(new Exercise1Fragment());
            changeActionBarColor(R.color.AE1_actionBarBackgroundColor);
            mDrawerLayout.closeDrawers();
        }

        if(id == R.id.second_fragment_menu) {
            Toast.makeText(this, "Second Fragment Clicked", Toast.LENGTH_SHORT).show();
            loadFragment(new Exercise2Fragment());
            changeActionBarColor(R.color.colorPrimaryDark);
            mDrawerLayout.closeDrawers();
        }

        return true;
    }


    private void loadFragment(Fragment fragment) {
// create a FragmentManager
        FragmentManager fm = getFragmentManager();
// create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
// replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }

    public void changeActionBarColor(int color) {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(color)));
    }
}
