package com.example.connectionwithbeing;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IntroductionActivity2 extends AppCompatActivity {

    private LinearLayout mIntroLinearLayout, mIntroExerciseMenu, mIntroExerciseIcon, mIntroNext2Button;
    private TextView mIntroIconTextView;

    private int clickCount = 2;

    private int[] introImages = {R.id.UIIntroExerciseMenuIcon_LinearLayout, R.id.UIIntroExerciseIcon_LinearLayout,
            R.drawable.guihome, R.drawable.guibookmark, R.drawable.shuffleiconimage, R.drawable.guiinfoitemimage};

    int[] introText = {R.string.ui_menu_icon, R.string.ui_exercise_icon, R.string.ui_home_icon, R.string.ui_bookmark_icon,
            R.string.ui_shuffle_icon, R.string.ui_info_icon};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction_2);

        mIntroLinearLayout = findViewById(R.id.IntroIconPlaceHolder_LinearLayout);
        mIntroIconTextView = findViewById(R.id.IntroIconText_TextView);
        mIntroNext2Button = findViewById(R.id.IntroductionNext2_LinearLayout);
        mIntroExerciseMenu = findViewById(introImages[0]);
        mIntroIconTextView.setText(introText[0]);
        mIntroExerciseIcon = findViewById(introImages[1]);

        mIntroLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageText();
                clickCount++;
            }
        });

    }

}
