package com.example.myandroidapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class OnBoardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!isFirstTimeStartApp()) {
            startMainActivity();
            finish();
        }

        setContentView(R.layout.activity_start_board);
        //Rest related to the layout and OnBoarding
        
        //Call the method for dynamic shortcuts
        addShortcuts();

       }
       
    /*Dynamic Shortcuts
    android:exported="true" will be useful here,if exported was set to "false" then you may get error as "App isn't installed
    Make Intent,set your action and put extra with key and value which will be used in MainActivity to verify and navigate
    Note - If you give same ids then one of them won't appear
    */
    private void addShortcuts() {
        String FRAG1 = "com.example.myandroidapp.FRAG1";
        String FRAG2 = "com.example.myandroidapp.FRAG2"

        ShortcutManager shortcutManager;
        ShortcutInfo s1, s2, s3;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N_MR1) {
            shortcutManager = getSystemService(ShortcutManager.class);

            Intent m1 = new Intent(getApplicationContext(),MainActivity.class);
            m1.setAction(SETTINGS).putExtra("FRAG1","FRAG1");
            s1 = new ShortcutInfo.Builder(getApplicationContext(), "Fragment1")//Fragment1 is id of shortcut
                    .setShortLabel(getApplicationContext().getString(R.string.fragmentonename))
                    .setIcon(Icon.createWithResource(getApplicationContext(), R.drawable.drawableone))
                    .setIntent(m1)
                    .setRank(1)
                    .build();


            Intent m2 = new Intent(getApplicationContext(),MainActivity.class);
            m2.setAction(MY_CLAN).putExtra("FRAG2","FRAG2");
            s2 = new ShortcutInfo.Builder(getApplicationContext(), "Fragment2")//Fragment2 is id of shortcut
                    .setShortLabel(getApplicationContext().getString(R.string.fragmenttwoname))
                    .setIcon(Icon.createWithResource(getApplicationContext(), R.drawable.drawabletwo))
                    .setIntent(m2)
                    .setRank(2)
                    .build();

         
            assert shortcutManager != null;
            shortcutManager.setDynamicShortcuts(Arrays.asList(s1, s2));

        }

       //Read the docs on how you can update,delete or disable shortcuts

    }
}
