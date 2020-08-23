package com.example.connectionwithbeing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

//    @Override
//    public void onBackPressed(){
//        Intent goHome = new Intent(SettingsActivity.this, MainActivity.class);
//        startActivity(goHome);
//    }
}
