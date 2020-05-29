package com.example.myandroidapp;

import android.Manifest;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

//If you are using Navigation Drawer,please set it up fully
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private static final String JUMPERKEY = "JUMPERKEY";
    private static final String KEY_JUMP = "JUMP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_navigator);

         /*Check the value received,if OK then do your Fragment transaction/navigation or go to other Activity*/
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(JUMPERKEY,MODE_PRIVATE);
        String mclan = sharedPreferences.getString(KEY_JUMP,null);
        String minfo = sharedPreferences.getString(KEY_JUMP,null);
        String msettings = sharedPreferences.getString(KEY_JUMP,null);
        
        if(mclan!=null && mclan.contentEquals("frag1")){
          //Go to your Activity or Fragment
        }else if(minfo!=null && minfo.contentEquals("frag2")){
            //Go to your Activity or Fragment
        }
    
    }


  
    @Override
    public void onBackPressed() {
        //TODO;for you
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Remove value of Jump ie shortcut to reuse after shortcut is pressed
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(JUMPERKEY, MODE_PRIVATE);
        SharedPreferences.Editor sharedPrefrencesEditor = sharedPreferences.edit();
        sharedPrefrencesEditor.remove(KEY_JUMP);
        sharedPrefrencesEditor.apply();
    }

  

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //Remove value of Jump ie shortcut to resuse after shortcut is pressed
        SharedPreferences sp = getApplicationContext().getSharedPreferences(JUMPERKEY, MODE_PRIVATE);
        SharedPreferences.Editor sE = sp.edit();
        sE.remove(KEY_JUMP);
        sE.apply();
    }

}
