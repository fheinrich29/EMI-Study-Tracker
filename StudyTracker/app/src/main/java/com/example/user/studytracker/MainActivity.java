package com.example.user.studytracker;


import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar myToolbar;
    List<Subject> subjectList = new ArrayList<Subject>();
    String file_subjectArray = " \\subj_array.txt";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);



        myToolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(myToolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, myToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        buildTabs();
    }

    @Override
    protected void onStart(){
        try {
            File file = new File(getFilesDir() + file_subjectArray);
            if (file.exists()) {
                FileInputStream fIS = new FileInputStream(file);
                ObjectInputStream oIS = new ObjectInputStream(fIS);

                subjectList = (List<Subject>) oIS.readObject();
            }
        }
        catch (Exception ex) {
            Toast.makeText(this, getString(R.string.txt_oops), Toast.LENGTH_SHORT).show();
        }



        Intent receivedIntent = getIntent();
        if(receivedIntent.hasExtra("subject")){
            Subject subj = (Subject) receivedIntent.getSerializableExtra("subject");
            subjectList.add(subj);
        }

        super.onStart();
        Toast.makeText(this, String.valueOf(subjectList.size()), Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        try {
            File file = new File(getFilesDir() + file_subjectArray);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            FileOutputStream fOS = new FileOutputStream(file);
            ObjectOutputStream oOS = new ObjectOutputStream(fOS);
            oOS.writeObject(subjectList);
            oOS.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    // creates the menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    // when you click on the settings-button in the toolbar
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    // handles what happens if you click the navigationDrawer
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_new){
            startActivity(new Intent(this, AddActivity.class));
        }
        if (id == R.id.nav_all) {
            myToolbar.setTitle("Alle Fächer");
        }


            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
    }

    // builds the UI for the tabs on the bottom
    public void buildTabs(){
        final TabLayout tabLayout = findViewById(R.id.tab_layout);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        LectureFragment tab1 = new LectureFragment();
                        return tab1;
                    case 1:
                        StatisticsFragment tab2 = new StatisticsFragment();
                        return tab2;
                    case 2:
                        CalendarFragment tab3 = new CalendarFragment();
                        return tab3;
                    default:
                        return null;
                }
            }


            @Override
            public int getCount() {
                return tabLayout.getTabCount();
            }
        };
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}

