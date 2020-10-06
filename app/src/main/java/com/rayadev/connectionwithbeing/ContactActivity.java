package com.rayadev.connectionwithbeing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        setTitle(R.string.contact_activity_title);


  }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
//                Toast.makeText(ContactActivity.this, "Contact Action Bar Back Pressed",
//                        Toast.LENGTH_SHORT ).show();
                Intent goHome = new Intent(ContactActivity.this, MainActivity.class);
                startActivity(goHome);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed(){
//        Toast.makeText(ContactActivity.this, " HardBack Pressed", Toast.LENGTH_SHORT ).show();
        Intent goHome = new Intent(ContactActivity.this, MainActivity.class);
        startActivity(goHome);

    }
}
