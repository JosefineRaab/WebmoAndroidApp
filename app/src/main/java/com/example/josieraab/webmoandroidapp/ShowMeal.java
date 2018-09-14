package com.example.josieraab.webmoandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Iterator;
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


    public final int requestCodeAdd = 123;
    public final int requestCodeEdit = 456;
    TableView<Meal> mealTableView;
    MealTableDataAdapter mealTableDataAdapter;

    List<Meal> mealList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_meal);
        Toolbar toolbar = findViewById(R.id.toolbar);
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

                Meal mealClicked = (Meal) clickedData;

                Intent intent = new Intent(ShowMeal.this, EditMeal.class);
                intent.putExtra("id", (mealClicked.getMealId()));
                intent.putExtra("name", (mealClicked.getName()));
                intent.putExtra("price", (mealClicked.getPrice()));
                intent.putExtra("type", (mealClicked.getMealType()));

                startActivityForResult(intent, requestCodeEdit);
            }
        });


        TableColumnWeightModel columnModel = new TableColumnWeightModel(4);

        columnModel.setColumnWeight(0, 1);
        columnModel.setColumnWeight(1, 3);
        columnModel.setColumnWeight(2, 2);
        columnModel.setColumnWeight(3, 3);
        mealTableView.setColumnModel(columnModel);


        Button NewMealButton = findViewById(R.id.add_meal_button);
        NewMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newMeal();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (requestCodeAdd == requestCode) {
            if (resultCode == RESULT_OK) {

                String name = data.getExtras().getString("name");
                float price = data.getExtras().getFloat("price");
                String type = data.getExtras().getString("type");

                int lastId = mealList.get(mealList.size() - 1).getMealId();

                addMeal(lastId + 1, name, price, type);

            }

        }
        if (requestCodeEdit == requestCode) {
            if (resultCode == RESULT_OK) {
                int id = data.getExtras().getInt("id");
                String name = data.getExtras().getString("name");
                float price = data.getExtras().getFloat("price");
                String type = data.getExtras().getString("type");

                if (data.getExtras().getString("status").equals("deleted")) {


                    for (Iterator<Meal> iter = mealList.listIterator(); iter.hasNext(); ) {
                        Meal foundMeal = iter.next();
                        if (foundMeal.getMealId() == id) {

                            iter.remove();
                            break;
                        }

                    }

                    WebMoApplication.getDataStorage().saveToDisc(this, mealList);



                } else

                    for (int z = 0; z < mealList.size(); z++) {
                        Meal foundMeal = mealList.get(z);
                        if (foundMeal.getMealId() == id) {

                            foundMeal.setName(name);
                            foundMeal.setPrice(price);
                            foundMeal.setMealType(type);

                            WebMoApplication.getDataStorage().saveToDisc(this, mealList);

                        }
                    }


            }
        }
        mealTableDataAdapter.notifyDataSetChanged();

    }


    public void addMeal(int id, String name, float price, String mealType) {
        Meal meal = new Meal();
        meal.setMealId(id);
        meal.setName(name);
        meal.setPrice(price);
        meal.setMealType(mealType);

        mealList.add(meal);

        WebMoApplication.getDataStorage().saveToDisc(this, mealList);
    }

    public void newMeal() {

        Intent intent = new Intent(ShowMeal.this, EditMeal.class);
        startActivityForResult(intent, requestCodeAdd);

    }


}