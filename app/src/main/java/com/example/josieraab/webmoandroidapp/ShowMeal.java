package com.example.josieraab.webmoandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


import android.graphics.Color;
import android.widget.Toast;

import java.util.ArrayList;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.model.TableColumnDpWidthModel;
import de.codecrafters.tableview.model.TableColumnWeightModel;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class ShowMeal extends AppCompatActivity {
    String[] MealDetailHeaders = {"ID", "Essen", "Preis", "Art"};
    String[][] Meals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_meal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final TableView<String[]> tb = (TableView<String[]>) findViewById(R.id.tableView);
        tb.setColumnCount(4);
        tb.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));


        //POPULATE
        populateData();

        //ADAPTERS
        tb.setHeaderAdapter(new SimpleTableHeaderAdapter(this, MealDetailHeaders));
        tb.setDataAdapter(new SimpleTableDataAdapter(this, Meals));
        tb.addDataClickListener(new TableDataClickListener() {
            @Override
            public void onDataClicked(int rowIndex, Object clickedData) {
                //   Toast.makeText(ShowMeal.this, ((String[])clickedData)[1], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ShowMeal.this, EditMeal.class);
                startActivity(intent);
            }
        });

        TableColumnWeightModel columnModel = new TableColumnWeightModel(4);

        columnModel.setColumnWeight(1, 1);
        columnModel.setColumnWeight(2, 2);
        columnModel.setColumnWeight(2, 2);
        columnModel.setColumnWeight(2, 2);
        tb.setColumnModel(columnModel);
    }

    private void populateData() {
        Meal meal = new Meal();
        ArrayList<Meal> mealList = new ArrayList<>();

        meal.setMealId("1");
        meal.setName("Spaghetti");
        meal.setPrice("3.5");
        meal.setMealType(MealType.vegetarian);
        mealList.add(meal);

        meal = new Meal();
        meal.setMealId("2");
        meal.setName("Pizza");
        meal.setPrice("3.5");
        meal.setMealType(MealType.withMeat);
        mealList.add(meal);

        meal = new Meal();
        meal.setMealId("3");
        meal.setName("Bulgursalat");
        meal.setPrice("2.0");
        meal.setMealType(MealType.vegan);
        mealList.add(meal);


        Meals = new String[mealList.size()][4];
        // spaceProbes= new String[][]{{}};

        for (int i = 0; i < mealList.size(); i++) {

            Meal s = mealList.get(i);

            Meals[i][0] = s.getMealId();
            Meals[i][1] = s.getName();
            Meals[i][2] = s.getPrice();
            Meals[i][3] = s.getMealType().toString();

        }


    }


}

