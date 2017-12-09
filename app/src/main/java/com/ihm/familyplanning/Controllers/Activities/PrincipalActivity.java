package com.ihm.familyplanning.Controllers.Activities;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.ihm.familyplanning.Controllers.Fragments.CoursesFragment;
import com.ihm.familyplanning.Controllers.Fragments.MenuFragment;
import com.ihm.familyplanning.Controllers.Fragments.PlanningFragment;
import com.ihm.familyplanning.R;

import java.util.Calendar;

public class PrincipalActivity extends AppCompatActivity {

    /**
     * date selection button
     */
    private Button mDatePickerButton;

    /**
     * DatePicker Dialog Listener
     */
    private DatePickerDialog.OnDateSetListener mDateListener;

    /**
     * show fragment depending on the icon clicked on the bottom navigation menu
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_menu:
                    showFragment(new MenuFragment());
                    return true;
                case R.id.navigation_planning:
                    showFragment(new PlanningFragment());
                    return true;
                case R.id.navigation_courses:
                    showFragment(new CoursesFragment());
                    return true;
            }
            return false;
        }

    };

    /**
     * Activity creation
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatePickerButton = (Button) findViewById(R.id.toolbar_Date_button);

        mDatePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickOnDatePicker();
            }
        });

        mDateListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                mDatePickerButton.setText(date);
            }
        };

        //Configuring Toolbar
        this.configureToolbar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        showFragment(new MenuFragment());
    }

    /**
     * Toolbar creation
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu and add it to the Toolbar
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    /**
     * do something depending to the item selected on the toolbar
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //3 - Handle actions on menu items
        switch (item.getItemId()) {
            case R.id.menu_activity_main_params:
                Toast.makeText(this, "Paramètres.", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_activity_main_search:
                this.onClickOnDatePicker();
                return true;
            case R.id.menu_activity_main_information:
                Toast.makeText(this, "Information.", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Create the DatePickerDialog
     */
    public void onClickOnDatePicker(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                PrincipalActivity.this,
                android.R.style.Theme_Material_Dialog_MinWidth,
                mDateListener,
                year,month,day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    /**
     * configure the toolbar
     */
    private void configureToolbar(){
        // Get the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        // Sets the Toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    /**
     * show the fragment passed as parameter
     * @param fragment
     */
    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }

}
