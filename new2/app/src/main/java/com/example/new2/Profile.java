package com.example.new2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Profile extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private ArrayList<String> mgymname=new ArrayList<>();
    private ArrayList<String> mimages=new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<datagym> d2gym;
    NavigationView navigationView;
    Toolbar toolbar;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int tid = item.getItemId();
                // Handle navigation view item clicks here.
                if (tid == R.id.nav_home) {
                    // Handle the camera action
                    Toast.makeText(Profile.this,"Clicked home",Toast.LENGTH_SHORT).show();
                } else if (tid == R.id.nav_payment) {
                    Intent intent = new Intent(Profile.this, payment.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } else if (tid == R.id.nav_slideshow) {
                    Toast.makeText(Profile.this,"Clicked slideshow",Toast.LENGTH_SHORT).show();

                } else if (tid == R.id.nav_tools) {
                    Toast.makeText(Profile.this,"Clicked tools",Toast.LENGTH_SHORT).show();

                } else if (tid == R.id.nav_share) {
                    Toast.makeText(Profile.this,"Clicked share",Toast.LENGTH_SHORT).show();

                } else if (tid == R.id.buttonLogout) {
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(Profile.this, login.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
//        recyclerView.setHasFixedSize(true);
      //  d2gym=new ArrayList<>();
      //  d2gym.add(new datagym(R.drawable.bgapp,"biryani","dokagym"));
     ////   d2gym.add(new datagym(R.drawable.bgapp,"biryani","dokagym"));
//        d2gym.add(new datagym(R.drawable.bgapp,"biryani","dokagym"));
      //  layoutManager = new GridLayoutManager(this,2);
     //   recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(mAdapter);
      //  BottomNavigationView navView = findViewById(R.id.nav_view);
      //  navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile, menu);
        MenuItem menuItem=menu.findItem(R.id.action_settings);
        Toast.makeText(Profile.this,"Clicked slideshow",Toast.LENGTH_SHORT).show();
       // SearchView searchView = (SearchView) menuItem.getActionView();
       // searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
       /* String userinput=s.toLowerCase();
        List<com.example.try2.datagym> newlist =new ArrayList<>();
        for (com.example.try2.datagym gymtemp:d2gym) {
            if(d2gym.toLowerCase().contains(userinput)) {
                newlist.add(name);
            }
        }
        mAdapter.updatelist(newlist);  */
        return false;
    }

   /* private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Toast.makeText(Profile.this,"Clicked Home",Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_dashboard:
                    Toast.makeText(Profile.this,"Clicked dashboard",Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_notifications:
                    Toast.makeText(Profile.this,"Clicked notifications",Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    };   */
}
