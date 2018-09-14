package com.example.josieraab.webmoandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

import android.widget.TextView;


public class ShowMealPlan extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView Monday;
    private TextView Tuesday;
    private TextView Wednesday;
    private TextView Thursday;
    private TextView Friday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_mealplan);

        mTextMessage = (TextView) findViewById(R.id.message);

        Monday = findViewById(R.id.MealPlan_Monday_Meal);
        Tuesday = findViewById(R.id.MealPlan_Tuesday_Meal);
        Wednesday = findViewById(R.id.MealPlan_Wednesday_Meal);
        Thursday = findViewById(R.id.MealPlan_Thursday_Meal);
        Friday = findViewById(R.id.MealPlan_Friday_Meal);


    }



    public void ShowMeal(View view) {

        Intent intent = new Intent(ShowMealPlan.this,ShowMeal.class);
        intent.putExtra("Geklickt_auf", "");
        startActivity(intent);
    }




}