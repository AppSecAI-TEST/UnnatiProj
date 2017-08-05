package com.example.unnatiproj;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class HomePage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    static boolean signedin;
    static MenuItem signin, signout;
    FragmentManager manager;
    RelativeLayout rl;
    static String title;
    FragmentTransaction transaction;
    static NavigationView navigationView;
    static Menu actionBarMenu, navigationBarMenu;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getChildAt(0).setVerticalScrollBarEnabled(false);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
        fragmentManager = getFragmentManager();

        fragmentManager
                .beginTransaction()
                .replace(R.id.login, new BlankFragment())
//                .addToBackStack(null)
                .commit();

        navigationBarMenu = navigationView.getMenu();
        rl = (RelativeLayout) findViewById(R.id.login);

    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //Checking for fragment count on backstack
            if (fragmentManager.getBackStackEntryCount() > 0) {
                fragmentManager.popBackStack();
            } else if (!doubleBackToExitPressedOnce) {
                this.doubleBackToExitPressedOnce = true;
                Toast.makeText(this, "Press back again to exit.", Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;
                    }
                }, 2000);
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        actionBarMenu = menu;
        signin = menu.findItem(R.id.sign_in);
//            signout = menu.findItem(R.id.sign_out);
//            checksignin();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        transaction = fragmentManager.beginTransaction().setCustomAnimations(R.animator.fade_in, R.animator.fade_out);

        for (int i = 0; i < navigationView.getMenu().size(); i++) {
            navigationView.getMenu().getItem(i).setChecked(false);
        }

        switch (id) {
            case R.id.sign_in:
                manager.beginTransaction().replace(R.id.login, new SignIn()).commit();
                title = "Sign In";
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        transaction = fragmentManager.beginTransaction().setCustomAnimations(R.animator.fade_in, R.animator.fade_out);

        manager = getFragmentManager();
        switch (item.getItemId()) {
            case R.id.students_form:
                manager.beginTransaction()
                        .replace(R.id.login, new StudentForm())
                        .commit();
                navigationView.getMenu().findItem(R.id.students_form).setChecked(true);
                title = "Student Form";
                break;
            case R.id.teachers_form:
                manager.beginTransaction()
                        .replace(R.id.login, new TeachersForm())
                        .commit();
                navigationView.getMenu().findItem(R.id.teachers_form).setChecked(true);
                title = "Teachers Form";
                break;
            case R.id.enquiry_form:
                manager.beginTransaction()
                        .replace(R.id.login, new EnquiryForm())
                        .commit();
                navigationView.getMenu().findItem(R.id.enquiry_form).setChecked(true);
                title = "Enquiry Form";
                break;
            case R.id.receipt:
                manager.beginTransaction()
                        .replace(R.id.login, new Receipt())
                        .commit();
                navigationView.getMenu().findItem(R.id.receipt).setChecked(true);
                title = "Receipt";
                break;
            case R.id.task_tab:
                manager.beginTransaction()
                        .replace(R.id.login, new TaskTab())
                        .commit();
                navigationView.getMenu().findItem(R.id.task_tab).setChecked(true);
                title = "Task Tab";
                break;
            case R.id.salary:
                manager.beginTransaction()
                        .replace(R.id.login, new Salary())
                        .commit();
                navigationView.getMenu().findItem(R.id.salary).setChecked(true);
                title = "Salary";
                break;
            case R.id.daily_act:
                manager.beginTransaction()
                        .replace(R.id.login, new DailyActivity())
                        .commit();
                navigationView.getMenu().findItem(R.id.daily_act).setChecked(true);
                title = "Daily Activity";
                break;
            case R.id.signin:
                manager.beginTransaction()
                        .replace(R.id.login, new SignIn())
                        .commit();
                navigationView.getMenu().findItem(R.id.signin).setChecked(true);
                title = "Sign In";
                break;


        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
