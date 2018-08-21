package com.example.josieraab.webmoandroidapp;

public class Meal {

    private Integer  mealId;
    private String name;
    private float price;

   /* Set Art = new TreeSet();

    String a = Vegetrarian;
    String b = Vega;
    String c = Fleisch;

    Art.add */

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
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

    Meal(Integer e,String es ,float p ){

        mealId = e;
        name= es;
        price= p;


    }

    //essensbeispiel...mindestens 10 Verschiedene
}
