package com.example.josieraab.webmoandroidapp;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MealManager {

    private List<Meal> mealList = new ArrayList<Meal>();
    private Context context;


    public MealManager(Context context) {

        this.context = context;
        List<Meal> loadedMeals = WebMoApplication.getMealDataStorage().readFromDisc(context);
        if (loadedMeals == null) {
            mealList = getDefaultMeals();


        } else {
            mealList = loadedMeals;
        }
    }


    public Meal getMeal(int id) {

        Meal meal = null;
        for (Meal m : mealList) {
            if (m.getMealId() == id) {
                meal = m;
                break;
            }
        }
        return meal;
    }


    public Meal getMeal(String name) {

        Meal meal = null;
        for (Meal m : mealList) {
            if (m.getName().equals(name)) {
                meal = m;
                break;
            }
        }
        return meal;
    }

    public Boolean Mealexists(int id) {

        for (Meal m : mealList) {
            if (m.getMealId() == id) {
                return true;
            }
        }

        return false;
    }

    public void removeMeal(int id) {

        for (Iterator<Meal> iter = mealList.listIterator(); iter.hasNext(); ) {
            Meal foundMeal = iter.next();
            if (foundMeal.getMealId() == id) {

                iter.remove();
                break;
            }
        }

        WebMoApplication.getMealDataStorage().saveToDisc(context, mealList);

    }

    public void addMeal(Meal meal) {
        mealList.add(meal);
        WebMoApplication.getMealDataStorage().saveToDisc(context, mealList);

    }

    public void editMeal(Meal meal) {

        int index = -1;
        for (Meal m : mealList) {
            if (m.getMealId() == meal.getMealId()) {
                index = mealList.indexOf(m);
                break;
            }
        }

        if (index != -1) {
            mealList.set(index, meal);
            WebMoApplication.getMealDataStorage().saveToDisc(context, mealList);
        }
    }

    private Meal createMeal(int id, String name, float price, String mealType) {
        Meal meal = new Meal();
        meal.setMealId(id);
        meal.setName(name);
        meal.setPrice(price);
        meal.setMealType(mealType);

        return meal;
    }

    private List<Meal> getDefaultMeals() {

        List<Meal> mealList = new ArrayList<>();

//the default Meals loaded above
        Meal meal = createMeal(0, "Currywurst", 2.5f, context.getResources().getStringArray(R.array.MealType)[2]);
        mealList.add(meal);

        meal = createMeal(1, "Spaghetti", 3.1f, context.getResources().getStringArray(R.array.MealType)[1]);
        mealList.add(meal);

        meal = createMeal(2, "Pizza with Salami", 3.6f, context.getResources().getStringArray(R.array.MealType)[2]);
        mealList.add(meal);

        meal = createMeal(3, "Bulgursalat", 2.75f, context.getResources().getStringArray(R.array.MealType)[0]);
        mealList.add(meal);

        meal = createMeal(4, "Chicken Teriyaki", 3.5f, context.getResources().getStringArray(R.array.MealType)[2]);
        mealList.add(meal);

        meal = createMeal(5, "French Fries", 1.5f, context.getResources().getStringArray(R.array.MealType)[0]);
        mealList.add(meal);

        meal = createMeal(6, "Steak with Sauce", 4.0f, context.getResources().getStringArray(R.array.MealType)[2]);
        mealList.add(meal);

        meal = createMeal(7, "Salmon with Herbs", 3.0f, context.getResources().getStringArray(R.array.MealType)[2]);
        mealList.add(meal);

        meal = createMeal(8, "Salat with Sauce", 3.8f, context.getResources().getStringArray(R.array.MealType)[1]);
        mealList.add(meal);

        meal = createMeal(9, "Pizza with Tuna", 2.0f, context.getResources().getStringArray(R.array.MealType)[2]);
        mealList.add(meal);

        return mealList;

    }

    public List<Meal> getAllMeals() {
        return mealList;
    }


    public List<String> getMealNames(){

     List<String> MealNames = new ArrayList<String>();

     for (Meal meal : mealList) {
         MealNames.add(meal.getName());

     }

        return  MealNames;

}


}
