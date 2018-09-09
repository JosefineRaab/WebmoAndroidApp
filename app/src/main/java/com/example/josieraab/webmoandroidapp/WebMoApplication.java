package com.example.josieraab.webmoandroidapp;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class WebMoApplication extends Application {

    private static DataStorage dataStorage;

    @Override
    public void onCreate() {

        super.onCreate();
        final DataStorage dataStorage = getDataStorage();


        List<Meal> loadedMeal = dataStorage.readFromDisc(this);
        if (loadedMeal == null) {
            dataStorage.saveToDisc(this, getDefaultMeals());


        }

    }


    public static DataStorage getDataStorage() {

        if (dataStorage == null) {

            dataStorage = new DataStorage();
        }
        return dataStorage;
    }


    private List<Meal> getDefaultMeals() {

        List<Meal> mealList = new ArrayList<>();

//the default Meals loaded above
        Meal meal = createMeal(1, "Spaghetti", 3.5f, getResources().getStringArray(R.array.MealType)[2]);
        mealList.add(meal);

        meal = createMeal(2, "Pizza", 3.5f, getResources().getStringArray(R.array.MealType)[1]);
        mealList.add(meal);

        meal = createMeal(3, "Bulgursalat", 2.0f, getResources().getStringArray(R.array.MealType)[0]);
        mealList.add(meal);

        return mealList;

    }


    private Meal createMeal(int id, String name, float price, String mealType) {
        Meal meal = new Meal();
        meal.setMealId(id);
        meal.setName(name);
        meal.setPrice(price);
        meal.setMealType(mealType);

        return meal;
    }
}
