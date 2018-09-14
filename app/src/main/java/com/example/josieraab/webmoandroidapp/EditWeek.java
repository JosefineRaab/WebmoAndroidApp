package com.example.josieraab.webmoandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EditWeek extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner Monday;
    private Spinner Tuesday;
    private Spinner Wednesday;
    private Spinner Thursday;
    private Spinner Friday;

    private String MondaySelect;
    private String TuesdaySelect;
    private String WednesdaySelect;
    private String ThursdaySelect;
    private String FridaySelect;

    private Button saveWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_week);


        Monday = findViewById(R.id.MealPlan_Monday_Meal1);
        ArrayAdapter<String> MonAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, WebMoApplication.getMealManager().getMealNames());
        MonAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Monday.setAdapter(MonAdapter);
        MondaySelect = WebMoApplication.getMealManager().getMeal(0).getName();
        Monday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sSelected = parent.getItemAtPosition(position).toString();

                MondaySelect = sSelected;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Tuesday = findViewById(R.id.MealPlan_Tuesday_Meal1);
        ArrayAdapter<String> TueAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, WebMoApplication.getMealManager().getMealNames());
        TueAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Tuesday.setAdapter(TueAdapter);
        TuesdaySelect = WebMoApplication.getMealManager().getMeal(0).getName();
        Tuesday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sSelected = parent.getItemAtPosition(position).toString();

                TuesdaySelect = sSelected;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Wednesday = findViewById(R.id.MealPlan_Wednesday_Meal1);
        ArrayAdapter<String> WedAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, WebMoApplication.getMealManager().getMealNames());
        WedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Wednesday.setAdapter(WedAdapter);
        WednesdaySelect = WebMoApplication.getMealManager().getMeal(0).getName();
        Wednesday.setOnItemSelectedListener((new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sSelected = parent.getItemAtPosition(position).toString();

                WednesdaySelect = sSelected;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }));

        Thursday = findViewById(R.id.MealPlan_Thursday_Meal1);
        ArrayAdapter<String> ThuAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, WebMoApplication.getMealManager().getMealNames());
        ThuAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Thursday.setAdapter(ThuAdapter);
        ThursdaySelect = WebMoApplication.getMealManager().getMeal(0).getName();
        Thursday.setOnItemSelectedListener((new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sSelected = parent.getItemAtPosition(position).toString();

                ThursdaySelect = sSelected;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }));


        Friday = findViewById(R.id.MealPlan_Friday_Meal1);
        ArrayAdapter<String> FriAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, WebMoApplication.getMealManager().getMealNames());
        FriAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Friday.setAdapter(FriAdapter);
        FridaySelect = WebMoApplication.getMealManager().getMeal(0).getName();
        Friday.setOnItemSelectedListener((new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sSelected = parent.getItemAtPosition(position).toString();

                FridaySelect = sSelected;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }));


        saveWeek = findViewById(R.id.save_week_button);

        saveWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveWeek();
            }
        });



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String Mon = extras.getString("Mon");
            String Tue = extras.getString("Tue");
            String Wed = extras.getString("Wed");
            String Thu = extras.getString("Thu");
            String Fri = extras.getString("Fri");


        }
    }

    public void saveWeek() {


        MealPlan newWeek = new MealPlan(WebMoApplication.getWeekManager().getTotalNumberofWeeks() + 1);

        List<Integer> mealIds = new ArrayList<>();

        mealIds.add(WebMoApplication.getMealManager().getMeal(MondaySelect).getMealId());
        mealIds.add(WebMoApplication.getMealManager().getMeal(TuesdaySelect).getMealId());
        mealIds.add(WebMoApplication.getMealManager().getMeal(WednesdaySelect).getMealId());
        mealIds.add(WebMoApplication.getMealManager().getMeal(ThursdaySelect).getMealId());
        mealIds.add(WebMoApplication.getMealManager().getMeal(FridaySelect).getMealId());


        newWeek.setMealIdsForWeek(mealIds);

        WebMoApplication.getWeekManager().addWeek(newWeek);

        Intent intent = new Intent(EditWeek.this, ShowMealPlan.class);
        startActivity(intent);

        Toast toast = Toast.makeText(this, "Success", Toast.LENGTH_SHORT);
        toast.show();


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String sSelected = parent.getItemAtPosition(position).toString();

        if (view == Monday) {
            MondaySelect = sSelected;
        }
        if (view == Tuesday) {
            TuesdaySelect = sSelected;
        }
        if (view == Wednesday) {
            WednesdaySelect = sSelected;
        }
        if (view == Thursday) {
            ThursdaySelect = sSelected;
        }
        if (view == Friday) {
            FridaySelect = sSelected;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }}