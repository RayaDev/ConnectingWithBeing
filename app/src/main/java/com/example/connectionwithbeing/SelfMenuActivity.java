package com.example.connectionwithbeing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SelfMenuActivity extends AppCompatActivity {

    private LinearLayout mHomeButtonBar;
    private ImageView mHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_menu);

        mHomeButtonBar = findViewById(R.id.selfBottomActionBar_Menu);
        mHomeButton = findViewById(R.id.selfHomeButton_Menu);

        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent returnHome = new Intent(SelfMenuActivity.this, MainActivity.class);
                startActivity(returnHome);

            }
        });
    }

//    //When back button on actionbar is pressed, returns to the previous activity which has not been destroyed.
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
