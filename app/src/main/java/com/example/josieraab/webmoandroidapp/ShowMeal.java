package com.example.josieraab.webmoandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.model.TableColumnWeightModel;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class ShowMeal extends AppCompatActivity {
    String[] MealDetailHeaders = {"ID", "Essen", "Preis", "Art"};
    String name;
    String price;
    public final int requestCode = 123;
    TableView<Meal> mealTableView;
    MealTableDataAdapter mealTableDataAdapter;

    List<Meal> mealList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_meal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mealTableView = findViewById(R.id.tableView);
        mealTableView.setColumnCount(4);
        mealTableView.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));

        // Dummy data
        addMeal("1", "Spaghetti", "3.5", MealType.vegetarian);
        addMeal("2", "Pizza", "3.5", MealType.withMeat);
        addMeal("3", "Bulgursalat", "2.0", MealType.vegan);

        // Create table view adapter
        mealTableDataAdapter = new MealTableDataAdapter(this, mealList);

        //ADAPTERS
        mealTableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this, MealDetailHeaders));
        mealTableView.setDataAdapter(mealTableDataAdapter);
        mealTableView.addDataClickListener(new TableDataClickListener() {
            @Override
            public void onDataClicked(int rowIndex, Object clickedData) {
                //   Toast.makeText(ShowMeal.this, ((String[])clickedData)[1], Toast.LENGTH_SHORT).show();

                Meal mealClicked = (Meal) clickedData;

                Intent intent = new Intent(ShowMeal.this, EditMeal.class);
                startActivityForResult(intent, requestCode);
            }
        });


        TableColumnWeightModel columnModel = new TableColumnWeightModel(4);

        columnModel.setColumnWeight(1, 1);
        columnModel.setColumnWeight(2, 2);
        columnModel.setColumnWeight(2, 2);
        columnModel.setColumnWeight(2, 2);
        mealTableView.setColumnModel(columnModel);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (this.requestCode == requestCode) {
            if (resultCode == RESULT_OK) {

                name = data.getExtras().getString("name");
                price = data.getExtras().getString("price");

                // TODO fix
                addMeal("", name, price, MealType.vegetarian);

                mealTableDataAdapter.notifyDataSetChanged();
            }
        }
    }

    private void addMeal(String id, String name, String price, MealType mealType)
    {
        Meal meal = new Meal();
        meal.setMealId(id);
        meal.setName(name);
        meal.setPrice(price);
        meal.setMealType(mealType);

        mealList.add(meal);
    }
}


