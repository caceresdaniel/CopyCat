package com.copycat;



import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.copycat.R;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;

    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolBar;
    private TextView usernameTV;

    protected String mUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolBar = (Toolbar) findViewById(R.id.nav_act);
        setSupportActionBar(mToolBar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.navigation_header);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.open, R.string.close);

        //instantiate NavigationView
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        View headerView = mNavigationView.getHeaderView(0);

        //instantiate TextView to display username on navigation bar
        usernameTV = (TextView)headerView.findViewById(R.id.username_header);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mNavigationView.setNavigationItemSelectedListener(this);

    }
    //update username TextView in navigation bar on LoginActivity Result; activity is started in mainFragment
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        mUsername = data.getStringExtra("username");
        usernameTV.setText(mUsername);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.account:
                Toast.makeText(this, "Subscribe to unlock this feature.", Toast.LENGTH_LONG).show();
                break;
            case R.id.viewUsers:
                Intent i = new Intent(MainActivity.this, ViewUsers.class);
                startActivity(i);
                Toast.makeText(this, "I'm so", Toast.LENGTH_LONG).show();
                break;
            case R.id.settings:
                Intent s = new Intent(MainActivity.this, LanguageSettings.class);
                startActivity(s);
                Toast.makeText(this, "done", Toast.LENGTH_LONG).show();
                break;
            case R.id.info:
                Toast.makeText(this, "with myself", Toast.LENGTH_LONG).show();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.navigation_header);
        drawer.closeDrawer(GravityCompat.START);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        //calling the method displayselectedscreen and passing the id of selected menu
        displaySelectedScreen(item.getItemId());
        //make this method blank
        return true;
    }

}