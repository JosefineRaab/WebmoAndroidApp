package com.example.josieraab.webmoandroidapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MealPlan implements Serializable {


    private int weekNumber;
    private List<Integer> mealIdsForWeek;


    public MealPlan(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public List<Integer> getMealsPerWeek(int weekNumber) {
        return mealIdsForWeek;
    }

    public void setMealIdsForWeek(List<Integer> MealsPerWeek) {
        mealIdsForWeek = MealsPerWeek;
    }

    public List<Meal> getListOfMeals (){
        List<Meal> meals = new ArrayList<>();

        for (int i = 0; i< mealIdsForWeek.size(); i++){
            int id = mealIdsForWeek.get(i);

            Meal meal = WebMoApplication.getMealManager().getMeal(id);
            meals.add(meal);
        }
        return meals;
    }


}


