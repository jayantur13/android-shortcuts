package com.example.myandroidapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class OnBoardingActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sharedPrefrencesEditor;
    private static final String JUMPERKEY = "JUMPERKEY";
    private static final String KEY_JUMP = "JUMP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!isFirstTimeStartApp()) {
            startMainActivity();
            finish();
        }

        setContentView(R.layout.activity_start_board);
        //Rest related to the layout and OnBoarding

        /*
        Check the intent which you will receive whenever a shortcut is pressed;
        Toast the value from shortcuts extra to check if the correct fragment shortcut is pressed;
        Send a key to the Navigation Drawer Activity (MainActivty) to verify the key for fragment 
        transaction or Navigation whatever you use. */
        String FRAG1 = "com.example.myandroidapp.FRAG1";
        String FRAG2 = "com.example.myandroidapp.FRAG2"
        if (FRAG1.equals(getIntent().getAction())) {
            Toast.makeText(getApplicationContext(), Objects.requireNonNull(getIntent().getExtras()).getString("FRAG1"),Toast.LENGTH_SHORT).show();
            
            sharedPreferences = getApplicationContext().getSharedPreferences(JUMPERKEY, MODE_PRIVATE);
            sharedPrefrencesEditor=sharedPreferences.edit();
            sharedPrefrencesEditor.putString(KEY_JUMP,"frag1");
            sharedPrefrencesEditor.apply();
        }else if (FRAG2.equals(getIntent().getAction())) {
           Toast.makeText(getApplicationContext(), Objects.requireNonNull(getIntent().getExtras()).getString("FRAG2"),Toast.LENGTH_SHORT).show();
           
            sharedPreferences = getApplicationContext().getSharedPreferences(JUMPERKEY, MODE_PRIVATE);
            sharedPrefrencesEditor=sharedPreferences.edit();
            sharedPrefrencesEditor.putString(KEY_JUMP,"frag2");
            sharedPrefrencesEditor.apply();
        }

}
