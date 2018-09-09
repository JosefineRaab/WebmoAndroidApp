package com.example.josieraab.webmoandroidapp;

import android.view.View;

import java.util.HashSet;
import java.util.Set;

public class MealPlan {


    private int weekNumber;
    private Set<Meal> mealsPerWeek;


    public MealPlan(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public Set<Meal> getMealsPerWeek(int weekNumber) {
        return mealsPerWeek;
    }

    public void setMealsPerWeek(Set<Meal> MealsPerWeek) {
        mealsPerWeek = MealsPerWeek;
    }

    public Meal getMeal(int mealId){
       Meal foundMeal = null;

       for (Meal meal : mealsPerWeek) {
           if (meal.getMealId().equals(mealId)){
               foundMeal = meal;
               break;
           }
       }
        return foundMeal;
    }


}


