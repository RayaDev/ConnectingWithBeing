package com.example.connectionwithbeing;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class CreditsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }

//    @Override
//    public void onBackPressed(){
//        Intent goHome = new Intent(CreditsActivity.this, MainActivity.class);
//        startActivity(goHome);
//    }
}
