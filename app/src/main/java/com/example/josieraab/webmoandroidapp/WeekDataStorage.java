package com.example.josieraab.webmoandroidapp;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class WeekDataStorage {

        private String fileName = "WeeksOnDiskv2";


        public void saveToDisc(Context context, List<MealPlan> objectsToSave) {
            try {
                FileOutputStream fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                objectOutputStream.writeObject(objectsToSave);

                objectOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public List<MealPlan> readFromDisc(Context context) {
            List<MealPlan> objectsToReturn = null;

            try {
                FileInputStream fileInputStream = context.openFileInput(fileName);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                objectsToReturn = (List<MealPlan>) objectInputStream.readObject();

                objectInputStream.close();
                fileInputStream.close();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            return objectsToReturn;
        }


    }

