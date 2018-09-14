package com.example.josieraab.webmoandroidapp;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class WebMoApplication extends Application {


    private static MealManager MealManager;
    private static WeekManager WeekManager;

    private static MealDataStorage MealDataStorage;
    private static WeekDataStorage WeekDataStorage;


    @Override
    public void onCreate() {

        super.onCreate();

        MealDataStorage = new MealDataStorage();
        WeekDataStorage = new WeekDataStorage();


        MealManager = new MealManager(this);
        WeekManager = new WeekManager(this);


/*

        List<Meal> loadedWeek = weekMealDataStorage.readFromDisc(this);
        if (loadedWeek == null) {
            weekMealDataStorage.saveToDisc(this, getDefaultWeeks());
*/


    }


    public static MealManager getMealManager() {

        return MealManager;
    }

    public static WeekManager getWeekManager() {

        return WeekManager;
    }


    public static MealDataStorage getMealDataStorage() {

        return MealDataStorage;
    }


    public static WeekDataStorage getWeekDataStorage() {


        return WeekDataStorage;
    }


    private List<MealPlan> getDefaultWeeks() {

        List<MealPlan> defaultWeeks = new ArrayList<>();


        for (int i = 0; i < 8; i++) {

            MealPlan mealPlan = new MealPlan(i);
            defaultWeeks.add(mealPlan);

        }

        return defaultWeeks;

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
