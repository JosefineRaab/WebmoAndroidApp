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
    String type;


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
       // mealTableView.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));


        mealList = WebMoApplication.getDataStorage().readFromDisc(this);


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

                String name = data.getExtras().getString("name");
                float price = data.getExtras().getFloat("price");
                String type = data.getExtras().getString("type");

                int lastId = mealList.get(mealList.size()-1).getMealId();

                addMeal(lastId+1, name, price, type);

                mealTableDataAdapter.notifyDataSetChanged();
            }
        }
    }

    public void addMeal(int id, String name, float price, String mealType)
    {
        Meal meal = new Meal();
        meal.setMealId(id);
        meal.setName(name);
        meal.setPrice(price);
        meal.setMealType(mealType);

        mealList.add(meal);

        WebMoApplication.getDataStorage().saveToDisc(this, mealList);
    }
}


