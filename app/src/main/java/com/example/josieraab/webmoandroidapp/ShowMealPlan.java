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




//TODO: write logic to populate textview to say whether logged in as admin or user


    public void ShowMeal(View view) {

        Intent intent = new Intent(ShowMealPlan.this,ShowMeal.class);
        intent.putExtra("Geklickt_auf", "123");
        startActivity(intent);
    }




}