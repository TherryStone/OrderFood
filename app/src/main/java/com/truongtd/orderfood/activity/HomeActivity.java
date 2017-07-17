package com.truongtd.orderfood.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.truongtd.orderfood.R;
import com.truongtd.orderfood.constraint.Constraint;
import com.truongtd.orderfood.fragment.ShowTableFoodFragment;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager  fragmentManager;
    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        View viewHeader = navigationView.getHeaderView(0);
        TextView tvNameEmployee = (TextView)viewHeader.findViewById(R.id.tv_name_employee);
        Intent itentGetNameEmployee = getIntent();
        tvNameEmployee.setText(itentGetNameEmployee.getStringExtra(Constraint.PUT_NAME_EMPLOYEE));
        hadleShowTableFoodFragment();
    }

    private void hadleShowTableFoodFragment() {

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction changeFragmentFood = fragmentManager.beginTransaction();
        ShowTableFoodFragment showTableFoodFragment = new ShowTableFoodFragment();
        changeFragmentFood.replace(R.id.content_food, showTableFoodFragment);
        changeFragmentFood.commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            hadleShowTableFoodFragment();
            item.setChecked(true);
            drawer.closeDrawers();

        } else if (id == R.id.nav_menu_order) {

        } else if (id == R.id.nav_employee) {

        } else if (id == R.id.nav_report) {

        } else if (id == R.id.nav_settings) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
