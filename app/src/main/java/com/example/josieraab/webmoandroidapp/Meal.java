package com.example.josieraab.webmoandroidapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Meal implements Serializable {

    private int mealId;
    private String name;
    private float price;
    private String mealType;

    public Meal() { }


    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return mealId == meal.mealId &&
                Float.compare(meal.price, price) == 0 &&
                Objects.equals(name, meal.name) &&
                Objects.equals(mealType, meal.mealType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mealId, name, price, mealType);
    }

    */
}




