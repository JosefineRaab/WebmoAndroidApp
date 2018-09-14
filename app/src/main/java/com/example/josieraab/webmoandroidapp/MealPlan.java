package com.example.josieraab.webmoandroidapp;

import android.view.View;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MealPlan {


    private int weekNumber;
    private List<Integer> mealsPerWeek;


    public MealPlan(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public List<Integer> getMealsPerWeek(int weekNumber) {
        return mealsPerWeek;
    }

    public void setMealsPerWeek(List<Integer> MealsPerWeek) {
        mealsPerWeek = MealsPerWeek;
    }

/*    public Meal getMeal(int mealId){
       Meal foundMeal = null;

       for (Meal meal : mealsPerWeek) {
           if (meal.getMealId() == (mealId)){
               foundMeal = meal;
               break;
           }
       }
        return foundMeal;
    }*/


}


