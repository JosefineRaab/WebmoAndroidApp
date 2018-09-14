package com.example.josieraab.webmoandroidapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class WeekManager {

    private List<MealPlan> mealPlanList = new ArrayList<MealPlan>();
    private Context context;


    public WeekManager(Context context) {

        this.context = context;
        List<MealPlan> loadedMeals = WebMoApplication.getWeekDataStorage().readFromDisc(context);
        if (loadedMeals == null) {
            mealPlanList = createMealsPerWeek();


        } else {
            mealPlanList = loadedMeals;
        }
    }


    public MealPlan getMealPlan(int weekNumber) {

        MealPlan mealPlan = null;
        for (MealPlan m : mealPlanList) {
            if (m.getWeekNumber() == weekNumber) {
                mealPlan = m;
                break;
            }
        }
        return mealPlan;
    }

    public void removeWeek(int id) {

        for (Iterator<MealPlan> iter = mealPlanList.listIterator(); iter.hasNext(); ) {
            MealPlan foundMealPlan = iter.next();
            if (foundMealPlan.getWeekNumber() == id) {

                iter.remove();
                break;
            }
        }

        WebMoApplication.getWeekDataStorage().saveToDisc(context, mealPlanList);

    }

    public void addWeek(MealPlan mealPlan) {
        mealPlanList.add(mealPlan);
        WebMoApplication.getWeekDataStorage().saveToDisc(context, mealPlanList);

    }

    public void ediWeek(MealPlan mealplan) {

        int index = -1;
        for (MealPlan m : mealPlanList) {
            if (m.getWeekNumber() == mealplan.getWeekNumber()) {
                index = mealPlanList.indexOf(m);
                break;
            }
        }

        if (index != -1) {
            mealPlanList.set(index, mealplan);
            //       WebMoApplication.getMealMealDataStorage().saveToDisc(context, mealList);
        }
    }


    private List<MealPlan> createMealsPerWeek() {
        List<MealPlan> mealsPerWeek = new ArrayList<>();

        Random rand = new Random();

            for (int i=0; i<9 ; i++){

                MealPlan mealPlan = new MealPlan(i);

                List<Integer> mealIds = new ArrayList<>();

                mealIds.add(rand.nextInt(9));
                mealIds.add(rand.nextInt(9));
                mealIds.add(rand.nextInt(9));
                mealIds.add(rand.nextInt(9));
                mealIds.add(rand.nextInt(9));


                mealPlan.setMealsPerWeek(mealIds);

            }

            return mealsPerWeek;

    }
}
