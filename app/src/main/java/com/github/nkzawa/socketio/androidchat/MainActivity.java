package com.github.nkzawa.socketio.androidchat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD

<<<<<<< HEAD


=======
        mDrawerLayout = (DrawerLayout) findViewById(R.id.container);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.open, R.string.close);

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
>>>>>>> 2db1947a1315bee2a0b69c49d1a829113e0e67e1
=======
>>>>>>> 57cfd4ae387c21fe317f5b0beef2461f87349f0b
    }
}