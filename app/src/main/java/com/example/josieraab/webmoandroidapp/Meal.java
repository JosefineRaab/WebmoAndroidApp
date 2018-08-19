package com.example.josieraab.webmoandroidapp;

public class Meal {

        private int mealId;
        private String name;
        private float price;
        private MealType mealType;

        public Meal(int MealId) {
            this.mealId = MealId;
        }

        public int getMealId() {
            return mealId;
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
         public MealType getMealType() {
            return mealType;
         }

          public void setMealType(MealType  mealType) {
             this.mealType = mealType;
          }
    }

