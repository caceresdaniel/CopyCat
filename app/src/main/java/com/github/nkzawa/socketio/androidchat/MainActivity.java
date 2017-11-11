package com.github.nkzawa.socketio.androidchat;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolBar = (Toolbar) findViewById(R.id.nav_act);
        setSupportActionBar(mToolBar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.navigation_header);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.open, R.string.close);

        //This is where I wanna change the username.
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        View headerView = mNavigationView.inflateHeaderView(R.layout.navigation_header);
        TextView tv = (TextView)headerView.findViewById(R.id.username_header);

        String username = "";
        tv.setText(username);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

