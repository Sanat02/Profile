package com.example.userprofie;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        navigationView=findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new Home_Fragment()).commit();
        navigationView.setSelectedItemId(R.id.nav_home);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()  {
            @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        fragment = new Home_Fragment();
                        break;

                    case R.id.nav_profile:
                        fragment = new Profile_Fragment();
                        break;
                    case R.id.nav_search:
                        fragment = new Search_Fragment();
                        break;
                    case R.id.nav_settings:
                        fragment = new Settings_Fragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container,fragment).commit();
                return true;

            }


        });


    }
}