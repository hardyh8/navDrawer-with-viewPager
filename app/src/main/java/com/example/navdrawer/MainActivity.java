package com.example.navdrawer;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.navdrawer.adapter.MainAdapter;
import com.example.navdrawer.fragments.AllFragment;
import com.example.navdrawer.fragments.CallsFragment;
import com.example.navdrawer.fragments.ContactFragment;
import com.example.navdrawer.fragments.FaqFragment;
import com.example.navdrawer.fragments.FolderFragment;
import com.example.navdrawer.fragments.HomeFragment;
import com.example.navdrawer.fragments.InviteFragment;
import com.example.navdrawer.fragments.PeopleFragment;
import com.example.navdrawer.fragments.SavedFragment;
import com.example.navdrawer.fragments.SettingFragment;
import com.example.navdrawer.fragments.newGroupFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    NavigationView nav_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        nav_view = findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.m_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;
            case R.id.m_new_group:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new newGroupFragment()).commit();
                break;
            case R.id.m_contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ContactFragment()).commit();
                break;
            case R.id.m_call:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CallsFragment()).commit();
                break;
            case R.id.m_people:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PeopleFragment()).commit();
                break;
            case R.id.m_saved:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SavedFragment()).commit();
                break;
            case R.id.m_setting:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SettingFragment()).commit();
                break;
            case R.id.m_invite:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new InviteFragment()).commit();
                break;
            case R.id.m_faq:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FaqFragment()).commit();
                break;
            }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}