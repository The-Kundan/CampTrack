package com.example.camptrack;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btmView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btmView = findViewById(R.id.btmView);

        btmView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.nav_home){
//                    Intent i = new Intent(MainActivity.this, MapsActivity.class);
//                    startActivity(i);
                    loadFrag(new MapsFragment(),true);
                } else if (id==R.id.nav_CollegeData) {
                    loadFrag(new DataFragment(),false);
                }else{
                    loadFrag(new AboutUSFragment(),false);
                }

                return true;
            }
        });
        btmView.setSelectedItemId(R.id.nav_home);
    }
    public void loadFrag(Fragment fragment, boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag){
            ft.add(R.id.container, fragment);
        }else {
            ft.replace(R.id.container,fragment);
        }
        ft.commit();
    }
}