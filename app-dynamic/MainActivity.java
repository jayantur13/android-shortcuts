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
        
        
        //Receive Intent and intent value from OnBoard,verify then and then navigate to your fragment or activity
        String FRAG1 = "com.example.myandroidapp.FRAG1";
        String FRAG2 = "com.example.myandroidapp.FRAG2"
        if (FRAG1.equals(getIntent().getAction())) {
           //Go to your Activity or Fragment
        }else if(FRAG2.equals(getIntent().getAction())){
           //Go to your Activity or Fragment
        }

    }


  
    @Override
    public void onBackPressed() {
        //TODO;for you
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
