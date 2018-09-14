package com.example.josieraab.webmoandroidapp;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class WebMoApplication extends Application {

    private static DataStorage MealDataStorage;
    private static DataStorage WeekDataStorage;
    private static MealManager MealManager;


    @Override
    public void onCreate() {

        super.onCreate();
        final DataStorage MealDataStorage = getMealDataStorage();


        final DataStorage WeekDataStorage = getMealDataStorage();
        MealManager = new MealManager(this);

/*

        List<Meal> loadedWeek = WeekDataStorage.readFromDisc(this);
        if (loadedWeek == null) {
            WeekDataStorage.saveToDisc(this, getDefaultWeeks());
*/




        }


    public static MealManager getMealManager() {

        return MealManager;
    }


    public static DataStorage getMealDataStorage() {

        if (MealDataStorage == null) {

            MealDataStorage = new DataStorage();
        }
        return MealDataStorage;
    }


    public static DataStorage getWeekDataStorage() {

        if (WeekDataStorage == null) {

            WeekDataStorage = new DataStorage();
        }
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

    private List<Integer> createMealsPerWeek(int weekNumber) {
        List<Integer> mealsPerWeek = new ArrayList<>();
        switch (weekNumber) {
            case 1: // Id
                mealsPerWeek.add(5);
                mealsPerWeek.add(4);
                mealsPerWeek.add(7);
                mealsPerWeek.add(9);
                mealsPerWeek.add(2);
                break;
            case 2: //
                mealsPerWeek.add(3);
                mealsPerWeek.add(8);
                mealsPerWeek.add(1);
                mealsPerWeek.add(5);
                mealsPerWeek.add(4);
                break;
            case 3: //
                mealsPerWeek.add(3);
                mealsPerWeek.add(6);
                mealsPerWeek.add(9);
                mealsPerWeek.add(4);
                mealsPerWeek.add(1);
                break;
            case 4: //
                mealsPerWeek.add(6);
                mealsPerWeek.add(7);
                mealsPerWeek.add(8);
                mealsPerWeek.add(9);
                mealsPerWeek.add(1);
                break;

            case 5: //
                mealsPerWeek.add(1);
                mealsPerWeek.add(2);
                mealsPerWeek.add(3);
                mealsPerWeek.add(4);
                mealsPerWeek.add(5);
                break;
            case 6: //
                mealsPerWeek.add(6);
                mealsPerWeek.add(7);
                mealsPerWeek.add(8);
                mealsPerWeek.add(9);
                mealsPerWeek.add(5);
                break;

            case 7: //
                mealsPerWeek.add(5);
                mealsPerWeek.add(4);
                mealsPerWeek.add(1);
                mealsPerWeek.add(9);
                mealsPerWeek.add(3);
                break;

            case 8: //
                mealsPerWeek.add(3);
                mealsPerWeek.add(4);
                mealsPerWeek.add(6);
                mealsPerWeek.add(2);
                mealsPerWeek.add(8);
                break;
        }

        return mealsPerWeek;
    }
}
