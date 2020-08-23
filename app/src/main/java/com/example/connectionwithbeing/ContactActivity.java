package com.example.connectionwithbeing;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

//    @Override
//    public void onBackPressed(){
//        Intent goHome = new Intent(ContactActivity.this, MainActivity.class);
//        Toast.makeText(ContactActivity.this, "Contact Back Pressed", Toast.LENGTH_SHORT).show();
//        startActivity(goHome);
//    }
}
